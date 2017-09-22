import java.util.*;
import java.lang.*;

public class DoubleContainer
{
    protected AbstractList<Double> data; 
    
    //add a number to the front
    public void addToFront(double frontNum){
        data.add(0,frontNum);
    }
    
    //add a number to the back
    public void addToBack(double backNum){
        int size = data.size();
        data.add(size,backNum);
    }
    
    //add a number to keep a sorted data sorted
    public void addSorted(double num){
        int i = 0;
        int pos = 0;
        while (i < data.size() && data.get(i) < num){               //look for the largest number that is smaller than input
            pos = i+1;
            i++;
        }
        data.add(pos, num);                                          //add the number
    }
    
    //swap the positions of 2 numbers in an data
    public void swap(int pos1, int pos2){
        double temp = data.get(pos1);
        data.set(pos1, data.get(pos2));
        data.set(pos2, temp);
    }
    
    //sort by selectionSort
    public void selectionSort(){
        for (int i = 0; i < data.size(); i++){
            int bigIdx = 0;                                                     //start from left
            for (int j = 1; j < data.size() - i; j++){                         //find the largest value 
                if (data.get(j).compareTo(data.get(bigIdx)) >0){
                    bigIdx = j;                                                  
                }
            }
            swap(bigIdx, data.size()-i-1);                                     //swap the largest value to the right end
        }
    }
    
    public int linearSearch(double num){
        for (int i = 0; i < data.size(); i++){
            if (data.get(i).compareTo(num) == 0){                             //Assume if the list has multiple matches, return the position
                return i;                                                     //of first record found
            }
        }
        return -1; 
    }
    
    public int binarySearch(double num){
        if (data.size() == 0) {                                     //stop searching if list is empty
            return -1;
        }
        int start = 0;                                              //initialize indices of the list first and last elements
        int end = data.size()-1;

        while (end > start) {                                       //check if the list size >=2 
            int midpoint =  (start + end)/2;                        //calculate midpoint
             if (data.get(midpoint).compareTo(num) == 0 ) {         //return if midpoint value = searching value
                 return midpoint;
             } else if (data.get(midpoint).compareTo(num) > 0) {    //search in first half and ignore second half
                 end = midpoint-1;
             } else if (data.get(midpoint).compareTo(num) < 0) {    //search in second half and ignore fist half
                 start = midpoint + 1;
            }
        }
        
        //special cases
        if (data.get(start).compareTo(num) == 0) {                  //stop if found searching value at list head
            return start;
        }
        
        if (data.get(end).compareTo(num) == 0){                     //stop if found searching value at list end
            return end;
        }
        
        return -1;                                                  
    }
    
    public Double[] convertToArray(){
        Double[] doubleArray = new Double[data.size()];
        doubleArray = data.toArray(doubleArray);
        return doubleArray; 
    }
    
    public String toString(){
        String message ="";
        for (int i = 0; i < data.size(); i++){
            message = message + data.get(i) + "\n";
        }
        System.out.println(message);
        System.out.println(data.size());
        return message;
    }
    
    public AbstractList<Double> getList(){
        return data;
    }
}
