import java.lang.*;
import java.util.*;

public abstract class SortedList<E extends Comparable<E>> 
{
    protected LinkedList<E> list; 
    
    //add
    public void addElement(E e){
        list.add(e);
    }
    
    //return size of list
    public int size(){
        return list.size();
    }
        
    //get element
    public E getElement(int index){
        return list.get(index);
    }
    
    //swap 2 elements in list
    public void swap(int pos1, int pos2){
        E temp = list.get(pos1);
        list.set(pos1, list.get(pos2));
        list.set(pos2, temp);
    }
    
    public int findpivot(int start, int end){
        return ((start+end)/2);
    }
    
    public int partition(int left, int right, E pivot){
        while (left <= right){                                                      //search from 2 ends
            while(list.get(left).compareTo(pivot) < 0) left++;                      //from left, find the first value smaller than pivot
            while((right >= left) && (list.get(right).compareTo(pivot) >=0)) right--;   //find right, find the first value bigger than pivot  
            if (right > left) swap(left,right);                                     //swap 
        }
        return left;        
    }
    
    public void quickSort(int i, int j){          
          int pivotindex = findpivot(i, j);  // Pick a pivot
          swap(pivotindex, j);               // Move pivot to list end                                
          int k = partition(i, j-1, list.get(j));    //partition
          swap(k, j);                        // Move pivot back to the right position
          if ((k-i) > 1) quickSort(i, k-1);  // Sort left partition
          if ((j-k) > 1) quickSort(k+1, j);  // Sort right partition
    }
    
    public void selectionSort(){
         for (int i = 0; i < list.size(); i++){
            int bigIdx = 0;                                                    //start from left
            for (int j = 1; j < list.size() - i; j++){                         //find the largest value 
                if (list.get(j).compareTo(list.get(bigIdx)) >0){
                    bigIdx = j;                                                  
                }
            }
            swap(bigIdx, list.size()-i-1);                                     //swap the largest value to the right end
        }
    }
    
    public abstract void printData();
}
