

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EventTest
{
    /**
     * Default constructor for test class EventTest
     */
    public EventTest()
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
    
    /** Compare 2 null events */
    @Test
    public void testCompareTo1(){
        Event e1 = new Event(null, null, null, null, null, null);
        Event e2 = new Event(null, null, null, null, null, null);
        assertEquals((Integer) 0, (Integer) e1.compareTo(e2));
    }
    
    /** compare 2 events of same data */
    @Test
    public void testCompareTo2(){
        ArrayList<String> orgs = new ArrayList<String>();                                   //create list of organizations
        orgs.add("Student Government");
        orgs.add("Residence Office");
        Date startDate = new Date(23,04,2018);                                              //create dates
        Date endDate = new Date(23,04,2018);
        Event e1 = new Event("Convocation", startDate, endDate, orgs, "Quad", "Academic");  //create events
        Event e2 = new Event("Convocation", startDate, endDate, orgs, "Quad", "Academic");
        assertEquals((Integer) 0, (Integer) e1.compareTo(e2));                              //assert
    }
   
    /** compare 2 null strings */
    @Test
    public void testCompareString1(){
        Event e = new Event();
        String s1 = null;
        String s2 = null;
        assertEquals((Integer) 0, (Integer) e.compareString(s1,s2));
    }
    
    /** compare 2 regular strings */
    @Test
    public void testCompareString2(){
        Event e = new Event();
        String s1 = "Oanh Doan";
        String s2 = "Oanh Doan";
        assertEquals((Integer) 0, (Integer) e.compareString(s1,s2));
    }
    
    /** compare 2 regular strings, note that the comparison is case insensitive */
    @Test
    public void testCompareString3(){
        Event e = new Event();
        String s1 = "oanh doan";
        String s2 = "Oanh Doan";
        assertEquals((Integer) 0, (Integer) e.compareString(s1,s2));
    }
    
    /** compare 2 strings */
    @Test
    public void testCompareString4(){
        Event e = new Event();
        String s1 = "oanh doan";
        String s2 = "Thanh Vu";
        assertTrue( (Integer) e.compareString(s1,s2) < 0);
    }
    
    /** compare 2 null dates */
    @Test 
    public void testCompareDate1(){
        Event e  = new Event();
        Date d1 = null;
        Date d2 = null;
        assertEquals((Integer) 0, (Integer) e.compareDate(d1,d2));
    }
    
    
    /** compare 2 regular dates */
    @Test
    public void testCompareDate2(){
        Event e  = new Event();
        Date d1 = new Date(2017, 04,23);
        Date d2 = new Date(2017,04,23);
        assertEquals((Integer) 0, (Integer) e.compareDate(d1,d2));
    }
    
    
    @Test
    public void testCompareDate3(){
        Event e  = new Event();
        Date d1 = new Date(2017, 04,23);
        Date d2 = new Date(2017,05,23);
        assertTrue((e.compareDate(d1,d2) < 0));
    }
    
    @Test
    public void testCompareDate4(){
        Event e  = new Event();
        Date d1 = new Date(2017, 04,23);
        Date d2 = new Date(2017,05,23);
        assertTrue((e.compareDate(d2,d1) > 0));
    }
}
