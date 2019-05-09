package com.epam.javacore2019.steve.appservice.profile;

import com.epam.javacore2019.steve.appservice.common.BaseView;
import com.epam.javacore2019.steve.appservice.common.CompositeView;
import com.epam.javacore2019.steve.appservice.common.ConsoleCanvas;

public class ProfileView extends CompositeView {


    public void draw (ConsoleCanvas canvas){
        for(BaseView view: children){
            view.draw(canvas);
        }

        //canvas.drawSquare(10);
        System.out.println("Criminal profile view");
        System.out.println("ID: " + ((ProfileModel)model).getId());
        System.out.println("Name: " + ((ProfileModel)model).getName());
        System.out.println("Active: " + ((ProfileModel)model).isActive());
    }


    public void init(){
        ProfilePhotoView photoView = new ProfilePhotoView(5, 5, 5);
        children.add(photoView);

    }



}
