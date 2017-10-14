import java.util.*;
import java.lang.*;

public class ChargingPoint
{
    private long id; 
    private boolean empty;
    private CarList line;
    
    public ChargingPoint(){
        this.empty = true;
        this.line = new CarList();
    }
    
    public void enqueue(Car c){
        if(empty){empty = false;}
        line.add(c);
    }
    
    public void dequeue(){line.dequeue();}
    public int getSize(){return line.getSize();}
    public Car getCar(int idx){return line.getCar(idx);}
}
