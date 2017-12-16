import java.util.*;

public class EventByOrganization implements EventByProperty<String>
{
   private TreeMap<String,ArrayList<Event>> tree; 
   public EventByOrganization(){
       this.tree = new TreeMap<String, ArrayList<Event>>();
   }
   
   /** Add an event */
   public void add(Event e){
       ArrayList<String> orgs = e.getOrg();                                 //get organizations
       
       if (orgs.size() == 0) {
           ArrayList<Event> events = new ArrayList<Event>();
           events.add(e);
           tree.put(" ",events);
       }
       
       for (int i = 0; i< orgs.size(); i++){
           String lowerCaseOrg =orgs.get(i).toLowerCase();
           orgs.set(i, lowerCaseOrg);
       }
       
       for (int i =0; i < orgs.size(); i++){
           String organization = orgs.get(i);
           if(tree.containsKey(organization)) {                            //add events to an existing list of events with same name
               ArrayList<Event> value = tree.get(organization);
               if (!value.contains(e))value.add(e);
           } else {                                                                   //create a new key-value pair
               ArrayList<Event> events = new ArrayList<Event>();
               events.add(e);
               tree.put(organization, events);
           }
       }
   }
   
   /** Remove an event */
   public void remove(String name){
       ArrayList<String> orgs = new ArrayList<String>();
       
       for (Map.Entry<String,ArrayList<Event>> entry : tree.entrySet()){
           ArrayList<Event> events = entry.getValue(); 
           ArrayList<Event> toremove = new ArrayList<Event>(); 
           
           for (int i = 0; i < events.size(); i++){
               if (events.get(i).getName().compareToIgnoreCase(name) == 0){
                   toremove.add(events.get(i));
               }
           }
           
           for(int i =0; i < toremove.size();i++) events.remove(toremove.get(i));
           if (events.size() == 0) orgs.add(entry.getKey());
       }
       
       for (int i = 0; i < orgs.size(); i++){
           tree.remove(orgs.get(i));
       }
   }
   
   /** Find an event by its organizer */
   public ArrayList<Event> find(String organization){
       if (tree.containsKey(organization)) return tree.get(organization);
       return new ArrayList<Event>();
   }
   
   public int size(){ return tree.size();}
}
