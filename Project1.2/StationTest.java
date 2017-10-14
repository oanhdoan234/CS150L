

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StationTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StationTest
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
    public void testGenerateDistance(){
        Station s = new Station(1);
        double d = s.generateDistance(new RandomGaussian(5,100,4328472));
        boolean positiveS = d>0;
        assertTrue(s.getDistance()>0);
    }
    
    @Test 
    public void testSetDistance(){
        Station s = new Station(1);
        s.setDistance(20);
        assertEquals(20.0, s.getDistance(),0);
    }
    
    @Test
    public void testAddRequest(){
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));
        Station s = new Station(1);
        stations.add(s);
        
        Car c1 = new Car(1,2.0,new Battery(2.0,4.0,2.0,10.0),stations);
        s.addRequest(c1);
        assertEquals(1,s.size());
    }
    
    @Test 
    public void testChargeAndWait1(){                                           //only 1 car, no need to wait
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));
        Station s = new Station(1);
        stations.add(s);
        //id, speed, long id, double speed, Battery battery, StationList stationList
        //double distancePerUnit, double threshold, double chargeTimePerUnit, double maxCapacity
        Car c1 = new Car(1,2.0,new Battery(2.0,4.0,2.0,10.0),stations);
        c1.consume();
        
        s.addRequest(c1);
        s.chargeAndWait();
        assertEquals(0.0, c1.getWaitTime(),0);
        s.chargeAndWait();
        assertEquals(0.0, c1.getWaitTime(),0);
        assertEquals(10.0,c1.batteryLevel(),0);
    }
    
    
    @Test 
    public void testChargeAndWait2(){                                           //car 1 charging, car 2 waiting
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));
        Station s = new Station(1);
        stations.add(s);
        
        Car c1 = new Car(1,2.0,new Battery(2.0,4.0,2.0,10.0),stations);
        Car c2 = new Car(2,2.0,new Battery(2.0,4.0,2.0,10.0),stations); 
        c1.consume();
        c2.consume();
        
        s.addRequest(c1);
        s.addRequest(c2); 
        s.chargeAndWait();
        assertEquals(0.0, c1.getWaitTime(),0);
        assertEquals(1.0, c2.getWaitTime(),0);
        s.chargeAndWait();
        assertEquals(0.0, c1.getWaitTime(),0);
        assertEquals(2.0, c2.getWaitTime(),0);
    }
    
    @Test
    public void testSimulateOneStep1(){                                             //Charge a car                                
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));
        Station s = new Station(1);
        stations.add(s);
        
        Car c1 = new Car(1,2.0,new Battery(2.0,4.0,2.0,10.0),stations);
        
        c1.consume(); 
        s.addRequest(c1);
        s.simulateOneStep();
        assertEquals(9.5, c1.batteryLevel(),0);
    }
    
    @Test
    public void testSimulateOneStep2(){                                             //Remove a car whose battery is full
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));
        Station s = new Station(1);
        stations.add(s);
        
        Car c1 = new Car(1,2.0,new Battery(2.0,4.0,2.0,10.0),stations);
        
        s.addRequest(c1);
        assertEquals(1,s.size());
        
        double result = s.simulateOneStep();
        assertEquals(0,s.size());
        assertEquals(0.0, result, 0);
    }
    
    @Test 
    public void testSimulateOneStep3(){                                            //Charge 1st car, 2nd car waits in line
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));
        Station s = new Station(1);
        stations.add(s);
        Car c1 = new Car(1,2.0,new Battery(2.0,4.0,2.0,10.0),stations);                                         //Generate 2 cars
        Car c2 = new Car(2,2.0,new Battery(2.0,4.0,2.0,10.0),stations);   
        c1.consume();                                                             //2 cars use battery
        c2.consume();
        s.addRequest(c1);                                                         //add cars to station
        s.addRequest(c2);
        double result1 = s.simulateOneStep();                                     //charge car 1, car 2 waits
        assertEquals(9.5, c1.batteryLevel(),0);
        assertEquals(9.0, c2.batteryLevel(),0);
        assertEquals(-1, result1, 0);
        
        double result2 = s.simulateOneStep();                                     //full charge car 1, remove it
        assertEquals(10.0, c1.batteryLevel(),0);
        assertEquals(9.0, c2.batteryLevel(),0); 
        assertEquals(0.0, result2,0); 
        
        double result3 = s.simulateOneStep();                                      //charge car 2
        assertEquals(9.5, c2.batteryLevel(),0);
        assertEquals(-1, result3,0);
        
        double result4 = s.simulateOneStep();                                      //full charge car2, remove it
        assertEquals(10.0, c2.batteryLevel(),0);
        assertEquals(2, result4,0);
    }
    
}
