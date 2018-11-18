package Model.Statement;

import Model.ProgramState;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IStatement {
    ProgramState execute(ProgramState programState) throws IOException;
}