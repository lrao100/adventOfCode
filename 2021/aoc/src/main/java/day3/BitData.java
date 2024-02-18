package day3;

import java.util.ArrayList;
import java.util.List;

public class BitData {
    private int onesCount;
    private int zerosCount;
    private List<String> onesIndex;

    public List<String> getOnesIndex() {
        return onesIndex;
    }

    public List<String> getZerosIndex() {
        return zerosIndex;
    }

    private List<String> zerosIndex;

    public BitData() {
        onesIndex = new ArrayList<>();
        zerosIndex = new ArrayList<>();
    }

    public int getOnesCount() {
        return onesCount;
    }

    public void setOnesCount(int onesCount) {
        this.onesCount = onesCount;
    }

    public int getZerosCount() {
        return zerosCount;
    }

    public void setZerosCount(int zerosCount) {
        this.zerosCount = zerosCount;
    }

    public void incrementZerosCount() {
        this.zerosCount++;
    }

    public void incrementOnesCount() {
        this.onesCount++;
    }

    public void addToZerosIndex(String item) {
        this.zerosIndex.add(item);
    }

    public void addToOnesIndex(String item) {
        this.onesIndex.add(item);
    }


}
