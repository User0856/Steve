package com.epam.javacore2019.steve.appservice.appstate;

import com.epam.javacore2019.steve.appservice.ServerApplication;


public class AppStateExecutingCommand extends AppState {


    public AppStateExecutingCommand(String name) {
        super(name);
    }

    @Override
    public void enter(String commandName) {
        System.out.println("enter..." + commandName);
        executeCommmand(commandName);
        // get command by name
        //command execute
        //change state

    }
    @Override
    public void onCommand(String commandName) {
        System.out.println("on...");


    }



    @Override
    public void exit() {
        System.out.println("exitr...");

    }

    private void executeCommmand(String commandName){
 //       ServerApplication.changeState(new AppStateIdle(), "idle");

    }
}
