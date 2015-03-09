package com.path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by surajitb on 3/7/2015.
 */
class Database{
    public Map<String , List<String>> databaseCreator(){
        Map<String ,List<String>> database = new HashMap<String , List<String>>();
        List <String> Banglore = new ArrayList<String>();
        Banglore.add("Singapore");
        List <String> Singapore = new ArrayList<String>();
        Singapore.add("Seoul");
        Singapore.add("Dubai");
        Singapore.add("Banglore");
        List <String> Seoul =  new ArrayList<String>();
        Seoul.add("Beijing");
        Seoul.add("Singapore");

        List <String> Beijing =  new ArrayList<String>();
        Beijing.add("Seoul");
        Beijing.add("Tokyo");
        List <String> Dubai =  new ArrayList<String>();
        Dubai.add("Singapore");
        List <String> Tokyo =  new ArrayList<String>();
        Tokyo.add("Beijing");

        database.put("Banglore" , Banglore);
        database.put("Singapore" , Singapore);
        database.put("Seoul" , Seoul);
        database.put("Beijing" , Beijing);
        database.put("Dubai" , Dubai);
        database.put("Tokyo" , Tokyo);
        return database;
    }

}