import java.util.*;

/**
 * Write a description of class DateNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class DateNode extends Node<Date> 
{
    public DateNode(Date d){
        super(d);
    }
    
    /** add an event to the node if date of event is equal to date of node. Add if the event is not yet in the node */
    public void add(Event e){
        Date start = e.getStartDate();                                  
        Date end = e.getEndDate(); 
        Date key = this.getKey();
        
        if (key.compareTo(start) >=0 && key.compareTo(end) <= 0){                   //compare key and event dates   
            if (!events.contains(e)) this.events.add(e);                            //add if not found
        }
    }
    
    /** find event on a particular date */
    public ArrayList<Event> findEventByADate(Date date){
        ArrayList<Event> eventsByADate = new ArrayList<Event>();
        for (int i =0; i< this.events.size(); i++){
            Date start = this.events.get(i).getStartDate();                         //compare start date and end date of each event in node
            Date end = this.events.get(i).getEndDate();                             //with given info
            if (start.compareTo(end) == 0 && start.compareTo(date)==0){
                eventsByADate.add(this.events.get(i));
            }
        }
        return eventsByADate;
    }
    
    /** find events given 2 dates. Events to be found must lie within this given range of dates or have start date before given start date and 
     * end date before given end date.
       */
    public ArrayList<Event> findEventsInRange(Date start, Date end){
        ArrayList<Event> eventsInRange = new ArrayList<Event>();
        for (int i = 0; i <this.events.size(); i++){
            Event e = this.events.get(i);
            Date eStart = e.getStartDate();
            Date eEnd = e.getEndDate(); 
            boolean condition1 = (eStart.compareTo(start)<= 0) && (eEnd.compareTo(end) <=0) && (eEnd.compareTo(start) >= 0);  //compare the conditions above
            boolean condition2 = (eStart.compareTo(start)>=0) && (eEnd.compareTo(end) <=0);
            if (condition1 || condition2) eventsInRange.add(e);
        }
        
        return eventsInRange; 
    }
}
