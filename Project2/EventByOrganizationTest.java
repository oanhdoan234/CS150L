

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class EventByOrganizationTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EventByOrganizationTest
{
    /**
     * Default constructor for test class EventByOrganizationTest
     */
    public EventByOrganizationTest()
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
    
    /** add an event organized by 2 organizations => container has 2 nodes*/
    @Test
    public void testAdd1(){
        EventByOrganization container =new EventByOrganization();
        ArrayList<String> orgs = new ArrayList<String>();
        orgs.add("isa");
        orgs.add("student government");
        Date startDate = new Date(2018,04,23);
        Date endDate = new Date(2018,04,23);
        Event e = new Event("Convocation", startDate, endDate, orgs, "Quad", "Academic");
        container.add(e); 
        assertEquals(2, container.size());
    }
    
    /** add an event without info on organizations */
    @Test
    public void testAdd2(){
        EventByOrganization container =new EventByOrganization();
        ArrayList<String> orgs = new ArrayList<String>();
        Date startDate = new Date(2018,04,23);
        Date endDate = new Date(2018,04,23);
        Event e = new Event("Convocation", startDate, endDate, orgs, "Quad", "Academic");
        container.add(e); 
        assertEquals(1, container.size());
    }
    
    
    /** add 2 events that share organizer => the node of this organizer has 2 events */ 
    @Test
    public void testAdd3(){
        EventByOrganization container =new EventByOrganization();                       //create events
        ArrayList<String> orgs = new ArrayList<String>();
        orgs.add("isa");
        orgs.add("student government");
        ArrayList<String> orgs2 = new ArrayList<String>();
        orgs2.add("isa");
        
        Event e1 = new Event("Convocation", null, null, orgs, "Quad", "Academic");
        Event e2 = new Event("Moon festival", null, null, orgs, "Quad", "Academic");
        
        container.add(e1);                                                              //add 
        container.add(e2); 
        assertEquals(2,container.size());   
        ArrayList<Event> byISA = container.find("isa");                                 //assert
        assertEquals(e1, byISA.get(0));
        assertEquals(e2, byISA.get(1));
    }
    
    /** add an event twice => only 1 success */
    @Test
    public void testAdd4(){
        EventByOrganization container =new EventByOrganization();
        ArrayList<String> orgs = new ArrayList<String>();
        orgs.add("isa");
        Event e = new Event("Convocation", null, null, orgs, "Quad", "Academic");
        container.add(e); 
        container.add(e);
        ArrayList<Event> byISA =  container.find("isa");
        assertEquals(1, container.size());
        assertEquals(1, byISA.size());
    }
    
    /** find an organizer not in list */ 
    @Test
    public void testFind(){
        EventByOrganization container = new EventByOrganization();
        ArrayList<Event> byISA = container.find("isa");
        assertEquals(0, byISA.size());
    }
    
    /** remove an event not in list */
    @Test
    public void testRemove1(){
        EventByOrganization container =new EventByOrganization();
        ArrayList<String> orgs = new ArrayList<String>();
        orgs.add("isa");
        Event e = new Event("Convocation", null, null, orgs, "Quad", "Academic");
        container.add(e);
        container.remove("Lunar New Year"); 
        assertEquals(1, container.size());
    }
    
    /** remove an event in a list having only 1 element => remove the list itself after removing the event*/
    @Test
    public void testRemove2(){
        EventByOrganization container =new EventByOrganization();
        ArrayList<String> orgs = new ArrayList<String>();
        orgs.add("isa");
        Event e = new Event("Convocation", null, null, orgs, "Quad", "Academic");
        container.add(e);
        container.remove("Convocation"); 
        assertEquals(0, container.size());
    }
    
    /** remove an event in a list having at 2 events */
    @Test
    public void testRemove3(){
        EventByOrganization container =new EventByOrganization();
        ArrayList<String> orgs = new ArrayList<String>();
        orgs.add("isa");
        Event e1 = new Event("Convocation", null, null, orgs, "Quad", "Academic");
        Event e2 = new Event("Lunar New Year", null, null, orgs, "Quad", "Academic");
        
        container.add(e1);
        container.add(e2);
        container.remove("Convocation"); 
        assertEquals(1, container.size());
        
        ArrayList<Event> isa = container.find("isa");
        assertEquals(e2, isa.get(0));
        assertEquals(1, isa.size());
        
    }
    
    /** remove an event that has 2 organizers */
    @Test
    public void testRemove4(){
        EventByOrganization container =new EventByOrganization();                       //create events
        ArrayList<String> orgs = new ArrayList<String>();
        orgs.add("isa");
        orgs.add("student government");
        ArrayList<String> orgs2 = new ArrayList<String>();
        orgs2.add("isa");
        
        Event e1 = new Event("Convocation", null, null, orgs, "Quad", "Academic");
        Event e2 = new Event("Moon festival", null, null, orgs, "Quad", "Academic");
        
        container.add(e1);                                                              //add 
        container.add(e2); 
        assertEquals(2,container.size());   
        container.remove("convocation");                                                //remove
        
        ArrayList<Event> isa = container.find("isa");                                 //assert
        ArrayList<Event> sg =  container.find("student government");
        assertEquals(1, isa.size());
        assertEquals(1, sg.size());
    }
}
