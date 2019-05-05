package com.epam.javacore2019.steve.db.dbstate;

import com.epam.javacore2019.steve.db.misc.DBConstants;
import com.epam.javacore2019.steve.db.misc.Utils;

import java.util.ArrayList;
import java.util.List;

public class DBStateStop extends DBState {

    public DBStateStop(String name){
        super(name);
    }


    @Override
    public void enter() {
        System.out.println("Entering state: Stop");

        List<String> list = new ArrayList<>();
        list.add("test string one");
        list.add("test string two");
        Utils.writeListToFile(list, DBConstants.DATA_DIR + "/test.dat");
    }

    @Override
    public void onStop() {
        System.out.println("Already trying to stop...");
    }
}
