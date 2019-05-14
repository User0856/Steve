package com.epam.javacore2019.steve.appservice.command;

public abstract class ACommand {
    private String name;
    private String description;

    public ACommand(String name){
        this.name = name;
    }

    public String execute(){
        return ("Command \"" + name + "\" not implemented");
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
