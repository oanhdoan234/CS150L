import java.util.*;
public class RandomDoubleContainer
{
    private ArrayList<Double> array;

    public RandomDoubleContainer()
    {
        this.array = new ArrayList<Double> ();
    }

    public static void main(String[] args) {
        RandomDoubleContainer r =new RandomDoubleContainer();
        r.addToFront(6);
        r.addToFront(15);
        r.addToFront(23);
        r.addToFront(12);
        r.toString();
        r.selectionSort();
        r.toString();
        Double[] newr = r.convertToArray();
    }
    
    //add a number to the front
    public void addToFront(double frontNum){
        array.add(0,frontNum);
    }
    
    //add a number to the back
    public void addToBack(double backNum){
        int size = array.size();
        array.add(size,backNum);
    }
    
    //add a number to keep a sorted array sorted
    public void addSorted(double num){
        int i = 0;
        int pos = 0;
        while (i < array.size() && array.get(i) < num){               //look for the largest number that is smaller than input
            pos = i+1;
            i++;
        }
        array.add(pos, num);                                          //add the number
    }
    
    //swap the positions of 2 numbers in an array
    public void swap(int pos1, int pos2){
        double temp = array.get(pos1);
        array.set(pos1, array.get(pos2));
        array.set(pos2, temp);
    }
    
    //sort by selectionSort
    public void selectionSort(){
        for (int i = 0; i < array.size(); i++){
            int bigIdx = 0;                                                     //start from left
            for (int j = 1; j < array.size() - i; j++){                         //find the largest value 
                if (array.get(j).compareTo(array.get(bigIdx)) >0){
                    bigIdx = j;                                                  
                }
            }
            swap(bigIdx, array.size()-i-1);                                     //swap the largest value to the right end
        }
    }
    
    //convert ArrayList to array
    public Double[] convertToArray(){
        Double[] doubleArray = new Double[array.size()];
        doubleArray = array.toArray(doubleArray);
        return doubleArray; 
    }
    
    public String toString(){
        String message ="";
        for (int i = 0; i < array.size(); i++){
            message = message + array.get(i) + "\n";
        }
        System.out.println(message);
        System.out.println(array.size());
        return message;
    }
    
    public ArrayList<Double> getArrayList(){
        return array;
    }
}


 
    
    
