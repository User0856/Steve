package com.epam.javacore2019.steve.db.server;

import com.epam.javacore2019.steve.db.DBApplication;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.util.stream.Collectors;

public class QueryHandler implements HttpHandler {


    @Override
    public void handle(HttpExchange exchange) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(exchange.getRequestBody(), "UTF-8"));
        String request = br.lines().collect(Collectors.joining(System.lineSeparator()));




        String response = DBApplication.INSTANCE.getStateName();
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();


    }
}


/*
        String query = "SELECT id, firstName, lastName, FROM Criminals";

        Pattern p = Pattern.compile(OP_GROUP + SPACE + FLD_GROUP + SPACE + FROM_GROUP + SPACE + TBL_GROUP);
        Matcher matcher = p.matcher(query);
        if(matcher.find()){
            System.out.println("Number of groups: " + matcher.groupCount());
            for (int i = 0, len = matcher.groupCount(); i <= len; i++) {
                System.out.println(matcher.group(i));
            }
        }
 */