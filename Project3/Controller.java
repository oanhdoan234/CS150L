import java.io.FileReader;
import java.util.Scanner;
import java.util.*;

/**
 * Write a description of class Controller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Controller
{
    public static void main(String[] args){
        Controller c = new Controller();
        c.run(args[0], args[1]);  
    }
    
    public void run(String cityFile, String siteFile){
        DirectedGraph<Integer> g = this.createMap(cityFile, siteFile);          //create map
        this.display(g);                                                        //display map's information to users
        this.createTour(g);                                                     //generate tours based on users' inputs
    }
    
    /** display sites and hotels in the graph so that users can choose their favorite starting point and desired places */
    public void display(DirectedGraph<Integer> graph){
        ArrayList<Hotel<Integer>> hotels = graph.getHotels();
        ArrayList<Site<Integer>> sites = graph.getSites();
        
        String hotelsMess = "Start from one of the following hotels: ";                           //display hotels
        for (int i =0; i < hotels.size(); i++){
            hotelsMess +=  hotels.get(i).key() +" ";
        }
        System.out.println(hotelsMess);
        
        String sitesMess = "Pick your favorite sites from : ";                                  //display sites
        for (int i =0; i < sites.size(); i++){
            sitesMess += sites.get(i).key() +" ";
        }
        System.out.println(sitesMess);
    }
    
    /** 
     * Generate tour itinerary from user inputs. 
     */
    public void createTour(DirectedGraph<Integer> graph){
        Scanner reader = new Scanner(System.in);                                        //Read inputs
        System.out.println("Specify hotel, time limit, and favorite sites: ");
        String aline = reader.nextLine();
        String[] tokens = aline.split(" ");

        if (tokens.length >= 2){
            Node<Integer> startNode = graph.find(Integer.parseInt(tokens[0]));          //starting node
            if (startNode == null || (!(startNode instanceof Hotel))) return;
            
            int timeLimit = Integer.parseInt(tokens[1]);                                //time limit
   
            Tour<Integer> t = new Tour<Integer>(graph, startNode, timeLimit);           //desired locations
            if (tokens.length > 2){
                for (int i = 2; i < tokens.length; i++) t.addDesiredSite(Integer.parseInt(tokens[i]));
            }
            
            t.travel();                                                                 //generate itinerary
            System.out.println("Generated tour: " + t.path().toString() +               
                               "\nTotal traveling and visiting time: " + t.getCurrTime() +
                               "\nTotal visitTime: " + t.getVisitTime() + 
                               "\nVisted sites: " + t.visitedSitesToString());

        } 
        
    }
    
    
    /**
     * Read input files to create a map of the city with sites and hotels
     */
    public DirectedGraph<Integer> createMap(String cityFile, String siteFile){
        DirectedGraph<Integer> graph = new DirectedGraph<Integer>();
        try{
            Scanner s = new Scanner(new FileReader(siteFile));
            Scanner c = new Scanner(new FileReader(cityFile));
            
            //Add sites and hotels to the map
            while (s.hasNextLine()){
                String aline = s.nextLine();
                String[] tokens = aline.split(" ");
                if (tokens.length == 2){
                   graph.addNode(Integer.parseInt(tokens[0]),"hotel",0);                                    //add hotels
                } else if (tokens.length == 3){
                   graph.addNode(Integer.parseInt(tokens[0]), "site", Integer.parseInt(tokens[2]));         //add sites
                }
            }
            
            //Add other nodes and connecting edges
            while (c.hasNextLine()){
                String aline = c.nextLine();
                String[] tokens = aline.split(" -> |\\ ");
                graph.addNode(Integer.parseInt(tokens[0]),"none",0);
                graph.addNode(Integer.parseInt(tokens[1]),"none",0);
                graph.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return graph;    
    }
    
}
   
 
