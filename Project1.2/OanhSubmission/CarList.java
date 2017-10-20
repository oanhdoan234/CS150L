import java.util.*;
import java.lang.*;

public class CarList
{
    private ArrayList<Car> list;
    private StationList stationList; 
    
    public CarList(){
        this.list = new ArrayList<Car>();
    }
    
    public CarList(StationList stationList){
        this.list = new ArrayList<Car>();
        this.stationList = stationList;
    }
    
    public void add(Car c){list.add(c);}                                        //add a car to list end
    
    public void removeFrontCar(){                                               //remove a car from the front of a list
        if (list.size() > 0) list.remove(0);
    }

    public ArrayList<Integer> simulateOneStep(RandomGaussian tripInterval, RandomGaussian tripDistance){
        int totalCars = 0;                                              //total of cars on road and at stations in the simulation
        int waitingCars = 0;                                            //total of cars waiting across all stations
        ArrayList<Integer> numCars = new ArrayList<Integer>();          //container for the two totals above
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getStatus() != -1){                                 //check if a car is not inactivated
                list.get(i).simulateOneStep(tripInterval, tripDistance);        //simulate a time step for that car
                if (list.get(i).getStatus() != 0 ) totalCars++;                 
            }
            if (list.get(i).getStatus() == 2) waitingCars++;
        }
        numCars.add(totalCars);
        numCars.add(waitingCars);
        return numCars;
    }
    
    public String commandP(){                                                   //Perform request when user presses "p" in console
        String batteryLevel = "";
        String chargingCars = "";
        for (int i = 0; i <list.size(); i++){
            Car c = list.get(i);
            if (c.getStatus() != -1){                                           //Print battery level of non-eliminated cars
                batteryLevel = batteryLevel + "Battery of car " + c.getId() + " is " + c.batteryLevel() + "\n";
            }
            if (c.getStatus() == 2){                                            //Print ids of cars that are at charging stations
                chargingCars = chargingCars + c.getId() + " "; 
            }
        }
        return batteryLevel + "Cars that are charging :" + chargingCars;
    }
    
    public String commandT(){                                                   //Perform request when user presses "t" in console
        String status = "" ;
        for (int i = 0; i < list.size(); i++){
            Car c = list.get(i); 
            if (c.getStatus() != -1){                                               
                status = status + "Car " + i + " is " + c.convertStatus(c.getStatus()) + "\n";              //Print status
            }
        }
        return status;
    }
    
    public Car get(int idx){ return list.get(idx);}
    public int size(){return list.size();}
}
