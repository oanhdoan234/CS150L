
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class MyLinkedListIteratorTest
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
    public void testHasNext(){
        MyLinkedList<Double> list = new MyLinkedList<Double>();             //create an empty list
        Iterator<Double> iterator = list.iterator();                        //create iterator of list
        assertFalse(iterator.hasNext());                                    //confirm list is empty
        list.addFirst(5.0);                                                 //add nodes 
        list.addFirst(6.0);
        list.addFirst(7.0);
        for (int i = 0; i<3; i++){
            assertTrue(iterator.hasNext());                 //starting from head, check for the next node and move there
            iterator.next();
        }
        assertFalse(iterator.hasNext());                    //reach the end of list, right before tail
    }
    
    @Test
    public void testNext(){
        MyLinkedList<Double> list = new MyLinkedList<Double>();              //create an empty list
        Iterator<Double> iterator = list.iterator();                         //iterator of list                                   
        list.addFirst(5.0);                                                  //add nodes
        list.addFirst(6.0);
        list.addFirst(7.0);
        Double[] data1 = new Double[3];                                      //array to store actual results
        Double[] data2 = {7.0,6.0,5.0};                                      //expected results
        for (int i = 0; i<3; i++){
            data1[i] = iterator.next();                                      //add list elements to array
        }
        assertArrayEquals(data1, data2);
    }
    
    @Test
    public void testNextNode(){
        MyLinkedList<Double> list = new MyLinkedList<Double>();                                         //create empty list and iterator 
        MyLinkedListIterator<Double> iterator = (MyLinkedListIterator<Double>) list.iterator(); 
        list.addFirst(5.0);                                                                             //add a node
        Node<Double> next = iterator.nextNode();                            //get the node right next to curr position (head) 
        double e = next.getElement();                                                                   //get its element
        assertEquals(e,5.0,0);
    }
    
    
}
