

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlayListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlayListTest
{
    /**
     * Default constructor for test class PlayListTest
     */
    public PlayListTest()
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
    
    @Test
    public void testAddSong1(){
        PlayList p = new PlayList();
        p.addSong("test1.txt");
        String[] actual = p.toArrayOfArtist();
        String[] expect = {"Taylor Swift"};
        assertArrayEquals(expect, actual);
    }
    
    @Test 
    public void testAddSong2(){
        PlayList p = new PlayList();
        p.addSong("test2.txt");
        String[] actual = p.toArrayOfArtist();
        String[] expect = {"Bob Dylan", "Linkin Park", "Taylor Swift"};
        assertArrayEquals(expect, actual);
    }
    
    @Test
    public void testAddSong3(){
        PlayList p = new PlayList();
        p.addSong("test3.txt");
        String[] actualArtist = p.toArrayOfArtist();
        String[] expectArtist = {"Bob Dylan", "Linkin Park", "Taylor Swift", "Taylor Swift"};
        String[] actualTitle = p.toArrayOfTitle();
        String[] expectTitle = {"A hard rain's a gonna fall", "Nobody can save me", "Dress","Look at what you made me do"};
        assertArrayEquals(expectArtist, actualArtist);
        assertArrayEquals(expectTitle, actualTitle);
    }
}
