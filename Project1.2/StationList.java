import java.util.*;
import java.lang.*; 

public class StationList
{
    private ArrayList<Station> stationList; 
    private RandomGaussian distanceToStation;
    
    public StationList(RandomGaussian distanceToStation){
        this.stationList = new ArrayList<Station>();
        this.distanceToStation = distanceToStation;
    }
    
    public void add(Station s){
        stationList.add(s);
    }
    
    public Station findNearestStation(){
        ArrayList<Double> distance = new ArrayList<Double>();                       //randomly generate distances of stations
        for (int i = 0; i < stationList.size(); i++){
            double d = stationList.get(i).generateDistance(distanceToStation);
            System.out.println("Distance of station " + i + " is " +d);
            distance.add(d);
        }
        
        int smallIndex = findMin(distance);                                         //find smallest distance 
        System.out.println("Selected station is " + smallIndex);
        if (smallIndex == -1){
            return null;                                                            //return null if list does not contain any station
        } else { 
            return stationList.get(smallIndex);                                     //otherwise, return nearest station
        }
    }
    
    public double simulateOneStep(){                      //simulate one step for all stations
        double sum = 0; 
        int ct = 0;
        for (int i = 0; i < stationList.size(); i++){
            double waitTime = stationList.get(i).simulateOneStep();
            if (waitTime > 0){
                sum =sum + waitTime; 
                ct  =ct+1; 
            }
        } 
        if (ct >0) return sum/ct;
        return 0;
    }
    
    public String commandE(){
        String message = "";
        for (int i = 0; i < stationList.size(); i++){
            Station s = stationList.get(i);
            message = message + "Station " + s.getId() + " has " + s.size() + " cars, whose IDs are " + s.commandE() + "\n";
        }
        return message;
    }
    
    public int findMin(ArrayList<Double> numbers){
        if (numbers.size() == 0){                                                   //list is empty, return
            return -1;
        } else {
            int smallIndex = 0;                                                     //list is nonempty, find smallest number
            double min = numbers.get(0);
            for (int i = 0; i < numbers.size(); i++){
                if(numbers.get(i) < min) {
                    min = numbers.get(i);
                    smallIndex = i;
                }
            }
            return smallIndex;
        }
    }
    
    public int numStations(){return stationList.size();}
}
