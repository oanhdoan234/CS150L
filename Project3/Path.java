import java.util.*;

public class Path<K extends Comparable<K>>
{
   private Node<K> start;
   private Node<K> destination; 
   private ArrayList<Node<K>> route;
   private boolean done;
   private int length; 
   private DirectedGraph<K> graph;
   
   public Path(Node<K> start, Node<K> destination, DirectedGraph<K> graph){
       this.start = start;
       this.destination = destination;
       this.route = new ArrayList<Node<K>>();
       this.length = Integer.MAX_VALUE;
       this.graph = graph;
       this.done = false;
   }
   
   /** 
    * Update route when a shorter path is found 
    * For example, let p(A,D) be the shortest path from A to D. Suppose there is a point C s.t p(A,C) + w(A,D) < p(A,D). We want to update 
    * p(A,D) to be p(A,C) and then from C go straight to D
    */
   public void updateRoute(Path<K> prev){  
       if (prev != null){
           this.route.clear();                                      //clear route
           for (int i = 0; i < prev.getRoute().size(); i++){        //travel along the path that leads to the node prior to our destination
               this.route.add(prev.getRoute().get(i));
           }
           this.route.add(destination);                             //travel from that node to destination
       }
   }
   
   /** 
    * Update length, using the length of the path that leads to the node prior to our destination
    */
   public void updateLength(Path<K> prev){
       if (prev != null){
           Node<K> prevNode = prev.getLastNode();
           length = prev.length + this.graph.weight(prevNode, destination);
       }
   }
   
   /** Update path*/
   public void updatePath(Path<K> prev){
       updateRoute(prev);
       updateLength(prev);
   }
   
   /** Combine the routes of 2 paths */
   public void combinePath(Path<K> p){
 
       if(p.size() == 0 || this.graph != p.graph || (this.size() > 0 && (!this.getLastNode().equals(p.getNode(0))))) {
           return;
       } else {
           
           ArrayList<Node<K>> toAdd = p.getRoute();
           if (this.size() == 0){
               //if the current route is empty, take everything from the added path
               for (int i = 0; i < toAdd.size(); i++) this.route.add(toAdd.get(i));
           } else {
               //if the current route is not empty, take everything from the second node of the added path to avoid overlapped nodes.
               for (int i = 1; i < toAdd.size(); i++) this.route.add(toAdd.get(i));            
           }
           //add lengths
           this.length += p.length();

       } 
   }
   
   public void setLength(int a){this.length = a;}
   public int length(){return this.length;}
   public ArrayList<Node<K>> getRoute(){ return route;}
   public boolean isDone(){
       return done;
    }   
   public void setDone(boolean b){
       this.done = b;
    }   
   public int size(){return this.route.size();}
   public Node<K> getLastNode(){return route.get(route.size()-1);}
   public Node<K> getNode(int i){
       if (i < route.size()) return route.get(i);
       return null;
   }
   public DirectedGraph<K> getGraph(){return this.graph;}
   public Node<K> getDestination(){return this.destination;}
   public String toString(){
       String message = "";
       for (int i = 0; i < route.size(); i++){
           message += route.get(i).key() + " ";
       }
       return message;
   }
}
