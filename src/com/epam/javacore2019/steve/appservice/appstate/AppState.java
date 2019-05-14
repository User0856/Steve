package com.epam.javacore2019.steve.appservice.appstate;

import com.epam.javacore2019.steve.appservice.server.AppServer;

import java.io.IOException;

public abstract class AppState {

    protected String name;

    public AppState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void onCommand(String commandName);

    public void enter(String commandName){

        try {
            AppServer.INSTANCE.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Default call for app entering state...");
    };

    public void exit(){

    };


}
