package Model.Statement;

import Model.ADT.MyDictionary;
import Model.ADT.MyHeap;
import Model.Expression.IExpression;
import Model.ProgramState;
import Exception.ADTException;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;

public class CloseRFile implements IStatement {
    private IExpression expressionFileId;

    public CloseRFile(IExpression expressionFileId) {
        this.expressionFileId = expressionFileId;
    }

    @Override
    public ProgramState execute(ProgramState programState) throws IOException {
        MyDictionary<String, Integer> symTable = programState.getSymTable();
        MyDictionary<Integer, Pair<String, BufferedReader>> fileTable = programState.getFileTable();
        MyHeap<Integer> heap = programState.getHeap();
        int val = expressionFileId.evaluate(symTable, heap);
        BufferedReader reader = fileTable.get(val).getValue();
        if( reader == null ){
            throw new ADTException("No such file descriptor");
        }
        reader.close();
        fileTable.remove(val);

        return null;
    }

    public String toString(){
        String s;
        s = "CloseFile " + expressionFileId.toString();
        return s;
    }
}
