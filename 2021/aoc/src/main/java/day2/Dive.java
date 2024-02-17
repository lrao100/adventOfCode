package day2;

import utils.FileUtils;

import java.util.List;

public class Dive {
    private String input;
    private List<String> list;

    protected  Dive(String fileName) {
        input = fileName;
        list = FileUtils.parseFileToStringList(input);
    }

    public int getPosition() {

        int xaxis = 0;
        int yaxis = 0;
        for(String direction: list) {
            String[] splitDirection = direction.split("\\s+");
            String dir = splitDirection[0];
            int value = Integer.parseInt(splitDirection[1]);
            if(dir.equals("forward")) {
                xaxis += value;
            } else if(dir.equals("up")) {
                yaxis -= value;
            } else if(dir.equals("down")) {
                yaxis += value;
            }
        }
        return  xaxis * yaxis;
    }

    public int getAimedPosition() {
        int xaxis = 0;
        int yaxis = 0;
        int aim = 0;
        for(String direction: list) {
            String[] splitDirection = direction.split("\\s+");
            String dir = splitDirection[0];
            int value = Integer.parseInt(splitDirection[1]);
            if(dir.equals("up")) {
                aim -= value;
            } else if(dir.equals("down")) {
                aim += value;
            } else if(dir.equals("forward")) {
                xaxis += value;
                yaxis += aim*value;
            }
        }
        return xaxis*yaxis;
    }

    public static void main(String[] args) {
        Dive dive = new Dive("day2/input");
        System.out.println(dive.getAimedPosition());
    }
}
