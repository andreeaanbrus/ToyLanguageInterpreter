package Repository;

import Model.ProgramState;
import Exception.ADTException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository{

    private List<ProgramState> programStates;
    private String logFile;
    private PrintWriter printWriter;
    private boolean firtsTime = true;
    private int current = 0;

    public Repository(String logFile) {
        programStates = new ArrayList<>();
        this.logFile = logFile;
    }

//    @Override
//    removed lab 8
//    public ProgramState getCurrentProgram() {
//        return programStates.get(current);
//    }

    @Override
    public List<ProgramState> getProgramStates() {
        return programStates;
    }

    @Override
    public void setProgramStates(List<ProgramState> ps) {
        this.programStates = ps;
    }

    @Override
    public void add(ProgramState p) {
        programStates.add(p);
    }

//    @Override
//    changed lab 8
//    public void logProgramStateExec() throws IOException {
//        printWriter = new PrintWriter(new BufferedWriter(new FileWriter(logFile, true)));
//        printWriter.println("EXE STACK");
//        printWriter.println(getCurrentProgram().getExeStack().toString());
//        printWriter.println("SYM TABLE");
//        printWriter.println(getCurrentProgram().getSymTable().toString());
//        printWriter.println("OUTPUT");
//        printWriter.println(getCurrentProgram().getOutput().toString());
//        printWriter.println("FILE TABLE");
//        printWriter.println(getCurrentProgram().getFileTable().toString());
//        printWriter.println("HEAP");
//        printWriter.println(getCurrentProgram().getHeap().toString());
//        printWriter.println("_____________________");
//        printWriter.close();
//    }

    public void logProgramStateExec(ProgramState programState) throws IOException{
        printWriter = new PrintWriter(new BufferedWriter(new FileWriter(logFile, true)));
        printWriter.println(programState.getThreadId());
        printWriter.println("EXE STACK");
        printWriter.println(programState.getExeStack().toString());
        printWriter.println("SYM TABLE");
        printWriter.println(programState.getSymTable().toString());
        printWriter.println("OUTPUT");
        printWriter.println(programState.getOutput().toString());
        printWriter.println("FILE TABLE");
        printWriter.println(programState.getFileTable().toString());
        printWriter.println("HEAP");
        printWriter.println(programState.getHeap().toString());
        printWriter.println("_____________________");
        printWriter.close();
    }
}
