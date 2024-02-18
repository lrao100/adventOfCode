package day3;
import day2.Dive;
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

}
