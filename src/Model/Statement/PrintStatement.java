package Model.Statement;

import Model.ADT.MyList;
import Model.Expression.IExpression;
import Model.ProgramState;

public class PrintStatement implements IStatement {
    private IExpression exp;

    public PrintStatement(IExpression exp) {
        this.exp = exp;
    }

    @Override
    public String toString(){
        return "print(" + exp.toString() + ")";
    }
    @Override
    public ProgramState execute(ProgramState programState) {
        MyList<Integer> output = programState.getOutput();
        output.add(exp.evaluate(programState.getSymTable()));
        return programState;
    }
}
