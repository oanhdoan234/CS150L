import java.util.Scanner;
import java.io.FileReader;

public class GraphExperiment
{
    public static void main(String[] args){
        GraphExperiment ex = new GraphExperiment();
        System.out.println("\nFirst graph");
        ex.breadthFirstClosest("graph1.txt");
        
        System.out.println("\nSecond graph");
        ex.breadthFirstClosest("graph2.txt");
        
        System.out.println("\nThird graph");
        ex.breadthFirstClosest("graph3.txt");
        
        System.out.println("\nLast graph");
        ex.breadthFirstClosest("graph4.txt");
    }
    
    
    /** read a file to create graph */
    public DirectedGraph<String> createGraph(String fileName){
        DirectedGraph<String> graph = new DirectedGraph<String>();
        try{
            Scanner s = new Scanner(new FileReader(fileName));      
            if (s.hasNextLine()){                                                           //read first line 
                String firstLine = s.nextLine();
                String[] tokens  = firstLine.split(" ");
                for (int i = 0; i < tokens.length; i++) graph.addNode(tokens[i]);           //add nodes 
            }
            
            while (s.hasNextLine()){                                                        //read remaining lines
                String aLine = s.nextLine();
                String[] tokens = aLine.split(" "); 
                graph.addEdge(tokens[0],tokens[1], Integer.parseInt(tokens[2]));            //add edges
            }
        } catch(Exception e){
            System.out.println(e);
        }
        return graph;
    }
    
    public void breadthFirstClosest(String fileName){
        DirectedGraph<String> graph = this.createGraph(fileName);                       //create graph
        if (graph.getNodes().size() == 0) return;
        graph.breadthFirstClosest(graph.getNodes().get(0).key());                       //print closest neighbor of each node
                                                                                        //starting from first node in the file
    }
}
