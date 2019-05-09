package com.epam.javacore2019.steve.appservice.common;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseView {

    protected BaseModel model;
    public static List<BaseView> children = new ArrayList<>();

    public void draw(){
        System.out.println("Drawing should be implemented...");
    }

    public void draw(Canvas canvas){
        System.out.println("Drawing on canvas to be implemented...");

    }

    public void setModel(BaseModel model){
        this.model = model;
    }

}
