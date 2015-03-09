package com.path;

public class Path{

    public static void main(String[] args) {
        String option = args[0];
        String fileName = args[1];
        String source = args[2];
        String destination = args[3];
        PathLib PathCreator = new PathLib(fileName);

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
