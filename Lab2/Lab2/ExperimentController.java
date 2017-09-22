import java.util.*;
import java.io.PrintWriter;
public class ExperimentController
{
    
    public static void main(String[] args){
        ExperimentController c = new ExperimentController();
        int[] numberOfItems = {5000,10000,15000,20000,25000,30000,35000,40000,45000,50000};            //input sizes 
        int[] seeds = {88087987,230451996,450908389};                                                  //seeds to ensure randomness 
        long timeAddToFrontAvg;
        long timeAddToBackAvg;
        long timeAddSortedAvg;
        long timeSortofUnsortedListAvg;
        long timeSortOfSortedListAvg;
                
        try{ 
            PrintWriter p = new PrintWriter("output2.csv");
            p.write("numberOfTimes,Method,totalTime\n");
            for (int i = 0; i < numberOfItems.length; i++){                         //test different input sizes
                long timeAddToFrontTot = 0;                                         //total run time of each method on a single dataset 
                long timeAddToBackTot = 0;
                long timeAddSortedTot = 0;
                long timeSortofUnsortedListTot = 0;
                long timeSortOfSortedListTot = 0;
                for (int j = 0; j < seeds.length; j++){                             //for each input size, try 3 different seeds
                    timeAddToFrontTot = timeAddToFrontTot + c.timeAddToFront(numberOfItems[i],seeds[j]);    //add run time of each trial to total
                    timeAddToBackTot  = timeAddToBackTot + c.timeAddToBack(numberOfItems[i],seeds[j]);
                    timeAddSortedTot = timeAddSortedTot + c.timeAddSorted(numberOfItems[i],seeds[j]);
                    timeSortofUnsortedListTot = timeSortofUnsortedListTot + c.timeSortofUnsortedList(numberOfItems[i],seeds[j]);
                    timeSortOfSortedListTot = timeSortOfSortedListTot + c.timeSortOfSortedList(numberOfItems[i],seeds[j]); 
                }
                timeAddToFrontAvg = timeAddToFrontTot/seeds.length;                 //average run time of 3 trials 
                timeAddToBackAvg = timeAddToBackTot/seeds.length; 
                timeAddSortedAvg = timeAddSortedTot/seeds.length; 
                timeSortofUnsortedListAvg = timeSortofUnsortedListTot/seeds.length; 
                timeSortOfSortedListAvg = timeSortOfSortedListTot/seeds.length; 
                p.write(numberOfItems[i] + "," + "AddToFront," + timeAddToFrontAvg + "\n");         //write the average to output file
                p.write(numberOfItems[i] + "," + "AddToBack," + timeAddToBackAvg + "\n");
                p.write(numberOfItems[i] + "," + "AddSorted," + timeAddSortedAvg + "\n");
                p.write(numberOfItems[i] + "," + "SortOfUnsortedList," + timeSortofUnsortedListAvg + "\n");
                p.write(numberOfItems[i] + "," + "SoftOfSortedList," + timeSortOfSortedListAvg + "\n");
                System.out.println(i);
            }
            p.close();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        
        
    }
    
    //record time to add numbers to AddToFront
    public long timeAddToFront(int numberOfItems, int seed){
        RandomDoubleContainer r  = new RandomDoubleContainer();
        Random random =  new Random(seed);                      
        long startTime = System.currentTimeMillis();                     //start the clock
        for (int i =0; i < numberOfItems; i++){                          //generate and add random numbers to the arrayLIst
            r.addToFront(random.nextDouble());
        }
        long stopTime = System.currentTimeMillis();                      //stop the clock
        long totalTime = stopTime - startTime;                           //calculate time difference
        return totalTime; 
    }
    
    //record time to add numbers to AddToBack 
    public long timeAddToBack(int numberOfItems, int seed){
        RandomDoubleContainer r  = new RandomDoubleContainer();
        Random random =  new Random(seed);
        long startTime = System.currentTimeMillis();
        for (int i =0; i < numberOfItems; i++){
            r.addToBack(random.nextDouble());
        }
        long stopTime = System.currentTimeMillis();
        long totalTime = stopTime - startTime; 
        return totalTime; 
    }
    
    //record time to add numbers to AddSorted 
    public long timeAddSorted(int numberOfItems, int seed){
        RandomDoubleContainer r  = new RandomDoubleContainer();
        Random random =  new Random(seed);
        long startTime = System.currentTimeMillis();
        for (int i =0; i < numberOfItems; i++){
            r.addSorted(random.nextDouble());
        }
        long stopTime = System.currentTimeMillis();
        long totalTime = stopTime - startTime; 
        return totalTime; 
    }
    
    //record time to sort an unsorted list 
    public long timeSortofUnsortedList(int numberOfItems, int seed){
        RandomDoubleContainer r =  new RandomDoubleContainer();
        Random random = new Random(seed); 
        for (int i =0; i < numberOfItems; i++){                             //create a random unsorted list
            r.addToBack(random.nextDouble());
        }
        long startTime = System.currentTimeMillis();                        //start the clock
        r.selectionSort();                                                  //sort
        long stopTime = System.currentTimeMillis();                         //stop the clock
        long totalTime = stopTime - startTime;                              //calculate time difference
        return totalTime;
    }
    
    //record time to sort a sorted list
    public long timeSortOfSortedList(int numberOfItems, int seed){
        RandomDoubleContainer r = new RandomDoubleContainer(); 
        Random random = new Random(seed); 
        for (int i =0; i < numberOfItems; i++){                             //create a random unsorted list
            r.addToBack(random.nextDouble());                               
        }
        r.selectionSort();                                                  //sort 
        long startTime = System.currentTimeMillis();                        //start the clock
        r.selectionSort();                                                  //re-sort
        long stopTime = System.currentTimeMillis();                         //stop the clock
        long totalTime = stopTime - startTime;                              //calculate time difference
        return totalTime;
    }
    
}
