package com.epam.javacore2019.steve.webservice;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class CssHandler implements HttpHandler {



    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String path = exchange.getRequestURI().getPath();
        String response = "";

        response = path;
        File file = new File("webclient/" + path);
        response +="\n File exists: " + file.exists();

        byte[] filebytes = null;
        if(file.exists()){
            filebytes = Utils.readBytes("webclient/" + path);
        }


        exchange.getRequestHeaders().put("Content-type", Arrays.asList(new String[]{"text/css"}));
        exchange.sendResponseHeaders(200, 0);

        OutputStream os = exchange.getResponseBody();
        // os.write(("Html Handler: " + response).getBytes());

        if(filebytes!=null){
            os.write(filebytes);
        }


        os.close();


    }
}
