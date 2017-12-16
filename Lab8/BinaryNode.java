public class BinaryNode<E> 
{
    
    protected BinaryNode<E> rightChild;
    protected BinaryNode<E> leftChild;
    protected BinaryNode<E> parent;
    protected E value;
    
    public BinaryNode(E e) {   //constructor
        this.rightChild = null;
        this.leftChild = null;
        this.parent = null;
        this.value = e;
    }
        

    public void setValue(E e){
        this.value = e;
    }
    
    public E getValue(){
        return this.value;
    }
    
    public void setLeftChild(BinaryNode<E> n){
        this.leftChild = n;
    }
    
    public void setRightChild(BinaryNode<E> n){
        this.rightChild = n;
    }
    
    public BinaryNode<E> getRightChild(){
        return this.rightChild;
    }
    
    public BinaryNode<E> getLeftChild() {
        return this.leftChild;
    }
}
