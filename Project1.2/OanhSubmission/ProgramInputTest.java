

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.lang.*;
import java.util.*;

public class ProgramInputTest
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
    public void testReadInt(){
        ProgramInput input = new ProgramInput("input.txt");
        ArrayList<Integer> integers = input.readInt(0,3);
        assertEquals(100, (int) integers.get(0));
        assertEquals(20, (int) integers.get(1));
        assertEquals(1, (int) integers.get(2));
    }
    
    @Test
    public void testReadDouble(){
        ProgramInput input = new ProgramInput("input.txt");
        ArrayList<Double> doubles = input.readDouble(3,8);
        assertEquals(2, (double) doubles.get(0),0);
        assertEquals(2, (double) doubles.get(1),0);
        assertEquals(4, (double) doubles.get(2),0);
        assertEquals(2, (double) doubles.get(3),0);
        assertEquals(10, (double) doubles.get(4),0);
    }
    
    @Test
    public void testReadRandomGaussian(){
        ProgramInput input = new ProgramInput("input.txt");
        ArrayList<RandomGaussian> randoms = input.readRandomGaussian(8,3213321);
        assertTrue(randoms.get(0).compareTo(new RandomGaussian(4,2,3213321)));
        assertTrue(randoms.get(1).compareTo(new RandomGaussian(10,2,3213321)));
        assertTrue(randoms.get(2).compareTo(new RandomGaussian(8,2,3213321)));
    }
}
