package Controller;

import Model.ADT.MyDictionary;
import Model.ADT.MyStack;
import Model.Expression.VariableExpression;
import Model.ProgramState;
import Model.Statement.CloseRFile;
import Model.Statement.IStatement;
import Repository.IRepository;
import Exception.ADTException;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InterpreterController {
    private IRepository repo;

    public InterpreterController(IRepository repo) {
        this.repo = repo;
    }

    public ProgramState oneStep(ProgramState state) throws Exception {
        MyStack<IStatement> exeStack = state.getExeStack();
        if(exeStack.isEmpty())
            throw new ADTException("Stack is empty");
        IStatement currentStatement = exeStack.pop();
        return currentStatement.execute(state);
    }

    public void allSteps() throws Exception {
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
        finally {
            //close all opened files
            Collection<Integer> fileTableKeys = program.getFileTable().keySet();
            MyDictionary<String, Integer> symTable = program.getSymTable();
            List<Map.Entry<String, Integer>> keys = symTable.entrySet().stream().filter(e->fileTableKeys.contains(e.getValue())).collect(Collectors.toList());
            for(Map.Entry<String, Integer> e : keys){
                if(program.getFileTable().containsKey(e.getValue()))
                    new CloseRFile(new VariableExpression(e.getKey())).execute(program);
            }

            repo.logProgramStateExec();

        }
    }



    private Map<Integer,Integer> conservativeGarbageCollector(Collection<Integer> symTableValues, Map<Integer, Integer> heap) {
        return heap.entrySet().stream()
                .filter(e->symTableValues.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
