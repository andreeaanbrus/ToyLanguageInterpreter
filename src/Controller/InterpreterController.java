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

    public ProgramState oneStep(ProgramState state){
        //TODO Exception
        MyStack<IStatement> exeStack = state.getExeStack();
//        System.out.println("DEBUG:");
//        System.out.println(exeStack);
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
            }
        }
        catch (RuntimeException e){
            System.out.println(e.toString());
        }
    }
}
