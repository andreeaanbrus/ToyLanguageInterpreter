package View;

import Controller.InterpreterController;
import Model.ADT.MyDictionary;
import Model.ADT.MyHeap;
import Model.ADT.MyList;
import Model.ADT.MyStack;
import Model.Command.ExitCommand;
import Model.Command.RunExample;
import Model.Expression.*;
import Model.ProgramState;
import Model.Statement.*;
import Repository.*;
import javafx.util.Pair;

import java.io.BufferedReader;

public class View {

    public static void main(String args[]) {

//        v = 2; print(v);
//        MyDictionary<String, Integer> symDict1 = new MyDictionary<>();
//        MyList<Integer> out1 = new MyList<>();
//        MyStack<IStatement> exeStack1 = new MyStack<>();
//        MyDictionary<Integer, Pair<String, BufferedReader>> fileTable1 = new MyDictionary<>();
//        MyHeap <Integer> heap1 = new MyHeap<>();
//
//        IStatement ex1 = new CompoundStatement(new AssignmentStatement("v",new ConstantExpression(2)), new PrintStatement(new
//                    VariableExpression("v")));
//
//        ProgramState programState1 = new ProgramState(symDict1, exeStack1, out1, ex1, fileTable1, heap1, 0);
//        IRepository repo1 = new Repository("test.txt");
//        repo1.add(programState1);
//        InterpreterController ctrl1 = new InterpreterController(repo1);


        
////         a=2+3*5;b=a+1; print(b) is represented as:
//        MyDictionary<String, Integer> symDict2 = new MyDictionary<>();
//        MyList<Integer> out2 = new MyList<>();
//        MyStack<IStatement> exeStack2 = new MyStack<>();
//        MyDictionary<Integer, Pair<String, BufferedReader>> fileTable2 = new MyDictionary<>();
//        MyHeap heap2 = new MyHeap();
//        IStatement ex2 = new CompoundStatement(new AssignmentStatement("a", new ArithmeticExpression(new ConstantExpression(2),'+',new
//                    ArithmeticExpression(new ConstantExpression(3),'*' ,new ConstantExpression(5)))),
//                    new CompoundStatement(new AssignmentStatement("b",new ArithmeticExpression(new VariableExpression("a"),'+', new
//                            ConstantExpression(1))), new PrintStatement(new VariableExpression("b"))));
//        ProgramState programState2 = new ProgramState(symDict2, exeStack2, out2, ex2, fileTable2, heap2, 0);
//        IRepository repo2 = new Repository("test2.txt");
//        repo2.add(programState2);
//        InterpreterController ctrl2 = new InterpreterController(repo2);
//
////      a=2-2;(If a Then v=2 Else v=3);Print(v) is represented as
//        MyDictionary<String, Integer> symDict3 = new MyDictionary<>();
//        MyList<Integer> out3 = new MyList<>();
//        MyStack<IStatement> exeStack3 = new MyStack<>();
//        MyDictionary<Integer, Pair<String, BufferedReader>> fileTable3 = new MyDictionary<>();
//        MyHeap heap3 = new MyHeap();
//        IStatement ex3 = new CompoundStatement(new AssignmentStatement("a", new ArithmeticExpression( new ConstantExpression(2),'-', new
//                    ConstantExpression(2))), new CompoundStatement(new IfStatement(new VariableExpression("a"), new AssignmentStatement("v", new ConstantExpression(2)), new
//                    AssignmentStatement("v", new ConstantExpression(3))), new PrintStatement(new VariableExpression("v"))));
//        ProgramState programState3 = new ProgramState(symDict3, exeStack3, out3, ex3, fileTable3, heap3, 0);
//        IRepository repo3 = new Repository("test3.txt");
//        repo3.add(programState3);
//        InterpreterController ctrl3 = new InterpreterController(repo3);
//
////      openRFile(var_f,"test.in");
////      readFile(var_f,var_c);print(var_c);
////      (if var_c then readFile(var_f,var_c);print(var_c)
////      else print(0));
////      closeRFile(var_f)
//        MyDictionary<String, Integer> symDict4 = new MyDictionary<>();
//        MyList<Integer> out4 = new MyList<>();
//        MyStack<IStatement> exeStack4 = new MyStack<>();
//        MyDictionary<Integer, Pair<String, BufferedReader>> fileTable4 = new MyDictionary<>();
//        MyHeap heap4 = new MyHeap();
//        IStatement ex4 = new CompoundStatement(
//                new OpenRFile("test.in", "var_f"),
//                new CompoundStatement(
//                        new ReadFile(new VariableExpression("var_f"), "var_c"),
//                        new CompoundStatement(
//                                new PrintStatement(new VariableExpression("var_c")),
//                                new CompoundStatement(
//                                        new IfStatement(
//                                                new VariableExpression("var_c"),
//                                                new CompoundStatement(
//                                                        new ReadFile(new VariableExpression("var_f"), "var_c"),
//                                                        new PrintStatement(new VariableExpression("var_c"))
//                                                ),
//                                                new PrintStatement(new ConstantExpression(0))
//                                        ),
//                                        new CloseRFile(new VariableExpression("var_f"))
//                                )
//                        )
//                )
//        );
//        ProgramState programState4 = new ProgramState(symDict4, exeStack4, out4, ex4, fileTable4, heap4, 0);
//        IRepository repo4 = new Repository("test4.txt");
//        repo4.add(programState4);
//        InterpreterController ctrl4 = new InterpreterController(repo4);
//
////      openRFile(var_f,"test.in");
////      readFile(var_f+2,var_c);print(var_c);
////      (if var_c then readFile(var_f,var_c);print(var_c)
////      else print(0));
////      closeRFile(var_f)
//        MyDictionary<String, Integer> symDict5 = new MyDictionary<>();
//        MyList<Integer> out5 = new MyList<>();
//        MyStack<IStatement> exeStack5 = new MyStack<>();
//        MyDictionary<Integer, Pair<String, BufferedReader>> fileTable5 = new MyDictionary<>();
//        MyHeap heap5 = new MyHeap();
//        IStatement ex5 = new CompoundStatement(
//                new OpenRFile("test.in", "var_f"),
//                new CompoundStatement(
//                        new ReadFile(new ArithmeticExpression(new VariableExpression("var_f"), '+', new ConstantExpression( 2)), "var_c"),
//                        new CompoundStatement(
//                                new PrintStatement(new VariableExpression("var_c")),
//                                new CompoundStatement(
//                                        new IfStatement(
//                                                new VariableExpression("var_c"),
//                                                new CompoundStatement(
//                                                        new ReadFile(new VariableExpression("var_f"), "var_c"),
//                                                        new PrintStatement(new VariableExpression("var_c"))),
//                                                new PrintStatement(new ConstantExpression(0))),
//                                        new CloseRFile(new VariableExpression("var_f")))
//                        )
//                )
//        );
//        ProgramState programState5 = new ProgramState(symDict5, exeStack5, out5, ex5, fileTable5, heap5, 0);
//        IRepository repo5 = new Repository("test5.txt");
//        repo5.add(programState5);
//        InterpreterController ctrl5 = new InterpreterController(repo5);

        //Example 6 : v=10;new(v,20);new(a,22);print(v)

        MyDictionary<String, Integer> symDict6 = new MyDictionary<>();
        MyList<Integer> out6 = new MyList<>();
        MyStack<IStatement> exeStack6 = new MyStack<>();
        MyDictionary<Integer, Pair<String, BufferedReader>> fileTable6 = new MyDictionary<>();
        MyHeap<Integer> heap6 = new MyHeap<>();
        IStatement ex6 = new CompoundStatement(
                new AssignmentStatement("v", new ConstantExpression(10)),
                new CompoundStatement(
                        new NewStatement("v", new ConstantExpression(20)),
                        new CompoundStatement(
                                new NewStatement("a", new ConstantExpression(22)),
                                new PrintStatement(new VariableExpression("v"))
                                )
                        )
        );
        ProgramState programState6 = new ProgramState(symDict6, exeStack6, out6, ex6,fileTable6, heap6, 0);
        IRepository repo6 = new Repository("test6.txt");
        repo6.add(programState6);
        InterpreterController ctrl6 = new InterpreterController(repo6);

        //Example: v=10;new(v,20);new(a,22);print(100+rH(v));print(100+rH(a))
        MyDictionary<String, Integer> symDict7 = new MyDictionary<>();
        MyList<Integer> out7 = new MyList<>();
        MyStack<IStatement> exeStack7 = new MyStack<>();
        MyDictionary<Integer, Pair<String, BufferedReader>> fileTable7 = new MyDictionary<>();
        MyHeap<Integer> heap7 = new MyHeap<>();
        IStatement ex7 = new CompoundStatement(
                    new AssignmentStatement("v", new ConstantExpression(10)),
                    new CompoundStatement(
                            new NewStatement("v", new ConstantExpression(20)),
                            new CompoundStatement(
                                    new NewStatement("a", new ConstantExpression(22)),
                                    new CompoundStatement(
                                            new PrintStatement(new ArithmeticExpression(
                                                    new ConstantExpression(100), '+', new HeapReadingExpression("v"))),
                                                    new PrintStatement(new ArithmeticExpression(
                                                            new ConstantExpression(100), '+', new HeapReadingExpression("a")
                                                    ))
                                    )
                            )
                    )
        );
        ProgramState programState7 = new ProgramState(symDict7, exeStack7, out7, ex7,fileTable7, heap7, 0);
        IRepository repo7 = new Repository("test7.txt");
        repo7.add(programState7);
        InterpreterController ctrl7 = new InterpreterController(repo7);

        //Example: v=10;new(v,20);new(a,22);wH(a,30);print(a);print(rH(a))

        MyDictionary<String, Integer> symDict8 = new MyDictionary<>();
        MyList<Integer> out8 = new MyList<>();
        MyStack<IStatement> exeStack8 = new MyStack<>();
        MyDictionary<Integer, Pair<String, BufferedReader>> fileTable8 = new MyDictionary<>();
        MyHeap<Integer> heap8 = new MyHeap<>();
        IStatement ex8 = new CompoundStatement(
                new AssignmentStatement("v", new ConstantExpression(10)),
                        new CompoundStatement(
                                new NewStatement("v", new ConstantExpression(20)),
                                new CompoundStatement(
                                        new NewStatement("a", new ConstantExpression(22)),
                                        new CompoundStatement(
                                                new HeapWritingStatement("a", new ConstantExpression(30)),
                                                new CompoundStatement(new PrintStatement(new VariableExpression("a")),
                                                        new PrintStatement(new HeapReadingExpression("a"))
                                        )
                                )
                        ))
        );
        ProgramState programState8 = new ProgramState(symDict8, exeStack8, out8, ex8, fileTable8, heap8, 0);
        IRepository repo8 = new Repository("text8.txt");
        repo8.add(programState8);
        InterpreterController ctrl8 = new InterpreterController(repo8);

        // v=10;new(v,20);new(a,22);wH(a,30);print(a);print(rH(a));a=0
        MyDictionary<String, Integer> symDict9 = new MyDictionary<>();
        MyList<Integer> out9 = new MyList<>();
        MyStack<IStatement> exeStack9 = new MyStack<>();
        MyDictionary<Integer, Pair<String, BufferedReader>> fileTable9 = new MyDictionary<>();
        MyHeap<Integer> heap9 = new MyHeap<>();
        IStatement ex9 = new CompoundStatement(
                new AssignmentStatement("v", new ConstantExpression(10)),
                new CompoundStatement(
                        new NewStatement("v", new ConstantExpression(20)),
                        new CompoundStatement(
                                new NewStatement("a", new ConstantExpression(22)),
                                new CompoundStatement(
                                        new HeapWritingStatement("a", new ConstantExpression(30)),
                                        new CompoundStatement(new PrintStatement(new VariableExpression("a")),
                                                new CompoundStatement(
                                                        new PrintStatement(new HeapReadingExpression("a")),
                                                        new AssignmentStatement("a", new ConstantExpression(0))
                                                )

                                        )
                                )
                        ))
        );
        ProgramState programState9 = new ProgramState(symDict9, exeStack9, out9, ex9, fileTable9, heap9, 0);
        IRepository repo9 = new Repository("text9.txt");
        repo9.add(programState9);
        InterpreterController ctrl9 = new InterpreterController(repo9);

////        v=6; (while (v-4) print(v);v=v-1);print(v)
        MyDictionary<String, Integer> symDict10 = new MyDictionary<>();
        MyList<Integer> out10 = new MyList<>();
        MyStack<IStatement> exeStack10 = new MyStack<>();
        MyDictionary<Integer, Pair<String, BufferedReader>> fileTable10 = new MyDictionary<>();
        MyHeap<Integer> heap10 = new MyHeap<>();
        // v=6; (while (v-4) print(v);v=v-1); print(v)
        IStatement ex10 = new CompoundStatement(
                new AssignmentStatement("v", new ConstantExpression(6)),
                new CompoundStatement(
                        new WhileStatement(new ArithmeticExpression(new VariableExpression("v"), '-', new ConstantExpression(4)),
                                new CompoundStatement(
                                        new PrintStatement(new VariableExpression("v")),
                                        new AssignmentStatement("v", new ArithmeticExpression(new VariableExpression("v"), '-', new ConstantExpression(1)))
                                )),
                        new PrintStatement(new VariableExpression("v")))
        );

//        IStatement ex10 = new CompoundStatement(
//                new AssignmentStatement("v", new ConstantExpression(6)),
//                new CompoundStatement(new  WhileStatement(new ArithmeticExpression(new VariableExpression("v"), '-', new ConstantExpression(4)),
//                                                         new CompoundStatement(new PrintStatement(new VariableExpression("v")),
//                                                                                new AssignmentStatement("v", new ArithmeticExpression(new VariableExpression("v"), '-', new ConstantExpression(1))))),
//
//                        new PrintStatement(new VariableExpression("v"))
//                        ));
        ProgramState programState10 = new ProgramState(symDict10, exeStack10, out10, ex10, fileTable10, heap10, 0);
        IRepository repo10 = new Repository("text10.txt");
        repo10.add(programState10);
        InterpreterController ctrl10 = new InterpreterController(repo10);




        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
//        menu.addCommand(new RunExample("2", ex2.toString(), ctrl2));
//        menu.addCommand(new RunExample("3", ex3.toString(), ctrl3));
//        menu.addCommand(new RunExample("4", ex4.toString(), ctrl4));
//        menu.addCommand(new RunExample("5", ex5.toString(), ctrl5));
        menu.addCommand(new RunExample("6", ex6.toString(), ctrl6));
        menu.addCommand(new RunExample("7", ex7.toString(), ctrl7));
        menu.addCommand(new RunExample("8", ex8.toString(), ctrl8));
        menu.addCommand(new RunExample("9", ex9.toString(), ctrl9));
        menu.addCommand(new RunExample("10", ex10.toString(), ctrl10));


        menu.show();

    }
}
