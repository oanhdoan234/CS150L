

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*; 

/**
 * The test class EventByNameTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EventByNameTest
{
    /**
     * Default constructor for test class EventByNameTest
     */
    public EventByNameTest()
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
    
    /** add a new event */
    @Test
    public void testAdd1(){                                                     //add a new event 
        EventByName container = new EventByName();                                   //create empty container
        
        ArrayList<String> orgs = new ArrayList<String>();                       //create event
        orgs.add("Student Government");
        orgs.add("Residence Office");
        Date startDate = new Date(2018,04,23);
        Date endDate = new Date(2018,04,23);
        Event e = new Event("Convocation", startDate, endDate, orgs, "Quad", "Academic");
        
        container.add(e);                                                            //add event
        ArrayList<Event> events = container.get("convocation");                      //find event
        assertEquals(e, events.get(0));                                         //assert
        
    }
    
    /** add a duplicate */
    @Test
    public void testAdd2(){                                                     //add a duplicate                            
        EventByName container = new EventByName();   
        
        ArrayList<String> orgs = new ArrayList<String>();                       //create an event and a duplicate
        orgs.add("Student Government");
        orgs.add("Residence Office");
        Date startDate = new Date(2018,04,23);
        Date endDate = new Date(2018,04,23);
        Event e1 = new Event("Convocation", startDate, endDate, orgs, "Quad", "Academic");
        Event e2 = new Event("convocation", startDate, endDate, orgs, "quad", "academic");
        
        
        container.add(e1);                                                           //add both
        container.add(e2);
        
        ArrayList<Event> events = container.get("convocation");                      //assert that only one is added
        assertEquals( 1, events.size());
        assertEquals(e1, events.get(0));
        
    }
    
    
    /** add 2 events with same name but different data*/
    @Test
    public void testAdd3(){                                                                              
        EventByName container = new EventByName();   
        
        ArrayList<String> orgs = new ArrayList<String>();                       //create an event and a duplicate
        orgs.add("Student Government");
        orgs.add("Residence Office");
        Date startDate1 = new Date(2018,04,23);
        Date endDate1 = new Date(2018,04,23);
        Date startDate2 = new Date(2019,04,23);
        Date endDate2 = new Date(2019,04,23);
        Event e1 = new Event("Convocation", startDate1, endDate1, orgs, "Quad", "Academic");
        Event e2 = new Event("convocation", startDate2, endDate2, orgs, "quad", "academic");
        
        container.add(e1);                                                           //add both
        container.add(e2);
        
        assertEquals(1, container.size());
        ArrayList<Event> events = container.get("convocation");                      //assert that only one is added
        assertEquals(2, events.size());
        assertEquals(e1, events.get(0));
        assertEquals(e2, events.get(1));
        
    }
    
    /** add 2 events with 2 different names */
    @Test
    public void testAdd4(){                                                                              
        EventByName container = new EventByName();   
        
        ArrayList<String> orgs = new ArrayList<String>();                       //create an event and a duplicate
        orgs.add("Student Government");
        orgs.add("Residence Office");
        Date startDate1 = new Date(2018,04,23);
        Date endDate1 = new Date(2018,04,23);
        Date startDate2 = new Date(2019,04,23);
        Date endDate2 = new Date(2019,04,23);
        Event e1 = new Event("Convocation", startDate1, endDate1, orgs, "Quad", "Academic");
        Event e2 = new Event("Commencement", startDate2, endDate2, orgs, "quad", "academic");
        
        container.add(e1);                                                           //add both
        container.add(e2);
        
        assertEquals(2, container.size());
        ArrayList<Event> convocation = container.get("convocation");                      //assert that only one is added
        ArrayList<Event> commencement= container.get("commencement");
        assertEquals(1, convocation.size());
        assertEquals(1, commencement.size());
        
    }
    
    /** find a event from an empty container*/
    @Test
    public void testFind1(){
        EventByName container = new EventByName(); 
        assertEquals(0, container.find("Convocation").size());
    }
    
    /** find an existing event and an nonexistent event */
    @Test
    public void testFind2(){
        EventByName container = new EventByName(); 
        ArrayList<String> orgs = new ArrayList<String>();                       //create event
        orgs.add("Student Government");
        orgs.add("Residence Office");
        Date startDate = new Date(2018,04,23);
        Date endDate = new Date(2018,04,23);
        Event e = new Event("Convocation", startDate, endDate, orgs, "Quad", "Academic");
        
        container.add(e);        
        assertEquals(1, container.find("Convocation").size());
        assertEquals(1, container.find("convocation").size());
        assertEquals(0, container.find("commencement").size());
    }
    
    @Test 
    public void testRemove1(){
        EventByName container = new EventByName();
        container.remove("Convocation");
    }
    
    @Test
    public void testRemove2(){
        EventByName container = new EventByName();   
        
        ArrayList<String> orgs = new ArrayList<String>();                       //create an event and a duplicat
        Event e1 = new Event("Convocation", null , null, null, "Quad", "Academic");
        
        container.add(e1);                                                           //add both
        container.remove("convocation");
        assertEquals(0, container.size());
        assertEquals(0, container.find("convocation").size());
    }
    
    @Test
    public void testRemove3(){
        EventByName container = new EventByName();   
        
        ArrayList<String> orgs = new ArrayList<String>();                       //create an event and a duplicat
        Event e1 = new Event("Convocation", null , null, null, "Quad", "Academic");
        Event e2 = new Event("Commencement", null, null, null, "quad", "academic");
        
        container.add(e1);                                                           //add both
        container.add(e2);
        container.remove("convocation");
        assertEquals(1, container.size());
        assertEquals(0, container.find("convocation").size());
        assertEquals(1, container.find("commencement").size());
    }
}
