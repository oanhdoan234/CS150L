import java.util.*; 

public abstract class GraphNode<K,V>{
      private K key;
      private V value;
      boolean searched = false;
      ArrayList<GraphNode> connectedList;
      
      public abstract void addConnection( GraphNode n );
      public abstract GraphNode find( K key );
      public void reset() { searched = false; }
}