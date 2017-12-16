

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class EventByTypeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */

public class EventByTypeTest
{
    /**
     * Default constructor for test class EventByTypeTest
     */
    public EventByTypeTest()
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
    
    /** add one event */
    @Test 
    public void testAdd1(){
        EventByType container = new EventByType();   
        Event e1 = new Event("Convocation", null, null, null, "Quad", "Academic");
        
        container.add(e1);                                                           //add event
        
        assertEquals(1, container.size());
        ArrayList<Event> events = container.find("academic");                      //assert the event is added
        assertEquals(1, events.size());
        assertEquals(e1, events.get(0));
    }
    
    /** add 2 events with same data => verify that only one is added to avoid duplicate*/ 
    @Test
    public void testAdd2(){
        EventByType container = new EventByType();   
        Event e1 = new Event("Convocation", null, null, null, "Quad", "Academic");          //create 2 events with same data
        Event e2 = new Event("Convocation", null, null, null, "Quad", "Academic");
        
        container.add(e1);                                                           //add both
        container.add(e2);
        
        assertEquals(1, container.size());
        ArrayList<Event> events = container.find("academic");                      //assert that only one is added
        assertEquals(1, events.size());
        assertEquals(e1, events.get(0));
    }
    
    /** add 2 events of different types*/ 
    @Test
    public void testAdd3(){
        EventByType container = new EventByType();   
        Event e1 = new Event("CS social", null, null, null, "acopian", "talk");
        Event e2 = new Event("Convocation", null, null, null, "Quad", "Academic");
        
        container.add(e1);                                                           //add both
        container.add(e2);
        
        assertEquals(2 , container.size());
        ArrayList<Event> academic = container.find("academic");                      //assert that 2 nodes are added, each containing 1 event
        ArrayList<Event> talk = container.find("talk"); 
        assertEquals(1, academic.size());
        assertEquals(e2, academic.get(0));
        assertEquals(1, talk.size());
        assertEquals(e1, talk.get(0));
    }
    
    
    /** add 2 events of same type but have different content*/ 
    @Test
    public void testAdd4(){
        EventByType container = new EventByType();   
        Event e1 = new Event("CS social", null, null, null, "acopian", "Academic");
        Event e2 = new Event("Convocation", null, null, null, "Quad", "Academic");
        
        container.add(e1);                                                           //add both
        container.add(e2);
        
        assertEquals(1 , container.size());
        ArrayList<Event> academic = container.find("academic");                      //assert that only one is added but the node has 2 events
        assertEquals(2, academic.size());
    }
    
    /** Remove an event not in container */
    @Test
    public void testRemove1(){
        EventByType container = new EventByType();
        container.remove("CS Social");
    }
    
    /**remove events of same name but have different types */
    @Test 
    public void testRemove2(){
        EventByType container = new EventByType();
        Event e1 = new Event("CS social", null, null, null, "Quad", "talk");                //add events
        Event e2 = new Event("CS social", null, null, null, "acopian", "academic");
        container.add(e1); 
        container.add(e2);
        
        assertEquals(2, container.size());                                                  //remove events
        container.remove("cs social");
        assertEquals(0, container.size());                                                  //assert that the container has no node left
        
    }
    
    @Test 
    public void testRemove3(){
        EventByType container = new EventByType();
        Event e1 = new Event("CS social", null, null, null, "Quad", "talk");                //add 4 events of 2 types, each type having 2 events
        Event e2 = new Event("CS social", null, null, null, "acopian", "academic");
        Event e3 = new Event("math social", null, null, null, "pardee", "academic");
        Event e4 = new Event("econ social", null, null, null, "simon", "talk");
        
        container.add(e1); 
        container.add(e2);
        container.add(e3);
        container.add(e4);
        
        assertEquals(2, container.size());
        container.remove("cs social");                                                //delete one from each
        assertEquals(2, container.size());
        ArrayList<Event> academic = container.find("academic");                      //assert that there are 2 nodes left, each having 1 event
        ArrayList<Event> talk = container.find("talk"); 
        assertEquals(e4, talk.get(0));
        assertEquals(e3, academic.get(0));
    }
    
    
}
