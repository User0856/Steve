package com.epam.javacore2019.steve.appservice.profile;

import com.epam.javacore2019.steve.appservice.common.BaseView;
import com.epam.javacore2019.steve.appservice.common.Canvas;

public class ProfilePhotoView extends BaseView {


    private int x;
    private int y;
    private int size;

    public ProfilePhotoView(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
    }

    @Override
    public void draw(Canvas canvas){
        canvas.drawSquare(5);
    }


}
