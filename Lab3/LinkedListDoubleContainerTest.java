

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LinkedListDoubleContainerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LinkedListDoubleContainerTest
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
    
    
    /**
     * Most methods are tested twice, one with a small dataList, one with a larger dataList
     */
    
    //test AddToFront
    @Test
    public void testAddToFront1(){
        LinkedListDoubleContainer r = new LinkedListDoubleContainer();
        r.addToFront(6);                                            //add a number to dataList                 
        Double[] data1 = r.convertToArray();                       //convert dataList to data
        Double[] data2 = {6.0};                                    
        assertArrayEquals(data1, data2);                          //check if the two datas are the same
    }
    
    @Test
    public void testAddToFront2(){
        LinkedListDoubleContainer r =  new LinkedListDoubleContainer(); 
        r.addToFront(6);
        r.addToFront(12);
        r.addToFront(23);
        Double[] data1 = r.convertToArray();
        Double[] data2 = {23.0,12.0,6.0};
        assertArrayEquals(data1, data2);
    }
    
    //test AddToBack
    @Test
    public void testAddToBack1(){
        LinkedListDoubleContainer r = new LinkedListDoubleContainer();
        r.addToBack(23);
        Double[] data1 = r.convertToArray();
        Double[] data2 = {23.0};
        assertArrayEquals(data1, data2);
    }
    
    @Test
    public void testAddToBack2(){
        LinkedListDoubleContainer r = new LinkedListDoubleContainer();
        r.addToBack(23);
        r.addToBack(5);
        r.addToBack(96);
        Double[] data1 = r.convertToArray();
        Double[] data2 = {23.0,5.0,96.0};
        assertArrayEquals(data1, data2);
    }
    
    //test AddSorted
    @Test
    public void testAddSorted(){
        LinkedListDoubleContainer r = new LinkedListDoubleContainer();
        r.addToFront(11);
        r.addToBack(15);
        r.addToBack(19);
        r.addToBack(23);
        r.addSorted(17);
        Double[] data1 = r.convertToArray();
        Double[] data2 = {11.0,15.0,17.0,19.0,23.0};
        assertArrayEquals(data1,data2);
    }
    
    //test Swap
    @Test
    public void testSwap1(){
        LinkedListDoubleContainer r = new LinkedListDoubleContainer();
        r.addToFront(11);
        r.addToBack(15);
        r.swap(0,1);
        Double[] data1 = r.convertToArray();
        Double[] data2 = {15.0,11.0};
        assertArrayEquals(data1,data2);
    }
    
    @Test
    public void testSwap2(){
        LinkedListDoubleContainer r = new LinkedListDoubleContainer();
        r.addToFront(11);
        r.addToBack(15);
        r.addToBack(19);
        r.addToBack(23);
        r.addSorted(17);
        r.swap(1,3);
        Double[] data1 = r.convertToArray();
        Double[] data2 = {11.0,19.0,17.0,15.0,23.0};
        assertArrayEquals(data1,data2);
    }
    
    //test SelectionSort
    @Test
    public void testSelectionSort1(){
        LinkedListDoubleContainer r = new LinkedListDoubleContainer();
        r.addToFront(2);
        r.selectionSort();
        Double[] data1 = r.convertToArray();
        Double[] data2 = {2.0};
        assertArrayEquals(data1, data2);
    }
    
    @Test
    public void testSelectionSort2(){
        LinkedListDoubleContainer r = new LinkedListDoubleContainer();
        r.addToFront(11);
        r.addToBack(21);
        r.addToBack(19);
        r.addToBack(5);
        r.selectionSort();
        Double[] data1 = r.convertToArray();
        Double[] data2 = {5.0,11.0,19.0,21.0};
        assertArrayEquals(data1, data2);
    }
    
    @Test
    public void linearSearch(){
        LinkedListDoubleContainer r = new LinkedListDoubleContainer();
        r.addToFront(11);
        r.addToBack(21);
        r.addToBack(19);
        r.addToBack(5);
        r.selectionSort();
        int pos = r.linearSearch(11);
        assertEquals(pos,1);
    }
    
    @Test
    public void binarySearch(){
        LinkedListDoubleContainer r = new LinkedListDoubleContainer();
        r.addToFront(11);
        r.addToBack(21);
        r.addToBack(19);
        r.addToBack(5);
        r.selectionSort();
        int pos = r.binarySearch(11);
        assertEquals(pos,1);
    }
}


