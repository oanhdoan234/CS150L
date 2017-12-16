

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class DirectedGraphTest
{
    /**
     * Default constructor for test class DirectedGraphTest
     */
    public DirectedGraphTest()
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
    
    /** add the same value twice => only 1 success */
    @Test
    public void testAddNode1(){
        DirectedGraph<Integer> graph = new DirectedGraph<Integer>();                            //create graph
        graph.addNode(1);                                                                       //add the same node twice
        graph.addNode(1);
       
        ArrayList<DirectedGraphNode<Integer>> nodes = graph.getNodes();                         //convert list of nodes into array
        int[] actual = new int[nodes.size()];                                                   //actual
        int[] expect = {1};                                                                     //expect
        for (int i = 0; i <nodes.size(); i++) actual[i] = nodes.get(i).key();
        assertArrayEquals(expect, actual);
    }
    
    /** add multiple nodes */
    @Test
    public void testAddNode2(){
        DirectedGraph<Integer> graph = new DirectedGraph<Integer>();                            
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
       
        ArrayList<DirectedGraphNode<Integer>> nodes = graph.getNodes();
        int[] actual = new int[nodes.size()];
        int[] expect = {1,2,3};
        for (int i = 0; i <nodes.size(); i++) actual[i] = nodes.get(i).key();
        assertArrayEquals(expect, actual);
    }
    
    /** add an edge that connects two nonexisting values => no success*/
    @Test
    public void testAddEdge1(){
        DirectedGraph<Integer> graph = new DirectedGraph<Integer>(); 
        assertFalse(graph.addEdge(1,2,3));         
    }
    
    /** add an edge connects 2 nodes*/
    @Test
    public void testAddEdge2(){
        DirectedGraph<Integer> graph = new DirectedGraph<Integer>();                    //create & add graph, nodes, edges
        graph.addNode(1);                                                               
        graph.addNode(2);
        assertTrue(graph.addEdge(1,2,3)); 
        
        DirectedGraphNode<Integer> start = graph.find(1);                              //start node
        assertTrue(start.containsEdge(2,3));                                           //contains edge
    }
    
    
    /** update weight of an existing edge*/
    @Test
    public void testAddEdge3(){
        DirectedGraph<Integer> graph = new DirectedGraph<Integer>();
        graph.addNode(1); 
        graph.addNode(2);
        assertTrue(graph.addEdge(1,2,10)); 
        assertTrue(graph.addEdge(1,2,9));
        
        DirectedGraphNode<Integer> start = graph.find(1); 
        assertFalse(start.containsEdge(2,10));
        assertTrue(start.containsEdge(2,9));
    }
    
    /** add multiple edges from a node */
    @Test
    public void testAddEdge4(){
        DirectedGraph<Integer> graph = new DirectedGraph<Integer>();
        graph.addNode(1); 
        graph.addNode(2);
        graph.addNode(3);
        assertTrue(graph.addEdge(1,2,10)); 
        assertTrue(graph.addEdge(1,3,11));
        
        DirectedGraphNode<Integer> start = graph.find(1); 
        assertTrue(start.containsEdge(2,10));
        assertTrue(start.containsEdge(3,11));
    }
    
    /** 2 nodes connected in both directions */
    @Test
    public void testAddEdge5(){
        DirectedGraph<Integer> graph = new DirectedGraph<Integer>();
        graph.addNode(1); 
        graph.addNode(2);
        assertTrue(graph.addEdge(1,2,10)); 
        assertTrue(graph.addEdge(2,1,11));
        
        DirectedGraphNode<Integer> start = graph.find(1); 
        DirectedGraphNode<Integer> end = graph.find(2);
        assertTrue(start.containsEdge(2,10));
        assertTrue(end.containsEdge(1,11));
    }
    
    /** get neighbor of a single node => empty*/
    @Test
    public void testGetNeighbor1(){
        DirectedGraph<Integer> graph = new DirectedGraph<Integer>(); 
        graph.addNode(1); 
        assertEquals(0,graph.getNeighbors(1).size());
    }
    
    /** get neighbors of a node connected with other nodes */
    @Test
    public void testGetNeighbor2(){
        DirectedGraph<Integer> graph = new DirectedGraph<Integer>();                    //create graph
        graph.addNode(1);                                                               //create and add nodes and edges
        graph.addNode(2);   
        graph.addNode(3);
        graph.addEdge(1,2,10);
        graph.addEdge(1,3,11);
        int[] expect = {2,3};                                                           //convert list of neighbors to array
        ArrayList<Integer> neighbors = graph.getNeighbors(1); 
        int[] actual = new int[neighbors.size()];
        for (int i = 0; i <neighbors.size(); i++) actual[i] = neighbors.get(i);
        assertArrayEquals(expect, actual);
    }
}
