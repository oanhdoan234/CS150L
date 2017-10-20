
/**
 * Write a description of interface Tree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Tree<E>
{
    public abstract boolean insert(E e);
    public abstract boolean contains(E e); 
    public abstract int size();
    public abstract boolean remove(E e);
    public abstract E findMax();
    public abstract E findMin();
    public abstract void printPreOrder();
    public abstract void printPostOrder();
    public abstract void printInOrder();
    public abstract void empty();
    public abstract boolean isEmpty(); 
}
