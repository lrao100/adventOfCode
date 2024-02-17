package day1;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class CountIncreases {

    public int parseFileToArr(String name) {
        int incCount = 0;
        int prev = Integer.MAX_VALUE;
        try{
            InputStream is = CountIncreases.class.getClassLoader().getResourceAsStream(name);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String data;
            while ((data = br.readLine()) != null) {
                int curr = Integer.parseInt(data);
                if (curr > prev) {
                    incCount += 1;
                }
                prev = curr;
            }
            br.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return incCount;
    }
}
