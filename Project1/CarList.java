import java.util.*;
import java.lang.*;

public class CarList
{
    private ArrayList<Car> list;
    
    public CarList(){
        this.list = new ArrayList<Car>();
    }
    
    public void add(Car c){
        list.add(c);
    }
    
    public void remove(Car c){
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).compareTo(c)){list.remove(i);}
        }
    }
    
    public void dequeue(){
        if (list.size() > 0){
            list.remove(list.size()-1);
        }
    }
    
    public int getSize(){ return list.size();}
    public Car getCar(int idx){ return list.get(idx);}
}
