package com.epam.javacore2019.steve.webclient;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class ApiGetTestHandler implements HttpHandler {



    @Override
    public void handle(HttpExchange exchange) throws IOException {



        exchange.getRequestHeaders().put("Content-type", Arrays.asList(new String[]{"text/plain"}));
        exchange.sendResponseHeaders(200, 0);

        OutputStream os = exchange.getResponseBody();
        os.write(WebClientApplication.APP_NAME.getBytes());

        os.close();


    }
}
