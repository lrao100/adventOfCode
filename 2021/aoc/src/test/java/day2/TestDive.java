package day2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDive {
    Dive dive;
    String testFile;

    @Before
    public void beforeTest() {
        testFile = "day2/test-day2";
        dive = new Dive(testFile);
    }

    @Test
    public void testDive() {
        int actual = dive.getPosition();
        Assert.assertEquals(150, actual);
    }

    @Test
    public void testAimedPosition() {
        int actual = dive.getAimedPosition();
        Assert.assertEquals(900, actual);
    }
}
