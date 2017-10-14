

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.lang.*;

/**
 * The test class StationListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StationListTest
{

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
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));
        for (int i = 0; i <3; i++){
            stations.add(new Station(i));
        }
        assertEquals(3, stations.numStations());
    }
    
    @Test 
    public void testFindMin1(){
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));
        for (int i = 0; i <3; i++){
            ArrayList<Double> num = new ArrayList<Double>();
            int result = stations.findMin(num);
            assertEquals(-1, result);
        }
    }
    
    @Test 
    public void testFindMin2(){
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));
        for (int i = 0; i <3; i++){
            ArrayList<Double> num = new ArrayList<Double>();
            num.add(5.0);
            num.add(3.2);
            num.add(1.8);
            num.add(9.0);
            int result = stations.findMin(num);
            assertEquals(2,result);
        }
    }
    
    @Test
    public void testSimulateOneStep1(){
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));
        Station s1 = new Station(1);                                    //create and add stations to StationList
        Station s2 = new Station(2); 
        stations.add(s1);
        stations.add(s2); 
        
        Car c1 = new Car(1,2.0,new Battery(2.0,4.0,2.0,10.0),stations);                                           //Create 2 cars                            
        Car c2 = new Car(2,2.0,new Battery(2.0,4.0,2.0,10.0),stations); 
        c1.consume();                                                               //2 cars use battery
        c2.consume();
        s1.addRequest(c1);                                                          //add cars to stations
        s2.addRequest(c2);
        
        stations.simulateOneStep();                                                 //simulate 1 step - charge both cars
        assertEquals(9.5, c1.batteryLevel(),0);
        assertEquals(9.5, c2.batteryLevel(),0);
    }
    
    @Test
    public void testSimulateOneStep2(){
        StationList stations = new StationList(new RandomGaussian(100.0,5.0,4328472));
        Station s1 = new Station(1);                                    //create and add stations to StationList
        Station s2 = new Station(2); 
        stations.add(s1);
        stations.add(s2); 
        
        Car c1 = new Car(1,2.0,new Battery(2.0,4.0,2.0,10.0),stations);             //Create 2 cars                            
        Car c2 = new Car(2,2.0,new Battery(2.0,4.0,2.0,10.0),stations); 
        c1.consume();                                                               //Car 1 uses battery
        s1.addRequest(c1);                                                          //add cars to stations
        s2.addRequest(c2);
        
        stations.simulateOneStep();                                                 //simulate one step 
        assertEquals(9.5, c1.batteryLevel(),0);                                     //station 1 charges car 1
        assertEquals(0, s2.size());                                                 //station 2 removes car 2 from its line
    }
}
