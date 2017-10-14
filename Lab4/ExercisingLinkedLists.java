
public class ExercisingLinkedLists
{
    public static void main(String[] args) {
       MyLinkedList<Double> big   = new MyLinkedList<Double>();                  //list of 10 elements
       MyLinkedList<Double> small = new MyLinkedList<Double>();                  //list of 1 element
       MyLinkedList<Double> empty = new MyLinkedList<Double>();                  //empty 
       
       //iterator
       MyLinkedListIterator<Double> bigIterator   = (MyLinkedListIterator<Double>) big.iterator(); 
       MyLinkedListIterator<Double> smallIterator = (MyLinkedListIterator<Double>) small.iterator(); 
       MyLinkedListIterator<Double> emptyIterator = (MyLinkedListIterator<Double>) empty.iterator(); 
       
       Double[] data = {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0};
       
       //addFirst & addLast
       System.out.println("Demonstrate addFirst() and addLast()");
       for (int i = 0; i < data.length; i++){
           big.addFirst(data[i]); 
       }
       small.addLast(1.0);
       
       System.out.println("Big, small, and empty lists are: ");
       big.toString();
       small.toString();
       empty.toString();
     
       //remove 
       System.out.println("\nDemonstrate remove() \nWe remove the last element of big list, first element of small list, and an out-of-range "
       + "element from the empty list.");
       big.remove(9);
       small.remove(0); 
       empty.remove(5);
       big.toString();
       small.toString();
       empty.toString();
       
       //add removed elements back to the list to continue with other methods 
       big.addLast(1.0); 
       small.addLast(1.0); 
       
       //getELement
       System.out.println("\nWe add back the removed elements to the list before moving on. The lists are now as follow:");
       big.toString();
       small.toString();
       empty.toString();
       System.out.println("\nDemonstrate getElement()");
       System.out.println("The 9th element of big list is " + big.getElement(9)); 
       System.out.println("The 1st element of small list is " + small.getElement(0)); 
       System.out.println("The 3th element of empty list is " + empty.getElement(4)); 
       
       //hasNext & next
       System.out.println("\nDemonstrate hasNext() and next()\nBig list:");
       for (int i = 0; i <= big.size(); i++){
           System.out.println(bigIterator.hasNext() + " Next element is " + bigIterator.next());
        }       
       System.out.println("\nSmall list:");
       System.out.println(smallIterator.hasNext() + " Next element is " + smallIterator.next());
       System.out.println(smallIterator.hasNext() + " Next element is " + smallIterator.next());
       System.out.println("\nEmpty list:");
       System.out.println(emptyIterator.hasNext() + " Next element is " + emptyIterator.next());
        
   }
}

