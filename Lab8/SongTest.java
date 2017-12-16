

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SongTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SongTest
{
    /**
     * Default constructor for test class SongTest
     */
    public SongTest()
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
    
    /** compare order 
     * a. Artist
     * b. Title
     * c. Year
     * d. Genre
     */
    
    /** compare 2 similar songs */
    @Test
    public void testCompareTo1(){
        Song s1 = new Song("Dress", "Taylor Swift", 2017, "pop");
        Song s2 = new Song("Dress", "Taylor Swift", 2017, "pop");
        assertTrue(s1.compareTo(s2) ==0);
    }
    
    /** compare 2 songs of different artist */
    @Test
    public void testCompareTo2(){
        Song s1 = new Song("Dress", "Taylor Swift", 2017, "pop");
        Song s2 = new Song("Dress", "Oanh", 2017, "pop");
        assertTrue(s1.compareTo(s2) >0);
    }
    
    /** compare 2 songs of different titles */
    @Test
    public void testCompareTo3(){
        Song s1 = new Song("Dress", "Taylor Swift", 2017, "pop");
        Song s2 = new Song("Look at what you made me do", "Taylor Swift", 2017, "pop");
        assertTrue(s1.compareTo(s2) <0);
    }
    
    /** compare 2 songs of different years */
    @Test
    public void testCompareTo4(){
        Song s1 = new Song("Dress", "Taylor Swift", 2017, "pop");
        Song s2 = new Song("Dress", "Taylor Swift", 2016, "pop");
        assertTrue(s1.compareTo(s2) >0);
    }
    
    /** compare 2 songs of genres */
    @Test
    public void testCompareTo5(){
        Song s1 = new Song("Dress", "Taylor Swift", 2017, "dance");
        Song s2 = new Song("Dress", "Taylor Swift", 2017, "pop");
        assertTrue(s1.compareTo(s2) <0);
    }
    
    @Test
    public void testEquals1(){
        Song s1 = new Song("Dress", "Taylor Swift", 2017, "pop");
        Song s2 = new Song("Dress", "Taylor Swift", 2017, "pop");
        assertTrue(s1.equals(s2));
    }
    
    @Test
    public void testEquals2(){
        Song s1 = null;
        Song s2 = new Song("Dress", "Taylor Swift", 2017, "pop");
        assertFalse(s2.equals(s1));
    }
    
}
