package Model.Statement;

import Model.ADT.MyDictionary;
import Model.ADT.MyHeap;
import Model.ADT.MyStack;
import Model.Expression.IExpression;
import Model.ProgramState;

import java.io.IOException;

public class WhileStatement implements IStatement {
    private IExpression expression;
    private IStatement doStatement;

    public WhileStatement(IExpression expression, IStatement doStatement) {
        this.expression = expression;
        this.doStatement = doStatement;
    }



    @Override
    public ProgramState execute(ProgramState programState) {

        MyStack<IStatement> exeStack = programState.getExeStack();
        if(expression.evaluate(programState.getSymTable(), programState.getHeap()) != 0) {
            exeStack.push(this);
            exeStack.push(doStatement);
        }
        return null;
    }

    @Override
    public String toString(){
        return "while ( " + expression.toString() + " ) " + doStatement.toString();
    }
}
