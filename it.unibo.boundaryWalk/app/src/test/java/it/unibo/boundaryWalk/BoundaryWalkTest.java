package it.unibo.boundaryWalk;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BoundaryWalkTest {
    private BuondaryWalk appl;

    @Before
    public void systemSetUp() {
        System.out.println("TestBuondarywalk | setUp: robot should be at HOME-DOWN ");
        appl = new BuondaryWalk();
    }

    @After
    public void  terminate() {
        System.out.println("%%%  TestBuondarywalk |  terminates ");
    }

    @Test
    public void testBoundaryWalk() {
        System.out.println("TestBoundaryWalk");
        String test_str= appl.doBoundary();
        //now use Regex to verify the pattern of test_str
        assertTrue(test_str.matches("^[w]*l[w]*l[w]*l[w]*l"));
        System.out.println("test_str:"+ test_str);
    }


}
