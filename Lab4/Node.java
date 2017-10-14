public class Node<E>
{
    private E e;                        //element
    private Node<E> next;               //pointer to next node
    
    public Node(E e, Node<E> next){                         //Constructor 1
        this.e = e;
        this.next = next;
    }
    
    public Node(Node<E> next){                              //Constructor 2
        this.e = null; 
        this.next= next;
    }
    
    public E getElement(){                                  
        return e;
    }
    
    public E setElement(E it){
        e = it; 
        return e;
    }
    
    public Node<E> next(){
        return next;
    }
    
    public Node<E> setNext(Node<E> nextNode){
        next = nextNode; 
        return next; 
    }
}
