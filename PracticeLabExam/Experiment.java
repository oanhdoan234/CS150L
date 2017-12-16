import java.util.*;

public class Experiment
{
    public static void main(String args[]){
        /** create a Dict object
         * Add 10 key, value pairs 
           */
        Experiment exp = new Experiment();
        Dict dict = new Dict();
        dict.add("a","ac");
        dict.add("b","bb");
        dict.add("c","cc");
        dict.add("d","dd");
        dict.add("e","ee");
        dict.add("f","ff");
        dict.add("g","gg");
        dict.add("h","hh");
        dict.add("a","aa");
        dict.add("a","dsa");
        dict.add("a","ab");
        
        /** use find to print the values corresponding to 4 different keys including one that does not match anything.*/
        ArrayList<String> findOfAA = dict.find("a");
        exp.printArrayList(findOfAA);
        
        ArrayList<String> findOfbb = dict.find("bb");
        exp.printArrayList(findOfbb);
    }
    
    
    public void printArrayList(ArrayList<String>  list){
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }
}
