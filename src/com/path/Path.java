package com.path;

public class Path{

    public static void main(String[] args) {
        String source = args[0];
        String destination = args[1];
        PathLib PathCreator = new PathLib();
        if(!PathCreator.isCityPresentInDatabase(source))
            System.out.println("No city named "+source+" in database");
        if(!PathCreator.isCityPresentInDatabase(destination)){
            System.out.println("No city named "+destination+" in database");
        }
        if(PathCreator.isCityPresentInDatabase(source) && PathCreator.isCityPresentInDatabase(destination)){
            System.out.println(PathCreator.giveRoutes(source, destination));
        }

    }
}
