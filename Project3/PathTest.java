

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class PathTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PathTest
{
    /**
     * Default constructor for test class PathTest
     */
    public PathTest()
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
    
    public int[] toIntArray(ArrayList<Node<Integer>> ins){
        int[] outs = new int[ins.size()];
        for (int i = 0; i < ins.size(); i++) outs[i] =  ins.get(i).key();
        return outs;
    }
    
    public Path<Integer> path(int start, int end, int[] ins){
        Path<Integer> prev = new Path<Integer>(new Node<Integer>(start), new Node<Integer>(end), null);
        for (int i = 0; i < ins.length; i++) prev.getRoute().add(new Node<Integer>(ins[i]));
        return prev;
    }
    
    public DirectedGraph<Integer> createGraph(){
        DirectedGraph<Integer> g = new DirectedGraph<Integer>();
        g.addNode(1,"none",0);
        g.addNode(2,"none",0);
        g.addNode(3,"none",0);
        g.addEdge(1,2,10);
        g.addEdge(1,3,5);
        g.addEdge(3,2,4);
        return g; 
    }
    
    /** Update an empty path */
    @Test
    public void testUpdateRoute1(){
        Node<Integer> start = new Node<Integer>(1);
        Node<Integer> end = new Node<Integer>(5);
        Path<Integer> path = new Path<Integer>(start, end, null);
        Path<Integer> prev = new Path<Integer>(start, end,null);
        for (int i = 1; i < 5; i++) prev.getRoute().add(new Node<Integer>(i));   
        path.updateRoute(prev);
        int[] actual = toIntArray(path.getRoute());
        int[] expect = {1,2,3,4,5};
        assertArrayEquals(expect, actual);
    }
    
    @Test
    public void testUpdateRoute2(){
        int[] ins1 = {1,2,3,4,5};
        int[] ins2 = {6,7,8};
        Path<Integer> p1 = path(1,5, ins1);
        Path<Integer> p2 = path(6,8, ins2);
        p1.updateRoute(p2);
        int[] actual = {6,7,8,5};
        assertArrayEquals(actual, toIntArray(p1.getRoute()));
    }
    
    @Test
    public void testUpdateRoute3(){
        int[] ins1 = {1,2,3,4,5};
        Path<Integer> p1 = path(1,5, ins1);
        Path<Integer> p2 = null;
        p1.updateRoute(p2);
        assertArrayEquals(ins1, toIntArray(p1.getRoute()));
    }
    
    @Test
    public void testUpdateLength1(){
        DirectedGraph<Integer> g= createGraph();
        Path<Integer> longP = new Path(g.find(1), g.find(2), g);
        longP.getRoute().add(g.find(1));
        longP.getRoute().add(g.find(2));
        
        Path<Integer> shortP = new Path(g.find(1), g.find(2),g);
        shortP.getRoute().add(g.find(1));
        shortP.getRoute().add(g.find(3));
        shortP.setLength(5);
        longP.updatePath(shortP);
        assertEquals(9, longP.length());
    }
   
    // @Test
    // public void testCombinePath(){
        // DirectedGraph<Integer> g = new DirectedGraph<Integer>();
        // Path<Integer> p1 = new Path<Integer>(new Node<Integer>(1), new Node<Integer>(3), g);
        // Path<Integer> p2 = new Path<Integer>(new Node<Integer>(3), new Node<Integer>(5), g);
        // for (int i = 1; i < 4; i++) p1.getRoute().add(new Node<Integer>(i)); 
        // for (int i = 3; i < 6; i++) p2.getRoute().add(new Node<Integer>(i)); 
        // p1.setLength(5);
        // p2.setLength(10);
        // p1.combinePath(p2);
        // assertEquals(15, p1.length());
    // }
}
