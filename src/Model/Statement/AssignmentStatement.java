package Model.Statement;

import Model.ADT.MyDictionary;
import Model.Expression.IExpression;
import Model.ProgramState;

public class AssignmentStatement implements IStatement {
    private String varName;
    private IExpression expression;

    public AssignmentStatement(String varName, IExpression expression) {
        this.varName = varName;
        this.expression = expression;
    }

    public String toString(){
        return varName + " = " + expression.toString();
    }

    public ProgramState execute(ProgramState ps){
        MyDictionary<String, Integer> st = ps.getSymTable();
        st.put(this.varName, this.expression.evaluate(st));
        return ps;
    }
}
