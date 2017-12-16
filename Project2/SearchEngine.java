import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class SearchEngine
{
    private EventByType eventByType; 
    private EventByDate eventByDate;
    private EventByOrganization eventByOrg;
    private EventByLocation eventByLoc;
    private EventByName eventByName;
    Scanner reader = new Scanner(System.in);
    private DateFormat df;
    private boolean exit;
    
    public SearchEngine(EventByType eventByType,EventByDate eventByDate, EventByOrganization eventByOrg, EventByLocation eventByLoc,EventByName eventByName){
        this.eventByType = eventByType; 
        this.eventByDate = eventByDate; 
        this.eventByOrg = eventByOrg; 
        this.eventByLoc = eventByLoc;
        this.eventByName = eventByName;
        this.df = new SimpleDateFormat("MM/dd/yyyy");
        this.exit = false;
    }
    
    public static void main(String[] args){
        FileScanner scanner = new FileScanner();
        SearchEngine engine = scanner.createDB(args[0]);
        engine.run();
    }
    
    /** add an event to all containers */
    public void add(Event e){
        eventByType.add(e);
        eventByDate.add(e);
        eventByOrg.add(e); 
        eventByLoc.add(e);
        eventByName.add(e);
    }
    
    
    /** remove an event from all containers */
    public void remove(String name){
        eventByType.remove(name);
        eventByDate.remove(name);
        eventByOrg.remove(name); 
        eventByLoc.remove(name);
        eventByName.remove(name);
    }
   
    /** display instruction to users*/
    public void display(){
        String message = "\n========================================= \na - add an event\n" + 
                         "f - find\n" + 
                         "      + n - name of event\n" + 
                         "      + d - date of the event\n" + 
                         "      + r - range of dates for the event\n" + 
                         "      + l - location of the event\n" + 
                         "      + t - type of the event\n" + 
                         "      + o - organizer of the event\n" + 
                         "d - delete\n" + 
                         "w - write\n" + 
                         "x - exit\n" +
                         "Specify your command here: ";
        System.out.print(message);
    }
    
    
    /** simulate program behavior */
    public void run(){
        while (!exit){
            display(); 
            Scanner commandReader = new Scanner(System.in);                     //take user's command and perform the action
            String cmd = commandReader.nextLine();
            if (cmd.compareTo("a") == 0){                                       //add an event specified by user
                this.addEventByUser(commandReader);
            } else if (cmd.split(" ")[0].compareTo("f")==0){                    //find 
                this.search(cmd, commandReader);
            } else if (cmd.compareTo("d")==0){                                  //delete
                String name = commandReader.nextLine(); 
                this.remove(name);
            } else if (cmd.compareTo("w")==0){                                  //write
                this.eventByName.write("output.txt");
            } else if (cmd.compareTo("x")==0){                                  //write and exit
                this.eventByName.write("output.txt.saved");
                this.exit =true;
            } else {                                                            //display error message if an invalid cmd is entered
                System.out.println(cmd + " is not a valid query\n");
            }
        } 
    }
    
    
    /** Search by one categories: From an array list of events, search for events that match with one quality specified by user */
    public ArrayList<Event> oneStepSearch(ArrayList<Event> events, String cmd){
        if (cmd.compareToIgnoreCase("n") == 0){                                     //by name
            return findByName(events);
        } else if (cmd.compareToIgnoreCase("d") == 0){                              //on a date
            return findByADate(events);
        } else if (cmd.compareToIgnoreCase("r") == 0){                              //by range of dates
            return findByARange(events);
        } else if (cmd.compareToIgnoreCase("l") == 0){                              //by location
            return findByLocation(events);
        } else if (cmd.compareToIgnoreCase("t") == 0){                              //by type
            return findByType(events);
        } else if (cmd.compareToIgnoreCase("o") == 0){                              //by organization
            return findByOrganizer(events);
        }
        return new ArrayList<Event>();
    }
   
    
    /** search using multiple inputs */
    public void search(String cmds, Scanner reader){
        String[] queries = cmds.split(" ");                                     //read user commands (i.e what categories to search by)
        ArrayList<Event> result = new ArrayList<Event>();
        
        if (queries.length >1){
            String firstCmd = queries[1];                                       //conduct first search from the containers
            if (firstCmd.compareTo("n") == 0){                                  //by name
                String name = reader.nextLine();
                result = eventByName.find(name);
            } else if (firstCmd.compareTo("d") == 0){                           //by a date
                try{
                    String date = reader.nextLine();
                    ArrayList<Date> r = new ArrayList<Date>();
                    r.add(this.df.parse(date));
                    result = eventByDate.find(r);
                }catch (Exception e){
                    System.out.println(e);
                }
            } else if (firstCmd.compareTo("r") == 0){                           //by a range
                try{
                    String[] dates = reader.nextLine().split(" "); 
                    ArrayList<Date> r = new ArrayList<Date>(); 
                    r.add(this.df.parse(dates[0]));
                    r.add(this.df.parse(dates[1]));
                    result = eventByDate.find(r);
                } catch(Exception e) {
                    System.out.println(e);
                }
            } else if (firstCmd.compareTo("l") == 0){                           //by a location
                String location = reader.nextLine();
                result = eventByLoc.find(location); 
            } else if (firstCmd.compareTo("t") == 0){                           //by type
                String type = reader.nextLine(); 
                result = eventByType.find(type);
            } else if (firstCmd.compareTo("o") == 0){                           //by organizer
                String organization = reader.nextLine();
                result = eventByOrg.find(organization);
            }
        }
        
        for (int i = 2; i < queries.length; i++)result = oneStepSearch(result, queries[i]);        //continue more searches from results of prev step
        for (int i = 0; i < result.size(); i++) System.out.println(result.get(i));                 //display results
    }
    
    /** The following methods search for events that meet one quality specified by user from an array list. These methods will be used if user wants
     * search for events using more than 1 category
       */
    public ArrayList<Event> findByName(ArrayList<Event> events){
        String name = reader.nextLine();                                            //read specified name        
        EventByName smallContainerByName = new EventByName();                       //search from arrayList
        for (int i = 0; i < events.size(); i++){
            smallContainerByName.add(events.get(i));
        }
        return smallContainerByName.find(name);
    }
    
    public ArrayList<Event> findByType(ArrayList<Event> events){
        String type = reader.nextLine();                                            //read specified type
        EventByType smallContainerByType = new EventByType();
        for (int i = 0; i < events.size(); i++){
            smallContainerByType.add(events.get(i));
        }
        return smallContainerByType.find(type);
    }
    
    public ArrayList<Event> findByADate(ArrayList<Event> events){
        String date = reader.nextLine();                                        
        try{
            Date d = this.df.parse(date);                                           //read specified date
            EventByDate smallContainerByDate = new EventByDate();
            ArrayList<Date> dateRange = new ArrayList<Date>();
            dateRange.add(d);
            for (int i = 0; i < events.size(); i++){                                //search
                smallContainerByDate.add(events.get(i));
            }
            return smallContainerByDate.find(dateRange);
        } catch (Exception e){
            System.out.println(e);
        }
        return new ArrayList<Event>(); 
    }
    
    public ArrayList<Event> findByARange(ArrayList<Event> events){
        String dates = reader.nextLine();                                       //read specified range of dates
        try{
            Date start = this.df.parse(dates.split(" ")[0]);
            Date end = this.df.parse(dates.split(" ")[0]);
            EventByDate smallContainerByDate = new EventByDate();
            ArrayList<Date> dateRange = new ArrayList<Date>();
            dateRange.add(start);
            dateRange.add(end);
            for (int i = 0; i < events.size(); i++){                           //search
                smallContainerByDate.add(events.get(i));
            }
            return smallContainerByDate.find(dateRange);
        } catch (Exception e){
            System.out.println(e);
        }
        return new ArrayList<Event>(); 
    }
    
    
    public ArrayList<Event> findByLocation(ArrayList<Event> events){                
        String location = reader.nextLine();                                            //read specified location
        EventByLocation smallContainerByLoc = new EventByLocation();
        for (int i = 0; i < events.size(); i++){
            smallContainerByLoc.add(events.get(i));                                     //search
        }
        return smallContainerByLoc.find(location);
    }
    
    public ArrayList<Event> findByOrganizer(ArrayList<Event> events){   
        String org = reader.nextLine();                                                //read specified organizer
        EventByOrganization smallContainerByOrg = new EventByOrganization();
        for (int i = 0; i < events.size(); i++){
            smallContainerByOrg.add(events.get(i));                                    //search
        }
        return smallContainerByOrg.find(org);
    }
    
    
    
    /** add an event given by user */
    public void addEventByUser(Scanner commandReader){                             
        try{
            /** read inputs */
            //read name
            System.out.print("name: ");
            String name =  commandReader.nextLine();
            
            //read dates
            System.out.print("date: ");
            String dates = commandReader.nextLine();
            String[] datesList = dates.split(" ");
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date start = null;
            Date end = null;
            if (datesList.length == 1){
                start = df.parse(datesList[0]);
                end = df.parse(datesList[0]);
            } else {
                start = df.parse(datesList[0]);
                end = df.parse(datesList[1]);
            }
            
            //read location
            System.out.print("location: ");
            String location = commandReader.nextLine(); 
            
            //read type 
            System.out.print("type: ");
            String type = commandReader.nextLine(); 
            
            //read organizations
            System.out.print("organization: ");
            String orgs = commandReader.nextLine(); 
            String[] orgsArr = orgs.split(", ");
            ArrayList<String> orgArrList = new ArrayList<String>();
            for (int i =0; i < orgsArr.length; i++){
                orgArrList.add(orgsArr[i]);
            }
            
            //create a new event based on inputs
            Event e = new Event(name, start, end, orgArrList, location, type);
            this.add(e); 
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public EventByName getEventByName(){return eventByName;}
    public EventByType getEventByType(){return eventByType;}
    public EventByOrganization getEventByOrg(){return eventByOrg;}
    public EventByLocation getEventByLoc(){return eventByLoc;}
    public EventByDate getEventByDate(){return eventByDate;}
    
}
