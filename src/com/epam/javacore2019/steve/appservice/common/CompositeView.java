package com.epam.javacore2019.steve.appservice.common;

import java.util.ArrayList;
import java.util.List;

public class CompositeView extends BaseView {
    public List<BaseView> children = new ArrayList<>();


    @Override
    public void draw(){
        for (BaseView view : children) {
            view.draw();
        }
        // drawing commands;
    }

    public void addChildView(BaseView view){
        children.add(view);
    }

}
