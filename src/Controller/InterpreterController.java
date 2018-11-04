package Controller;

import Model.ADT.MyStack;
import Model.ProgramState;
import Model.Statement.IStatement;
import Repository.IRepository;
import Exception.ADTException;

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
}
