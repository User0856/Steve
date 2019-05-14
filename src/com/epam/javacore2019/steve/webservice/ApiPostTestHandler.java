package com.epam.javacore2019.steve.webservice;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class ApiPostTestHandler implements HttpHandler {



    @Override
    public void handle(HttpExchange exchange) throws IOException {

        //received from browser
        InputStream is = exchange.getRequestBody();
        byte[] requsetBytes = new byte[is.available()];
        is.read(requsetBytes);


        //response
        exchange.getRequestHeaders().put("Content-type", Arrays.asList(new String[]{"text/plain"}));
        exchange.sendResponseHeaders(200, 0);

        OutputStream os = exchange.getResponseBody();
        os.write(requsetBytes);

        os.close();

    }
}
