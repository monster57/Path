package com.path;

import java.util.*;

/**
 * Created by surajitb on 3/7/2015.
 */
public class PathLib {
    private Map<String , List<String>> database;
    List <String> routes = new ArrayList<String>();
    public PathLib(String fileName) {
        Database data = new Database();
        database = data.databaseCreator(fileName);
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
            if(!routes.contains(ele)){
                if(database.get(ele).size() !=1){
                    newStart = ele;
                    break;
                }
            }
        }
        return newStart;
    }
    public boolean isPathAvailable(String source , String destination){
        List<String> directPath = database.get(source);
        routes.add(source);
        System.out.println(source);
        System.out.println(destination);

        if(directPath.contains(destination)){
            routes.add(destination);
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