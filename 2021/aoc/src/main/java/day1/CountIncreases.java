package day1;

import utils.FileUtils;

import java.util.List;

public class CountIncreases {
    String input;
    public CountIncreases(String fileName) {
        input = fileName;
    }

    public int getIncCount() {
        int incCount = 0;
        int prev = Integer.MAX_VALUE;
        List<Integer> list = FileUtils.parseFileToList(input);
        for(Integer curr: list) {
            if(curr > prev) {
                incCount += 1;
            }
            prev = curr;
        }

        return incCount;
    }

    public int getCountSlidingWindow(int windowSize) {
        List<Integer> list = FileUtils.parseFileToList(input);
        int slidingWindowSumPrev = Integer.MAX_VALUE;
        int slidingWindowSumCurr = 0;

        int incCount = 0;

        for(int i = 0; i < list.size(); i++) {
            for(int j=i; j < i + windowSize && j < list.size(); j++) {
                slidingWindowSumCurr += list.get(j);
            }
            if(slidingWindowSumCurr > slidingWindowSumPrev) {
                incCount += 1;
            }
            slidingWindowSumPrev = slidingWindowSumCurr;
            slidingWindowSumCurr = 0;
        }
        return incCount;
    }

    public static void main(String[] args) {
        CountIncreases countIncreases = new CountIncreases("day1/input");
        System.out.println(countIncreases.getCountSlidingWindow(3));
    }
}
