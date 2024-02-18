package day3;

import utils.FileUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Binary {
    private String input;
    private List<String> list;
    private Map<Integer, BitData> positionData;

    protected Binary(String fileName) {
        input = fileName;
        list = FileUtils.parseFileToStringList(input);
        positionData = new TreeMap<>();
    }

    private void populateBitData() {
        for(String item: list) {
            for(int i=0; i < item.length(); i++) {
                int value = item.charAt(i) - '0';
                BitData bitData = positionData.getOrDefault(i, new BitData());
                if(value == 1) {
                    bitData.incrementOnesCount();
                } else if (value == 0){
                    bitData.incrementZerosCount();
                }
                positionData.put(i, bitData);
            }
        }
    }

    public int getPower() {
        populateBitData();
        StringBuilder gammaString = new StringBuilder();
        StringBuilder epsilonString = new StringBuilder();
        for (Map.Entry<Integer, BitData> entry: positionData.entrySet()) {
            BitData value = entry.getValue();
            if(value.getOnesCount() > value.getZerosCount()) {
                gammaString.append("1");
                epsilonString.append("0");
            } else  {
                gammaString.append("0");
                epsilonString.append("1");
            }
        }

        int gammaValue = Integer.parseInt(gammaString.toString(), 2);
        int epsilonValue = Integer.parseInt(epsilonString.toString(), 2);

        return gammaValue * epsilonValue;
    }



    public static void main(String[] args) {
        Binary binary = new Binary("day3/input");
        System.out.println(binary.getPower());
    }
}
