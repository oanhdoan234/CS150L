import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Experiment
{
    public static void main(String[] args){
        Experiment e = new Experiment();
        FileScanner scanner = new FileScanner();
        int[] sizes = {500,700,800,1000,1500,2000,2500};
        //,3000,3500,4000,4500,5000
        for (int i = 0; i < sizes.length; i++){
            String filename = "data_" + sizes[i] + "_"+args[0] + ".txt";
            SearchEngine engine = scanner.createDB(filename);
            try{
                String outf = "finalresult_" + args[0] + ".txt";
                System.out.println(filename);
                
                //System.out.println(e.searchTypeName(engine, args[1], args[2])); 
                // System.out.println(e.findByName(engine, args[1]));
                // System.out.println(e.findByType(engine, args[2]));
                // System.out.println(e.findByOrg(engine, args[3]));
                ArrayList<Date> dates = new ArrayList<Date>();
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                
                    Date start = df.parse(args[1]);
                    Date end = df.parse(args[2]);
                    dates.add(start);
                    dates.add(end);
                
                System.out.println(e.searchDateOrg(engine, dates, args[3]));
                
                // System.out.println(e.findByDate(engine,dates));
                // System.out.println(e.findByLocation(engine, args[6]) );
                // System.out.println("Write time " + e.write(engine, "outf.txt") + "\n");
            } catch (Exception error){
                System.out.println(error);            
            }  
        }
    }

    public long findByName(SearchEngine engine, String name){
        EventByName eventByName = engine.getEventByName();
        long start = System.nanoTime();
        eventByName.find(name);
        long stop  = System.nanoTime();
        long total = stop - start; 
        return total;
    }
    
    public long findByType(SearchEngine engine, String type){
        EventByType eventByType = engine.getEventByType();
        long start = System.nanoTime();
        eventByType.find(type);
        long stop  = System.nanoTime();
        long total = stop - start; 
        return total;
    }
    
    public long findByOrg(SearchEngine engine, String org){
        EventByOrganization eventByOrg = engine.getEventByOrg();
        long start = System.nanoTime();
        eventByOrg.find(org);
        long stop  = System.nanoTime();
        long total = stop - start; 
        return total;
    }
    
    public long findByDate(SearchEngine engine, ArrayList<Date> d){
        EventByDate eventByDate = engine.getEventByDate();
        long start = System.nanoTime();
        eventByDate.find(d);
        long stop  = System.nanoTime();
        long total = stop - start; 
        return total;
    }
    
    public long findByLocation(SearchEngine engine, String location){
        EventByLocation eventByLoc = engine.getEventByLoc();
        long start = System.nanoTime();
        eventByLoc.find(location);
        long stop  = System.nanoTime();
        long total = stop - start; 
        return total;
    }
    
    public long write(SearchEngine engine, String outf){
        EventByName eventByName = engine.getEventByName();
        long start = System.nanoTime(); 
        eventByName.write(outf);
        long end = System.nanoTime();
        return end-start;
    }
    
    public long searchNameType(SearchEngine engine, String name, String type){
        EventByName eventByName = engine.getEventByName();
        EventByType eventByType = new EventByType();  
        long start = System.nanoTime(); 
        ArrayList<Event> events = eventByName.find(name);
        for (int i = 0; i < events.size(); i++) eventByType.add(events.get(i)); 
        eventByType.find(type); 
        long end = System.nanoTime(); 
        return end-start;
    }

    public long searchTypeName(SearchEngine engine, String type, String name){
        EventByType eventByType = engine.getEventByType();
        EventByName eventByName = new EventByName();  
        long start = System.nanoTime(); 
        ArrayList<Event> events = eventByType.find(type);
        for (int i = 0; i < events.size(); i++) eventByName.add(events.get(i)); 
        eventByName.find(name); 
        long end = System.nanoTime(); 
        return end-start;
    }
    
    public long searchDateOrg(SearchEngine engine, ArrayList<Date> d, String org){
        EventByDate eventByDate = engine.getEventByDate(); 
        EventByOrganization eventByOrg = new EventByOrganization(); 
        long start= System.nanoTime(); 
        ArrayList<Event> events = eventByDate.find(d); 
        for (int i = 0; i < events.size(); i++) eventByOrg.add(events.get(i)); 
        eventByOrg.find(org);
        long end = System.nanoTime();
        return end - start; 
    }
}
