import java.util.*;

public class EventByDate implements EventByProperty<ArrayList<Date>>
{
    private LinkedList<DateNode> dates;
    
    public EventByDate(){
        this.dates = new LinkedList<DateNode>(); 
    }
    
    /** add an event */
    public void add(Event e){
        Date startDate = e.getStartDate();                                  //add nodes representing end and start dates of events
        Date endDate =  e.getEndDate();
        DateNode startNode =  new DateNode(startDate);
        DateNode endNode =  new DateNode(endDate);
        this.addNode(startNode);
        this.addNode(endNode);
        for (int i = 0; i < dates.size(); i++)dates.get(i).add(e);         //add events to the nodes(dates) on which the event happens
        
    }
    
    /** add a node (representing a date) to list if the list does not have this date yet */
    public void addNode(DateNode n){
        if (this.contains(n.getKey()) == -1){                                       //add if this date exists in list
            int idx = this.findPlaceToInsert(n);
            dates.add(idx, n);
        }
    }
    
    /** remove an event given event name: Go through each node in list, find events of same name, remove these events before moving to the next 
     * node. At last, remove any empty nodes
       */
    public void remove(String name){
       ArrayList<DateNode> deleteNode = new ArrayList<DateNode>();
       for (int i = 0; i < dates.size(); i++){                                             //iterate through nodes            
           dates.get(i).remove(name);                                                      //remove event of given name in a name
           if (dates.get(i).getValue().size() == 0) {                                      
               deleteNode.add(dates.get(i));                                               //record empty nodes
           }
       }
      
       for (int i = 0; i<deleteNode.size(); i++){                                           //delete empty nodes
           dates.remove(deleteNode.get(i));
       }
    }
    
    /** find events within a range of dates */
    public ArrayList<Event> find(ArrayList<Date> dateRange){
        ArrayList<Event> events = new ArrayList<Event>(); 
        
        for (int i = 0; i < dates.size(); i++){                                                 //iterate through nodes to find events
            ArrayList<Event> eventsInRange = new ArrayList<Event>();
            if (dateRange.size() == 1){                                                         //find events happen on a specific day
                eventsInRange = dates.get(i).findEventByADate(dateRange.get(0)); 
            } else {
                eventsInRange = dates.get(i).findEventsInRange(dateRange.get(0), dateRange.get(1));     //find events within a range 
            }
            
            for (int j =0; j< eventsInRange.size(); j++){
                if (!events.contains(eventsInRange.get(j))) events.add(eventsInRange.get(j));           //do not find duplicates
            }
            
        }
        
        return events;
    }
    
    /** find index of a particular date in list */
    public int contains(Date date){
        for (int i = 0; i < dates.size(); i++){
            if(dates.get(i).getKey().compareTo(date) == 0){
                return i;
            }
        }
        return -1;
    }
    
    
    /** find the place to insert a new date to keep the list sorted */
    public int findPlaceToInsert(DateNode n){
        int idx =0;                                                                     //if list is empty, insert to list front
        if (dates.size() != 0){                                                         //list is not empty
            for (int i = 0; i<dates.size(); i++){                                       //find the place
                if(dates.get(i).getKey().compareTo(n.getKey()) < 0) idx++;
            }
        }
        return idx;
    }
    
    public int size(){return dates.size();}
    public DateNode get(int pos){return dates.get(pos);}
    
  
    
}
