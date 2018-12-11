package Model.Statement;

import Model.ADT.MyDictionary;
import Model.ADT.MyHeap;
import Model.Expression.IExpression;
import Model.ProgramState;

import java.io.IOException;

public class HeapWritingStatement implements IStatement {
    private String variableName;
    private IExpression expression;

    public HeapWritingStatement(String variableName, IExpression expression) {
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState programState) {
        MyDictionary<String, Integer> symTable = programState.getSymTable();
        MyHeap<Integer> heap = programState.getHeap();
        int address = symTable.get(variableName);
        int value  = expression.evaluate(symTable, heap);
        heap.update(address, value);
        return null;
    }

    @Override
    public String toString(){
        String s = "";
        s += "heapWrite ( " + variableName + ", " + expression.toString() + " ) ";
        return s;
    }
}
