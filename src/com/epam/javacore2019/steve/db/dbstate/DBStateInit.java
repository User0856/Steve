package com.epam.javacore2019.steve.db.dbstate;

import com.epam.javacore2019.steve.db.DBApplication;
import com.epam.javacore2019.steve.db.misc.DBConstants;
import com.epam.javacore2019.steve.db.misc.Utils;
import com.epam.javacore2019.steve.db.misc.DataHandler;
import com.epam.javacore2019.steve.db.data.Table;
import com.epam.javacore2019.steve.db.data.TableMetaData;
import com.epam.javacore2019.steve.db.server.DBServer;

public class DBStateInit extends DBState {

    public DBStateInit(String name){
        super(name);
    }

    @Override
    public void enter() {
        System.out.println("Entering DBInit state");
        initTables();

        try{
            DBServer.INSTANCE.start();
            DBApplication.INSTANCE.changeState(DBApplication.INSTANCE.stateRun);
        } catch (Exception e){

        }

    }

    private void initTables() {
        Utils.readDir(DBConstants.TABLE_DIR, new DataHandler() {
            @Override
            public void handleFile(String filePath) {
                TableMetaData metaData = TableMetaData.loadFromFile(filePath);
                Table table = new Table(metaData);
                table.load();
            }
        });
    }

    @Override
    public void onStop() {
        //check if everything is ok
        DBApplication.INSTANCE.changeState(DBApplication.INSTANCE.stateStop);
    }
}
