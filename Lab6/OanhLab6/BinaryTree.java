
/**
 * Abstract class BinaryTree - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class BinaryTree<E> implements Tree<E>
{   
    protected BinaryNode<E> rt; 
    protected int size;
    
    public BinaryTree(BinaryNode<E> rt){
        this.rt = rt;
        if (rt == null) this.size = 0;                          //an empty tree has size 0
        else this.size = 1;                                     //a nonempty tree starts with size 1
    }
    
    public void printPreOrder(){printPreOrderR(this.rt);}
    public void printPostOrder(){printPostOrderR(this.rt);}
    public void printInOrder(){printInOrderR(this.rt);}
    
    public void printPreOrderR(BinaryNode<E> root){
        if(root == null) return;                                        //do nothing if root is an empty node
        System.out.print(root.value() + " ");                           //print value of node root
        printPreOrderR(root.left());                                    //process all nodes in left
        printPreOrderR(root.right());                                   //process all nodes in right
    }
    
    public void printPostOrderR(BinaryNode<E> root){
        if(root == null) return;                                        //do nothing if root is an empty node
        printPostOrderR(root.left());                                   //process all nodes in left
        printPostOrderR(root.right());                                  //process all nodes in right
        System.out.print(root.value() + " ");                           //print value of node root
    }
    
    public void printInOrderR(BinaryNode<E> root){
        if(root == null) return;                                        //do nothing if root is an empty node
        printInOrderR(root.left());                                     //process all nodes in left
        System.out.print(root.value() + " ");                           //process all nodes in right
        printInOrderR(root.right());                                    //print value of node root
    }
    
    public boolean isEmpty(){return this.rt ==null && this.size == 0;}      
    public int size(){return size;}                                         
    public BinaryNode<E> root(){return rt;}                                 
    public void empty(){                                //erase root
        this.rt = null; 
        this.size = 0;
    }
    
    //abstract classes that need further implementation
    public abstract boolean insert(E e);
    public abstract boolean contains(E e); 
    public abstract boolean remove(E e);
    public abstract E findMax();
    public abstract E findMin();
    
    
    
    
}
