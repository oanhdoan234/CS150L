import java.lang.*;
import java.util.*;

public class MyListDoubleContainer
{
    private MyLinkedList<Double> list; 
    
    public MyListDoubleContainer(){
        this.list = new MyLinkedList<Double>();
    }
    
    public void addToFront(double e){
        list.addFirst(e); 
    }
    
    public void addToBack(double e){
        list.addLast(e);
    }
    
    public int searchWithIterator(double e){
        MyLinkedListIterator<Double> i = (MyLinkedListIterator<Double>) list.iterator(); 
        int index = -1;
        while(i.hasNext()){                                             //start from head, check if list has more nodes
            index++;                                                    //move to the next node
            if (i.next().compareTo(e) == 0){                            //get the node value and compare
                return index;                                           
            }
        }
        return -1;
    }
    
    public int searchWithoutIterator(double e){
        int index = 0;
        Node<Double> head = list.getHead(); 
        Node<Double> tail = list.getTail();
        Node<Double> temp = head.next();                                //temp is head's next node
        
        while (temp != tail){                                           //move temp to the right until it reaches tail
            if (temp.getElement().compareTo(e) == 0){                   //compare 
                return index;
            }
            temp = temp.next();
            index++;
        }
        return -1;
    }
    
    public MyLinkedList<Double> getList(){
        return list;
    }
    
    public Double[] toArray(){
        ArrayList<Double> arrList = list.toArrayList();
        Double[] arr = new Double[list.size()];
        arr = arrList.toArray(arr);
        return arr;
    }
    
    public String toString(){
        Double[] arr = toArray();
        String message = "";
        for (int i = 0; i < arr.length; i++){
            message = message + arr[i] + " ";
        }
        System.out.println(message);
        return message;
    }
}
