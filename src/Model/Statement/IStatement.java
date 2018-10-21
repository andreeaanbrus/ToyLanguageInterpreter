package Model.Statement;

import Model.ProgramState;

public interface IStatement {
//    String toString();
    ProgramState execute(ProgramState programState);
}
