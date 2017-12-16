public interface Tree<E>
{
    
    abstract public boolean insert(E e);
    abstract public boolean contains(E e);
    abstract public int size();
    abstract public boolean remove(E e);
    abstract public E findMax();
    abstract public E findMin();
    abstract public void printPreOrder();
    abstract public void printPostOrder();
    abstract public void printInOrder();
    abstract public void empty();
    abstract public boolean isEmpty();
}
