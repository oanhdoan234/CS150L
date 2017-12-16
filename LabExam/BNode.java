
import java.util.*;
import java.lang.*;

public class BNode 
{
    private MyBook b;
    private BNode prev;
    private BNode next;
    
    public BNode(MyBook b){
        this.b = b;
        this.prev = null;
        this.next = null;
    }
    
    public BNode(MyBook b, BNode prev, BNode next){
        this.b = b;
        this.prev = prev; 
        this.next = next;
    }
    
    /** set and get methods */
    public void setNext(BNode n){this.next = n;} 
    public void setPrev(BNode n){this.prev = n; } 
    public BNode getNext(){return next;} 
    public BNode getPrev(){return prev; }
    public MyBook getMyBook(){return b;}
    public String getAuthor(){return b.getAuthor();}
    public String getTitle(){return b.getTitle();}
}
