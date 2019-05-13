package com.epam.javacore2019.steve.appservice.command;

import static com.epam.javacore2019.steve.appservice.ServerApplication.VERSION;

public class CommandVersion extends ACommand {
    public CommandVersion(String name) {
        super(name);
    }

    @Override
    public void execute() {
        System.out.println("My version is " + VERSION);
    }
}
