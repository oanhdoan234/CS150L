import java.util.*;

public class Tour<K extends Comparable<K>>
{
    private DirectedGraph<K> graph;
    private Path<K> path;
    private Node<K> start;
    private Node<K> currNode;
    private int visitTime; 
    private int currTime;
    private int timeLimit;
    private boolean goBack;
    private ArrayList<Node<K>> desiredSites;
    private ArrayList<Node<K>> visitedSites;
    
    public Tour(DirectedGraph<K> graph, Node<K> start, int timeLimit){
        this.graph = graph;
        this.start = start;
        this.timeLimit = timeLimit;
        this.currTime = 0;
        this.visitTime = 0;
        this.currNode = start;
        this.path = new Path<K>(start, start, this.graph);
        this.visitedSites = new ArrayList<Node<K>>();
        this.desiredSites = new ArrayList<Node<K>>();
        this.goBack = false;
    }
    
    /** generate tour itinerary */
    public void travel(){
        visitDesiredSite();                     //prioritize desired sites
        visitOtherSite();                       //visit other sites if have time
        goBack();                               //return to starting point
    }
    
    /** add desired sites to tour */
    public void addDesiredSite(K k){
        Node<K> n = this.graph.find(k);                                 //check if the site exists in map
        boolean added = false;
        if (n != null){
            for (int i = 0; i < desiredSites.size(); i++){
                if (desiredSites.get(i).equals(n)) added = true;       //check if the site has already been added
            }
            if (!added && n instanceof Site){
                desiredSites.add(n);                                    //add it if it has not been added and is actually a Site
            }
        }
    }
    
    /** visit desired sites */
    public void visitDesiredSite(){
        HashMap<Node<K>, Boolean> visited = createHashMap(desiredSites);                        //local visited booleans for desired sites
        
        for (int i = 0; i < desiredSites.size(); i++){
            
            if(currTime < timeLimit){                                                           //if there is still time
                Path<K> toNearestSite = this.graph.travelToNearestSite(currNode, visited);      //find nearest unvisited node
                if (toNearestSite == null){
                    return;
                } else if (toNearestSite.size() == 0){
                    visited.put(toNearestSite.getDestination(), true);
                } else {                                                                        
                    Site<K> visitedSite = (Site) toNearestSite.getLastNode();
                    //System.out.println(returnable(visitedSite));
                    if (returnable(visitedSite)){                                    //check if we can return to starting point if we travel there
                        currTime += visitedSite.getSuggestTime() + toNearestSite.length();      //travel
                        visitTime += visitedSite.getSuggestTime();
                        currNode = visitedSite;
                        visited.put(visitedSite, true);
                        this.visitedSites.add(visitedSite);
                        this.path.combinePath(toNearestSite);
                    }
                } 
                
            }
        }
        
    }
    
    
    /** visit other sites - repeat the same procedure as we do with desired sites. However, here, we mark the desired sites as visited so we do not
       consider revisiting them 
       */
    public void visitOtherSite(){
        //create visited boolean for all sites
        ArrayList<Node<K>> allsites = new ArrayList<Node<K>>();
        for (int i = 0; i < this.graph.getSites().size(); i++) allsites.add(this.graph.getSites().get(i));
        HashMap<Node<K>, Boolean> visited = createHashMap(allsites);
    
        //set all desired sites as visited
        for (int i = 0; i < this.desiredSites.size(); i++){
            visited.put(this.desiredSites.get(i), true);
        }
     
        for (int i = 0; i < this.graph.getSites().size(); i++){
            //System.out.println("Current node: " + currNode.key());
            if(currTime < timeLimit){
                //Visit the nearest unvisited site 
                Path<K> toNearestSite = this.graph.travelToNearestSite(currNode, visited);
                if(toNearestSite == null){
                    return;
                } else if (toNearestSite.size() == 0){
                    visited.put(toNearestSite.getDestination(), true);
                } else {
                    Site<K> visitedSite = (Site) toNearestSite.getLastNode();
                    //System.out.println("Travel to next node: " + toNearestSite.length());
                    //System.out.println("Time at next node: " + visitedSite.getSuggestTime());
                    //System.out.println(returnable(visitedSite));
                    
                    //System.out.println("Path: " + this.path.toString());
                    if (returnable(visitedSite)){
                        currTime += visitedSite.getSuggestTime() + toNearestSite.length();
                        visitTime += visitedSite.getSuggestTime();
                        currNode = visitedSite;
                        visited.put(visitedSite, true);
                        this.visitedSites.add(visitedSite);
                        this.path.combinePath(toNearestSite);
                    }
                }
            }
            //System.out.println("Current time: " + currTime);
            //System.out.println(" =======================");
        }
    }
    
    /** find the shortest path to go home and add it to the path of the tour */
    public void goBack(){
        Path<K> returnPath = this.graph.shortestPath(currNode.key(), this.start.key());
        currTime += returnPath.length();
        //System.out.println("time go back: " + returnPath.length());
        //System.out.println(" ");
        this.path.combinePath(returnPath);
    }
    
    /** create boolean hashmap that is used locally in methods to visit sites */
    public HashMap<Node<K>, Boolean> createHashMap(ArrayList<Node<K>> l){
        HashMap<Node<K>, Boolean> visited = new HashMap<Node<K>, Boolean>();
        for (int i =0; i < l.size(); i++){
            visited.put(l.get(i), false);
        }
        return visited;
    }
    
    
    /** before traveling to a site X, we need to check if we have time to return home after visiting it. 
       The condition is:  currentTime + timeToX + timeAtX + timeGoHome
       If X is not a site but just a regular node, we do not have to account for time spent at X
       */
    public boolean returnable(Node<K> n){
        Path<K> returnPath = this.graph.shortestPath(n.key(), this.start.key());            //path to go home
        //System.out.println("Time to go back: " + returnPath.length());
        Path<K> p = this.graph.shortestPath(currNode.key(), n.key());                       //path travel from current node to given node
        
        if (returnPath != null){
            if (n instanceof Site){
                Site<K> s = (Site) n;
                return (currTime + p.length() +  s.getSuggestTime() + returnPath.length()) <= this.timeLimit;       
            }
            return currTime + p.length() + returnPath.length() <= this.timeLimit;
        }
        return false;
    }
    
    public ArrayList<Node<K>> getDesiredSites(){return this.desiredSites;}
    public Path<K> path(){return this.path;}
    public Node<K> getCurrNode(){return currNode;}
    public int getCurrTime(){return currTime;}
    public int getVisitTime(){return visitTime;}
    public String visitedSitesToString(){
        String mess = "";
        int totalVisitTime = 0;
        for (int i = 0; i < visitedSites.size(); i++) {
            mess += visitedSites.get(i).key() + " ";
        }
        return mess;
    }
}
