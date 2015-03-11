package com.path;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by surajitb on 3/7/2015.
 */

public class Database{
    public Map<String, List<String>> mapper(String[] arrOfString ){
        Map<String , List<String>> map = new HashMap<String , List<String>>();
        for(String element : arrOfString){
            String[] cities = element.split(",");
            List<String> list = new ArrayList<String>();
            if(!map.containsKey(cities[0])){
                list.add(cities[1]);
                map.put(cities[0] , list);
            }
            else map.get(cities[0]).add(cities[1]);
            List<String> list1 = new ArrayList<String>();
            if(!map.containsKey(cities[1])){
                list1.add(cities[0]);
                map.put(cities[1] , list1);
            }
            else map.get(cities[1]).add(cities[0]);
        }

        return map;
    }
    public String[] textSplitter(String fileName){
        MyFileReader file = new MyFileReader();
        Database database = new Database();
        String str = file.readFile(fileName);
        String[] arrOfString = str.split("\r\n");
        return arrOfString;
    }
    public Map<String , Integer> costSetter(String fileName , String countryFile){
        PathLib path = new PathLib(fileName , countryFile);
        Map<String ,Integer> costForRoute = new HashMap<String , Integer>();
        String[] arrOfString = textSplitter(fileName);
        for(String ele:arrOfString){
            String[] cities = ele.split(",");
            costForRoute.put( path.addCountry(cities[0])+"->"+path.addCountry(cities[1]) ,Integer.parseInt(cities[2]));
            costForRoute.put(path.addCountry(cities[0])+"->"+path.addCountry(cities[0]) , Integer.parseInt(cities[2]));
        }
        return costForRoute;
    }

    public Map<String , List<String>> databaseCreator(String fileName){
        String[] arrOfString = textSplitter(fileName);
        Map<String , List<String>> map = mapper(arrOfString);
        return map;
    }
    public Map<String,String> countryReader(String countryFile){
        MyFileReader file = new MyFileReader();
        String content = file.readFile(countryFile);
        Map<String,String> getCountryName = new HashMap<String,String>();
        String[] lines = content.split("\r\n");
        for(String line:lines){
            if(line!=null) {
                String path[] = line.split(",");
                getCountryName.put(path[0], path[1]);
            }
        }
        return getCountryName;
    }
}