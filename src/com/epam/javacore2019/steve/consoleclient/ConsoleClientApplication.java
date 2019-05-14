package com.epam.javacore2019.steve.consoleclient;

import com.epam.javacore2019.steve.appservice.command.ACommand;
import com.epam.javacore2019.steve.appservice.command.CommandRegistry;
import com.epam.javacore2019.steve.consoleclient.server.ConsoleClientServer;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public enum ConsoleClientApplication {
    INSTANCE;

    public void start() {

//        try {
//            ConsoleClientServer.INSTANCE.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Scanner sc = new Scanner(System.in);
        String request;


        while (sc.hasNext()){
            request = sc.nextLine();
            sendRequest(request);

        }

    }

    public void sendRequest(String request){
        String response = "";
        URL url = null;
        try {
            url = new URL("http://localhost:6702/api/consoleclient/request");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
            dos.write(request.getBytes());
            dos.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((response = br.readLine()) !=null){
                System.out.println(response);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
