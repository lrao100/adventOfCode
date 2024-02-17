package utils;

import day1.CountIncreases;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<Integer> parseFileToList(String name) {
        List<Integer> result = new ArrayList<>();
        try{
            InputStream is = CountIncreases.class.getClassLoader().getResourceAsStream(name);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String data;
            while ((data = br.readLine()) != null) {
                int curr = Integer.parseInt(data);
                result.add(curr);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return  result;
    }


    public static List<String> parseFileToStringList(String name) {
        List<String> result = new ArrayList<>();
        try{
            InputStream is = CountIncreases.class.getClassLoader().getResourceAsStream(name);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String data;
            while ((data = br.readLine()) != null) {
                result.add(data);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return  result;
    }
}
