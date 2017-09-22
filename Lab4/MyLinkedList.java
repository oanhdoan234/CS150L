import java.lang.*;
import java.util.*;

public class MyLinkedList<E> implements Iterable<E>
{
   private Node<E> head;
   private Node<E> tail;
   private Node<E> curr;
   private int size;
   
   public MyLinkedList(Node<E> head, Node<E> tail, Node<E> curr, int size){
       this.size = 0;
       this.tail = this.head = this.curr = new Node(null);
    }
   
    public Iterator<E> iterator() {
        return new MyLinkedListIterator<E>();
    }
    
    public void addFirst(E value){
        curr = head.setNext(new Node<E>(value, null));      //create a new node to the right of head
        tail = curr.setNext(new Node<E>(null));             //set tail to be the right of the new node
        size++;
    }
    
    //WARNING: remember to deal with boundary cases
    public void addLast(E value){
        tail.setNext(new Node<E>(null));
        tail.setElement(value);
        tail = tail.next();
        size++;
    }
    
    public E getElement(int index){
        Iterator<E> i = iterator();
        curr = head;
        int pos = 0;
        while(i.hasNext() && pos < index){
            curr = curr.next();
            pos++;
        }
        return curr.getElement();
    }
    
    
    public Node<E> getTail(){
        return tail; 
    }
    
    public Node<E> getCurr(){
        return curr; 
    }
    
    
}
