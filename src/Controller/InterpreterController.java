package Controller;

import Model.ADT.MyStack;
import Model.ProgramState;
import Model.Statement.IStatement;
import Repository.IRepository;
import Exception.ADTException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class InterpreterController {
    private IRepository repo;

    public InterpreterController(IRepository repo) {
        this.repo = repo;
    }

    public ProgramState oneStep(ProgramState state) throws Exception {
        //TODO Exception
        MyStack<IStatement> exeStack = state.getExeStack();
        if(exeStack.isEmpty())
            throw new ADTException("Stack is empty");
        IStatement currentStatement = exeStack.pop();
        return currentStatement.execute(state);
    }

    public void allSteps(){
        ProgramState program = repo.getCurrentProgram();
        try{
            while(!program.getExeStack().isEmpty()){
                oneStep(program);
//                program.getHeap().setContent(conservativeGarbageCollector(program.getSymTable().values(), program.getHeap().getContent()));
                repo.logProgramStateExec();
            }
        }
        catch (ADTException e){
            System.out.println(e.toString());
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private HashMap<Integer, Integer> conservativeGarbageCollector(Collection<Integer> symTableValues, Map<Integer, Integer> heap) {
//        //TODO incearca sa intelegi ce face mizeria asta
//
//                .filter(e -> symTableValues.contains(e.getKey()))
//                .collect(Collectors.toMap(HashMap.Entry::getKey, HashMap.Entry::getValue));
//        return collect;
//    }
}
