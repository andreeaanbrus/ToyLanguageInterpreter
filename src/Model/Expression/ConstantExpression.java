package Model.Expression;

import Model.ADT.MyDictionary;

public class ConstantExpression implements IExpression {
    private int value;
    public ConstantExpression(int value){
        this.value = value;
    }
    @Override
    public int evaluate(MyDictionary<String, Integer> symTable) {
        return this.value;
    }
    public String toString(){
        return String.valueOf(this.value);
    }
}
