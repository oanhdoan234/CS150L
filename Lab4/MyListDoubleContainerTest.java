

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MyListDoubleContainerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MyListDoubleContainerTest
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
    public void testAddToFront1(){                                              //add 1 number to front
        MyListDoubleContainer c = new MyListDoubleContainer();                  //create new container
        c.addToFront(1.0);                                                      //add number to front
        Double[] data1 = c.toArray();                                           //actual
        Double[] data2 = {1.0};                                                 //expected
        assertArrayEquals(data1, data2);
    }
    
    @Test
    public void testAddToFront2(){                                              //add multiple numbers to front
        MyListDoubleContainer c = new MyListDoubleContainer(); 
        c.addToFront(1.0);
        c.addToFront(2.0);
        c.addToFront(3.0);
        Double[] data1 = c.toArray(); 
        Double[] data2 = {3.0,2.0,1.0};
        assertArrayEquals(data1, data2);
    }
    
    @Test
    public void testAddToBack1(){                                               //add 1 number to back
        MyListDoubleContainer c = new MyListDoubleContainer(); 
        c.addToBack(1.0);
        Double[] data1 = c.toArray(); 
        Double[] data2 = {1.0};
        assertArrayEquals(data1, data2);
    }
    
    @Test 
    public void testAddToBack2(){                                               //add multiple numbers to back
        MyListDoubleContainer c = new MyListDoubleContainer(); 
        c.addToBack(1.0);
        c.addToBack(2.0);
        c.addToBack(3.0);
        Double[] data1 = c.toArray(); 
        Double[] data2 = {1.0,2.0,3.0};
        assertArrayEquals(data1, data2);
    }
    
    @Test
    public void searchWithIterator1(){                                          //search with iterator from an empty list
        MyListDoubleContainer c = new MyListDoubleContainer(); 
        int idx = c.searchWithIterator(4.0);
        assertEquals(-1,idx);
    }
    
    @Test
    public void searchWithIterator2(){                                          //search with iterator for a number that is not in list
        MyListDoubleContainer c = new MyListDoubleContainer(); 
        c.addToBack(1.0);
        c.addToBack(2.0);
        c.addToBack(3.0);
        int idx = c.searchWithIterator(4.0);
        assertEquals(-1,idx);
    }
    
    @Test
    public void searchWithIterator3(){                                          //search with iterator for a number at list head
        MyListDoubleContainer c = new MyListDoubleContainer(); 
        c.addToBack(1.0);
        c.addToBack(2.0);
        c.addToBack(3.0);
        int idx = c.searchWithIterator(1.0);
        assertEquals(0,idx);
    }
    
    
    @Test
    public void searchWithoutIterator1(){                                      //search without iterator from an empty list
        MyListDoubleContainer c = new MyListDoubleContainer(); 
        int idx = c.searchWithoutIterator(4.0);
        assertEquals(-1,idx);
    }
    
    @Test
    public void searchWithoutIterator2(){                                      //search without iterator for a number that is not in list
        MyListDoubleContainer c = new MyListDoubleContainer(); 
        c.addToBack(1.0);
        c.addToBack(2.0);
        c.addToBack(3.0);
        int idx = c.searchWithoutIterator(4.0);
        assertEquals(-1,idx);
    }
    
    @Test
    public void searchWithoutIterator3(){                                      //search without iterator for a number at list head
        MyListDoubleContainer c = new MyListDoubleContainer(); 
        c.addToBack(1.0);
        c.addToBack(2.0);
        c.addToBack(3.0);
        int idx = c.searchWithoutIterator(1.0);
        assertEquals(0,idx);
    }
    
    @Test
    public void searchWithoutIterator4(){                                       //search without iterator for a number in the middle
        MyListDoubleContainer c = new MyListDoubleContainer(); 
        c.addToBack(1.0);
        c.addToBack(2.0);
        c.addToBack(3.0);
        c.addToBack(4.0);
        int idx = c.searchWithoutIterator(2.0);
        assertEquals(1,idx);
    }
    
    @Test
    public void searchWithoutIterator5(){                                       //search without iterator for a number at list tail
        MyListDoubleContainer c = new MyListDoubleContainer(); 
        c.addToBack(1.0);
        c.addToBack(2.0);
        c.addToBack(3.0);
        c.addToBack(4.0);
        int idx = c.searchWithoutIterator(4.0);
        assertEquals(3,idx);
    }
}
