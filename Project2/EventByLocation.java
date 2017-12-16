import java.util.*;

public class EventByLocation implements EventByProperty<String>
{
   private TreeMap<String,ArrayList<Event>> tree; 
   public EventByLocation(){
       this.tree = new TreeMap<String, ArrayList<Event>>();
   }
   
   /** Add an event: Find the node whose key word (location) is the same as the location of the event. Check if this event is in the node. 
    * If not, add the event. If no matching location is found, add a new node. 
      */
   public void add(Event e){
       String eventLoc = e.getLocation().toLowerCase();            //get name 
       if(tree.containsKey(eventLoc)) {                            //add events to an existing list of events with same name
           ArrayList<Event> value = tree.get(eventLoc);
           if (!value.contains(e)){value.add(e);}
       } else {                                                                   //create a new key-value pair
           ArrayList<Event> events = new ArrayList<Event>();
           events.add(e);
           tree.put(eventLoc, events);
       }
   }
   
   /** Remove an event: Go to each node, find and remove events of same name. At last, remove all empty nodes */
   public void remove(String name){
       ArrayList<String> locations = new ArrayList<String>();
       for (Map.Entry<String,ArrayList<Event>> entry : tree.entrySet()){                    //iterate 
           ArrayList<Event> events = entry.getValue();                                      //find events of given name in each node
           ArrayList<Event> toremove = new ArrayList<Event>();
           for (int i = 0; i < events.size(); i++){
               if (events.get(i).getName().compareToIgnoreCase(name) == 0){
                   toremove.add(events.get(i));
               }
           }
           for (int i = 0; i < toremove.size(); i++){                                       //remove found events
               events.remove(toremove.get(i));
           }
           if (events.size() == 0) locations.add(entry.getKey());                           //record empty nodes
       }
       
       for (int i = 0; i < locations.size(); i++){
           tree.remove(locations.get(i));                                                   //remove empty nodes
        }
   }
   
   /** Find an event by its name */
   public ArrayList<Event> find(String location){
       String lowerCaseLocation = location.toLowerCase();
       if (tree.containsKey(lowerCaseLocation)) {
           return tree.get(lowerCaseLocation);
        }
       return new ArrayList<Event>();
   }
   
   public int size(){return tree.size();}
   
}
