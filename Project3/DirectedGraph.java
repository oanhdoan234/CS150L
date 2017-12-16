import java.util.*;

public class DirectedGraph<K extends Comparable<K>>
{   private ArrayList<Node<K>> nodes;
    private ArrayList<Hotel<K>> hotels;
    private ArrayList<Site<K>> sites;
    
    public DirectedGraph(){
        this.nodes = new ArrayList<Node<K>>();
        this.hotels = new ArrayList<Hotel<K>>();
        this.sites = new ArrayList<Site<K>>();
    }
    
    /** add a node */
    public boolean addNode(K k, String type, int suggestTime){
        if (contains(k)) return false;                                      //stop if a node of this value exists
        if (type.compareTo("hotel")==0){
            Hotel<K> h = new Hotel<K>(k);
            nodes.add(h);
            hotels.add(h);
            return true;
        } else if (type.compareTo("site")==0){
            Site<K> s = new Site<K>(k, suggestTime);
            nodes.add(s);
            sites.add(s);
            return true;
        }
        nodes.add(new Node<K>(k));                             //otherwise, create and add a new one 
        return true; 
    }
    
    /** add an edge connecting 2 values and carrying a weight */
    public boolean addEdge(K k1, K k2, int w){
        if (contains(k1) && contains(k2)){                                  //check if both values exist 
            Node<K> start = find(k1);                          //find start node
            Node<K> end = find(k2);                            //find end node
            ArrayList<Edge<K>> edgeFromStartNode = start.getEdges();       //check if start node is already connected to end node
            for (int i = 0; i < edgeFromStartNode.size(); i++) {
                Edge<K> anEdge  = edgeFromStartNode.get(i);
                Node<K> endNode = anEdge.end();
                if (endNode.equalsKey(end)) {                                           //if connected, reset weight
                    anEdge.setWeight(w);
                    return true;
                }
            }
            Edge<K> edge = new Edge<K>(start,end,w);          //otherwise, add an edge to connect 2 nodes
            start.getEdges().add(edge);
            return true; 
        }
        return false;
    }
    
    /** get neighbors of a node given its value */
    public ArrayList<K> getNeighbors(K k){
        if (contains(k)){                                                               //check if the node exists
            Node<K> givenNode = find(k);                                   //find the node
            ArrayList<Edge<K>> edges = givenNode.getEdges();               //find its edges
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
    
    /** find the nearest unvisited node */
    public Node<K> minNode(HashMap<Node<K>,Path<K>> allpaths){
        Node<K> minN = null;
        
        //find the first node to be unvisited
         for (Map.Entry<Node<K>,Path<K>> entry : allpaths.entrySet()){
            if (!entry.getValue().isDone()){
                minN = entry.getKey();
                break;
            }
        }
        
        //find the node that has min distance (shortest path)
        if (minN !=null){
            for (Map.Entry<Node<K>, Path<K>> entry: allpaths.entrySet()){
                if (!entry.getValue().isDone() && entry.getValue().length() < allpaths.get(minN).length()) minN = entry.getKey();
            }
        }
        return minN;
    }
    
    
    /** find shortest path between any 2 points  - dijkstra algorithm*/
    public Path<K> shortestPath(K k1, K k2){
        Node<K> start = this.find(k1);                                              //check if 2 points exist
        Node<K> end = this.find(k2);
        if (start == null || end == null){ 
            return null;
        } else {
            HashMap<Node<K>,Path<K>> allpaths = new HashMap<Node<K>,Path<K>>();      //paths to all other nodes, coming from starting point (k1)
            ArrayList<Node<K>> visited = new ArrayList<Node<K>>();
            
            for (int i = 0; i < nodes.size(); i++ ){
                Path<K> p = new Path<K>(start, nodes.get(i), this);
                if (nodes.get(i).equals(start)) {
                    p.getRoute().add(start);                                        //set the path from start node to itself to be 0
                    p.setLength(0);   
                }
                allpaths.put(nodes.get(i),p);
            }
            
            Node<K> minN = minNode(allpaths);                                      //find the nearest unvisited node
            allpaths.get(minN).setDone(true);
            visited.add(minN);
                
            while(!allpaths.get(end).isDone()){                                    //terminate once end node is the nearest unvisited node
                
                if (allpaths.get(minN).length() == Integer.MAX_VALUE) return null;          //stop if the nearest unvisited node is unreachable
                
                ArrayList<Node<K>> neighbors = minN.getNeighbors();                 //find neighbors of the nearest unvisited node
                for (int i = 0; i < neighbors.size(); i++){                        
                    Node<K> nb = neighbors.get(i);
                    Path<K> p  = allpaths.get(nb);
                    if (p.length() > (allpaths.get(minN).length() + this.weight(minN, nb))){     //update the path to each of these neighbors
                        p.updatePath(allpaths.get(minN));
                    }
                }
                
                minN = minNode(allpaths);
                allpaths.get(minN).setDone(true);
                visited.add(minN);
            }
            
            return allpaths.get(end);
        }
    }
    
    /** find the path to the nearest site from a given node */
    public Path<K> travelToNearestSite(Node<K> start, HashMap<Node<K>, Boolean> visit){
        Path<K> p = null;
        int idx = -1;
        
        //find first unvisited site
        for (Map.Entry<Node<K>, Boolean> entry : visit.entrySet()){
            if(!entry.getValue()){
                p = this.shortestPath(start.key(), entry.getKey().key());
                break;
            }
        }
        
        //find the nearest site - the one that has the shortest path from start node
        if (p!=null){
            for (Map.Entry<Node<K>, Boolean> entry : visit.entrySet()){
                if(!entry.getValue()){
                    Path<K> newPath = this.shortestPath(start.key(), entry.getKey().key());
                    if (newPath.length() < p.length())  p = newPath;
                }
            }
        }
        //System.out.println(p.toString());
        return p;
    }
    
    
    /** get the weight of the edge connecting 2 nodes */
    public int weight(Node<K> start, Node<K> end){
        if (start != null){
            ArrayList<Edge<K>> edges = start.getEdges();                                //outgoing edges of start node
            for (int i = 0; i < edges.size(); i++){
                if (edges.get(i).end().equals(end)) return edges.get(i).weight();       //compare the other ends of edges with end node
            }
            return -1;
        }
        return -1;   
    }
    
    public boolean contains(K k){
        ArrayList<K> keys = new ArrayList<K>();
        for (int i = 0; i < this.nodes.size(); i++) keys.add(this.nodes.get(i).key());
        if (keys.contains(k)) return true; 
        return false;
    }
    
    public Node<K> find(K k){
        for (int i = 0; i < nodes.size(); i++){
            if (nodes.get(i).key().compareTo(k) == 0) return nodes.get(i);
        }
        return null; 
    }
    
    public int size(){return nodes.size();}
    public ArrayList<Node<K>> getNodes(){return this.nodes;}
    public ArrayList<Hotel<K>> getHotels(){ return this.hotels;}
    public ArrayList<Site<K>> getSites(){ return this.sites;}

}
