package Model.Expression;

import Model.ADT.MyDictionary;

public class ArithmeticExpression implements IExpression {
    private IExpression operand1, operand2;
    private char operator;

    public ArithmeticExpression(IExpression operand1, char operator, IExpression operand2){
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
    }

    @Override
    public int evaluate(MyDictionary<String, Integer> symTable) {
        int firstResult = this.operand1.evaluate(symTable);
        int secondResult = this.operand2.evaluate(symTable);
        if(this.operator == '+')
            return firstResult + secondResult;
        if(this.operator == '-')
            return firstResult - secondResult;
        if(this.operator == '*')
            return firstResult * secondResult;
        if(this.operator == '/'){
            if(secondResult == 0)
                throw new RuntimeException("Division by 0");
            else
                return firstResult/secondResult;
        }
        throw new RuntimeException("Invalid operator");
    }

    public String toString(){
        return operand1.toString() + operator + operand2.toString();
    }
}
