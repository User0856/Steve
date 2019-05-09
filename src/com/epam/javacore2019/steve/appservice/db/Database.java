package com.epam.javacore2019.steve.appservice.db;

import java.io.*;
import java.util.*;

public class Database {

    static final Map<String, Table> tables;

    private Object tableLock = new Object();
    public static final String[] CRIMNIALS_COLUMNS = new String[]{"id", "firstName"};
    public static final String[] CRIME_FAMILY_COLUMNS = new String[]{"id", "name"};

    //DB.query("SELECT ID, NAME, EMAIL FROM CRIMINAL WHERE ID = ?");

    static{
        tables = new HashMap<>();
        tables.put("Criminals", new Table("Criminals", Arrays.asList(CRIMNIALS_COLUMNS)));
        tables.put("Criminal Family", new Table("Criminal Family", Arrays.asList(CRIME_FAMILY_COLUMNS)));


    }
public void init(){
        //load data to tables
}



    public void select(){

        System.out.println("Starting fetching records...");
        synchronized (tableLock){
        try {
            Thread.sleep(500);
            System.out.println("Finishing fetching records");
        } catch (InterruptedException e) {
        }
        }
    }

    public void update(){
        System.out.println("Starting updating records...");
        synchronized (tableLock){
        try {
            Thread.sleep(5000);
            System.out.println("Finishing updating records...");
        } catch (InterruptedException e) {
        }
        }
    }

    public static List<String[]> readDataFile(String fileName){
        FileInputStream fis = null;
        List<String[]> result = new ArrayList<>();
        BufferedReader br;
        try{
            fis = new FileInputStream(fileName);
            br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
                result.add(line.split(";"));
            }
        } catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        } catch (IOException ioex){
            ioex.printStackTrace();
        } finally{
            try{
                fis.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }


        return null;
    }


    public void delete(){

    }

    public void insert(Record record, Table table){

    }


}
