import java.util.*;
import java.lang.*;

public class StationList
{
   private ArrayList<Station> list; 
   
   public StationList(){
       this.list = new ArrayList<Station>();
   }
   
   public void randomDistance(){
       RandomGaussian r = new RandomGaussian(4.0,2.0);
       for (int i = 0; i < list.size(); i++){
           list.get(i).setDistanceToCar(r.getGaussian());
       }
   }
   
   public Station findNearestStation(){
       Station s = list.get(0);
       for (int i = 0; i < list.size(); i++){
           if (list.get(i).getDistanceToCar()< s.getDistanceToCar()) s =list.get(i); 
       }
       return s;
   }
}
