import java.util.*;

public class MyBookList implements Iterable<MyBook>
{
    private BNode head; 
    
    public MyBookList(){
        this.head = new BNode(null);
       
    }
    
    public static void main(String args[]){
        MyBookList list = new MyBookList();
        MyBook b1 = new MyBook("Chun Wai Liew", "Java");
        MyBook b2 = new MyBook("Oanh Doan", "Java");
        MyBook b3 = new MyBook("Chun Wai Liew", "AbC");
        list.add(b1);
        list.add(b2);
        System.out.println("Add third item");
        list.add(b3); 
        
        BNode head = list.getHead(); 
        BNode firstNode = head.getNext(); 
        BNode secondNode = firstNode.getNext();
        //BNode thirdNode = secondNode.getNext(); 
        //BNode forthNode = thirdNode.getNext();
        
        firstNode.getMyBook().print();
        secondNode.getMyBook().print();
        
        
        System.out.println(secondNode.getNext() == list.getHead());
        System.out.println(list.getHead().getPrev() == secondNode);
        
    }
    
    /** Add a book to list */
    public void add(MyBook b){
        BNode newNode = new BNode(b);                       //create a node to hold the book
        String lastName = b.getLastName();                  //get last name of book's author
         
        if (head.getNext() == null){                        //List is empty - add 1st element
            System.out.println("Hello add first book");
            head.setNext(newNode);
            newNode.setNext(head);
            newNode.setPrev(head);
        }
        
        MyBookListIterator i = this.iterator(); 
        while(i.hasNext() ){                                //list is non-empty - add the book in the middle of the list
            BNode thisNode = i.nextNode();                  //get each book 
            
            if (thisNode.getMyBook().getLastName().compareTo(lastName) >0){             //compare authors' last names 
            
                    //System.out.println("One more");
                    BNode prevNode = thisNode.getPrev();                        
                    prevNode.setNext(newNode);
                    newNode.setPrev(prevNode);
                    newNode.setNext(thisNode);
                    thisNode.setPrev(newNode);

            }
            return;
        }
        
        //add to the end of list
            BNode lastNode =  this.head.getPrev();
            lastNode.setNext(newNode);
            newNode.setPrev(lastNode);
            newNode.setNext(this.head);
            this.head.setPrev(newNode); 
        
    }
    
    /** Find all books of the same author and add them to an array list */
    public ArrayList<MyBook> find(String author){
        ArrayList<MyBook> sameAuthor = new ArrayList<MyBook>();             //create empty list
        MyBookListIterator i = this.iterator();                             //iterate through list
        while(i.hasNext()){
            BNode thisNode = i.nextNode();  
            if (thisNode.getAuthor().compareTo(author) == 0){               //compare authors' names
                sameAuthor.add(thisNode.getMyBook());                       //add to list 
            }
        }
        return new ArrayList<MyBook>();
    }
    
    /** create list iterator */
    public MyBookListIterator iterator(){
        return new MyBookListIterator(this);                               
    }
    
    public BNode getHead(){return head;}
    
    
}

