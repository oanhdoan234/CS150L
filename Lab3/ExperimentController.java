import java.util.*;
import java.io.PrintWriter;
public class ExperimentController
{
    
    public static void main(String[] args){
        ExperimentController c = new ExperimentController();
        int[] numberOfItems = {100,1000,2000,5000};                                                 //input size
        int[] seeds = {88087987,4340590,23451996};                                                  //seeds to ensure randomness 
        double[] findable = {0.8010091916241494,0.7866776054272067,0.7111831628430687};             //searching values, corresponding to seeds
        double findIt2 = 1.1;
        
        try{
            PrintWriter p = new PrintWriter("output.csv");
            p.write("Size, Seed, Data Structure, AddToFront, AddToBack, SortOfUnsorted, SortOfSorted, linearSearchFindable," + 
            "binarySearchFindable, linearSearchNotFindable, binarySearchNotFindable\n");
        
            for (int i = 0; i < numberOfItems.length; i++){
                for (int j =0; j < seeds.length; j++){
                    
                    System.out.println(numberOfItems[i] + "," + seeds[j]); 
                    
                    //run time of various methods on each data structure
                    Long[] addToFront = c.timeAddToFront(numberOfItems[i], seeds[j]);
                    Long[] addToBack  = c.timeAddToBack(numberOfItems[i], seeds[j]);
                    Long[] sortOfUnsortedList   = c.timeSortOfUnsortedList(numberOfItems[i], seeds[j]);
                    Long[] sortOfSortedList     = c.timeSortOfSortedList(numberOfItems[i], seeds[j]);
                    Long[] linearSearchFindable = c.timeLinearSearch(numberOfItems[i], seeds[j], findable[j]);
                    Long[] binarySearchFindable =  c.timeBinarySearch(numberOfItems[i], seeds[j], findable[j]);
                    Long[] linearSearchNotFindable = c.timeLinearSearch(numberOfItems[i], seeds[j], findIt2);
                    Long[] binarySearchNotFindable = c.timeBinarySearch(numberOfItems[i], seeds[j], findIt2);
                    
                    //print run time of ArrayList
                    p.write(numberOfItems[i] + "," + seeds[j] + "," + "ArrayList" + "," 
                            + addToFront[0] + "," 
                            + addToBack[0] + ","
                            + sortOfUnsortedList[0] + ","
                            + sortOfSortedList[0] + ","
                            + linearSearchFindable[0] + "," 
                            + binarySearchFindable[0] + ","
                            + linearSearchNotFindable[0] + ","
                            + binarySearchNotFindable[0] +
                            "\n");
                    //print run time of LinkedList
                    p.write(numberOfItems[i] + "," + seeds[j] + "," + "LinkedList" + "," 
                            + addToFront[1] + "," 
                            + addToBack[1] + ","
                            + sortOfUnsortedList[1] + ","
                            + sortOfSortedList[1] + ","
                            + linearSearchFindable[1] + "," 
                            + binarySearchFindable[1] + ","
                            + linearSearchNotFindable[1] + ","
                            + binarySearchNotFindable[1] +
                            "\n");
               
                }
            }
            
            p.close(); 
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        } 
        
    }
    
    //record time to add numbers to AddToFront
    public Long[] timeAddToFront(int numberOfItems, int seed){
        ArrayListDoubleContainer arrayList  = new ArrayListDoubleContainer();               //initialize arrayList
        LinkedListDoubleContainer linkedList = new LinkedListDoubleContainer();             //initialize linkedList
        Random random1 =  new Random(seed);                                                 //initialize 2 similar random generators 
        Random random2 =  new Random(seed);
        
        long startTimeArrayList = System.nanoTime();            //start clock
        for (int i =0; i < numberOfItems; i++){ 
            double num = random1.nextDouble();                  //generate and add random numbers to the arrayLIst
            arrayList.addToFront(num);            
        }
        long stopTimeArrayList = System.nanoTime();             //stop clock
        long totalTimeArrayList = stopTimeArrayList - startTimeArrayList;       //calculate time difference
        
        long startTimeLinkedList = System.nanoTime();
        for (int i =0; i < numberOfItems; i++){ 
            double num = random2.nextDouble();                  //generate and add random numbers to the linkedList
            linkedList.addToFront(num);
        }
        long stopTimeLinkedList = System.nanoTime();
        long totalTimeLinkedList = stopTimeLinkedList - startTimeLinkedList;
        
        Long[] totalTime = {totalTimeArrayList, totalTimeLinkedList}; 
     
        return totalTime; 
         
    }
    
    
    public Long[] timeAddToBack(int numberOfItems, int seed){
        ArrayListDoubleContainer arrayList  = new ArrayListDoubleContainer();               //initialize arrayList
        LinkedListDoubleContainer linkedList = new LinkedListDoubleContainer();             //initialize linkedList
        Random random1 =  new Random(seed);                                                 //initialize 2 similar random generators 
        Random random2 =  new Random(seed);
        
        long startTimeArrayList = System.nanoTime();   
        for (int i =0; i < numberOfItems; i++){ 
            double num = random1.nextDouble();                  //generate and add random numbers to the arrayLIst
            arrayList.addToBack(num);            
        }
        long stopTimeArrayList = System.nanoTime();
        long totalTimeArrayList = stopTimeArrayList - startTimeArrayList; 
        
        long startTimeLinkedList = System.nanoTime();
        for (int i =0; i < numberOfItems; i++){ 
            double num = random2.nextDouble();                  //generate and add random numbers to the linkedList
            linkedList.addToBack(num);
        }
        long stopTimeLinkedList = System.nanoTime();
        long totalTimeLinkedList = stopTimeLinkedList - startTimeLinkedList;
        
        Long[] totalTime = {totalTimeArrayList, totalTimeLinkedList}; 
        
        
        //System.out.print(totalTimeArrayList + "," + totalTimeLinkedList + ",");
        return totalTime;
    }
    
    public Long[] timeSortOfUnsortedList(int numberOfItems, int seed){
        ArrayListDoubleContainer arrayList  = new ArrayListDoubleContainer();               //initialize arrayList
        LinkedListDoubleContainer linkedList = new LinkedListDoubleContainer();             //initialize linkedList
        Random random1 =  new Random(seed);                                                 //initialize 2 similar random generators 
        Random random2 =  new Random(seed);
        
        
        for (int i =0; i < numberOfItems; i++){ 
            double num = random1.nextDouble();                  //generate and add random numbers to the arrayLIst
            arrayList.addToBack(num);            
        }
        long startTimeArrayList = System.nanoTime();   
        arrayList.selectionSort();                              //sort and record sort time
        long stopTimeArrayList = System.nanoTime();
        long totalTimeArrayList = stopTimeArrayList - startTimeArrayList; 
        
        
        for (int i =0; i < numberOfItems; i++){ 
            double num = random2.nextDouble();                  //generate and add random numbers to the linkedList
            linkedList.addToBack(num);
        }
        long startTimeLinkedList = System.nanoTime();
        linkedList.selectionSort();                             //sort and record sort time
        long stopTimeLinkedList = System.nanoTime();
        long totalTimeLinkedList = stopTimeLinkedList - startTimeLinkedList;
        
        Long[] totalTime = {totalTimeArrayList, totalTimeLinkedList}; 
 
        return totalTime;
    }
    
    public Long[] timeSortOfSortedList(int numberOfItems, int seed){
        ArrayListDoubleContainer arrayList  = new ArrayListDoubleContainer();               //initialize arrayList
        LinkedListDoubleContainer linkedList = new LinkedListDoubleContainer();             //initialize linkedList
        Random random1 =  new Random(seed);                                                 //initialize 2 similar random generators 
        Random random2 =  new Random(seed);
        
        for (int i =0; i < numberOfItems; i++){ 
            double num = random1.nextDouble();                  //generate and add random numbers to the arrayLIst
            arrayList.addToBack(num);            
        }
        arrayList.selectionSort();                              //sort
        long startTimeArrayList = System.nanoTime();   
        arrayList.selectionSort();                              //resort
        long stopTimeArrayList = System.nanoTime();
        long totalTimeArrayList = stopTimeArrayList - startTimeArrayList; 
        
        
        for (int i =0; i < numberOfItems; i++){ 
            double num = random2.nextDouble();                  //generate and add random numbers to the linkedList
            linkedList.addToBack(num);
        }
        linkedList.selectionSort();                             //sort
        long startTimeLinkedList = System.nanoTime();           
        linkedList.selectionSort();                             //resort
        long stopTimeLinkedList = System.nanoTime();
        long totalTimeLinkedList = stopTimeLinkedList - startTimeLinkedList;
        
        Long[] totalTime = {totalTimeArrayList, totalTimeLinkedList}; 
      
        return totalTime;
    }
    
    public Long[] timeLinearSearch(int numberOfItems, int seed, double findIt){
        ArrayListDoubleContainer arrayList  = new ArrayListDoubleContainer();               //initialize arrayList
        LinkedListDoubleContainer linkedList = new LinkedListDoubleContainer();             //initialize linkedList
        Random random1 =  new Random(seed);                                                 //initialize 2 similar random generators 
        Random random2 =  new Random(seed);
        
        for (int i =0; i < numberOfItems; i++){                   //generate and add random numbers to the arrayLIst
            arrayList.addToBack(random1.nextDouble());            
        }
        arrayList.selectionSort();
        long startTimeArrayList = System.nanoTime();   
        arrayList.linearSearch(findIt);                           //search and record search time
        long stopTimeArrayList = System.nanoTime();
        long totalTimeArrayList = stopTimeArrayList - startTimeArrayList; 
        
        
        for (int i =0; i < numberOfItems; i++){               //generate and add random numbers to the linkedList
            linkedList.addToBack(random2.nextDouble());
        }
        linkedList.selectionSort();
        long startTimeLinkedList = System.nanoTime();
        linkedList.linearSearch(findIt);                     //search and record search time
        long stopTimeLinkedList = System.nanoTime();
        long totalTimeLinkedList = stopTimeLinkedList - startTimeLinkedList;
        
        Long[] totalTime = {totalTimeArrayList, totalTimeLinkedList}; 
        
        return totalTime;
    }    
    
    public Long[] timeBinarySearch(int numberOfItems, int seed, double findIt){
        ArrayListDoubleContainer arrayList  = new ArrayListDoubleContainer();               //initialize arrayList
        LinkedListDoubleContainer linkedList = new LinkedListDoubleContainer();             //initialize linkedList
        Random random1 =  new Random(seed);                                                 //initialize 2 similar random generators 
        Random random2 =  new Random(seed);
        
        
        for (int i =0; i < numberOfItems; i++){                 //generate and add random numbers to the arrayLIst
            arrayList.addToBack(random1.nextDouble());            
        }
        arrayList.selectionSort();
        long startTimeArrayList = System.nanoTime();   
        arrayList.binarySearch(findIt);                         //search and record search time
        long stopTimeArrayList = System.nanoTime();
        long totalTimeArrayList = stopTimeArrayList - startTimeArrayList; 
        
        
        for (int i =0; i < numberOfItems; i++){                  //generate and add random numbers to the linkedList
            linkedList.addToBack(random2.nextDouble());
        }
        linkedList.selectionSort();
        long startTimeLinkedList = System.nanoTime();
        linkedList.binarySearch(findIt);                         //search and record search time
        long stopTimeLinkedList = System.nanoTime();
        long totalTimeLinkedList = stopTimeLinkedList - startTimeLinkedList;
        
        Long[] totalTime = {totalTimeArrayList, totalTimeLinkedList}; 
        
        return totalTime;
    }   
}
