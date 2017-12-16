import java.util.*;

public class Node<K extends Comparable<K>>
{
    protected K key;
    protected ArrayList<Edge<K>> edges;
    protected String label;
    protected boolean visited; 
    
    public Node(K key){
        this.key = key; 
        this.edges = new ArrayList<Edge<K>>();
        this.visited = false;
        this.label = "none";
    }
    
    /** find closest neighbor */
    public Node<K> closest(){
        if (edges.size() == 0) return null;                                    //return null if the node cannot reach anything
        Edge<K> shortestEgde = edges.get(0);                      //find closest
        for (int i = 0; i < edges.size(); i++){
            if (edges.get(i).weight() < shortestEgde.weight()) shortestEgde = edges.get(i);
        }
        return shortestEgde.end();
    }
    
    /** compare if 2 nodes have same keys*/
    public boolean equalsKey(Node<K> obj){                        
        if (this.key.compareTo(obj.key) == 0) return true; 
        return false;
    }
    
    /** get all neighbors */
    public ArrayList<Node<K>> getNeighbors(){                     
        ArrayList<Node<K>> neighbors = new ArrayList<Node<K>>();
        for (int i = 0; i < edges.size(); i++){
            neighbors.add(edges.get(i).end());
        }
        return neighbors;
    }
    
    /** check if this node is connected to an edge, given the edge's weight and value of end node */
    public boolean containsEdge(K k, int w){
        for (int i = 0; i < edges.size(); i++){
            Edge<K> edge = edges.get(i);
            if (edge.end().key().compareTo(k) == 0 && edge.weight() == w) return true;
        }
        return false;
    }
    
    public K key(){ return key;}
    public ArrayList<Edge<K>> getEdges(){ return edges;}
    public void setVisit(boolean b){this.visited = b;}
    public boolean getVisit(){ return visited;}
    
}
