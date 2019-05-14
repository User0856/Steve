package com.epam.javacore2019.steve.appservice.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public enum AppServer {
    INSTANCE;

    public static final int PORT = 6702;

    public void start() throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 10);
        server.createContext("/api/criminals", new CrminalsApiHandler()); //criminals/id
        server.start();
        String message = String.format("AppServer is running on port: %d", server.getAddress().getPort());
        System.out.println(message);



    }



}
