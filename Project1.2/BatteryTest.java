

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BatteryTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BatteryTest
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
    public void testDecreaseAndIncrease1(){                         //Test average case
        Battery b =  new Battery(2.0,4.0,2.0,10.0);
        for (int i = 0; i < 5; i++){
            b.decrease();
        }
        assertEquals(5,b.getBatteryLevel(),0);
   
        for (int i = 0; i < 5; i++){
            b.increase();
        }
        assertEquals(7.5,b.getBatteryLevel(),0);
    }
    
    @Test
    public void testDecreaseAndIncrease2(){                         //Test boundary case
        Battery b =  new Battery(2.0,4.0,2.0,10.0);
        
        for (int i = 0; i < 5; i++){                                //Refill battery when it is still full
            b.increase();
        }
        assertEquals(10,b.getBatteryLevel(),0);

        for (int i = 0; i < 20; i++){                               //Decrease battery if it is depleted
            b.decrease();
        }
        assertEquals(0,b.getBatteryLevel(),0);
        
   
    }
    
    @Test 
    public void testLowBattery(){
        Battery b = new Battery(2.0,4.0,2.0,10.0);
        assertFalse(b.lowBattery());
        for (int i = 0 ; i < 6; i++){
            b.decrease();
        }
        assertTrue(b.lowBattery());
    }
}
