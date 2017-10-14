import java.io.PrintWriter;

public class ExperimentController
{
    public static void main(String[] args){
        //Compare search time for an element with and without iterator 
        ExperimentController c = new ExperimentController(); 
        try{
            PrintWriter w = new PrintWriter("searchForValue.csv");
            w.write("Value,Index,WithIterator, WithoutIterator\n");
            //first run to initialize the computer - explained in report 
            w.write(4.0 + "," + 0 + "," + c.timeSearchWithIterator(4.0) + ","  + c.timeSearchWithoutIterator(4.0) + "\n");
            //run 5 times for each searching value 
            for (int i = 0; i < 5; i++){
                w.write(4.0 + "," + 0 + "," + c.timeSearchWithIterator(4.0) + "," + c.timeSearchWithoutIterator(4.0) + "\n");
                w.write( 15.0 + "," + 4 + "," + c.timeSearchWithIterator(15.0) + "," + c.timeSearchWithoutIterator(15.0) + "\n");
                w.write( 10.0 + "," + 9 + "," + c.timeSearchWithIterator(10.0) + "," + c.timeSearchWithoutIterator(10.0) + "\n");
            }
            w.close();
        } catch (Exception e){
            System.out.println(e);
        }
        
        //Compare search time by index of Array and LinkedList 
        Double[] data1 = new Double[100000];                                    //array of different sizes
        Double[] data2 = new Double[5000];
        Double[] data3 = {4.0}; 
        for (int i = 0; i < data1.length; i++){
            if (i <data2.length){
                data2[i] = (double) i;
            }
            data1[i] = (double) i;
        }
        
        MyLinkedList<Double> list1 = new MyLinkedList<Double>();               //linked lists of different sizes
        MyLinkedList<Double> list2 = new MyLinkedList<Double>();
        MyLinkedList<Double> list3 = new MyLinkedList<Double>();
        
        
        for (int i = 0; i < data1.length; i++){                                 //add elements from array to linked list
            list1.addLast(data1[i]);
        }
        
        for (int i = 0; i < data2.length; i++){
            list2.addLast(data2[i]);
        }
        
        list3.addLast(data3[0]);
        
        int[] indices1 = {0,49999,99999};                                       //indices to be searched for, corresponding to the array and list
        int[] indices2 = {0,2499,4999};                                         //eg. data1 - list1 - indices1
        int[] indices3 = {0,3};
        
        try{
            PrintWriter p = new PrintWriter("searchByIndex.csv");
            p.write("data structure,input size,index,time\n");
            //first run to initialize the computer - explained in report 
            p.write("linkedList," + data1.length + "," + 0 + "," + c.timeSearchByIdxLinkedList(list1,0) + "\n");
            p.write("Array," + data1.length + "," + 0 + "," + c.timeSearchByIdxArray(data1,0) + "\n");
            
            //search from array data1 and list1
            for (int i = 0; i < indices1.length; i++){
                //for each search, run 5 times 
                for (int j = 0; j <5; j++){
                    p.write("linkedList," + data1.length + "," + indices1[i] + "," + c.timeSearchByIdxLinkedList(list1,indices1[i]) + "\n");
                    p.write("Array," + data1.length + "," + indices1[i] + "," + c.timeSearchByIdxArray(data1,indices1[i]) + "\n");
                }
            }
            
            //search from array data2 and list2
            for (int i = 0; i < indices2.length; i++){
                //for each search, run 5 times 
                for (int j = 0; j <5; j++){
                    p.write("linkedList," + data2.length + "," + indices2[i] + "," + c.timeSearchByIdxLinkedList(list2,indices2[i]) + "\n");
                    p.write("Array," + data2.length + "," + indices2[i] + "," + c.timeSearchByIdxArray(data2,indices2[i]) + "\n");
                }
            }
            
            //search from array data3 and list3
            for (int i = 0; i < indices3.length; i++){
                //for each search, run 5 times 
                for (int j = 0; j <5; j++){
                    p.write("linkedList," + data3.length + "," + indices3[i] + "," + c.timeSearchByIdxLinkedList(list3,indices3[i]) + "\n");
                    p.write("Array,"      + data3.length + "," + indices3[i] + "," + c.timeSearchByIdxArray(data3,indices3[i]) + "\n");
                }
            }
            p.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public long timeSearchWithIterator(double e){
        MyListDoubleContainer container = new MyListDoubleContainer();                          //create data
        Double[] data = {4.0,23.0,5.0,96.0,15.0,1.0,84.0,46.0,22.0,10.0};
        for (int i = 0; i < data.length; i++){
                container.addToBack(data[i]);                         
        }
        
        long startTime = System.nanoTime();                     //search and record time
        container.searchWithIterator(e);
        long endTime = System.nanoTime();
        long totalTime = endTime-startTime;
        
        container.toString();
        return totalTime;
    }
    
    
    public long timeSearchWithoutIterator(double e){
        MyListDoubleContainer container = new MyListDoubleContainer();                          //create data
        Double[] data = {4.0,23.0,5.0,96.0,15.0,1.0,84.0,46.0,22.0,10.0};
        for (int i = 0; i < data.length; i++){
                container.addToBack(data[i]);                                   
        }
         
        long startTime = System.nanoTime();                         //search and record time
        container.searchWithIterator(e);
        long endTime = System.nanoTime();
        long totalTime = endTime-startTime;
        
        container.toString();
        return totalTime;
    }
    
    public long timeSearchByIdxLinkedList(MyLinkedList<Double> list, int index){       //search by index from a given list
        long startTime =  System.nanoTime();
        list.getElement(index);
        long endTime = System.nanoTime(); 
        long totalTime = endTime - startTime; 
        return totalTime;
    }
    
    public long timeSearchByIdxArray(Double[] array, int index){                        //search by index from a given array
        long startTime = System.nanoTime();
        if (index < array.length){
             double findIt = array[index];
        } 
        long endTime = System.nanoTime(); 
        long totalTime = endTime - startTime;
        return totalTime; 
    }
}
