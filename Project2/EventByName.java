import java.util.*;
import java.io.PrintWriter;

public class EventByName implements EventByProperty<String>
{
   private TreeMap<String,ArrayList<Event>> tree; 
   public EventByName(){
       this.tree = new TreeMap<String, ArrayList<Event>>();
   }
    
   /** add an event - create a new mapping if the name of this event does not exist yet. Otherwise, add the event to the list of the same name */
   public void add(Event e){
       String eventName = e.getName().toLowerCase();                //get name 
       if(tree.containsKey(eventName)) {                            //add events to an existing list of events with same name
           ArrayList<Event> value = tree.get(eventName);
           //System.out.println(value.contains(e));
           if (!value.contains(e)){value.add(e);}
       } else {                                                                   //create a new key-value pair
           ArrayList<Event> events = new ArrayList<Event>();
           events.add(e);
           tree.put(eventName, events);
       }
   }
   
   /** Remove an event */
   public void remove(String name){
       if (tree.containsKey(name.toLowerCase())) {tree.remove(name.toLowerCase());}
   }
   
   /** Find an event by its name */
   public ArrayList<Event> find(String name){
       String lowerCaseName = name.toLowerCase();
       if (tree.containsKey(lowerCaseName)) return tree.get(lowerCaseName);
       return new ArrayList<Event>();
   }
   
   public ArrayList<Event> get(String name){return tree.get(name);}
   public int size(){return tree.size();}
   
   /** write data to a file */
   public void write(String outfile){
       try{
           PrintWriter p = new PrintWriter(outfile);
           for (Map.Entry<String,ArrayList<Event>> entry : tree.entrySet()){
               ArrayList<Event> eventList = entry.getValue();
               for (int i =0; i < eventList.size(); i++) p.write(eventList.get(i).toString());
           }
           p.close();
       } catch (Exception e){
           System.out.println(e);
       }
   }
}
