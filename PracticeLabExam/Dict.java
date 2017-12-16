import java.util.*;

public class Dict
{
    private LinkedList<DictObj> list; 
    
    public Dict(){
        this.list = new LinkedList<DictObj>(); 
    }
    
    public void add(String key, String value){
        for (int i = 0; i <list.size(); i++){
            if (list.get(i).getKey().compareTo(key) == 0){
                list.get(i).add(value);
                return;
            }
        }
        DictObj newObj = new DictObj(key, value); 
        list.add(newObj);
    }
    
    /**a method find(String key) that searches through the Dict. If the key is found, it will return an ArrayList of the String values. 
     * The values are obtained by using an Iterator to traverse the TreeSet. Returns an empty ArrayList if there are no matches for the key.
     */ 
    
    public ArrayList<String> find(String key){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getKey().compareTo(key) == 0){
                return list.get(i).toArrayList();
            }
        }
        return new ArrayList<String>();
    }
}
