package com.epam.javacore2019.steve;

import com.epam.javacore2019.steve.db.DBApplication;

public class MainApplication {

    static private int count = 1;
    public static void main(String[] args) {
        DBApplication.INSTANCE.start();


    }
}

/*
TODO
- чтение из файлов data и structure
- вывод в консоль по формату таблицы
- вывод в таблицу только запроценных данных
- шифрование данных (16, Цезарь)


- сделать сервер в стив аппликайшн

 */
