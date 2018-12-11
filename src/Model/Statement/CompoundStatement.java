package Model.Statement;

import Model.ADT.MyStack;
import Model.ProgramState;


public class CompoundStatement implements IStatement {
    private IStatement statement1, statement2;

    public CompoundStatement(IStatement statement1, IStatement statement2) {
        this.statement1 = statement1;
        this.statement2 = statement2;
    }

    public ProgramState execute(ProgramState programState){
        MyStack<IStatement> exeStack = programState.getExeStack();
        exeStack.push(this.statement2);
        exeStack.push(this.statement1);
        return null;
    }

    public String toString(){
        return statement1.toString() + " ; " + statement2.toString() + " ; ";
    }
}
