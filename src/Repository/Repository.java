package Repository;

import Model.ADT.MyList;
import Model.ProgramState;
import Exception.ADTException;

import java.io.*;

public class Repository implements IRepository{

    private MyList<ProgramState> programStates;
    private String logFile;
    private PrintWriter printWriter;
    private boolean firtsTime = true;
    private int current = 0;

    public Repository(String logFile) {
        programStates = new MyList<>();
        this.logFile = logFile;
    }

    @Override
    public ProgramState getCurrentProgram() {
        return programStates.get(current);
    }

    @Override
    public void add(ProgramState p) {
        programStates.add(p);
    }

    @Override
    public void logProgramStateExec() throws IOException {
        printWriter = new PrintWriter(new BufferedWriter(new FileWriter(logFile, true)));
        printWriter.println("EXE STACK");
        printWriter.println(getCurrentProgram().getExeStack().toString());
        printWriter.println("SYM TABLE");
        printWriter.println(getCurrentProgram().getSymTable().toString());
        printWriter.println("OUTPUT");
        printWriter.println(getCurrentProgram().getOutput().toString());
        printWriter.println("FILE TABLE");
        printWriter.println(getCurrentProgram().getFileTable().toString());
        printWriter.println("HEAP");
        printWriter.println(getCurrentProgram().getHeap().toString());
        printWriter.println("_____________________");
        printWriter.close();
    }
}
