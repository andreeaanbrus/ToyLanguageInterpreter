package Model.Statement;

import Model.ADT.MyDictionary;
import Model.ADT.MyStack;
import Model.Expression.IExpression;
import Model.ProgramState;
import javafx.util.Pair;
import Exception.ADTException;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadFile implements IStatement {
    private IExpression expressionFileId;
    private String variableName;

    public ReadFile(IExpression expressionFileId, String variableName) {
        this.expressionFileId = expressionFileId;
        this.variableName = variableName;
    }

    @Override
    public ProgramState execute(ProgramState programState) throws IOException {
        MyDictionary<String, Integer> symTable = programState.getSymTable();
        int x = expressionFileId.evaluate(symTable);
        MyStack<IStatement> exeStack = programState.getExeStack();
        MyDictionary<Integer, Pair<String, BufferedReader>> fileTable = programState.getFileTable();
        BufferedReader reader = fileTable.get(x).getValue();
        if(reader == null)
            throw new ADTException("No such file descriptor");
        String line = reader.readLine();
        System.out.println(line);
        int val;
        if(line == null) {
            val = 0;
        }
        else {
            val = Integer.parseInt(line);
        }
        symTable.put(variableName, val);
        return programState;
    }
}
