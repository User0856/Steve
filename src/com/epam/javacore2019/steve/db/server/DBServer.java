package com.epam.javacore2019.steve.db.server;
import com.epam.javacore2019.steve.db.DBApplication;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Arrays;

import static com.sun.net.httpserver.HttpServer.create;


public enum DBServer {
    INSTANCE;
    public static final int PORT = 6701;

    public static final String BAD_HTML =
            "<html>" +
                    "<head></head>" +
                    "<body><div style=\"background-color:green; color:blue;\">{{db_state}}</div></body>" +
                    "</html>";



    public void start() throws Exception{
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 10);
        server.createContext("/db/stste", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                String state = BAD_HTML.replace("{{db_state}}", DBApplication.INSTANCE.getStateName());
                //state = String.format(BAD_HTML, state);

                httpExchange.sendResponseHeaders(200, state.length());
                httpExchange.getRequestHeaders().put("Content-type", Arrays.asList(new String[]{"text/html"}));
                OutputStream os = httpExchange.getResponseBody();
                os.write(state.getBytes());
                os.close();

            }
        });
        server.start();
        String message = String.format("Server is running on port: %d", server.getAddress().getPort());
        System.out.println(message);



    }



}
