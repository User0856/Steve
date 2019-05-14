package com.epam.javacore2019.steve.appservice.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class CrminalsApiHandler implements HttpHandler {

    public static final String LIST_REQUEST = "(.*[/]+[criminals]+[/])"; //"/criminals"
    public static final String PERSON_REQUEST = "([/]+[criminals]+[/]+[0-9]+)"; //"/criminals/{n}"

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();
        String response ="";
        if(path.matches(LIST_REQUEST)){
            response = "LIST";
        } else if (path.matches(PERSON_REQUEST)) {
            response = "PERSON";
        } else {
            response = "400";
        }
        //response
        exchange.getRequestHeaders().put("Content-type", Arrays.asList(new String[]{"text/plain"}));
        exchange.sendResponseHeaders(200, 0);

        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());

        os.close();


    }
}
