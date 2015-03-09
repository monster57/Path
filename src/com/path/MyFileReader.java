package com.path;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by surajitb on 3/9/2015.
 */
public class MyFileReader {
    public String readFile(String fileName) {
        String str = null;
        File file = new File(fileName);
        try {
            FileReader reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            str = new String(chars);
            reader.close();
        } catch (IOException e) {
            System.out.println("Something went wrong......."+e);
        }
        return str;
    }
}