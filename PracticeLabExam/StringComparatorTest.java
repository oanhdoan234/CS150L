

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringComparatorTest
{
    /**
     * Default constructor for test class StringComparatorTest
     */
    public StringComparatorTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testCompare1(){
        StringComparator c = new StringComparator();
        String s = "oanh";
        String t = "doan";
        assertTrue( c.compare(s,t)>0);
    }
    
    @Test
    public void testCompare2(){
        StringComparator c = new StringComparator();
        String t = "oanh";
        String s = "doan";
        assertTrue( c.compare(s,t)<0);
    }
    
    @Test
    public void testCompare3(){
        StringComparator c = new StringComparator();
        String t = "oanh";
        String s = "oanh";
        assertTrue( c.compare(s,t)==0);
    }
}
