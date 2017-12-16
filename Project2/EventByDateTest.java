

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class EventByDateTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EventByDateTest
{
    /**
     * Default constructor for test class EventByDateTest
     */
    public EventByDateTest()
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
    
    /** add 2 nodes of same date => only 1 is added */
    @Test
    public void testAddNode1(){
        EventByDate container = new EventByDate();
        DateNode node1 = new DateNode(new Date(2018, 04,23));                       //add 2 nodes
        DateNode node2 = new DateNode(new Date(2018, 04,23));
        container.addNode(node1);
        container.addNode(node2);
        assertEquals(1, container.size());                                          //assert 1 is added
    }
    
    /** add 2 different nodes */
    @Test
    public void testAddNode2(){
        EventByDate container = new EventByDate();
        DateNode node1 = new DateNode(new Date(2018, 04,23));                       //add 2 nodes
        DateNode node2 = new DateNode(new Date(2018, 05,23));
        container.addNode(node1);
        container.addNode(node2);
        assertEquals(2, container.size());                                          //assert 2 nodes are added
        assertEquals(node1.getKey(), container.get(0).getKey());
        assertEquals(node2.getKey(), container.get(1).getKey());                    //assert the list is sorted
    }
    
    /** add multiple nodes and verify that the list is sorted */
    @Test
    public void testAddNode3(){
        EventByDate container = new EventByDate();                                 
        DateNode node1 = new DateNode(new Date(2018, 4,23));
        DateNode node2 = new DateNode(new Date(2018, 5,23));
        DateNode node3 = new DateNode(new Date(2018, 3,23));
        DateNode node4 = new DateNode(new Date(2018, 4,30));
        
        container.addNode(node1);
        container.addNode(node2);
        container.addNode(node3);
        container.addNode(node4); 
        
        assertEquals(4, container.size());
        
        assertEquals(node3.getKey(), container.get(0).getKey());
        assertEquals(node1.getKey(), container.get(1).getKey());
        assertEquals(node4.getKey(), container.get(2).getKey());
        assertEquals(node2.getKey(), container.get(3).getKey());
        
    }
    
    
    /** add 2 events of same data, so only 1 event can be added. This event happens over a range of time, so there 2 nodes, but each node has only
     * 1 event
       */
    @Test 
    public void testAdd1(){
        EventByDate container = new EventByDate();
        Event e1 = new Event("Convocation", new Date(2018,04,23), new Date(2018,04,30), null, "Quad", "Academic");
        Event e2 = new Event("Convocation", new Date(2018,04,23), new Date(2018,04,30), null, "Quad", "Academic");
        container.add(e1);
        container.add(e2);
        
        assertEquals(2, container.size());
        assertEquals(1, container.get(0).size());
        assertEquals(1, container.get(1).size());
        assertEquals(e1, container.get(0).getValue().get(0));
        assertEquals(e1, container.get(1).getValue().get(0));
    }
    
    /** add 2 events. 1 event on a day, 1 event over a range of time => 3 nodes. Since date of first event is in range of second event, first 
     * node and last node have 1 event, the second node has 2 events
       */
    @Test
    public void testAdd2(){
        EventByDate container = new EventByDate();
        Event e1 = new Event("Convocation", new Date(2018,04,23), new Date(2018,04,23), null, "Quad", "Academic");
        Event e2 = new Event("commencement", new Date(2018,03,23), new Date(2018,05,30), null, "Quad", "Academic");
        container.add(e1);
        container.add(e2);
        
        assertEquals(3, container.size());                                      //assert 3 nodes
        assertEquals(1, container.get(0).size());                               //first node has 1 event
        assertEquals(2, container.get(1).size());                               //2nd node has 2
        assertEquals(1, container.get(2).size());                               //last node has 1
        assertEquals(e1, container.get(1).getValue().get(0));
        assertEquals(e2, container.get(1).getValue().get(1));
    }
    
    /** Remove 1 from the list of 3 nodes */
    @Test
    public void testRemove1(){
        EventByDate container = new EventByDate();
        Event e1 = new Event("Convocation", new Date(2018,04,23), new Date(2018,04,23), null, "Quad", "Academic");
        Event e2 = new Event("commencement", new Date(2018,03,23), new Date(2018,05,30), null, "Quad", "Academic");
        Event e3 = new Event("Cs social", new Date(2018,03,23), new Date(2018,05,30), null, "Quad", "Academic");
        container.add(e1);
        container.add(e2);
        container.add(e3);
        
        container.remove("commencement");
        assertEquals(3, container.size());
        assertEquals(1, container.get(0).size());
        assertEquals(2, container.get(1).size());
        assertEquals(1, container.get(2).size());
        assertEquals(e3, container.get(0).getValue().get(0));
        assertEquals(e3, container.get(1).getValue().get(1));
        assertEquals(e3, container.get(2).getValue().get(0));
        
        container.remove("cs social");
        assertEquals(1, container.size());
    }
    
    /** Find an event on a date */
    @Test
    public void testFind1(){
        EventByDate container = new EventByDate();
        Event e1 = new Event("Convocation", new Date(2018,04,23), new Date(2018,04,23), null, "Quad", "Academic");
        Event e2 = new Event("commencement", new Date(2018,03,23), new Date(2018,05,30), null, "Quad", "Academic");
        Event e3 = new Event("Cs social", new Date(2018,03,23), new Date(2018,05,30), null, "Quad", "Academic");
        container.add(e1);
        container.add(e2);
        container.add(e3);
        
        ArrayList<Date> rangeDate = new ArrayList<Date>();
        rangeDate.add(new Date(2018,04,23));
        
        ArrayList<Event> found = container.find(rangeDate);
        assertEquals(1, found.size());
    }
    
    /** Find an event on a date */
    @Test
    public void testFind2(){
        EventByDate container = new EventByDate();
        Event e1 = new Event("Convocation", new Date(2018,04,23), new Date(2018,04,23), null, "Quad", "Academic");
        Event e2 = new Event("commencement", new Date(2018,03,23), new Date(2018,04,20), null, "Quad", "Academic");
        Event e3 = new Event("Cs social", new Date(2018,03,23), new Date(2018,04,20), null, "Quad", "Academic");
        container.add(e1);
        container.add(e2);
        container.add(e3);
        
        ArrayList<Date> rangeDate = new ArrayList<Date>();
        rangeDate.add(new Date(2018,04,23));
        
        ArrayList<Event> found = container.find(rangeDate);
        assertEquals(1, found.size());
    }
    
    /** Find events in a range of dates => Found 1 */
    @Test
    public void testFind3(){
        EventByDate container = new EventByDate();
        Event e1 = new Event("Convocation", new Date(2018,04,23), new Date(2018,04,23), null, "Quad", "Academic");
        Event e2 = new Event("commencement", new Date(2018,03,23), new Date(2018,04,20), null, "Quad", "Academic");
        Event e3 = new Event("Cs social", new Date(2018,03,23), new Date(2018,04,30), null, "Quad", "Academic");
        container.add(e1);
        container.add(e2);
        container.add(e3);
        
        ArrayList<Date> rangeDate = new ArrayList<Date>();
        rangeDate.add(new Date(2018,04,23));
        rangeDate.add(new Date(2018,04,27));
        
        ArrayList<Event> found = container.find(rangeDate);
        assertEquals(1, found.size());
    }
    
    /** Find events in a range of dates => Found none because all events are not in this range */
    @Test
    public void testFind4(){
        EventByDate container = new EventByDate();
        Event e1 = new Event("Convocation", new Date(2018,04,23), new Date(2018,04,23), null, "Quad", "Academic");
        Event e2 = new Event("commencement", new Date(2018,03,23), new Date(2018,04,20), null, "Quad", "Academic");
        Event e3 = new Event("Cs social", new Date(2018,03,23), new Date(2018,04,30), null, "Quad", "Academic");
        container.add(e1);
        container.add(e2);
        container.add(e3);
        
        ArrayList<Date> rangeDate = new ArrayList<Date>();
        rangeDate.add(new Date(2018,02,23));
        rangeDate.add(new Date(2018,02,27));
        
        ArrayList<Event> found = container.find(rangeDate);
        assertEquals(0, found.size());
    }
}
