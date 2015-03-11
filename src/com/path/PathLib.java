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
        for (int counter = 0; counter < destinationList.size(); counter++)
            if (!path.contains(addCountry(destinationList.get(counter))))
                givePath(path, allPath, destinationList.get(counter), destination);
        path.remove(addCountry(source));
    }

    public List<String> giveRoutes(String source  , String destination){
        List<String> pathList = new ArrayList<String>();
        List<List<String>> listOfPathList = getAllPath(source , destination);

        for(List<String> ele:listOfPathList){
            pathList.add(String.join("->",ele));
        }
        return pathList;

    }
    public Integer costCalculater(List<String> list , Map<String , Integer> map){
        Integer cost = 0;
        for(int i=0;i<list.size()-1;i++){
            cost += map.get(list.get(i)+"->"+list.get(i+1));
        }
        return cost;
    }
    public Map<Integer , String> routeCostSetter(String fileName , String countryFile , String source , String destination){
        Map <Integer , String> map = new HashMap<Integer , String>();
        List <String> list = giveRoutes(source , destination);
        int count = 0;
        Database data = new Database();
        Map<String ,Integer> costOfRoute = data.costSetter(fileName , countryFile);
        List<List<String>> allPath = getAllPath(source , destination);
        for(List<String> ele:allPath){
            Integer cost = costCalculater(ele , costOfRoute);
            map.put(cost ,list.get(count++));
        }
        return map;

    }
    public List<String> setPathListWithCost(Map<Integer , String> map){
        Set <Integer> set = map.keySet();
        List<String> list = new ArrayList();
        for(Integer ele: set){
            list.add(map.get(ele)+"\r\nTotal cost: "+ele);
        }
        return list;
    }
    public String printPath(String option ,String fileName,String countryFile, String source , String destination){
        Map<Integer , String> map = routeCostSetter(fileName , countryFile , source , destination);
        List<String> list = setPathListWithCost(map);
        if(option.equals("-a")){
            String allPathWithCost = String.join("\r\n" , list);
            return allPathWithCost;
        }
        return list.get(0);
    }
}
