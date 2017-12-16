import java.util.*;

public class SimulationBookList
{   
    /** simulate find method in MyBookList */
    public static void main(String[] args){
        
        MyBookList list = new MyBookList();                                     //create a list, books and add books
        MyBook b1 = new MyBook("Chun Wai Liew", "Java");
        MyBook b2 = new MyBook("Chun Wai Liew", "C++");
        MyBook b3 = new MyBook("Chun Wai Liew", "Python");
        MyBook b4 = new MyBook("Jeff Lieb", "Stats");
        MyBook b5 = new MyBook("Elisa Wilson", "abc"); 
        
        list.add(b1);
        list.add(b5);
        list.add(b4);
        list.add(b2);
        list.add(b3); 
        
        ArrayList<MyBook> findOneMatch = list.find("Elisa Wilson");                 //find 
        ArrayList<MyBook> findMultipleMatch = list.find("Chun Wai Liew");
        ArrayList<MyBook> findNoMatch = list.find("Oanh Doan");
        
        for (int i = 0; i<findOneMatch.size(); i++){                                //print lists
            findOneMatch.get(i).print();
        }
        
        for (int i = 0; i<findMultipleMatch.size(); i++){
            findMultipleMatch.get(i).print();
        }
        
        for (int i = 0; i <findNoMatch.size(); i++){
            findNoMatch.get(i).print();
        }
    }
}
