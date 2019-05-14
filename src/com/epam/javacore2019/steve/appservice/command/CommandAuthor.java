package com.epam.javacore2019.steve.appservice.command;

import static com.epam.javacore2019.steve.appservice.ServerApplication.AUTHOR;

public class CommandAuthor extends ACommand {
    public CommandAuthor(String name) {
        super(name);
    }

    @Override
    public String execute() {
        //System.out.println("My author is " + AUTHOR);
        return("My author is " + AUTHOR);



    }
}
