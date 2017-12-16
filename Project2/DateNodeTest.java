

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class DateNodeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DateNodeTest
{
    /**
     * Default constructor for test class DateNodeTest
     */
    public DateNodeTest()
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
    
    /** node is out of range of event's dates => this node does not contain any event yet */
    @Test
    public void testAdd1(){
        DateNode node = new DateNode(new Date(2018,04,23));
        Event e1 = new Event("Convocation", new Date(2018,03,23), new Date(2018,04,22), null, "Quad", "Academic");
        node.add(e1); 
        assertEquals(0, node.size());
    }
   
    @Test
    public void testAdd2(){
        DateNode node = new DateNode(new Date(2018,02,23));
        Event e1 = new Event("Convocation", new Date(2018,03,23), new Date(2018,04,22), null, "Quad", "Academic");
        node.add(e1); 
        assertEquals(0, node.size());
    }
    
    /** node is in range of event's dates => node contains that event until the event is removed*/
    @Test
    public void testAdd3(){
        DateNode node = new DateNode(new Date(2018,04,23));
        Event e1 = new Event("Convocation", new Date(2018,04,23), new Date(2018,04,30), null, "Quad", "Academic");
        node.add(e1); 
        assertEquals(1, node.size());
        node.remove("convocation");
        assertEquals(0, node.size());
    }
    
    /**add a node of an existing date => not successfully adde */
    @Test
    public void testAdd4(){
        DateNode node = new DateNode(new Date(2018,04,23));
        Event e1 = new Event("Convocation", new Date(2018,04,10), new Date(2018,04,23), null, "Quad", "Academic");
        node.add(e1); 
        assertEquals(1, node.size());
    }
    
    /**Add an event to a node twice => only one is added */
    @Test
    public void testAdd6(){
        DateNode node = new DateNode(new Date(2018,04,23));
        Event e1 = new Event("Convocation", new Date(2018,04,10), new Date(2018,04,30), null, "Quad", "Academic");
        node.add(e1); 
        node.add(e1);
        assertEquals(1, node.size());
    }
    
    /** add 2 events that cover the date of the node => 2 events are added to the node */
    @Test
    public void testAdd7(){
        DateNode node = new DateNode(new Date(2018,04,23));
        Event e1 = new Event("Convocation", new Date(2018,04,10), new Date(2018,04,30), null, "Quad", "Academic");
        Event e2 = new Event("Commencement", new Date(2018,04,10), new Date(2018,04,30), null, "Quad", "Academic");
        node.add(e1); 
        node.add(e2);
        assertEquals(2, node.size());
    }
    
    /** Remove an existing event */
    @Test
    public void testRemove1(){
        DateNode node = new DateNode(new Date(2018,04,23));
        Event e1 = new Event("Convocation", new Date(2018,04,23), new Date(2018,04,30), null, "Quad", "Academic");
        node.add(e1); 
        assertEquals(1, node.size());
        node.remove("convocation");
        assertEquals(0, node.size());
    }
    
    /** Remove a nonexisting event */
    @Test
    public void testRemove2(){
        DateNode node = new DateNode(new Date(2018,04,23));
        Event e1 = new Event("Convocation", new Date(2018,04,23), new Date(2018,04,30), null, "Quad", "Academic");
        node.add(e1);
        assertEquals(1, node.size());
        node.remove("cs social");
        assertEquals(1, node.size());
    }
    
    @Test
    public void testRemove3(){
        DateNode node = new DateNode(new Date(2018,04,23));
        Event e1 = new Event("Convocation", new Date(2018,04,23), new Date(2018,04,30), null, "Quad", "Academic");
        Event e2 = new Event("Convocation", new Date(2018,04,23), new Date(2018,04,30), null, "Quad", "talk");
        node.add(e1);
        node.add(e2);
        assertEquals(2, node.size());
        node.remove("Convocation");
        assertEquals(0, node.size());
    }
}
