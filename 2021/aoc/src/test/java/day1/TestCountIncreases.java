package day1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCountIncreases {
    CountIncreases countIncreases;
    String testFile;
    @Before
    public void beforeTest() {
        testFile = "day1/test-day1";
        countIncreases = new CountIncreases(testFile);

    }

    @Test
    public void testCount(){
        int actual = countIncreases.getIncCount();
        Assert.assertEquals(7, actual);
    }

    @Test
    public void testSlidingWindowCount(){
        int actual = countIncreases.getCountSlidingWindow(3);
        Assert.assertEquals(5, actual);
    }

}
