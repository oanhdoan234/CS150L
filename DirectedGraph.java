import java.util.*;

public class DirectedGraph<K extends Comparable<K>>
{   private ArrayList<DirectedGraphNode<K>> nodes;
    
    public DirectedGraph(){
        this.nodes = new ArrayList<DirectedGraphNode<K>>();
    }
    
    /** add a node */
    public boolean addNode(K k){
        if (contains(k)) return false;                                      //stop if a node of this value exists
        nodes.add(new DirectedGraphNode<K>(k));                             //otherwise, create and add a new one 
        return true; 
    }
    
    /** add an edge connecting 2 values and carrying a weight */
    public boolean addEdge(K k1, K k2, int w){
        if (contains(k1) && contains(k2)){                                  //check if both values exist 
            DirectedGraphNode<K> start = find(k1);                          //find start node
            DirectedGraphNode<K> end = find(k2);                            //find end node
            ArrayList<DirectedGraphEdge<K>> edgeFromStartNode = start.getEdges();       //check if start node is already connected to end node
            for (int i = 0; i < edgeFromStartNode.size(); i++) {
                DirectedGraphEdge<K> anEdge  = edgeFromStartNode.get(i);
                DirectedGraphNode<K> endNode = anEdge.end();
                if (endNode.equalsKey(end)) {                                           //if connected, reset weight
                    anEdge.setWeight(w);
                    return true;
                }
            }
            DirectedGraphEdge<K> edge = new DirectedGraphEdge<K>(start,end,w);          //otherwise, add an edge to connect 2 nodes
            start.getEdges().add(edge);
            return true; 
        }
        return false;
    }
    
    
    /** get neighbors of a node given its value */
    public ArrayList<K> getNeighbors(K k){
        if (contains(k)){                                                               //check if the node exists
            DirectedGraphNode<K> givenNode = find(k);                                   //find the node
            ArrayList<DirectedGraphEdge<K>> edges = givenNode.getEdges();               //find its edges
            ArrayList<K> neighbors = new ArrayList<K>();                                //find its neighbors (end nodes of all edges)
            if (edges.size() > 0){
                for (int i = 0; i < edges.size(); i++){
                    neighbors.add(edges.get(i).end().key());
                }
            }
            return neighbors;
        }
        return null;
    } 
    
    
    /** find closest neighbor of all nodes */
    public void breadthFirstClosest(K k1){
        if (nodes.size() == 0) return;                                                  //stop if the graph has no node                                            
        if (contains(k1)){                                                              //stop if cannot find starting node
            Queue<DirectedGraphNode<K>> q = new LinkedList<DirectedGraphNode<K>>();     //visit given node and add it to a queue
            DirectedGraphNode<K> startNode = find(k1); 
            
            q.add(startNode);
            startNode.setVisit(true);
            
            while (q.size() >0){                                                       
                DirectedGraphNode<K> node = q.remove();                                 //remove and print each node in a queue
                DirectedGraphNode<K> closestNeighbor = node.closest();                  //and its closest neighbor
                if (closestNeighbor == null){
                    System.out.println(node.key() + " " + closestNeighbor);
                } else {
                    System.out.println(node.key() + " " + closestNeighbor.key());
                }
                
                ArrayList<DirectedGraphNode<K>> neighbors = node.getNeighbors();        //add all of its unvisited neighbors to the queue
                for (int i = 0; i < neighbors.size(); i++){
                    if (!neighbors.get(i).getVisit()){
                        neighbors.get(i).setVisit(true);
                        q.add(neighbors.get(i));
                    }
                }
            }
            
            for (int i = 0; i < nodes.size(); i++){                                     //recurse to all other unvisited nodes
                if (!nodes.get(i).getVisit()) breadthFirstClosest(nodes.get(i).key());
            }
        }
        return;
    }
    
    
    public boolean contains(K k){
        ArrayList<K> keys = new ArrayList<K>();
        for (int i = 0; i < this.nodes.size(); i++) keys.add(this.nodes.get(i).key());
        if (keys.contains(k)) return true; 
        return false;
    }
    
    public DirectedGraphNode<K> find(K k){
        for (int i = 0; i < nodes.size(); i++){
            if (nodes.get(i).key().compareTo(k) == 0) return nodes.get(i);
        }
        return null; 
    }
    
    public ArrayList<DirectedGraphNode<K>> getNodes(){return this.nodes;}
    
}
