package Model.Expression;

import Model.ADT.MyDictionary;

public class VariableExpression implements IExpression {
    private String name;
    public VariableExpression(String name){
        this.name = name;
    }

    @Override
    public int evaluate(MyDictionary<String, Integer> st) {
        if(st.get(this.name) != null){
            return st.get(name);
        }
        else
            throw new RuntimeException("Inexistent variable.");
    }

    public String toString(){
        return this.name;
    }
}
