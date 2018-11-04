package View;

import Controller.InterpreterController;
import Model.ADT.MyDictionary;
import Model.ADT.MyList;
import Model.ADT.MyStack;
import Model.Expression.ArithmeticExpression;
import Model.Expression.ConstantExpression;
import Model.Expression.VariableExpression;
import Model.ProgramState;
import Model.Statement.*;
import Repository.*;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.util.Scanner;

public class View {

    private static void displayMenu(){
        System.out.println("Choose a program:");
        System.out.println("1: v = 2; print(v)");
        System.out.println("2: a = 2 + 3 * 5; b = a + 1; print(b)");
        System.out.println("3: a=2-2; (if a then v=2 else v=3); print(v)");
    }

    public static void main(String args[]) throws Exception {
        MyDictionary<String, Integer> symDict = new MyDictionary<>();
        MyList<Integer> out = new MyList<>();
        MyStack<IStatement> exeStack = new MyStack<>();
        MyDictionary<Integer, Pair<String, BufferedReader>> fileTable = new MyDictionary<>();
        displayMenu();
        System.out.println("Command: ");
        Scanner sc = new Scanner(System.in);
        int cmd = sc.nextInt();
//        int cmd = 1;
//        v = 2; print(v);
        IStatement stm = null;
        if(cmd == 1){

            stm= new CompoundStatement(new AssignmentStatement("v",new ConstantExpression(2)), new PrintStatement(new
                    VariableExpression("v")));
        }
        //a=2+3*5;b=a+1; print(b) is represented as:
        if(cmd == 2){

            stm = new CompoundStatement(new AssignmentStatement("a", new ArithmeticExpression(new ConstantExpression(2),'+',new
                    ArithmeticExpression(new ConstantExpression(3),'*' ,new ConstantExpression(5)))),
                    new CompoundStatement(new AssignmentStatement("b",new ArithmeticExpression(new VariableExpression("a"),'+', new
                            ConstantExpression(1))), new PrintStatement(new VariableExpression("b"))));
        }


//        a=2-2;(If a Then v=2 Else v=3);Print(v) is represented as
        if(cmd == 3) {
            stm = new CompoundStatement(new AssignmentStatement("a", new ArithmeticExpression( new ConstantExpression(2),'-', new
                    ConstantExpression(2))), new CompoundStatement(new IfStatement(new VariableExpression("a"), new AssignmentStatement("v", new ConstantExpression(2)), new
                    AssignmentStatement("v", new ConstantExpression(3))), new PrintStatement(new VariableExpression("v"))));
        }

//        IStatement s = new CompoundStatement(new OpenRFile("test.txt", "var_f"), new CloseRFile(new VariableExpression("var_f")));

        IStatement s = new CompoundStatement(
                new OpenRFile("test.in", "var_f"),
                new CompoundStatement(
                        new ReadFile(new VariableExpression("var_f"), "var_c"),
                        new CompoundStatement(
                                new PrintStatement(new VariableExpression("var_c")),
                                new CompoundStatement(
                                        new IfStatement(
                                                new VariableExpression("var_c"),
                                                new CompoundStatement(
                                                        new ReadFile(new VariableExpression("var_f"), "var_c"),
                                                        new PrintStatement(new VariableExpression("var_c"))
                                                ),
                                                new PrintStatement(new ConstantExpression(0))
                                        ),
                                        new CloseRFile(new VariableExpression("var_f"))
                                )
                        )
                )
        );



        IRepository r = new Repository("test.txt");
        ProgramState prog = new ProgramState(symDict, exeStack, out, s, fileTable);
        r.add(prog);
        InterpreterController controller = new InterpreterController(r);
        while(!prog.getExeStack().isEmpty()) {
            System.out.println("Choose one step (1) or all steps (2)");
            int cmd1 = sc.nextInt();
            if (cmd1 == 1) {
                controller.oneStep(prog);
            } else {
                controller.allSteps();
            }
            System.out.println(r.getCurrentProgram());

        }


    }
}
