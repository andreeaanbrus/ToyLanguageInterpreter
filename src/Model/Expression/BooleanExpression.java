package Model.Expression;

import Model.ADT.MyDictionary;
import Model.ADT.MyHeap;
import Exception.ADTException;

public class BooleanExpression implements IExpression {
    private IExpression exp1, exp2;
    private String type;

    public BooleanExpression(IExpression exp1, IExpression exp2, String type) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.type = type;
    }

    @Override
    public int evaluate(MyDictionary<String, Integer> symTable, MyHeap<Integer> heap) {
        int value1 = exp1.evaluate(symTable, heap);
        int value2 = exp2.evaluate(symTable, heap);
        if(type.equals("=="))
            return value1 == value2 ? 1 : 0;
        if(type.equals("<"))
            return value1 < value2 ? 1 : 0;
        if(type.equals(">"))
            return value1 > value2 ? 1 : 0;
        if(type.equals("<="))
            return value1 <= value2 ? 1 : 0;
        if(type.equals(">="))
            return value1 >= value2 ? 1 : 0;
        if(type.equals("!="))
            return value1 != value2 ? 1 : 0;
        throw new ADTException("Invalid type of comparison");
    }

    @Override
    public String toString() {
        String s = exp1.toString() + " " + type + " " +exp2.toString();
        return s;
    }
}
