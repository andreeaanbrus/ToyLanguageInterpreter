package Model.Statement;

import Model.Expression.IExpression;
import Model.ProgramState;

public class IfStatement implements IStatement {
    private IExpression expression;
    private IStatement statement1, statement2;

    public IfStatement(IExpression expression, IStatement statement1, IStatement statement2) {
        this.expression = expression;
        this.statement1 = statement1;
        this.statement2 = statement2;
    }

    public String toString(){
        return "if " + expression.toString() + " then " + statement1.toString() + " else " + statement2.toString();
    }

    @Override
    public ProgramState execute(ProgramState programState) {
        int res = expression.evaluate(programState.getSymTable());
        if( res != 0 )
            statement1.execute(programState);
        else
            statement2.execute(programState);
        return programState;
    }
}
