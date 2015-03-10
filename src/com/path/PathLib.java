package com.path;

import java.util.*;

/**
 * Created by surajitb on 3/7/2015.
 */
public class PathLib {
    private Map<String , List<String>> database;
    private Map<String , String> countryList;
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
    public String addCountry(String city){
        String country = countryList.get(city);
        return city+"["+country+"]";
    }

    public List<List<String>> getAllPath(String source, String destination) {
        List<String> path = new ArrayList<String>();
        List<List<String>> allPath = new ArrayList<List<String>>();
        givePath(path, allPath, source, destination);
        return allPath;
    }

    private void givePath(List<String> path, List<List<String>> allPath,String source, String destination) {
        path.add(addCountry(source));
        if (source.equals(destination)) {
            allPath.add(new ArrayList<String>(path));
            path.remove(addCountry(source));
            return;
        }
        List<String> destinationList = database.get(source);
        for (int counter = 0; counter < destinationList.size(); counter++) {
            if (!path.contains(addCountry(destinationList.get(counter)))) {
                givePath(path, allPath, destinationList.get(counter), destination);
            }
        }
        path.remove(addCountry(source));
    }

    public List<String> giveRoutes(String source  , String destination){
        List<String> pathList = new ArrayList<String>();
        List<List<String>> ListOfPathList = getAllPath(source , destination);
        for(List<String> ele:ListOfPathList){
            pathList.add(String.join("->",ele));
        }
        return pathList;
    }
    public String printPath(String option , String Source , String destination){
        List <String> list = giveRoutes(Source , destination);
        if(option.equals("-a")){
            String allPath = String.join("\r\n" , list);
            return allPath;
        }
        return list.get(0);
    }

}
