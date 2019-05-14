package com.epam.javacore2019.steve.webclient;

import java.util.Map;

public class Template {

    public String templateFileName; //crimiinalprofile.html    //html file
    public Map<String, String> values;


    public Template(String fileName, Map<String, String> values){
        this.values = values;
        this.templateFileName = fileName;
    }

    public String compile(){

        String templateText = ""; //read file from disc Utils.readFile(templateFilename)
        for(String key: values.keySet()) {
            templateText = templateText.replace("{{" + key + "}}", values.get(key));
        }

        return templateText;
    }

    /*
    map.put("FirstName", "Steve");
    map.put("lastName", "Forest");
     */


}
