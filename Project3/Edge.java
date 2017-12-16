
public class Edge<K extends Comparable<K>>
{
    private Node<K> start;
    private Node<K> end; 
    private int w;
      
    public Edge(Node<K> start, Node<K> end, int w){
        this.start = start;
        this.end = end;
        this.w = w;
    }
    
    public Node<K> start(){ return start;} 
    public Node<K> end(){ return end;} 
    public int weight(){return w;}
    public void setWeight(int weight){this.w = weight;}
}
