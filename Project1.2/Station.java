import java.util.*;
import java.lang.*;

public class Station
{
    private CarList cars;
    private double distance; 
    private long id; 
    
    public Station(long id){
        this.id = id;
        this.cars = new CarList();
    }
    
    public double generateDistance(RandomGaussian distanceToStation){                  //generate a distance to the station
        this.distance = distanceToStation.getGaussian();
        while (this.distance<0){
            this.distance = distanceToStation.getGaussian();
        }
        return this.distance;
    }
    
    public void addRequest(Car c){                                                      //add a car in line
        cars.add(c);
    }
    
    public void chargeAndWait(){
        if (cars.size() == 1){                                                           //if there is 1 more car in line, charge it
            cars.get(0).charge();
        } else if (cars.size() > 1){                                                    //if there are more than one cars in line   
            cars.get(0).charge();                                                       //charge 1st car
            for (int i = 1; i < cars.size(); i++) cars.get(i).waiting();                //increase waiting time of other cars
        }
    }
    
    public double simulateOneStep(){
        chargeAndWait();                                    //otherwise, charge 1st car and increase waiting time for others (if any)
        if (cars.size() >0){
                if (cars.get(0).fullBattery()){                          //if the 1st car in line is full
                    Car toremove = cars.get(0);
                    toremove.setFindStation(false);                                    //set findStation to false so it can find a new station next time
                    double waitTime = toremove.getWaitTime();                          
                    toremove.resetWaitTime();                                          //reset total wait time to 0 for next time at a station
                    toremove.setStatus(1);
                    cars.removeFrontCar();                                             //remove the car
                    return waitTime;                                                   //return total waiting time of the car to be removed
            } 
        }
        return -1;
    }
    
    public String commandE(){
        String ids = "";
        for(int i = 0; i<cars.size(); i++){
            ids = ids + cars.get(i).getId() + " ";
        }
        return ids;
    }
    
    public double getDistance(){return distance;}
    public void setDistance(double d){distance = d;}
    public int size(){return cars.size();}
    public long getId(){return id;}
    public Car get(int index){return cars.get(index);}
}
