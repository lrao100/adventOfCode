package day3;

import utils.FileUtils;

import java.util.*;


public class Binary {
    private String input;
    private List<String> list;
    private int oxygenRating = 1;
    private int scrubberRating = 1;

    protected Binary(String fileName) {
        input = fileName;
        list = FileUtils.parseFileToStringList(input);

    }

    private Map<Integer, BitData> populateBitData(List<String> inputList) {
        Map<Integer, BitData> positionData = new TreeMap<>();
        for(String item: inputList) {
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
        return positionData;
    }



    private Map<Integer, BitData> populateBitData(List<String> inputList, int i) {
        Map<Integer, BitData> positionData = new TreeMap<>();
        for(String item: inputList) {
                int value = item.charAt(i) - '0';
                BitData bitData = positionData.getOrDefault(i, new BitData());
                if(value == 1) {
                    bitData.incrementOnesCount();
                    bitData.addToOnesIndex(item);
                } else if (value == 0){
                    bitData.incrementZerosCount();
                    bitData.addToZerosIndex(item);
                }
                positionData.put(i, bitData);
        }
        return positionData;
    }



    public void getOxygenRating(List<String> inputList, int i) {
        if(inputList.size() == 1) {
            oxygenRating = Integer.parseInt(inputList.get(0), 2);
            return;
        }
        Map<Integer, BitData> positionData = populateBitData(inputList, i);
        List<String> nextList = new ArrayList<>();

        for (Map.Entry<Integer, BitData> entry: positionData.entrySet()) {
            BitData value = entry.getValue();
            // oxygen generator rating
            if(value.getOnesCount() >= value.getZerosCount()) {
                nextList = value.getOnesIndex();
            } else  {
                nextList = value.getZerosIndex();
            }
        }
        getOxygenRating(nextList, i+1);
    }

    public void getScrubberRating(List<String> inputList, int i) {
        if(inputList.size() == 1) {
            scrubberRating = Integer.parseInt(inputList.get(0), 2);
            return;
        }
        Map<Integer, BitData> positionData = populateBitData(inputList, i);
        List<String> nextList = new ArrayList<>();

        for (Map.Entry<Integer, BitData> entry: positionData.entrySet()) {
            BitData value = entry.getValue();
            // oxygen generator rating
            if(value.getOnesCount() >= value.getZerosCount()) {
                nextList = value.getZerosIndex();
            } else  {
                nextList = value.getOnesIndex();
            }
        }
        getScrubberRating(nextList, i+1);
    }

    public int getLifeSupportRating() {
        getOxygenRating(list, 0);
        getScrubberRating(list, 0);

        return oxygenRating * scrubberRating;
    }

    public GammaEpsilon getGammaEpsilon(Map<Integer, BitData> positionData) {
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

        return new GammaEpsilon(gammaString.toString(), epsilonString.toString());

    }

    public int getPower() {
        Map<Integer, BitData> positionData = populateBitData(list);
        GammaEpsilon ge = getGammaEpsilon(positionData);

        return ge.getGammaValue() * ge.getEpsilonValue();
    }



    public static void main(String[] args) {
        Binary binary = new Binary("day3/input");
        System.out.println(binary.getLifeSupportRating());
    }
}
