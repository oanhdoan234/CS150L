import java.lang.*;
import java.util.*;

public class Event implements Comparable<Event>
{
    private String name;
    private Date startDate; 
    private Date endDate;
    private ArrayList<String> org;
    private String location;
    private String type; 
    
    public Event(String name, Date startDate, Date endDate, ArrayList<String> org, String location, String type){
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.org = org;
        this.location = location;
        this.type = type; 
    }
    
    public Event(){}
    
    /** get methods */
    public String getName(){return this.name; }
    public Date getStartDate(){return this.startDate; }
    public Date getEndDate(){return this.endDate; }
    public ArrayList<String> getOrg(){return this.org; }
    public String getLocation(){return this.location; }
    public String getType(){return this.type; }
    
    /** compare 2 organization lists, return 0 if 2 organization lists are the same, return -1 otherwise*/
    public int compareOrganization(ArrayList<String> orgs1, ArrayList<String> orgs2){
        if (orgs1 == null && orgs2 == null) {                       //true if 2 organizations are null
            return 0;
        } else if (orgs1 == null && orgs2 != null){                 //false if only one obj is null
            return -1;
        } else if (orgs2 != null && orgs1 == null){
            return -1;
        } 
        if (orgs1.size() != orgs2.size()) return -1;                //false if 2 organization lists are of different sizes
        for (int i = 0; i < orgs1.size(); i++){
                if(!orgs2.contains(orgs1.get(i))) return -1;
        }
        return 0; 
    }
    
    /** compare 2 strings, control for the case when one string is null*/
    public int compareString(String s1, String s2){
        if (s1 == null && s2 == null){                               
            return 0;
        } else if (s1 == null && s2 != null){
            return -1; 
        } else if (s1 != null && s2 == null){
            return -1;
        }
        return s1.compareToIgnoreCase(s2);
    }
    
    /** compare 2 dates, control for the case when one date is null */
    public int compareDate(Date d1, Date d2){
        if (d1 == null && d2 == null){
            return 0;
        } else if (d1 == null && d2 != null){
            return -1; 
        } else if (d1 != null && d2 == null){
            return -1;
        }
        return d1.compareTo(d2);
    }
    
    
    /** compare 2 events, return 0 if all data of 2 objects are equal, return -1 otherwise */
    public int compareTo(Event obj){
        if (this.compareString(this.name, obj.name) == 0 &&
            this.compareString(this.type, obj.type) == 0 && 
            this.compareDate(this.startDate, obj.startDate) == 0 && 
            this.compareDate(this.endDate, obj.endDate) == 0 && 
            this.compareOrganization(this.org, obj.org) == 0 && 
            this.compareString(this.location, obj.location) == 0 && 
            this.compareString(this.type, obj.type) == 0){
                 return 0;
        }
        return -1;
    }
    
    /** check if 2 objects are equals. This method will be used implicitly by the data structures in contains() method to check if one object is 
     * in the list or the tree
     */
    @Override
    public boolean equals(Object o) {       
        if (o == this) {                    // If the object is compared with itself then return true  
            return true;
        }
        /* Check if o is an instance of Event or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Event)) {
            return false;
        }
        // typecast o to Complex so that we can compare data members 
        Event c = (Event) o;       
        // Compare the data members and return accordingly 
        return this.compareTo(c) == 0;
    }
    
    /** print list of organizers of an event */
    public String organizationToString(){
        String organizationString = "";
        for (int i = 0; i < this.org.size(); i++){
            organizationString = organizationString + this.org.get(i) + " ";
        }
        return organizationString;
    }
    
    /** print an event */
    public String toString(){
        return "name: " + this.name + "\ndate: " + this.startDate + " " + this.endDate + 
        "\norganizations: " +  this.organizationToString() + 
        "\ntype: " + this.type + "\nlocation: " + this.location + "\n";
    }
}
