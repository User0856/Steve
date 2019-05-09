package com.epam.javacore2019.steve.dbservice.dbstate;

import com.epam.javacore2019.steve.dbservice.DBApplication;

public abstract class DBState {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected String name;

    public DBState(String name){
        this.name = name;
    }



    public void enter() {
        System.out.println("Basic entering state");
    }

    public void onQuery(String query) {
        System.out.println("Basic query handling");
    }

    public void exit() {
        System.out.println("Exiting state: " + DBApplication.INSTANCE.getStateName());
    }

    public void onStop() {
        System.out.println("Basic stop handling");
    }

}
