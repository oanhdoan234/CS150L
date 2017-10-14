

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MyLinkedListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MyLinkedListTest
{

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
    
     @Test
    public void testAddFirst(){
        MyLinkedList<Double> list = new MyLinkedList<Double>();                //create an empty list
        list.addFirst(5.0);                                                    //add nodes to front
        list.addFirst(6.0);
        list.addFirst(7.0);
        Double[] data1 = new Double[3];                                         //convert to array
        data1 = list.toArrayList().toArray(data1);
        Double[] data2 = {7.0,6.0,5.0};                                         //expected array
        assertArrayEquals(data1, data2);                                        //compare actual and expected
    }
    
    @Test
    public void testAddLast(){
        MyLinkedList<Double> list = new MyLinkedList<Double>();                 //create an empty list
        list.addLast(5.0);                                                      //add nodes to back
        list.addLast(6.0);                      
        list.addLast(7.0);
        Double[] data1 = new Double[3];                                         //convert to array
        data1 = list.toArrayList().toArray(data1);                              
        Double[] data2 = {5.0,6.0,7.0};                                         //expected array
        assertArrayEquals(data1, data2); 
    }
    
    @Test
    public void testRemove1(){                                                  //when index > list size
        MyLinkedList<Double> list = new MyLinkedList<Double>();                 //empty list
        list.remove(3);                                                         //remove
        Double[] data1 = new Double[list.size()];                                
        data1 = list.toArrayList().toArray(data1);
        Double[] data2 = new Double[0];                                         //expected array is empty because the method should not do 
        assertArrayEquals(data1, data2);                                        //anything to the list
    }
    
    @Test
    public void testRemove2(){                                                  //remove first node
        MyLinkedList<Double> list = new MyLinkedList<Double>();                 //create an empty list 
        list.addLast(5.0);                                                      //add nodes
        list.addLast(6.0);
        list.addLast(7.0);
        list.remove(0);                                                         //remove first node
        Double[] data1 = new Double[list.size()];                               //convert list to array
        data1 = list.toArrayList().toArray(data1);
        Double[] data2 = {6.0,7.0};                                             //expected array
        assertArrayEquals(data1, data2); 
    }
    
    @Test
    public void testRemove3(){                                                  //remove any nodes other than the first
        MyLinkedList<Double> list = new MyLinkedList<Double>();                 //create an empty list
        list.addLast(5.0);                                                      //add nodes
        list.addLast(6.0);
        list.addLast(7.0);
        list.remove(1);                                                         //remove some node in the middle 
        Double[] data1 = new Double[list.size()];
        data1 = list.toArrayList().toArray(data1);                              //convert to array
        Double[] data2 = {5.0,7.0};                                             //expected result
        assertArrayEquals(data1, data2); 
    }
    
    @Test
    public void testGetNode(){
        MyLinkedList<Double> list = new MyLinkedList<Double>();                 //create empty list
        list.addLast(5.0);                                                      //add nodes
        list.addLast(6.0);
        list.addLast(7.0);
        Node<Double> findIt = list.getNode(1);                                  //get a node given index
        double findItElement = findIt.getElement();                             //get the node element
        double nextNodeElement = findIt.next().getElement();                    
        Double[] data1 = {findItElement, nextNodeElement};                      //get element of the next node
        Double[] data2 = {6.0,7.0};                                             //expect elements of this node and its next one
        assertArrayEquals(data1, data2);
    }
    
    @Test
    public void testGetElement(){
        MyLinkedList<Double> list = new MyLinkedList<Double>();                 //create empty list
        list.addLast(5.0);                                                      //add nodes
        list.addLast(6.0);
        list.addLast(7.0);
        double e = list.getElement(1);                                          //get an element given its index
        assertEquals(e,6.0,0);                          
    }
}
