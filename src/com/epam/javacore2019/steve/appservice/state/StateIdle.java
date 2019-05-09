package com.epam.javacore2019.steve.appservice.state;

public class StateIdle extends ApplicationState {

    public void onCommand(String name){
        System.out.println("on... " + name + " has to wait");
    }

    @Override
    public void enter(String commandName) {
        System.out.println("enter..." + commandName);


    }

    @Override
    public void exit() {
        System.out.println("exit...");

    }

    ;



}
