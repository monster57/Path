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
    public Map<String , List<String>> databaseCreator(String fileName){
        MyFileReader file = new MyFileReader();
        Database database = new Database();
        String str = file.readFile(fileName);
        String[] arrOfString = str.split("\r\n");
        Map<String , List<String>> map = database.mapper(arrOfString);
        return map;
    }

}