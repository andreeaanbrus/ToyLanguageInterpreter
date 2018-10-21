package Model;

import Model.ADT.MyDictionary;
import Model.ADT.MyList;
import Model.ADT.MyStack;
import Model.Statement.IStatement;


public class ProgramState {
    private IStatement originalProgram;
    private MyDictionary<String, Integer> symTable;
    private MyStack<IStatement> exeStack;
    private MyList<Integer> output;

    public ProgramState(MyDictionary<String, Integer> symTable, MyStack<IStatement> exeStack, MyList<Integer> output, IStatement program) {
        this.symTable = symTable;
        this.exeStack = exeStack;
        this.output = output;
        //originalProgram=deepCopy(program);
        exeStack.push(program);
    }

    public IStatement getProgram() {
        return originalProgram;
    }

    public void setProgram(IStatement originalProgram) {
        this.originalProgram = originalProgram;
    }

    public MyDictionary<String, Integer> getSymTable() {
        return symTable;
    }

    public void setSymTable(MyDictionary<String, Integer> symTable) {
        this.symTable = symTable;
    }

    public MyStack<IStatement> getExeStack() {
        return exeStack;
    }

    public void setExeStack(MyStack<IStatement> exeStack) {
        this.exeStack = exeStack;
    }

    public MyList<Integer> getOutput() {
        return output;
    }

    public void setOutput(MyList<Integer> output) {
        this.output = output;
    }
}
