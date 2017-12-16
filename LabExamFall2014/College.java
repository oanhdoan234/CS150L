import java.util.*;
import java.util.Scanner;
import java.io.FileReader;

public class College
{
    private TreeSet<Athlete> tree;
    
    public College(){
        this.tree = new TreeSet<Athlete>(new AthleteComparator());
    }
    
    public static void main(String args[]){
        College c = new College();
        c.createDB2(args[0]);
        ArrayList<Athlete> list = c.studentList();
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getFirstName());
        }
        ArrayList<Athlete> listOfSameName = c.search(args[1]);
    }
    
    // public void createDB(String filename){
        // try{
            // Scanner r = new Scanner(new FileReader(filename));
            // while (r.hasNextLine()){                                                    //have a line
                // Scanner aLine =  new Scanner(r.nextLine());                             //read a line  
                // String name = "";
                // String firstName = "";
                // String lastName = "";
                // int heightFoot =0;
                // int heightInch =0;
                // int month = 0;
                // int year = 0;
                // String sport = "";
                // if (aLine.hasNext()){
                    // while(aLine.hasNext()){                                                 //read words by words in a line
                        // String s = aLine.next();
                        // if (s.compareTo("Name:") == 0){
                            // firstName = aLine.next();
                            // lastName = aLine.next();
                            // System.out.println(lastName);
                        // } else if (s.compareTo("Sport:") == 0){
                            // sport = aLine.next();
                            
                        // } else if (s.compareTo("Birth:") == 0){
                            // month = convertMonth(aLine.next());
                            // year = aLine.nextInt();
                            
                        // } else if (s.compareTo("Height:") == 0){
                            // heightFoot = aLine.nextInt();
                            // heightInch = aLine.nextInt();
                           
                        // }
                    // }
                // } 
                // Athlete a = new Athlete(heightFoot, heightInch, month, year, lastName, firstName, sport);
                // this.tree.add(a);
            // }
        // } catch(Exception e){
            // System.out.println(e);
        // }
    
    // }
    
    
    public void createDB2(String filename){
        try{
            Scanner r = new Scanner(new FileReader(filename));
            String name = "";
            String firstName = "";
            String lastName = "";
            int heightFoot =0;
            int heightInch =0;
            int month = 0;
            int year = 0;
            String sport = "";
                
            while (r.hasNextLine()){                                                    //have a line
                String aLine = r.nextLine();
                String[] words = aLine.split(" ");
                String keyword = words[0];
                if (words[0].compareTo("Name:") == 0){
                    firstName = words[1];
                    lastName = words[2];
                    System.out.println("Hello:");
                } else if (words[0].compareTo("Birth:") == 0){
                    month = convertMonth(words[1]);
                    year = Integer.parseInt(words[2]);
                } else if (words[0].compareTo("Height:") == 0){
                    heightFoot = Integer.parseInt(words[1]);
                    heightInch = Integer.parseInt(words[2]);
                } else if (words[0].compareTo("Sport:") == 0){
                    sport = words[1];
                } else {
                    System.out.println(heightFoot + " " + heightInch + " " + month + " " + year + " " + lastName + " " + firstName + " " + sport);
                    Athlete a = new Athlete(heightFoot, heightInch, month, year, lastName, firstName, sport);
                    tree.add(a);
                }
                
            }
        } catch(Exception e){
            System.out.println(e);
        }
    
    }
    
    public int convertMonth(String m){
        String[] months = {"january", "february", "march", "april", "may", "june", "july","august","september", "october","november","december"};
        int[] monthInt = {1,2,3,4,5,6,7,8,9,10,11,12};
        for (int i = 0; i < months.length; i++){
            if (m.equalsIgnoreCase(months[i])){ return monthInt[i];}
        }
        return -1;
    }
    
    public ArrayList<Athlete> studentList(){
        Iterator<Athlete> i = tree.iterator();
        ArrayList<Athlete> list = new ArrayList<Athlete>();
        while (i.hasNext()){
            list.add(i.next());
        }
        return list;
    }
    
    public ArrayList<Athlete> search(String name){
        Iterator<Athlete> i = tree.iterator();
        ArrayList<Athlete> list = new ArrayList<Athlete>();
        while (i.hasNext()){
            Athlete a = i.next();
            if(a.getLastName().compareTo(name) == 0){
                list.add(a);
            }
        }
        return list;
    }
}
    
    
    
