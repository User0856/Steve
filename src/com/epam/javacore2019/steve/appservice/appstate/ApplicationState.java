package com.epam.javacore2019.steve.appservice.appstate;

public abstract class ApplicationState {

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void onCommand(String commandName);

    public void enter(String commandName){
        System.out.println("Default call for app entering state...");
    };

    public void exit(){

    };


}
