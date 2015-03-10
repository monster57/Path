package com.path;

public class Path{

    public static void main(String[] args) {
        System.out.println(args);
        String option = args[0];
        String fileName = args[1];
        String countryOption = args[2];
        String countryList = args[3];
        String otherOption = args[4];
        String source;
        String destination;
        if(otherOption.equals("-a")){
            source = args[5];
            destination = args[6];
        }
        else{
            source = args[4];
            destination = args[5];
        }


        PathLib PathCreator = new PathLib(fileName , countryList);
        if(!PathCreator.isCityPresentInDatabase(source))
            System.out.println("No city named "+source+" in database");
        if(!PathCreator.isCityPresentInDatabase(destination)){
            System.out.println("No city named "+destination+" in database");
        }
        boolean cityPresent = PathCreator.isCityPresentInDatabase(source) && PathCreator.isCityPresentInDatabase(destination);
        if(cityPresent && option.equals("-f") && countryOption.equals("-c")){
            System.out.println(PathCreator.printPath(otherOption , source ,destination));
        }

    }
}
