package com.epam.javacore2019.steve.webclient;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class HtmlHandler implements HttpHandler {

    public static final String HTML_FORMAT = "^/pages/(([a-zA-Z]+\\.)(html))$";



    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String path = exchange.getRequestURI().getPath();
        String response = "";
        if (path.matches(HTML_FORMAT)){
            response = path;
        } else{
            response = "invalid URL: " + path;
        }

        File file = new File("webclient/" + path);
        response +="\n File exists: " + file.exists();

        byte[] filebytes = null;
        if(file.exists()){
            filebytes = Utils.readBytes("webclient/" + path);
        }


        exchange.getRequestHeaders().put("Content-type", Arrays.asList(new String[]{"text/html"}));
        exchange.sendResponseHeaders(200, 0);

        OutputStream os = exchange.getResponseBody();
       // os.write(("Html Handler: " + response).getBytes());

        if(filebytes!=null){
            os.write(filebytes);
        }


        os.close();
    }
}
