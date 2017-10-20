
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
        if (rt == null) this.size = 0;
        else this.size = 1;
    }
    
    public void printPreOrder(){printPreOrderR(this.rt);}
    public void printPostOrder(){printPostOrderR(this.rt);}
    public void printInOrder(){printInOrderR(this.rt);}
    
    public void printPreOrderR(BinaryNode<E> root){
        if(root == null) return; 
        System.out.print(root.value() + " ");
        printPreOrderR(root.left());
        printPreOrderR(root.right());
    }
    
    public void printPostOrderR(BinaryNode<E> root){
        if(root == null) return; 
        printPostOrderR(root.left());
        printPostOrderR(root.right());
        System.out.print(root.value() + " ");
    }
    
    public void printInOrderR(BinaryNode<E> root){
        if(root == null) return; 
        printPreOrderR(root.left());
        System.out.print(root.value() + " ");
        printInOrderR(root.right());
    }
    
    public boolean isEmpty(){return this.rt ==null && this.size == 0;}
    public BinaryNode<E> root(){return rt;}
    public abstract boolean insert(E e);
    public abstract boolean contains(E e); 
    public int size(){return size;}
    public abstract boolean remove(E e);
    public abstract E findMax();
    public abstract E findMin();
    public void empty(){
        this.rt = null; 
        this.size = 0;
    }
    
    
    
}
