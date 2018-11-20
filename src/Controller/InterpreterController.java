package Controller;

import Model.ADT.MyDictionary;
import Model.ADT.MyStack;
import Model.ProgramState;
import Model.Statement.IStatement;
import Repository.IRepository;
import Exception.ADTException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
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
                program.getHeap().setContent((HashMap<Integer, Integer>) conservativeGarbageCollector(program.getSymTable().values(), program.getHeap().getContent()));
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

    private Map<Integer,Integer> conservativeGarbageCollector(Collection<Integer> symTableValues, Map<Integer, Integer> heap) {
        return heap.entrySet().stream()
                .filter(e->symTableValues.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
