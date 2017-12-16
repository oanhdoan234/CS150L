

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class EventByLocationTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EventByLocationTest
{
    /**
     * Default constructor for test class EventByLocationTest
     */
    public EventByLocationTest()
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
        EventByLocation container = new EventByLocation();                                   //create empty container
        
        ArrayList<String> orgs = new ArrayList<String>();                       //create event
        Event e = new Event("Convocation", null, null, null, "Quad", "Academic"); 
        container.add(e);   
        ArrayList<Event> events = container.find("quad");                      //find event
        assertEquals(e, events.get(0));                                         //assert
  
    }
    
    /** add a duplicate */
    @Test
    public void testAdd2(){                                                     //add a duplicate                            
        EventByLocation container = new EventByLocation();   
        Event e1 = new Event("Convocation", null, null, null, "Quad", "Academic");
        Event e2 = new Event("convocation", null, null, null, "quad", "academic");

        container.add(e1);                                                           //add both
        container.add(e2);
        
        assertEquals(1, container.size());
        ArrayList<Event> events = container.find("quad");                      //assert that only one is added
        assertEquals(1, events.size());
        assertEquals(e1, events.get(0));
        
    }
    
    
    /** add 2 events at the same location but different data*/
    @Test
    public void testAdd3(){                                                                              
        EventByLocation container = new EventByLocation();                        //create an event and a duplicate
        Event e1 = new Event("Convocation", null, null, null, "Quad", "Academic");
        Event e2 = new Event("convocation", null, null, null, "quad", "social");
        container.add(e1);                                                           //add both
        container.add(e2);
        
        assertEquals(1, container.size());
        ArrayList<Event> events = container.find("quad");                      //assert that only one is added
        assertEquals(2, events.size());
        assertEquals(e1, events.get(0));
        assertEquals(e2, events.get(1));
        
    }
    
    /** add 2 events at 2 different locations */
    @Test
    public void testAdd4(){                                                                              
        EventByLocation container = new EventByLocation();                        //create an event and a duplicate
        Event e1 = new Event("Convocation", null, null, null, "Quad", "Academic");
        Event e2 = new Event("convocation", null, null, null, "acopian", "academic");
        container.add(e1);                                                           //add both
        container.add(e2);
        
        assertEquals(2, container.size());
        ArrayList<Event> convocation = container.find("quad");                      //assert that only one is added
        ArrayList<Event> commencement= container.find("acopian");
        assertEquals(1, convocation.size());
        assertEquals(1, commencement.size());
        
    }
    
    /** find an event not in container */
    @Test 
    public void testFind1(){
        EventByLocation container = new EventByLocation(); 
        assertEquals(0,container.find("quad").size());
    }
    
    /** remove an existing event with unique name */
    @Test 
    public void testRemove1(){
        EventByLocation container = new EventByLocation();
        Event e1 = new Event("Convocation", null, null, null, "Quad", "Academic");
        Event e2 = new Event("CS social", null, null, null, "acopian", "academic");
        container.add(e1); 
        container.add(e2);
        
        assertEquals(2, container.size());
        container.remove("cs social");
        assertEquals(1, container.size());
        
    }
    
    /**remove events of same name but happen at different locations */
    @Test 
    public void testRemove2(){
        EventByLocation container = new EventByLocation();
        Event e1 = new Event("CS social", null, null, null, "Quad", "Academic");
        Event e2 = new Event("CS social", null, null, null, "acopian", "academic");
        container.add(e1); 
        container.add(e2);
        
        assertEquals(2, container.size());
        container.remove("cs social");
        assertEquals(0, container.size());
        
    }
    
    /** remove an event not in container */
    @Test 
    public void testRemove3(){
        EventByLocation container = new EventByLocation();
        Event e1 = new Event("CS social", null, null, null, "Quad", "Academic");
        Event e2 = new Event("CS social", null, null, null, "acopian", "academic");
        container.add(e1); 
        container.add(e2);
        
        assertEquals(2, container.size());
        container.remove("commencement");
        assertEquals(2, container.size());
        
    }
    
    
}
