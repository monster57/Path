package com.path;

import java.util.*;

/**
 * Created by surajitb on 3/7/2015.
 */
public class PathLib {
    private Map<String , List<String>> database;
    private Map<String , String> countryList;
    List <String> routes = new ArrayList<String>();
    public PathLib(String fileName , String countryFile) {
        Database data = new Database();
        database = data.databaseCreator(fileName);
        countryList = data.countryReader(countryFile);
    }

    public  boolean isCityPresentInDatabase(String city){
        Set<String> newSet = database.keySet();
        if(newSet.contains(city)) return true;
        for(String ele:newSet){
            List<String> places = database.get(ele);
            if(places.contains(city)) return true;
        }
        return false;
    }

    public  String findStart(List<String> directPath){
        String newStart = null;
        for(String ele: directPath){
            if(!routes.contains(addCountry(ele))){
                System.out.println("this is routes "+ routes);
                System.out.println("this is data element "+database.get(ele));
                boolean isCityInDatabase = routes.contains(addCountry(database.get(ele).get(0)));
                if(database.get(ele).size()!=1 ){
                    newStart = ele;
                    break;
                }
            }
        }
        return newStart;
    }

    public String addCountry(String city){
        String country = countryList.get(city);
        return city+"["+country+"]";

    }

    public boolean isPathAvailable(String source , String destination){

        List<String> directPath = database.get(source);
        System.out.println("this is the directpath "+directPath);

        routes.add(addCountry(source));

        if(directPath.contains(destination)){
            routes.add(addCountry(destination));
            return true;
        }
        String newStart = findStart(directPath);
        return isPathAvailable(newStart , destination);
    }

    public String giveRoutes(String source  , String destination){
        String path = null;
        if(isPathAvailable(source , destination)){
            path  = String.join("->",routes);
        }
        return path;
    }
}