

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class DirectedGraphNodeTest
{
    /**
     * Default constructor for test class DirectedGraphNodeTest
     */
    public DirectedGraphNodeTest()
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
    
    /** a node connected to nothing => no neighbors */
    @Test
    public void testClosest1(){
        DirectedGraphNode<Integer> start = new DirectedGraphNode<Integer>(1);
        assertEquals(null, start.closest());
    }
    
    /** a node connected to 2 other nodes */
    @Test
    public void testClosest2(){
        DirectedGraphNode<Integer> start = new DirectedGraphNode<Integer>(1);
        DirectedGraphNode<Integer> end1  = new DirectedGraphNode<Integer>(2);
        DirectedGraphNode<Integer> end2  = new DirectedGraphNode<Integer>(3);
        DirectedGraphEdge<Integer> edge1 = new DirectedGraphEdge(start, end1, 1); 
        DirectedGraphEdge<Integer> edge2 = new DirectedGraphEdge(start, end2, 2); 
        
        ArrayList<DirectedGraphEdge<Integer>> edges = start.getEdges(); 
        edges.add(edge1);
        edges.add(edge2); 
        
        assertEquals((Integer) 2, (Integer) start.closest().key());
    }
    
    /** a node connected to 3 nodes */
    @Test
    public void testClosest3(){
        DirectedGraphNode<Integer> start = new DirectedGraphNode<Integer>(1);
        DirectedGraphNode<Integer> end1  = new DirectedGraphNode<Integer>(2);
        DirectedGraphNode<Integer> end2  = new DirectedGraphNode<Integer>(3);
        DirectedGraphNode<Integer> end3  = new DirectedGraphNode<Integer>(4);
        DirectedGraphEdge<Integer> edge1 = new DirectedGraphEdge(start, end1, 10); 
        DirectedGraphEdge<Integer> edge2 = new DirectedGraphEdge(start, end2, 2); 
        DirectedGraphEdge<Integer> edge3 = new DirectedGraphEdge(start, end3, 23); 
        
        ArrayList<DirectedGraphEdge<Integer>> edges = start.getEdges(); 
        edges.add(edge1);
        edges.add(edge2); 
        edges.add(edge3);
        
        assertEquals((Integer) 3, (Integer) start.closest().key());
    }
    
    /** 2 unequal nodes */
    @Test
    public void testEqualsKey(){
        DirectedGraphNode<Integer> node1  = new DirectedGraphNode<Integer>(2);
        DirectedGraphNode<Integer> node2  = new DirectedGraphNode<Integer>(3);
        assertFalse(node1.equalsKey(node2));
    }
    
    /** 2 equal nodes */
    @Test
    public void testEqualsKey2(){
        DirectedGraphNode<Integer> node1  = new DirectedGraphNode<Integer>(2);
        DirectedGraphNode<Integer> node2  = new DirectedGraphNode<Integer>(2);
        assertTrue(node1.equalsKey(node2));
    }
    
    /** a node that has no neighbors */
    @Test
    public void testGetNeighbor1(){
        DirectedGraphNode<Integer> start = new DirectedGraphNode<Integer>(1); 
        ArrayList<DirectedGraphNode<Integer>> neighbors = start.getNeighbors();
        assertEquals(0, neighbors.size());
    }
    
    /** a node that has multiple neighbors  */
    @Test
    public void testGetNeighbors2(){
        DirectedGraphNode<Integer> start = new DirectedGraphNode<Integer>(1);                       //create node
        DirectedGraphNode<Integer> end1  = new DirectedGraphNode<Integer>(2);                       //create neighbors
        DirectedGraphNode<Integer> end2  = new DirectedGraphNode<Integer>(3);
        DirectedGraphNode<Integer> end3  = new DirectedGraphNode<Integer>(4);
        DirectedGraphEdge<Integer> edge1 = new DirectedGraphEdge(start, end1, 10);                  //create edges
        DirectedGraphEdge<Integer> edge2 = new DirectedGraphEdge(start, end2, 2); 
        DirectedGraphEdge<Integer> edge3 = new DirectedGraphEdge(start, end3, 23); 
         
        ArrayList<DirectedGraphEdge<Integer>> edges = start.getEdges();                             //connect node to neighbors using edges
        edges.add(edge1);
        edges.add(edge2); 
        edges.add(edge3);
        
        ArrayList<DirectedGraphNode<Integer>> neighbors = start.getNeighbors();                     //convert neighbors to array to compare
        int[] expect = {2,3,4};                                                                     //expect
        int[] actual = new int[3];                                                                  //actual
        for (int i = 0; i < neighbors.size(); i++){
            actual[i] = (int) neighbors.get(i).key();
        }
        
        assertArrayEquals(expect, actual);
    }
    
    /** a node having no outgoing edges*/
    @Test
    public void testContainsEdge1(){
        DirectedGraphNode<Integer> start = new DirectedGraphNode<Integer>(1);                       //create node
        assertFalse(start.containsEdge(3,3)); 
    }
    
    /** a node having 1 outgoing edge*/
    @Test
    public void testContainsEdge2(){
        DirectedGraphNode<Integer> start = new DirectedGraphNode<Integer>(1);                       //create node
        DirectedGraphNode<Integer> end1  = new DirectedGraphNode<Integer>(2);                       //create edge
        DirectedGraphEdge<Integer> edge1 = new DirectedGraphEdge(start, end1, 10);   
        ArrayList<DirectedGraphEdge<Integer>> edges = start.getEdges();                             //connect node to neighbors using edges
        edges.add(edge1);
        assertTrue(start.containsEdge(2,10)); 
        assertFalse(start.containsEdge(2,11));
        assertFalse(start.containsEdge(1,10));
    }
}
