
public class DirectedGraphEdge<K extends Comparable<K>>
{
    private DirectedGraphNode<K> start;
    private DirectedGraphNode<K> end; 
    private int w;
      
    public DirectedGraphEdge(DirectedGraphNode<K> start, DirectedGraphNode<K> end, int w){
        this.start = start;
        this.end = end;
        this.w = w;
    }
    
    public DirectedGraphNode<K> start(){ return start;} 
    public DirectedGraphNode<K> end(){ return end;} 
    public int weight(){return w;}
    public void setWeight(int weight){this.w = weight;}
}
