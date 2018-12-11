package Model.Statement;

import Model.Expression.IExpression;
import Model.ProgramState;

import java.io.FileNotFoundException;
import java.io.IOException;

public class IfStatement implements IStatement {
    private IExpression condition;
    private IStatement ifStatement, elseStatement;

    public IfStatement(IExpression condition, IStatement ifStatement, IStatement elseStatement) {
        this.condition = condition;
        this.ifStatement = ifStatement;
        this.elseStatement = elseStatement;
    }

    public String toString(){
        return "if " + condition.toString() + " then " + ifStatement.toString() + " else " + elseStatement.toString();
    }

    @Override
    public ProgramState execute(ProgramState programState) throws IOException {
        int res = condition.evaluate(programState.getSymTable(), programState.getHeap());
        if( res != 0 )
            ifStatement.execute(programState);
        else
            elseStatement.execute(programState);
        return null;
    }
}
