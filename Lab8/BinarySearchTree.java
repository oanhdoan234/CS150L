public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {
    
    public BinarySearchTree (E e){
        super(e);
        this.root = super.root;
    }
    
    public BinaryNode<E> getRoot(){
        return root;
    }
    
    public E findMax() {return findMaxR(this.root);}
    
    public E findMin() {return findMinR(this.root);}
   
    public boolean contains(E e) {
        BinaryNode<E> c = this.root;
        if (c == null) {return false;}
        else 
        {
            while (c !=null)
            {
                switch ((c.getValue()).compareTo(e)) 
                {
                    case 0: return true;
                    case -1: c = c.rightChild;
                            break;
                    case 1: c = c.leftChild;
                            break;
                    default: return false;
                }
            }
            return false;
        }
    }
    
   public boolean insert(E e) {
        BinaryNode<E> c = this.root;
        BinaryNode<E> parent = this.root;
        if (this.contains(e) || (this.isEmpty())) {
            return false;
        }
        else {
           while (c!=null) {
               parent = c;
               if (c.getValue().compareTo(e)<0) {
                   c = c.rightChild;
                }
                else {
                    c = c.getLeftChild();
                }
            }
            //reached leaf to insert node into
            BinaryNode<E> n = new BinaryNode<E>(e);
            if ((parent.getValue().compareTo(e))>0) {
                parent.setLeftChild(n);
            }
            else {
                parent.setRightChild(n);
            }
            this.size++;
        }
        return true;
    }
    
    boolean isLeaf(BinaryNode<E> bnode){
        if (bnode != null) {
            if ((bnode.getLeftChild().equals(null)) && (bnode.getRightChild().equals(null))) {
                return true;
            }
        }
        return false;
    }
    
    public boolean remove(E e){
        boolean b = removeR(this.root,this.root, e);                                            //remove e if found
        if (b) this.size--;                                                                 //decrease size if e is removed
        return b;
    }
    
    public boolean removeR(BinaryNode<E> parent, BinaryNode<E> rt, E e) {
        if (rt == null) return false;                                               
        if (rt.getValue().compareTo(e) < 0) return removeR(rt, rt.getRightChild(), e);                      //if e is greater than value of rt, search from the right side
        if (rt.getValue().compareTo(e) > 0) return removeR(rt, rt.getLeftChild(), e);                       //if e is greater than value of rt, search from the left side
          
        if (rt.getLeftChild() == null) {                                    //leaf node or internal node with a nonempty right child
            if (rt == parent){                                              //if remove tree root, set its right child as the new root
                this.root = this.root.getRightChild();
            } else if (rt == parent.getLeftChild()) {                               //root is its parent left's child 
                parent.setLeftChild(rt.getRightChild());                                 //remove connection between parent and root 
            }else {
                parent.setRightChild(rt.getRightChild());                                //root is its parent's right child
            }
        } else if (rt.getRightChild() == null) {                            //internal node with a nonempty left child
            if (rt == parent){                                              //if remove tree root, set its left child as the new root
                this.root = this.root.getLeftChild();
            } else if (rt == parent.getLeftChild()) {                               //root is its parent left child
                parent.setLeftChild(rt.getLeftChild());
            } else {                                                        //root is its parent right child
                parent.setRightChild(rt.getLeftChild());
            }
        } else {                                                    //an internal node with 2 non-empty children
            E successValue = findMinR(rt.getRightChild());              
            rt.setValue(successValue);                              //replace it with the smallest node in the right subtree with this node 
            return removeR(rt, rt.getRightChild(), successValue);           //being the root of the tree
        }
        
        return true;
    }

    public E findMinR(BinaryNode<E> rt){
        if (rt == null) return null;                                                       //empty - do nothing
        if (rt.getLeftChild() == null) return rt.getValue();                                 //go to the furtherest left node
        return findMinR(rt.getLeftChild());
    }
    
    public E findMaxR(BinaryNode<E> rt){
       if (rt == null) return null;                                                        //empty - do nothing
       if (rt.getRightChild() == null) return rt.getValue();                                  //go to the futherest right node
       return findMaxR(rt.getRightChild());
    }
}
