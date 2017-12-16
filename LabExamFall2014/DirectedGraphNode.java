

public class DirectedGraphNode<K,V> extends GraphNode<K,V> implements ISearch<K,V>
{
   public  void addConnection( GraphNode n ){}
   public  GraphNode find( K key ){}
   public V bfs( K key ){}
   public V dfs( K key ){}
}
