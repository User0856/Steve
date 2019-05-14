package com.epam.javacore2019.steve.consoleclient.server;

import com.epam.javacore2019.steve.dbservice.server.QueryHandler;
import com.epam.javacore2019.steve.dbservice.server.StatusHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public enum ConsoleClientServer {
    INSTANCE;

    public static final int PORT = 6705;

    public void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 10);

        server.start();

        String message = String.format("Console client server is running on port: %d", server.getAddress().getPort());
        System.out.println(message);

    }




}
