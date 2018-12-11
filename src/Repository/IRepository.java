package Repository;

import Model.ProgramState;

import java.util.List;

public interface IRepository {
//    ProgramState getCurrentProgram();
    List<ProgramState> getProgramStates();
    void setProgramStates(List<ProgramState> ps);
    void add(ProgramState p);
    void logProgramStateExec(ProgramState ps) throws Exception;
}
