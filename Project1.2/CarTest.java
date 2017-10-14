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
    public void testConsume_IncreaseMillage_Charge(){
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));
        Car c1 = new Car(1,2.0,new Battery(2.0,4.0,2.0,10.0),stations);                                                                   
        c1.consume(); 
        c1.increaseMillage(); 
        assertEquals(9.0, c1.batteryLevel(),0); 
        assertEquals(2.0, c1.getMillage(),0);
        c1.charge(); 
        assertEquals(9.5, c1.batteryLevel(),0);
    }
    
    @Test 
    public void testPutMeAtHome(){
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));
        Car c1 = new Car(1,2.0,new Battery(2.0,4.0,2.0,10.0),stations); 
        c1.setStatus(1);
        c1.consume();
        c1.increaseMillage();
        c1.putMeAtHome(); 
        assertEquals(0.0, c1.getMillage(), 0); 
        assertEquals(0, c1.getStatus()); 
    }
    
    @Test 
    public void testFullBattery(){
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));
        Car c1 = new Car(1,2.0,new Battery(2.0,4.0,2.0,10.0),stations); 
        assertTrue(c1.fullBattery());
    }
    
    @Test 
    public void testLowBattery(){
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));
        Car c1 = new Car(1,2.0,new Battery(2.0,4.0,2.0,10.0),stations); 
        for (int i = 0; i<7;i++) c1.consume();
        assertTrue(c1.lowBattery());
    }
    
    @Test
    public void testCanCompleteTrip(){
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));
        Car c1 = new Car(1,2.0,new Battery(2.0,4.0,2.0,10.0),stations); 
        c1.setTrip(9.0);
        for (int i = 0; i<7;i++) {
            c1.consume();
            c1.increaseMillage();
        }
        assertTrue(c1.canCompleteTrip());
    }
    
    @Test
    public void testAmIDone(){
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));
        Car c1 = new Car(1,2.0,new Battery(2.0,4.0,2.0,10.0),stations); 
        c1.setTrip(9.0);
        for (int i = 0; i<4;i++) {
            c1.consume();
            c1.increaseMillage();
        }
        assertFalse(c1.amIDone());
        c1.consume();
        c1.increaseMillage();
        assertTrue(c1.amIDone());
    }
    
    @Test 
    public void testRun1(){                                          //Remove a car from simulation when its battery is depleted 
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));               //create a car
        Car c1 = new Car(1,2.0,new Battery(2.0,4.0,2.0,10.0),stations); 
        c1.setStatus(1);
                                                                                            //deplete battery 
        for (int i = 0; i<10;i++) c1.consume();                                         
        c1.run();                                                                           //remove the car
        assertEquals(-1, c1.getStatus());                                                   
    }
    
    @Test
    public void testRun2(){                                          //A car finishes a short trip before battery gets below threshold
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));              //create a car
        Car c1 = new Car(1,2.0,new Battery(2.0,4.0,2.0,10.0),stations); 
        c1.setStatus(1);
        c1.setTrip(9.0);                                                                    //run and set home when it finishes the trip
        for (int i = 0; i <5; i++){ c1.run();}
        assertEquals(0,c1.getStatus());
    }
    
    @Test
    public void testRun3(){                                             //A car finishes a longer trip. Battery gets below threshold but is still 
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));          //enough for the car to finish the trip
        Car c1 = new Car(1,2.0,new Battery(2.0,4.0,2.0,10.0),stations); 
        c1.setStatus(1);
        c1.setTrip(16.0);                                                               //Run 
        for (int i = 0; i <7; i++){ c1.run();}
        assertTrue(c1.lowBattery());                                                    //Check low battery                       
        assertTrue(c1.canCompleteTrip());                                               //Check if the trip can be completed 
        c1.run();                                                                       //move on
        assertEquals(0,c1.getStatus());                                                 //get home
    }
    
    @Test
    public void testRun4(){                                                             //no stations found, keep moving 
       StationList stations = new StationList(new RandomGaussian(4.0,2.0,4563214));
       Car c1 = new Car(1,2.0,new Battery(2.0,4.0,2.0,10.0),stations); 
       c1.setTrip(22.0);
       c1.setStatus(1);
       for (int i = 0; i <7; i++){ c1.run();}
       assertEquals(1,c1.getStatus());
    }
    
}
