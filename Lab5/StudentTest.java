

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentTest
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
    public void testCompareTo(){
        Student student1 = new Student("Oanh","Doan",4340590,2018);
        Student student2 = new Student("Thanh","Vu", 4349270,2018);
        int result = student1.compareTo(student2);
        assertEquals(-1, result);
    }
}
