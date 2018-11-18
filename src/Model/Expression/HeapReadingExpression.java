package Model.Expression;

import Model.ADT.MyDictionary;
import Model.ADT.MyHeap;

public class HeapReadingExpression implements IExpression {
    private String variableName;
    public HeapReadingExpression(String variableName){
        this.variableName = variableName;
    }
    @Override
    public int evaluate(MyDictionary<String, Integer> symTable, MyHeap<Integer> heap) {
        int index = symTable.get(variableName); //heap address
        return heap.get(index);
    }

    @Override
    public String toString(){
        String s = "";
        s += "readHeap(" + variableName + ")";
        return s;
    }
}
