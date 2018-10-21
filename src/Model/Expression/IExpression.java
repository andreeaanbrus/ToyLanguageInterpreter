package Model.Expression;

import Model.ADT.MyDictionary;

public interface IExpression {
    int evaluate(MyDictionary<String, Integer> symTable);
//    String toString();
}
