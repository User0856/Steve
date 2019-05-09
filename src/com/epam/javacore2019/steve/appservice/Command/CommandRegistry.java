package com.epam.javacore2019.steve.appservice.Command;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum CommandRegistry {
    INSTANCE;

    static Map<String, ACommand> commands;
    public static final String QUERY_NAME = "([a-zA-Z0-9]*) ";

    static {
        commands = new HashMap<>();
        CommandAuthor commandAuthor = new CommandAuthor("author");
        commands.put("version", new CommandVersion("version"));
        commands.put("author", new CommandAuthor("author"));
        commands.put("creator", new CommandAuthor("author"));
        commands.put("father", new CommandAuthor("author"));
        commands.put("help", new CommandHelp("help"));
        commands.put("status", new CommandDBStatus("database status"));
        commands.put("query", new CommandQuery("database query"));
        commands.put("query: " + QUERY_NAME, new CommandQuery("database query"));
    }

    public ACommand getCommand(String name){
        return commands.get(name);
    }


    public void listCommands(){
        Iterator it = commands.entrySet().iterator();
        System.out.println("List of commmands:");

        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            System.out.println(entry.getKey());
        }
    }

    public boolean hasCommand(String name){
        return commands.containsKey(name);
    }

}
