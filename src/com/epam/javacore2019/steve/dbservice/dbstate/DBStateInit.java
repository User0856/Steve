package com.epam.javacore2019.steve.dbservice.dbstate;

import com.epam.javacore2019.steve.dbservice.DBApplication;
import com.epam.javacore2019.steve.dbservice.misc.DBConstants;
import com.epam.javacore2019.steve.dbservice.misc.Utils;
import com.epam.javacore2019.steve.dbservice.misc.DataHandler;
import com.epam.javacore2019.steve.dbservice.data.Table;
import com.epam.javacore2019.steve.dbservice.data.TableMetaData;
import com.epam.javacore2019.steve.dbservice.server.DBServer;

public class DBStateInit extends DBState {

    public DBStateInit(String name){
        super(name);
    }

    @Override
    public void enter() {
        System.out.println("Entering state: Stop");
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
                DBApplication.INSTANCE.tables.add(table);
            }
        });
    }

    @Override
    public void onStop() {
        //check if everything is ok
        DBApplication.INSTANCE.changeState(DBApplication.INSTANCE.stateStop);
    }
}
