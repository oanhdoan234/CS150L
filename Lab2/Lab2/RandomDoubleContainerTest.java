import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RandomDoubleContainerTest
{
    public RandomDoubleContainerTest()
    {
    }

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
     * Most methods are tested twice, one with a small arrayList, one with a larger arrayList
     */
    
    //test AddToFront
    @Test
    public void testAddToFront1(){
        RandomDoubleContainer r = new RandomDoubleContainer();
        r.addToFront(6);                                            //add a number to ArrayList                 
        Double[] array1 = r.convertToArray();                       //convert ArrayList to array
        Double[] array2 = {6.0};                                    
        assertArrayEquals(array1, array2);                          //check if the two arrays are the same
    }
    
    @Test
    public void testAddToFront2(){
        RandomDoubleContainer r =  new RandomDoubleContainer(); 
        r.addToFront(6);
        r.addToFront(12);
        r.addToFront(23);
        Double[] array1 = r.convertToArray();
        Double[] array2 = {23.0,12.0,6.0};
        assertArrayEquals(array1, array2);
    }
    
    //test AddToBack
    @Test
    public void testAddToBack1(){
        RandomDoubleContainer r = new RandomDoubleContainer();
        r.addToBack(23);
        Double[] array1 = r.convertToArray();
        Double[] array2 = {23.0};
        assertArrayEquals(array1, array2);
    }
    
    @Test
    public void testAddToBack2(){
        RandomDoubleContainer r = new RandomDoubleContainer();
        r.addToBack(23);
        r.addToBack(5);
        r.addToBack(96);
        Double[] array1 = r.convertToArray();
        Double[] array2 = {23.0,5.0,96.0};
        assertArrayEquals(array1, array2);
    }
    
    //test AddSorted
    @Test
    public void testAddSorted(){
        RandomDoubleContainer r = new RandomDoubleContainer();
        r.addToFront(11);
        r.addToBack(15);
        r.addToBack(19);
        r.addToBack(23);
        r.addSorted(17);
        Double[] array1 = r.convertToArray();
        Double[] array2 = {11.0,15.0,17.0,19.0,23.0};
        assertArrayEquals(array1,array2);
    }
    
    //test Swap
    @Test
    public void testSwap1(){
        RandomDoubleContainer r = new RandomDoubleContainer();
        r.addToFront(11);
        r.addToBack(15);
        r.swap(0,1);
        Double[] array1 = r.convertToArray();
        Double[] array2 = {15.0,11.0};
        assertArrayEquals(array1,array2);
    }
    
    @Test
    public void testSwap2(){
        RandomDoubleContainer r = new RandomDoubleContainer();
        r.addToFront(11);
        r.addToBack(15);
        r.addToBack(19);
        r.addToBack(23);
        r.addSorted(17);
        r.swap(1,3);
        Double[] array1 = r.convertToArray();
        Double[] array2 = {11.0,19.0,17.0,15.0,23.0};
        assertArrayEquals(array1,array2);
    }
    
    //test SelectionSort
    @Test
    public void testSelectionSort1(){
        RandomDoubleContainer r = new RandomDoubleContainer();
        r.addToFront(2);
        r.selectionSort();
        Double[] array1 = r.convertToArray();
        Double[] array2 = {2.0};
        assertArrayEquals(array1, array2);
    }
    
    @Test
    public void testSelectionSort2(){
        RandomDoubleContainer r = new RandomDoubleContainer();
        r.addToFront(11);
        r.addToBack(21);
        r.addToBack(19);
        r.addToBack(5);
        r.selectionSort();
        Double[] array1 = r.convertToArray();
        Double[] array2 = {5.0,11.0,19.0,21.0};
        assertArrayEquals(array1, array2);
    }
    
    
}


