

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FacultyTest
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
    
    @Test                                                                                               //same last name
    public void testCompareToLastName1(){                                                       
        Faculty faculty1 = new Faculty("John","Wilson", 610905583, "wilsonj@lafayette.edu");
        Faculty faculty2 = new Faculty("Marry","Wilson", 418252487, "marryj@lafayette.edu");
        int result = faculty1.compareToLastName(faculty2); 
        assertEquals(0, result);
    }
    
    @Test                                                                                               //different last names 
    public void testCompareToLastName2(){
        Faculty faculty1 = new Faculty("John","Wilson", 610905583, "wilsonj@lafayette.edu");
        Faculty faculty2 = new Faculty("Marry","Thompson", 418252487, "marryj@lafayette.edu");
        int result = faculty1.compareToLastName(faculty2); 
        assertEquals(1, result);
    }
    
    @Test                                                                                               //different last names 
    public void testCompareToLastName3(){
        Faculty faculty1 = new Faculty("John","Wilson", 610905583, "wilsonj@lafayette.edu");
        Faculty faculty2 = new Faculty("Marry","Thompson", 418252487, "marryj@lafayette.edu");
        int result = faculty2.compareToLastName(faculty1); 
        assertEquals(-1, result);
    }
    
    @Test                                                                                               //same first names 
    public void testCompareToFirstName1(){
        Faculty faculty1 = new Faculty("John","Wilson", 610905583, "wilsonj@lafayette.edu");
        Faculty faculty2 = new Faculty("John","Thompson", 418252487, "marryj@lafayette.edu");
        int result = faculty1.compareToFirstName(faculty2); 
        assertEquals(0, result);
    }
    
    @Test                                                                                               //different first names 
    public void testCompareToFirstName2(){
        Faculty faculty1 = new Faculty("John","Wilson", 610905583, "wilsonj@lafayette.edu");
        Faculty faculty2 = new Faculty("Marry","Thompson", 418252487, "marryj@lafayette.edu");
        int result = faculty1.compareToFirstName(faculty2); 
        assertEquals(-1, result);
    }
    
    @Test                                                                                                //different first names 
    public void testCompareToFirstName3(){
        Faculty faculty1 = new Faculty("John","Wilson", 610905583, "wilsonj@lafayette.edu");
        Faculty faculty2 = new Faculty("Marry","Thompson", 418252487, "marryj@lafayette.edu");
        int result = faculty2.compareToFirstName(faculty1); 
        assertEquals(1, result);
    }
    
    @Test                                                                                               //matching names
    public void testCompareTo1(){
        Faculty faculty1 = new Faculty("John","Wilson", 610905583, "wilsonj@lafayette.edu");
        Faculty faculty2 = new Faculty("John","Wilson", 418252487, "marryj@lafayette.edu");
        int result = faculty1.compareTo(faculty2); 
        assertEquals(0, result);
    }
    
    @Test                                                                                               //same last names, different first names
    public void testCompareTo2(){
        Faculty faculty1 = new Faculty("John","Wilson", 610905583, "wilsonj@lafayette.edu");
        Faculty faculty2 = new Faculty("Marry","Wilson", 418252487, "marryj@lafayette.edu");
        int result = faculty1.compareTo(faculty2); 
        assertEquals(-1, result);
    }
    
    @Test                                                                                               //different last names
    public void testCompareTo3(){
        Faculty faculty1 = new Faculty("John","Wilson", 610905583, "wilsonj@lafayette.edu");
        Faculty faculty2 = new Faculty("John","Thompson", 418252487, "marryj@lafayette.edu");
        int result = faculty1.compareTo(faculty2); 
        assertEquals(1, result);
    }
}
