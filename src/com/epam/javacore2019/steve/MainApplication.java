package com.epam.javacore2019.steve;

import com.epam.javacore2019.steve.appservice.ServerApplication;
import com.epam.javacore2019.steve.dbservice.DBApplication;
import com.epam.javacore2019.steve.webservice.WebClientApplication;

public class MainApplication {

    static private int count = 1;
    public static void main(String[] args) {
        DBApplication.INSTANCE.start();

       /*
               try {
            WebClientApplication.INSTANCE.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */




    }
}

/*
TODO
- чтение из файлов data и structure
- вывод в консоль по формату таблицы
- вывод в таблицу только запроценных данных
- шифрование данных (16, Цезарь)


- сделать сервер в стив аппликайшн


 add Handlers
 /criminals/1
 / api/showprofile/1

what is %s %d

*/