

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChargingPointTest
{
    /**
     * Default constructor for test class ChargingPointTest
     */
    public ChargingPointTest()
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
    public void testEnqueue(){
        Car c1 = new Car(1); 
        Car c2 = new Car(2);
        ChargingPoint p = new ChargingPoint();
        p.enqueue(c1);
        p.enqueue(c2);
        assertEquals(1,p.getCar(0).getId());
        assertEquals(2,p.getCar(1).getId());
    }
    
    public void testDequeue(){
        Car c1 = new Car(1); 
        Car c2 = new Car(2);
        Car c3 = new Car(3); 
        ChargingPoint p = new ChargingPoint();
        p.enqueue(c1);
        p.enqueue(c2);
        p.enqueue(c3);
        assertEquals(3,p.getSize());
        p.enqueue(c3);
        assertEquals(2,p.getSize());
        assertEquals(2,p.getCar(p.getSize()-1).getId());
    }
    
}
