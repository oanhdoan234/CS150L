import java.util.*;
import java.lang.*;

public class Station
{
    private long id; 
    private ArrayList<ChargingPoint> points; 
    private double distanceToCar;
    
    public Station(long id){
        this.id = id;
        this.points = new ArrayList<ChargingPoint>();
    }
    
    public ChargingPoint findShortestLine(){
        ChargingPoint shortestLine = points.get(0) ;
        for (int i = 0; i < points.size(); i++){
            if (points.get(i).getSize() < shortestLine.getSize()) shortestLine = points.get(i);
        }
        return shortestLine;
    }
    
    public void setDistanceToCar(double d){distanceToCar = d;}
    public double getDistanceToCar(){return distanceToCar;}
}
