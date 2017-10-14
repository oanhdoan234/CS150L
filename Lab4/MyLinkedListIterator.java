import java.util.*;

public class MyLinkedListIterator<E> implements Iterator<E> 
{
   private Node<E> head;
   private Node<E> tail;
   private Node<E> curr;
   
   public MyLinkedListIterator(Node<E> head, Node<E> tail){
       this.head = head ;
       this.tail = tail;
       this.curr = head;                                            //set head to be current node
   }
   
   public boolean hasNext(){
       return (curr.next() != tail);                                //if current is the last node right before tail
   }
   
   public E next(){
       if (hasNext()){                                              //check if the list has more nodes
           curr = curr.next();                                      //move to the next node
           return curr.getElement();                                //get value
       }
       return null;
   }
   
   public Node<E> nextNode(){
       if (hasNext()){                                              //check if the list has more nodes
           curr = curr.next();                                      //move to and return next nodes
           return curr;
       }
       return null;
   }
}
