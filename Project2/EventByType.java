import java.util.*;

public class EventByType implements EventByProperty<String>
{
   private LinkedList<Node<String>> list; 
   
   public EventByType(){
       this.list = new LinkedList<Node<String>>();
   }
   
   /** Add an event to the right node by comparing event's type with key word of node. If list does not have that type, create a new node*/
   public void add(Event e){
       String type = e.getType().toLowerCase();                                     //get type of event
       for (int i = 0; i < list.size(); i++){                                       //add the event to right node in list if found
           if (list.get(i).getKey().compareToIgnoreCase(type) == 0){
               list.get(i).add(e);
               return;
           }
       }
       Node<String> newType = new Node<String>(type);                               //if this type does not exist, add a new node of that type
       newType.add(e);
       list.add(newType);                                                           //then add event to node
   }
   
   /** Remove an event given its name: go through each node to search for events of given name, remove the events before moving to the next node.
    * At last, check if there are any empty nodes, remove those empty nodes
   */
   public void remove(String name){
       for (int i = 0; i < list.size(); i++){                                             //iterate through nodes            
  
           ArrayList<Event> eventsByType = list.get(i).getValue();                         //events in each node
           ArrayList<Event> toremove = new ArrayList<Event>();
           
           for (int j = 0; j < eventsByType.size(); j++){                                  //find events that need to remove
               if (eventsByType.get(j).getName().compareToIgnoreCase(name) == 0) toremove.add(eventsByType.get(j));
           }
           
           for (int k = 0; k < toremove.size(); k++){                                       //remove these events 
               eventsByType.remove(toremove.get(k));
           }
       }
       
       ArrayList<Node<String>> deleteNode = new ArrayList<Node<String>>();
       for (int i = 0; i< list.size(); i++){                                                //find empty nodes
           if (list.get(i).getValue().size() == 0) {    
               deleteNode.add(list.get(i));
            }
       }
      
       for (int i = 0; i<deleteNode.size(); i++){                                           //delete empty nodes
           list.remove(deleteNode.get(i));
       }
   }
   
   /** Find an event by its type */
   public ArrayList<Event> find(String type){
       String lowerCaseType = type.toLowerCase();                                           //turn type to lower case
       for (int i = 0; i < list.size(); i++){                                               //iterate through list and return if found a
           if (list.get(i).getKey().compareToIgnoreCase(type) == 0) {
               return list.get(i).getValue();
           }
       }
       return new ArrayList<Event>();
   }
   
   public int size(){ return list.size();}
   
}
