package com.epam.javacore2019.steve.appservice.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table {

    protected String name;
    protected List <String> columns;
    protected List <Record> records;

    {
        records = new ArrayList<Record>();
    }

    public Table(String name, List<String> columns){
        this.name = name;
        this.columns = columns;
    }

    public Table(String name){
        this.name = name;
    }

    public void insert(Record record){
        records.add(record);
    }

    public List<String> getColumns(){

        return columns;
    }




    public List<String> selectField(String fieldName){
        int index = columns.indexOf(fieldName);
        Iterator it = records.iterator();
        List<String> result = new ArrayList<>();
        while(it.hasNext()){
            Record r = (Record)it.next();
            result.add(r.values.get(index));

        }
        return result;
    }


}

    /*
    TODO

    SELECT id, firstname, lastname
    make a separate thread, each entry with a delay 100 ms, include loading before table
    public void select(String query){



        -----------------------------------------------
        id             firstname             lastname
        -----------------------------------------------
        1               Firstname             Lastname



    ---------
    to innit dbs from file on start





     */