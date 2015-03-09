package com.path;

import java.util.*;

/**
 * Created by surajitb on 3/7/2015.
 */
public class PathLib {
    List <String> routes = new ArrayList<String>();
    public  boolean isCityPresentInDatabase(String city){
        Database data = new Database();
        Map<String , List<String>> database = data.databaseCreator();
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
                newStart = ele;
                break;
            }
        }
        return newStart;
    }
    public boolean isPathAvailable(String source , String destination){
        Database data = new Database();
        Map<String , List<String>> database = data.databaseCreator();
        List<String> directPath = database.get(source);
        routes.add(source);
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