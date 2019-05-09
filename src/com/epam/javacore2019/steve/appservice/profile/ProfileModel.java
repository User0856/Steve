package com.epam.javacore2019.steve.appservice.profile;

import com.epam.javacore2019.steve.appservice.common.BaseModel;
import com.epam.javacore2019.steve.appservice.db.Record;

import java.util.Date;


public class ProfileModel extends BaseModel {

    private int id;
    private String firstName;
    private String lastName;
    private boolean active;
    private String nickname;
    private int numberOfCrimes;
    private Date dateOfBirth;
    private boolean deceased;
    private String description;
    private String placeOfBirth;


    public ProfileModel(int id, String firstName, String lastName, boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
    }

    public static ProfileModel randomModel(){
        int rId = (int)(10*Math.random());
        boolean rActive = rId % 2 == 0;
        String rFirstName = "Steve_" + rId;
        String rLastName = "Balmer_" + rId;
        return new ProfileModel(rId, rFirstName, rLastName, rActive);
    }

    ProfileModel(){};

    public static ProfileModel modelFromRecord(Record recuord){
        ProfileModel model = new ProfileModel();
        try{
            model
                    .setDeceased(recuord.getBoolean("deceased"))
                    .setId(recuord.getInt("id"));
        } catch (Exception e){

        }
        return null;


    }

    public boolean isDeceased() {
        return deceased;
    }

    public ProfileModel setDeceased(boolean deceased) {
        this.deceased = deceased;
        return this;

    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName(){
        return firstName + " " + lastName;
    }


}
