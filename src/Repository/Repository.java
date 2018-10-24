package Repository;

import Model.ADT.MyList;
import Model.ProgramState;

public class Repository implements IRepository{
    MyList<ProgramState> programStates;
    int current = 0;

    public Repository() {
        programStates = new MyList<>();
    }

    @Override
    public ProgramState getCurrentProgram() {
        return programStates.get(current);
    }

    @Override
    public void add(ProgramState p) {
        programStates.add(p);
    }
}
