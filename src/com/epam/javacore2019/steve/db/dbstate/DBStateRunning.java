package com.epam.javacore2019.steve.db.dbstate;

import com.epam.javacore2019.steve.db.DBApplication;

public class DBStateRunning extends DBState {

    public DBStateRunning(String name){
        super(name);
    }


    @Override
    public void enter() {
        System.out.println("Entering state: Running");
    }

    @Override
    public void onStop() {
        //check if everything is ok
        DBApplication.INSTANCE.changeState(DBApplication.INSTANCE.stateStop);
    }


}
