package Controller;

import Model.Expression.ConstantExpression;
import Model.ProgramState;
import Model.Statement.CloseRFile;
import Repository.IRepository;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class InterpreterController {
    private IRepository repo;
    private ExecutorService executor;

    public InterpreterController(IRepository repo) {
        this.repo = repo;
    }


    private List<ProgramState> removeCompletedPrograms(List<ProgramState> inProgramsList){
        return inProgramsList.stream().filter(ProgramState::isNotCompleted).collect(Collectors.toList());
    }

    private void oneStepForAllPrograms(List<ProgramState> programStates) throws Exception {
        for(ProgramState ps : programStates)
            repo.logProgramStateExec(ps);
        //RUN concurrently one step for each of the existing PrgStates
        List<Callable<ProgramState>> callList = programStates.stream()
                .map((ProgramState p) -> (Callable<ProgramState>) (p::oneStep))
                .collect(Collectors.toList());
        List<ProgramState> newProgramsList = executor.invokeAll(callList).stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (InterruptedException | ExecutionException e) {
                        System.out.println(e);
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        programStates.addAll(newProgramsList);
        for ( ProgramState ps : programStates)
            repo.logProgramStateExec(ps);
        repo.setProgramStates(programStates);

    }

    private Map<Integer,Integer> conservativeGarbageCollector(Collection<Integer> symTableValues, Map<Integer, Integer> heap) {
        return heap.entrySet().stream()
                .filter(e->symTableValues.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private void closeOpenedFiles(ProgramState programState) throws Exception {
        List<Map.Entry<Integer, Pair<String, BufferedReader>>> files = new ArrayList<>(programState.getFileTable().getContent().entrySet());
        for(Map.Entry<Integer, Pair<String, BufferedReader>> k : files)
            new CloseRFile(new ConstantExpression(k.getKey())).execute(programState);
//        repo.logProgramStateExec(programState);
    }

    public void allSteps() throws Exception {
        executor = Executors.newFixedThreadPool(2);
        List<ProgramState> programStateList = removeCompletedPrograms(repo.getProgramStates());

        Map <Integer, Integer> heap = programStateList.get(0).getHeap().getContent();
        while(programStateList.size() > 0 ){
            programStateList.forEach(program -> conservativeGarbageCollector(program.getSymTable().values(), heap));
            oneStepForAllPrograms(programStateList);
            programStateList = removeCompletedPrograms(repo.getProgramStates());
        }
        executor.shutdown();
        List<ProgramState> tmpList = repo.getProgramStates();
        closeOpenedFiles(tmpList.get(0));
        repo.setProgramStates(programStateList);

    }
}
