package Model.Expression;

import Model.ADT.MyDictionary;
import Model.ADT.MyHeap;

public interface IExpression {
    int evaluate(MyDictionary<String, Integer> symTable, MyHeap<Integer> heap);

}
