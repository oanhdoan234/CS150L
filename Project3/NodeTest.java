

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class NodeTest
{
    /**
     * Default constructor for test class NodeTest
     */
    public NodeTest()
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
        Node<Integer> start = new Node<Integer>(1);
        assertEquals(null, start.closest());
    }
    
    /** a node connected to 2 other nodes */
    @Test
    public void testClosest2(){
        Node<Integer> start = new Node<Integer>(1);
        Node<Integer> end1  = new Node<Integer>(2);
        Node<Integer> end2  = new Node<Integer>(3);
        Edge<Integer> edge1 = new Edge(start, end1, 1); 
        Edge<Integer> edge2 = new Edge(start, end2, 2); 
        
        ArrayList<Edge<Integer>> edges = start.getEdges(); 
        edges.add(edge1);
        edges.add(edge2); 
        
        assertEquals((Integer) 2, (Integer) start.closest().key());
    }
    
    /** a node connected to 3 nodes */
    @Test
    public void testClosest3(){
        Node<Integer> start = new Node<Integer>(1);
        Node<Integer> end1  = new Node<Integer>(2);
        Node<Integer> end2  = new Node<Integer>(3);
        Node<Integer> end3  = new Node<Integer>(4);
        Edge<Integer> edge1 = new Edge(start, end1, 10); 
        Edge<Integer> edge2 = new Edge(start, end2, 2); 
        Edge<Integer> edge3 = new Edge(start, end3, 23); 
        
        ArrayList<Edge<Integer>> edges = start.getEdges(); 
        edges.add(edge1);
        edges.add(edge2); 
        edges.add(edge3);
        
        assertEquals((Integer) 3, (Integer) start.closest().key());
    }
    
    /** 2 unequal nodes */
    @Test
    public void testEqualsKey(){
        Node<Integer> node1  = new Node<Integer>(2);
        Node<Integer> node2  = new Node<Integer>(3);
        assertFalse(node1.equalsKey(node2));
    }
    
    /** 2 equal nodes */
    @Test
    public void testEqualsKey2(){
        Node<Integer> node1  = new Node<Integer>(2);
        Node<Integer> node2  = new Node<Integer>(2);
        assertTrue(node1.equalsKey(node2));
    }
    
    /** a node that has no neighbors */
    @Test
    public void testGetNeighbor1(){
        Node<Integer> start = new Node<Integer>(1); 
        ArrayList<Node<Integer>> neighbors = start.getNeighbors();
        assertEquals(0, neighbors.size());
    }
    
    /** a node that has multiple neighbors  */
    @Test
    public void testGetNeighbors2(){
        Node<Integer> start = new Node<Integer>(1);                       //create node
        Node<Integer> end1  = new Node<Integer>(2);                       //create neighbors
        Node<Integer> end2  = new Node<Integer>(3);
        Node<Integer> end3  = new Node<Integer>(4);
        Edge<Integer> edge1 = new Edge(start, end1, 10);                  //create edges
        Edge<Integer> edge2 = new Edge(start, end2, 2); 
        Edge<Integer> edge3 = new Edge(start, end3, 23); 
         
        ArrayList<Edge<Integer>> edges = start.getEdges();                             //connect node to neighbors using edges
        edges.add(edge1);
        edges.add(edge2); 
        edges.add(edge3);
        
        ArrayList<Node<Integer>> neighbors = start.getNeighbors();                     //convert neighbors to array to compare
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
        Node<Integer> start = new Node<Integer>(1);                       //create node
        assertFalse(start.containsEdge(3,3)); 
    }
    
    /** a node having 1 outgoing edge*/
    @Test
    public void testContainsEdge2(){
        Node<Integer> start = new Node<Integer>(1);                       //create node
        Node<Integer> end1  = new Node<Integer>(2);                       //create edge
        Edge<Integer> edge1 = new Edge(start, end1, 10);   
        ArrayList<Edge<Integer>> edges = start.getEdges();                             //connect node to neighbors using edges
        edges.add(edge1);
        assertTrue(start.containsEdge(2,10)); 
        assertFalse(start.containsEdge(2,11));
        assertFalse(start.containsEdge(1,10));
    }
}
