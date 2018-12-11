package Model.Statement;

import Model.ADT.MyDictionary;
import Model.ADT.MyStack;
import Model.ProgramState;

import java.io.IOException;

public class ForkStatement implements IStatement {

    private IStatement Statement;

    public ForkStatement(IStatement statement) {
        Statement = statement;
    }

    @Override
    public ProgramState execute(ProgramState programState) {
        MyDictionary<String, Integer> symTableCopy = (MyDictionary<String, Integer>) programState.getSymTable().deepcopy();
        return new ProgramState(symTableCopy, new MyStack<>(), programState.getOutput(), Statement, programState.getFileTable(),
                programState.getHeap(), programState.getFileDescriptor(), programState.getThreadId() * 10);
    }

    @Override
    public String toString(){
        String s;
        s = "Fork ( " + Statement.toString() + ")";
        return s;
    }
}
