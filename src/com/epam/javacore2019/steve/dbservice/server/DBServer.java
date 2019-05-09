package com.epam.javacore2019.steve.dbservice.server;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

import static com.sun.net.httpserver.HttpServer.create;


public enum DBServer {
    INSTANCE;
    public static final int PORT = 6701;


    public void start() throws Exception{
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 10);



        server.createContext("/db/serverstate", new StatusHandler());
        server.createContext("/db/query", new QueryHandler());

        server.start();

        String message = String.format("Server is running on port: %d", server.getAddress().getPort());
        System.out.println(message);



    }



}





      /*
              server.createContext("/db/state", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                String state = DBApplication.INSTANCE.getStateName();

                httpExchange.sendResponseHeaders(200, state.length());
                httpExchange.getRequestHeaders().put("Content-type", Arrays.asList(new String[]{"text/html"}));
                OutputStream os = httpExchange.getResponseBody();
                os.write(state.getBytes());
                os.close();

            }
        });
       */
