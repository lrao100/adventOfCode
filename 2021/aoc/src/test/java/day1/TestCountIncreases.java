package day1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCountIncreases {
    CountIncreases countIncreases;
    String testFile;
    @Before
    public void beforeTest() {
        countIncreases = new CountIncreases();
        testFile = "day1/test-day1";
    }

    @Test
    public void testCount(){
        int actual = countIncreases.parseFileToArr(testFile);
        Assert.assertEquals(7, actual);
    }

}
