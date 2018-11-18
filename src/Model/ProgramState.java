package Model;

import Model.ADT.MyDictionary;
import Model.ADT.MyHeap;
import Model.ADT.MyList;
import Model.ADT.MyStack;
import Model.Statement.IStatement;
import javafx.util.Pair;

import java.io.BufferedReader;


public class ProgramState {
    //TODO DEEPCOPY
    private IStatement originalProgram;
    private MyDictionary<String, Integer> symTable;
    private MyStack<IStatement> exeStack;
    private MyList<Integer> output;
    private MyDictionary<Integer, Pair<String, BufferedReader>> fileTable;
    private MyHeap<Integer> heap;
    private int fileDescriptor;


    public ProgramState(MyDictionary<String, Integer> symTable, MyStack<IStatement> exeStack, MyList<Integer> output, IStatement program, MyDictionary<Integer, Pair<String, BufferedReader>> fileTable, MyHeap<Integer> heap, int fileDescriptor) {
        this.symTable = symTable;
        this.exeStack = exeStack;
        this.output = output;
        this.fileTable = fileTable;
        this.heap = heap;
        //originalProgram=deepCopy(program);
        this.fileDescriptor = fileDescriptor;
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

    public MyDictionary<Integer, Pair<String, BufferedReader>> getFileTable() {
        return fileTable;
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


    public int getFileDescriptor() {
        return fileDescriptor;
    }

    public int getNextFileDescriptor() {
        fileDescriptor++;
        return fileDescriptor;
    }
    public String toString(){
        String s = "";
        s += "exeStack:\n";
        s += this.exeStack.toString();
        s += "\nsymTable:";
        s += this.symTable.toString();
        s += "\noutput:";
        s += this.output.toString();
        return s;
    }

    public MyHeap<Integer> getHeap() {
        return heap;
    }
}
