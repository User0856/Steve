package com.epam.javacore2019.steve.appservice.Command;

public class CommandHelp  extends ACommand{
    public CommandHelp(String name) {
        super(name);
    }

    @Override
    public void execute(){
        CommandRegistry.INSTANCE.listCommands();
    }
}
