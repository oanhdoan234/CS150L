import java.util.*;

public class Node<E>
{
    protected E e; 
    protected ArrayList<Event> events;
    
    public Node(E e){
        this.e = e;
        this.events = new ArrayList<Event>();
    }
    
    public void add(Event e){
        if (!events.contains(e)) events.add(e);
    }
    
    public void remove(String name){
        ArrayList<Event> toremove = new ArrayList<Event>();
        for (int i = 0; i < events.size(); i++){
            if (events.get(i).getName().compareToIgnoreCase(name) == 0){
                toremove.add(events.get(i));
            }
        }
        
        for (int i =0; i < toremove.size(); i++){
            events.remove(toremove.get(i));
        }
    }
    
    
    public E getKey(){return e;}
    public ArrayList<Event> getValue(){return events;}
    public int size(){return events.size();}
}
