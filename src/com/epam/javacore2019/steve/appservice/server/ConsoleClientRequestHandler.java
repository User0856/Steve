package com.epam.javacore2019.steve.appservice.server;

import com.epam.javacore2019.steve.appservice.command.ACommand;
import com.epam.javacore2019.steve.appservice.command.CommandRegistry;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.stream.Collectors;

public class ConsoleClientRequestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(exchange.getRequestBody(), "UTF-8"));
        String name = br.lines().collect(Collectors.joining(System.lineSeparator()));

        String response = "";




        if(CommandRegistry.INSTANCE.hasCommand(name)){
            ACommand command = CommandRegistry.INSTANCE.getCommand(name);
            response = command.execute();

            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();


        } else {
            response = ("Command \"" + name + "\" not implemented");

            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();

        }


    }
}
