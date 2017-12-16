import java.util.*;

public class DirectedGraphNode<K extends Comparable<K>>
{
    private K key;
    private ArrayList<DirectedGraphEdge<K>> edges;
    private boolean visited; 
    
    public DirectedGraphNode(K key){
        this.key = key; 
        this.edges = new ArrayList<DirectedGraphEdge<K>>();
        this.visited = false;
    }
    
    /** find closest neighbor */
    public DirectedGraphNode<K> closest(){
        if (edges.size() == 0) return null;                                    //return null if the node cannot reach anything
        DirectedGraphEdge<K> shortestEgde = edges.get(0);                      //find closest
        for (int i = 0; i < edges.size(); i++){
            if (edges.get(i).weight() < shortestEgde.weight()) shortestEgde = edges.get(i);
        }
        return shortestEgde.end();
    }
    
    /** compare if 2 nodes have same keys*/
    public boolean equalsKey(DirectedGraphNode<K> obj){                        
        if (this.key.compareTo(obj.key) == 0) return true; 
        return false;
    }
    
    /** get all neighbors */
    public ArrayList<DirectedGraphNode<K>> getNeighbors(){                     
        ArrayList<DirectedGraphNode<K>> neighbors = new ArrayList<DirectedGraphNode<K>>();
        for (int i = 0; i < edges.size(); i++){
            neighbors.add(edges.get(i).end());
        }
        return neighbors;
    }
    
    /** check if this node is connected to an edge, given the edge's weight and value of end node */
    public boolean containsEdge(K k, int w){
        for (int i = 0; i < edges.size(); i++){
            DirectedGraphEdge<K> edge = edges.get(i);
            if (edge.end().key().compareTo(k) == 0 && edge.weight() == w) return true;
        }
        return false;
    }
    
    public K key(){ return key;}
    public ArrayList<DirectedGraphEdge<K>> getEdges(){ return edges;}
    public void setVisit(boolean b){this.visited = b;}
    public boolean getVisit(){ return visited;}
}
