package Model.Statement;

import Model.ADT.MyDictionary;
import Model.ADT.MyHeap;
import Model.Expression.IExpression;
import Model.Expression.VariableExpression;
import Model.ProgramState;

import java.io.IOException;

public class NewStatement implements IStatement {
    private String variable;
    private IExpression expression;
    public NewStatement(String variable, IExpression expression){
        this.variable = variable;
        this.expression = expression;
    }
    @Override
    public ProgramState execute(ProgramState programState) throws IOException {
        MyDictionary<String, Integer> symTable = programState.getSymTable();
        MyHeap<Integer> heap = programState.getHeap();
        int value = expression.evaluate(symTable, heap);
        int index = heap.allocate(value);
        symTable.put(variable, index);
        return programState;
    }

    public String toString(){
        String s = "";
        s += "new ( " + variable + "," + expression.toString() + ")";
        return s;
    }
}
