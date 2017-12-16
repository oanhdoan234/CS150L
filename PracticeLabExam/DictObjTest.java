

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class DictObjTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DictObjTest
{
    /**
     * Default constructor for test class DictObjTest
     */
    public DictObjTest()
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
    public void testAdd1(){
        DictObj obj = new DictObj("Lafayette College", "Oanh");
        obj.add("thanh");
        obj.add("khun");
        obj.add("Oanh");
        String[] arr = {"khun","Oanh","thanh"};
        ArrayList<String> list = obj.toArrayList();
        assertArrayEquals(arr, list.toArray());
    }
    
}
