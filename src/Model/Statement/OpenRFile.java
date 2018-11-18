package Model.Statement;

import Model.ADT.MyDictionary;
import Model.ProgramState;
import javafx.util.Pair;
import Exception.ADTException;

import java.io.*;

public class OpenRFile implements IStatement {
//    private static int numberOfVarFileId = 1;
    private String filename;
    private String varFileId;

    public OpenRFile(String filename, String varFileId) {
        this.filename = filename;
        this.varFileId = varFileId;
    }

    @Override
    public ProgramState execute(ProgramState programState) throws ADTException, FileNotFoundException {
        MyDictionary<String, Integer> symTable = programState.getSymTable();
        MyDictionary<Integer, Pair<String, BufferedReader>> fileTable = programState.getFileTable();
        for(Pair<String, BufferedReader> e : fileTable.values())
            if(e.getKey().equals(filename)) {
                throw new ADTException("Filename already exists");
            }

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        Pair<String, BufferedReader> p = new Pair<>(filename, reader);
        int numberOfVarFileId = programState.getFileDescriptor();
        fileTable.put(numberOfVarFileId, p);
        symTable.put(varFileId, numberOfVarFileId);
//            numberOfVarFileId ++;
        return programState;
    }

    public String toString(){
        String s;
        s = "OpenRFile(" + filename + ", " + varFileId + ")";
        return s;
    }
}
