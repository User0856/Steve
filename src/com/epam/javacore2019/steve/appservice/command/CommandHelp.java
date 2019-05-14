package com.epam.javacore2019.steve.appservice.command;

public class CommandHelp  extends ACommand{
    public CommandHelp(String name) {
        super(name);
    }

    @Override
    public String execute(){


        return CommandRegistry.INSTANCE.listCommands();
    }
}
