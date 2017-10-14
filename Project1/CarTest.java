

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CarTest
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
    public void testTravel1(){
        Car c = new Car(1);
        for (int i = 0; i < 5; i++){
            c.travel();
        }
        //assert miles travelled
        assertEquals(10,c.getDistanceTraveled(),0);
        assertEquals(5,c.getBattery(),0);
        assertEquals(5,c.getTimeInSystem(),0);
        
    }
    
    @Test
    public void testTravel2(){
        Car c = new Car(2);
        for (int i = 0; i < 20; i++){
            c.travel();
        }
        //assert miles travelled
        assertEquals(20,c.getDistanceTraveled(),0);
        assertEquals(0,c.getBattery(),0);
        assertEquals(10,c.getTimeInSystem(),0);
    }
    
    @Test 
    public void testCheckBatteryAndCharge(){
        Car c = new Car(3);
        assertFalse(c.checkLowBattery());
        for (int i = 0; i < 7; i++){
            c.travel();
        }
        assertTrue(c.checkLowBattery());
        for (int i = 0; i <5; i++){
            c.chargeBattery();
        }
        assertEquals(5.5,c.getBattery(),0);
    }
}
