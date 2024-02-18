package day3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class TestBinary {

    Binary binary;
    String testFile;

    @Before
    public void beforeTest() {
        testFile = "day3/test-day3";
        binary = new Binary(testFile);
    }

    @Test
    public void testGetPower() {
        int actual = binary.getPower();
        Assert.assertEquals(198, actual);
    }

    @Test
    public void testGetLifeSupportRating() {
        int actual = binary.getLifeSupportRating();
        Assert.assertEquals(230, actual);
    }

}
