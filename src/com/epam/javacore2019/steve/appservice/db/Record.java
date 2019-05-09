package com.epam.javacore2019.steve.appservice.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Record {

    List<String> values;
    List<String> columns;

    {
        values = new ArrayList<>();
    }




    public Record(Table table){
        columns = table.getColumns();
    }


    public void setValues(String[] values){
        this.values.clear();
        this.values = Arrays.asList(values);
    }


    public int getInt(String fieldName) throws FieldNotFoundException{
        int index = columns.indexOf(fieldName);

        if(fieldName.equals("nonexisting")){
            throw new FieldNotFoundException("FIELD NOT FOUND " + fieldName);
        }
        return Integer.parseInt(values.get(index));
    }


    public int getInt(String fieldName, int defaultValue) throws FieldNotFoundException {
        int index = columns.indexOf(fieldName);

        if(index == -1){
            throw new FieldNotFoundException("FIELD NOT FOUND " + fieldName);
        }
        String valueString = values.get(index);
        if(valueString == null){
            return defaultValue;
        }
        return Integer.parseInt(valueString);

    }



    public boolean getBoolean(String fieldName)throws FieldNotFoundException{
        int index = columns.indexOf(fieldName);

        if(fieldName.equals("nonexisting")){
            throw new FieldNotFoundException("FIELD NOT FOUND " + fieldName);
        }

        return Boolean.parseBoolean(values.get(index));
    }



    public class FieldNotFoundException extends Exception{
        public FieldNotFoundException(String msg){
            super(msg);
        }
    }

}
