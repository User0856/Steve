package com.epam.javacore2019.steve.webservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Utils {

    public static byte[] readBytes(String filename){
        byte[] result = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filename);
            result = new byte[fis.available()];
            fis.read(result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;


    }

}
