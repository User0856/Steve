package com.epam.javacore2019.steve.db.server;

import com.epam.javacore2019.steve.db.DBApplication;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class StateHandler implements HttpHandler {


    @Override
    public void handle(HttpExchange request) throws IOException {
        String state = DBApplication.INSTANCE.getStateName();
        request.sendResponseHeaders(200, state.length());
        request.getRequestHeaders().put("Content-type", Arrays.asList(new String[]{"application/xml"}));
        OutputStream os = request.getResponseBody();
        os.write(state.getBytes());
        os.close();
    }
}
