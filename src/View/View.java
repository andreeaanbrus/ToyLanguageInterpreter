package View;

import Model.ADT.MyDictionary;
import Model.ADT.MyList;
import Model.ADT.MyStack;
import Model.Expression.ArithmeticExpression;
import Model.Expression.ConstantExpression;
import Model.Expression.IExpression;
import Model.Expression.VariableExpression;
import Model.ProgramState;
import Model.Statement.*;

public class View {
    public static void main(String args[]) {
        MyDictionary<String, Integer> symDict = new MyDictionary<>();
        MyList<Integer> out = new MyList<>();
        MyStack<IStatement> exeStack = new MyStack<>();
        IExpression ex = new ArithmeticExpression(new ConstantExpression(4), '+', new ConstantExpression(4));
        IStatement s1 = new AssignmentStatement("a", ex);
        IStatement s2 = new PrintStatement(ex);
        IStatement prg = new CompoundStatement(s1, s2);
        ProgramState prog = new ProgramState(symDict, exeStack, out, prg);
        
        System.out.println(prog.getExeStack());
        System.out.println(prog.getSymTable());
        System.out.println(prog.getOutput());



    }
}
