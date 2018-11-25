package Model.Command;


import Controller.InterpreterController;
import Exception.ADTException;

import java.io.IOException;


public class RunExample extends Command {
    private InterpreterController controller;
    public RunExample(String key, String description, InterpreterController controller) {
        super(key, description);
        this.controller = controller;
    }

    @Override
    public void execute() {
        try{
            controller.allSteps();
        }
        catch (ADTException e){
            System.out.println(e.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
