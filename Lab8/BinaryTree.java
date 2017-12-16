import java.io.PrintWriter;
/**
 * Abstract class BinaryTree -
 *
 * @Plotnick 
 * 
 */
public abstract class BinaryTree<E> implements Tree<E>
{
    // instance variables - replace the example below with your own
    protected BinaryNode<E> root;
    protected int size; 
    
    
   public BinaryTree(E e) {
        root = new BinaryNode(e);
        size = 1;
    }
   
   public void printPreOrder() {
        System.out.println();
        preOrder(this.root);
        System.out.println();
    }
    
    public void preOrder(BinaryNode<E> e){
        
        if (e != null) {  //not an empty subtree 
            System.out.print(" " + e.getValue() + " ");
            preOrder(e.getLeftChild());
            preOrder(e.getRightChild());
        }
    }
    
    public void printPostOrder() {
        System.out.println();
        postOrder(this.root);
        System.out.println();
    }
        
    public void postOrder(BinaryNode<E> e) {
        if (e != null) {
            postOrder(e.getLeftChild());
            postOrder(e.getRightChild());
            System.out.print(" " + e.getValue() + " ");
        }
    }
    
    public void printInOrder() {
       System.out.println();
        inOrder(this.root);
        System.out.println();
    }
    
    public void inOrder(BinaryNode<E> e) {
        if (e != null) {
            inOrder(e.getLeftChild());
            System.out.print(" " + e.getValue() + " ");
            inOrder(e.getRightChild());
        }
    }
    
    /** write elements of tree to a file using inOrder */
    public void write(String outfile){
        try{
            PrintWriter w = new PrintWriter(outfile);
            w.write(writeInOrder(this.root));
            w.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    /** toString method of a tree, write in sorted order */
    public String writeInOrder(BinaryNode<E> node){
            if (node == null) return "";
            String output = "";
            output += writeInOrder(node.getLeftChild());
            output += node.getValue().toString();
            output += writeInOrder(node.getRightChild());
            return output;
    }
 
    public void empty() {
        this.root = null;
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return (this.root == null);
        
    }
    
    public int size(){return size;}
    // public int size() {
         // return getSize(this.root);
    // }
    
    public int getSize(BinaryNode<E> e){
            if (e == null) 
        {
             return 0;
        }
        else {
                int count = 1;
                count += getSize(e.getLeftChild());
                count += getSize(e.getRightChild());
                return count;
        }
  
    }
   
   
  }
         
