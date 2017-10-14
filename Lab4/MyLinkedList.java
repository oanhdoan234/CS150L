import java.lang.*;
import java.util.*;

public class MyLinkedList<E> implements Iterable<E>
{
   private Node<E> head;
   private Node<E> tail;
   private int size;
   
   public MyLinkedList(){
       this.size = 0;
       this.tail = new Node<E>(null);                                           //create tail
       this.head = new Node<E>(null, tail);                                     //create head and connect it with tail
   }
   
   public Iterator<E> iterator() {
        return new MyLinkedListIterator<E>(head, tail);
   }
    
   public void addFirst(E value){
        Node<E> temp = new Node<E>(value, null);                                //create temp node to store value
        if (size == 0){                                                         
            head.setNext(temp);                                                 //connect head with temp, temp with tail
            temp.setNext(tail);
        } else {
            temp.setNext(head.next());                                          //connect head with temp, temp with the one used to be right 
            head.setNext(temp);                                                 //after head
           
        }
        size++;
   }
    
   public void addLast(E value){
        if (size == 0){
            addFirst(value);                                                    
        } else { 
            Node<E> temp = new Node<E>(value, null);                            //create temp node to store values    
            Node<E> lastNode = getNode(size-1);                                 //old last node
            lastNode.setNext(temp);                                             //connect old last node with temp
            temp.setNext(tail);                                                 //connect temp with tail
            size++;
        }
   }
    
   public void remove(int index){
        if (size <= index){                             //check if list is not empty and index is greater than size
            return;
        } else if (index == 0){                                                //remove first node
            Node<E> firstNode = getNode(0);             
            head.setNext(firstNode.next());
            size--;
        } else if (index == size - 1) {                                         //remove last node
            Node<E> toremove = getNode(index);
            Node<E> prevNode = getNode(index-1);                                //get previous node
            toremove.setNext(null);
            prevNode.setNext(tail);                                             //connect previous node with tail
            size--;
        } else {                                                                //remove any node in between
            Node<E> prevNode = getNode(index-1);                                //get previous node
            prevNode.setNext(prevNode.next().next());                           //connect previous node with the node after the one to be removed
            size--;
        }
   }
    
   public Node<E> getNode(int index){
        MyLinkedListIterator<E> i = (MyLinkedListIterator<E>) iterator();
        Node<E> curr = null;
        if (index >= 0 && index < size) {                                       //check if index is valid 
            for (int j = 0; j <= index; j++ ){                                  //move to index position
                curr = i.nextNode();
            }
        }           
        return curr;
   }
    
   public E getElement(int index){
       Node<E> n = getNode(index);                                              //find node at given index
       if (n != null){
           return n.getElement();                                               //return value of that node
       } 
       return null;
   }
    
   public int size(){
       return size;
   }
   
   public Node<E> getHead(){
       return head;
   }
   
   public Node<E> getTail(){
       return tail;
   }
   
   public ArrayList<E> toArrayList(){
        ArrayList<E> arr = new ArrayList<E>();
        for (int i = 0; i < size; i++){
            arr.add(i,getElement(i));
        }
        return arr;
   }
   
   public String toString(){
       ArrayList<E> arr = toArrayList();
       String message = "";
       if (arr.size() == 0){
           message = "This list is empty";
       } else {
           for (int i = 0; i <arr.size(); i++){
               message = message + arr.get(i) + " ";
           }
       }
       System.out.println(message);
       return message; 
   }
}
