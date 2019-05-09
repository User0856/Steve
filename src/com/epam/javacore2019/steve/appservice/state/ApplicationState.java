package com.epam.javacore2019.steve.appservice.state;

public abstract class ApplicationState {

    public abstract void onCommand(String commandName);

    public abstract void enter(String commandName);

    public abstract void exit();


}
