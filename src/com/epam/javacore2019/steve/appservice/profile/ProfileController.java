package com.epam.javacore2019.steve.appservice.profile;

import com.epam.javacore2019.steve.appservice.common.ConsoleCanvas;

public class ProfileController {

    private ProfileModel profileModel;
    private ProfileView view;
    private ProfileStore store;
    private ConsoleCanvas canvas;

    {
        store.INSTANCE.loasData();
        view = new ProfileView();


    }



    public void showProfile(int id){

        ProfileModel model = store.INSTANCE.getProfile(id);
        if(model == null){
            System.out.println("No record with id " + id + " found");
        } else {
            view.setModel(model);
            view.draw();
            view.draw(canvas);

        }




    }





    public ProfileView getView() {
        return view;
    }

    public void setView(ProfileView view) {
        this.view = view;
    }

}
