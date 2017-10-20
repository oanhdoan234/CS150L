import java.lang.*;
import java.util.*;

public class BinarySearchTree extends BinaryTree<Double> implements Tree<Double>
{   
    
    public BinarySearchTree(BinaryNode<Double> rt){
        super(rt);
    }
    
    public static void main(String args[]){
        BinarySearchTree tree1 = new BinarySearchTree(null);
        BinarySearchTree tree2 = new BinarySearchTree(new BinaryNode((Double) 100.0));
        BinarySearchTree tree3 = new BinarySearchTree(new BinaryNode(100.0));
        BinarySearchTree tree4 = new BinarySearchTree(new BinaryNode(100.0)); 
        
        Double[] nodes = {99.0,105.0,23.0,126.0,113.0,117.0,15.0,46.0,85.0,345.0,102.0};
        for (int i = 0; i<nodes.length; i++){
            if(i < 2) tree3.insert(nodes[i]);
            tree4.insert(nodes[i]);
        }
        
        ArrayList<BinarySearchTree> trees = new ArrayList<BinarySearchTree>();
        trees.add(tree1);
        trees.add(tree2);
        trees.add(tree3);
        trees.add(tree4);
        for (int i = 0; i < trees.size(); i++){
            System.out.println("Traversal of tree" + (int)(i+1));
            
            System.out.print("Preorder: ");
            trees.get(i).printPreOrder();
            System.out.print("\n");
            
            System.out.print("Postorder: ");
            trees.get(i).printPostOrder();
            System.out.print("\n");
            
            System.out.print("Inorder: ");
            trees.get(i).printInOrder();
            System.out.println("\n");
        }
    }
   
    /** contain */
    public boolean contains(Double e){return containsR(this.rt, e);}
    public boolean remove(Double e){
        boolean b = removeR(this.rt,this.rt, e);
        if (b) this.size--;
        return b;
    }
    public boolean insert(Double e){
        boolean b = insertR(this.rt, this.rt, e);
        if (b) this.size++;
        return b;
    }
    public Double findMax(){return findMaxR(this.rt);}
    public Double findMin(){return findMinR(this.rt);}
    
    public boolean containsR(BinaryNode<Double> rt, Double e){
        if(rt == null) return false;
        if (rt.value().compareTo(e) > 0){
            return containsR(rt.left(), e);
        } else if (rt.value().compareTo(e) < 0){
            return containsR(rt.right(),e);
        }
        return true;
    }
    
    public Double findMaxR(BinaryNode<Double> rt){
       if (rt == null) return null; 
       if (rt.right() == null) return (Double) rt.value();
       return findMaxR(rt.right());
    }
    
    public Double findMinR(BinaryNode<Double> rt){
        if (rt == null) return null;
        if (rt.left() == null) return (Double) rt.value();
        return findMinR(rt.left());
    }
    
    public boolean insertR(BinaryNode<Double> parent, BinaryNode<Double> rt,Double e){
        if (rt == null) {
            rt =  new BinaryNode(e);
            if (parent.value().compareTo(e) < 0) parent.setRight(rt);
            else parent.setLeft(rt);
            return true;
        }
        if (rt.value().compareTo(e) < 0) return insertR(rt,rt.right(),e);
        if (rt.value().compareTo(e) > 0) return insertR(rt,rt.left(),e);
        return false;
    }
    
    public boolean removeR(BinaryNode<Double> parent, BinaryNode<Double> rt, Double e) {
        if (rt == null) return false;                                               
        if (rt.value() < e) return removeR(rt, rt.right(), e);                      //if e is greater than value of rt, search from the right side
        if (rt.value() > e) return removeR(rt, rt.left(), e);                       //if e is greater than value of rt, search from the left side
          
        if (rt.left() == null) {                                    //internal node with a nonempty right child
            if (rt == parent){
                this.rt = this.rt.right();
            } else if (rt == parent.left()) {
                parent.setLeft(rt.right());
            }else {
                parent.setRight(rt.right());
            }
        } else if (rt.right() == null) {                            //an internal node with a nonempty left child
            if (rt == parent){
                this.rt = this.rt.left();
            } else if (rt == parent.left()) {                          //remove the node by setting the node's left child to be the child of its parent
                parent.setLeft(rt.left());
            } else {
                parent.setRight(rt.left());
            }
        } else {                                                    //an internal node with 2 non-empty children
            Double successValue = findMinR(rt.right());              
            rt.setValue(successValue);                              //replace it with the smallest node in the right subtree with this node 
            return removeR(rt, rt.right(), successValue);           //being the root of the tree
        }
        
        return true;
    }

  
}
