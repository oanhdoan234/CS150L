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
    
    public void add(Car c){list.add(c);}
    
    public void removeFrontCar(){
        if (list.size() > 0) list.remove(0);
    }

    public ArrayList<Integer> simulateOneStep(RandomGaussian tripInterval, RandomGaussian tripDistance){
        int totalCars = 0;
        int waitingCars = 0;
        ArrayList<Integer> numCars = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getStatus() != -1){
                list.get(i).simulateOneStep(tripInterval, tripDistance);
                if (list.get(i).getStatus() != 0 ) totalCars++;
            }
            if (list.get(i).getStatus() == 2) waitingCars++;
        }
        numCars.add(totalCars);
        numCars.add(waitingCars);
        return numCars;
    }
    
    public String commandP(){
        String batteryLevel = "";
        String chargingCars = "";
        for (int i = 0; i <list.size(); i++){
            Car c = list.get(i);
            if (c.getStatus() != -1){
                batteryLevel = batteryLevel + "Battery of car " + c.getId() + " is " + c.batteryLevel() + "\n";
            }
            if (c.getStatus() == 2){
                chargingCars = chargingCars + c.getId() + " "; 
            }
        }
        return batteryLevel + "Cars that are charging :" + chargingCars;
    }
    
    public String commandT(){
        String status = "" ;
        for (int i = 0; i < list.size(); i++){
            Car c = list.get(i); 
            if (c.getStatus() != -1){
                status = status + "Car " + i + " is " + c.convertStatus(c.getStatus()) + "\n";
            }
        }
        return status;
    }
    
    public Car get(int idx){ return list.get(idx);}
    public int size(){return list.size();}
}
