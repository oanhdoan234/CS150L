import java.util.*;

public class DictObj
{
    private String key;
    private TreeSet<String> set;

    public DictObj(String key, String value){
        this.key = key;
        this.set = new TreeSet(new StringComparator());
        this.set.add(value);
    }
    
    public void add(String value){
        this.set.add(value);
    }
    
    public String getKey(){
        return key;
    }
    
    public ArrayList<String> toArrayList(){
        Iterator<String> i = this.set.iterator(); 
        ArrayList<String> list = new ArrayList<String>();
        while (i.hasNext()){
            list.add(i.next());
        }
        return list;
    }
    
    public TreeSet<String> getValue(){
        return set; 
    }
}
