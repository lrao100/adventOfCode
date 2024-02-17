package day3;

public class BitData {
    private int onesCount;
    private int zerosCount;


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
}
