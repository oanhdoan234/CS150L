
/**
 * Write a description of class BinaryNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BinaryNode<E>
{
    private E value;
    private BinaryNode left;
    private BinaryNode right; 
    public BinaryNode(E value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
    
    public void setLeft(BinaryNode<E> left){this.left = left;}
    public void setRight(BinaryNode<E> right){this.right = right;}
    public void setValue(E e){this.value = e;}
    public BinaryNode left(){ return left;}
    public BinaryNode right(){return right;}
    public E value(){return value;}
    
   
}
