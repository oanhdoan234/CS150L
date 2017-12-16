import java.util.*;
import java.lang.*;

public class MyBookListIterator implements Iterator<MyBook>
{
    private MyBookList list;
    private BNode n;
    
    public MyBookListIterator(MyBookList list){
        this.list = list;
        this.n = list.getHead();
    }
    
    /** hasNext - check if the next node is not head */
    public boolean hasNext(){                                       //next node is head => end of list
        if (n.getNext() == list.getHead() && list.getHead().getPrev() ==  n){
            return false;
        } 
        return true;
    }
    
    /** get element of the next node */
    public MyBook next(){                                             //return the next MyBook in list
        return (MyBook) n.getNext().getMyBook();
    }
    
    /** get next node */
    public BNode nextNode(){
        return n.getNext();
    }
    
    public void remove(){
        
    }
}
