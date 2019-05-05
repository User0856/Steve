package com.epam.javacore2019.steve.db.server;

import com.epam.javacore2019.steve.db.DBApplication;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

public class QueryHandler implements HttpHandler {


    @Override
    public void handle(HttpExchange exchange) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(exchange.getRequestBody(), "UTF-8"));
        String request = br.lines().collect(Collectors.joining(System.lineSeparator()));



        if(request.equals("status")){
            String response = DBApplication.INSTANCE.getStateName();
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } else {
            String response = "555";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }


    }
}


/*
//Test class for query handling


        BufferedReader br = new BufferedReader(new InputStreamReader(exchange.getRequestBody(), "UTF-8"));
        String request = br.lines().collect(Collectors.joining(System.lineSeparator()));



        if(request.equals("status")){
            String response = DBApplication.INSTANCE.getStateName();
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } else {
            String response = "555";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }


    }

 */