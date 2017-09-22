import java.util.*;

public class MyLinkedListIterator<E> implements Iterator<E> 
{
   private MyLinkedList<E> list;
   
   public boolean hasNext(){
       Node<E> curr = list.getCurr();
       Node<E> tail = list.getTail();
       return (curr != tail);
   }
   
   public E next(){
       if (list.iterator().hasNext()){
           return list.getCurr().next().getElement();
       }
       return null;
   }
}
