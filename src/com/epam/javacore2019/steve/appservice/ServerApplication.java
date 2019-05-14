package com.epam.javacore2019.steve.appservice;

import com.epam.javacore2019.steve.appservice.command.ACommand;
import com.epam.javacore2019.steve.appservice.command.CommandRegistry;
import com.epam.javacore2019.steve.appservice.appstate.AppState;
import com.epam.javacore2019.steve.appservice.server.AppServer;

import java.io.IOException;
import java.util.Scanner;

public enum ServerApplication {
    INSTANCE;


    public static final String APP_NAME = "Steve";
    static public final String AUTHOR = "Aleksandr Lutkov";
    static public final String VERSION = "0.0.1";

    public static final String OP_GROUP = "^(SELECT|DELETE)";
    public static  final String FLD_GROUP = "([a-zA-Z, ]+)";
    public static final String SPACE = "([\\s]+)";
    public static final String FROM_GROUP = "(FROM)";
    public static final String TBL_GROUP = "([a-zA-Z]+)$";

    static AppState currentState;



    public static void main(String[] args) throws IOException {


    }

    public void start(){

        try {
            AppServer.INSTANCE.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        String name;
        while (sc.hasNext()){
            name = sc.nextLine();
            if(CommandRegistry.INSTANCE.hasCommand(name)){
                ACommand command = CommandRegistry.INSTANCE.getCommand(name);
                command.execute();
            } else {
                System.out.println("Command \"" + name + "\" not implemented");
            }
        }

    }

    public static void changeState(AppState newState, String commandName){
        if(currentState != null){
            if(currentState.equals(newState)){
                return;
            } else {
                currentState.exit();
            }
        }
        currentState = newState;
        currentState.enter(commandName);
    }

}





/*



                public static final String ALLOWED_DOMAIN_NAMES = "^([a-zA-Z0-9]+\\.)+(com|de|ru)$";
    public static final String OP_GROUP = "^(SELECT|DELETE)";
    public static  final String FLD_GROUP = "([a-zA-Z, ]+)";
    public static final String SPACE = "([\\s]+)";
    public static final String FROM_GROUP = "(FROM)";
    public static final String TBL_GROUP = "([a-zA-Z]+)$";





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
