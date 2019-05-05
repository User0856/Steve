package com.epam.javacore2019.steve.db;

import com.epam.javacore2019.steve.db.data.QueryResult;
import com.epam.javacore2019.steve.db.dbstate.DBState;
import com.epam.javacore2019.steve.db.dbstate.DBStateInit;
import com.epam.javacore2019.steve.db.dbstate.DBStateRunning;
import com.epam.javacore2019.steve.db.dbstate.DBStateStop;

public enum DBApplication {
    INSTANCE;

    public static final String DATA_ENCRYPTION_LEVEL = "LOW";
    private DBState currentState;
    public DBState stateInit = new DBStateInit("Initializing");
    public DBState stateRun = new DBStateRunning("Running");
    public DBState stateStop = new DBStateStop("Stopped");

    public void start() {
        changeState(stateInit);

    }

    public void stop() {
        currentState.onStop();
    }

    public QueryResult query(String query) {
        return null;
    }

    public void changeState(DBState state) {
        if (currentState != null) {
            if (currentState.equals(state)) {
                return;
            } else {
                currentState.exit();
            }
        }
        currentState = state;
        currentState.enter();
    }

    public String getStateName(){
        return currentState.getName();
    }

}
