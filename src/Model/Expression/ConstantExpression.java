package Model.Expression;

import Model.ADT.MyDictionary;
import Model.ADT.MyHeap;

public class ConstantExpression implements IExpression {
    private int value;
    public ConstantExpression(int value){
        this.value = value;
    }
    @Override
    public int evaluate(MyDictionary<String, Integer> symTable, MyHeap<Integer> heap) {
        return this.value;
    }
    public String toString(){
        return String.valueOf(this.value);
    }
}
