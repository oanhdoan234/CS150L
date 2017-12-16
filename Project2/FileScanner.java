import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class FileScanner
{
    /** Read a text file to create a database of events and add them to a search engine for further actions */
    public SearchEngine createDB(String filename){
        try{
            SearchEngine engine = new SearchEngine(new EventByType(),new EventByDate(), new EventByOrganization(), new EventByLocation(), new EventByName());
            Scanner r = new Scanner(new FileReader(filename));
            
            //properties of an event
            String name = "";
            String type = "";
            String location = "";
            ArrayList<String> orgs = new ArrayList<String>();
            Date start = null;
            Date end = null;
                
            while (r.hasNextLine()){                                                    //have a line
                String aLine = r.nextLine();
                String[] words = aLine.split(": ");
                String keyword = words[0];
                if (keyword.compareToIgnoreCase("name") == 0){                          //read name
                    name = words[1];
                } else if (keyword.compareToIgnoreCase("type") == 0){                   //read type
                    type = words[1];
                } else if (keyword.compareToIgnoreCase("location") == 0){               //read location
                    location = words[1];
                } else if (keyword.compareToIgnoreCase("organization") == 0){           //read orgs
                    String[] organizations = words[1].split(" ");
                    for (int i = 0; i < organizations.length; i++) orgs.add(organizations[i]);
                } else if (keyword.compareToIgnoreCase("date") ==0){                    //read dates
                    String[] dates = words[1].split(" ");
                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                    if (dates.length == 1){                                             //only 1 date is specified
                        start = df.parse(dates[0]);
                        end = df.parse(dates[0]);
                    } else {                                                            //2 dates are specified
                        start = df.parse(dates[0]);
                        end = df.parse(dates[1]);
                    }
                } else {
                    Event e = new Event(name, start, end, orgs, location, type);    //create event
                    engine.add(e);                                                  //add event to engine
                }
            }
            return engine;
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }
    
    
}
