

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CarListTest
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
    public void testAdd(){
        RandomGaussian r = new RandomGaussian(100.0,5.0,4328472);
        StationList stations = new StationList(r); 
        CarList cars = new CarList(stations);
        for (int i = 0; i < 3; i++){
            cars.add(new Car(i,2.0,new Battery(2.0,4.0,2.0,10.0),stations));
        }
        assertEquals(0, cars.get(0).getId());
        assertEquals(1, cars.get(1).getId());
        assertEquals(2, cars.get(2).getId());
        assertEquals(3, cars.size());
    }
    
    @Test
    public void testRemoveFrontCar(){
        RandomGaussian r = new RandomGaussian(100.0,5.0,4328472);
        StationList stations = new StationList(r); 
        CarList cars = new CarList(stations);
        for (int i = 0; i < 3; i++){
            cars.add(new Car(i,2.0,new Battery(2.0,4.0,2.0,10.0),stations));
        }
        cars.removeFrontCar();
        assertEquals(1, cars.get(0).getId());
        assertEquals(2, cars.get(1).getId());
        assertEquals(2, cars.size());
    }
    

}
