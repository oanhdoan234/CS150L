import java.lang.*;
import java.util.*;

public class BinarySearchTree extends BinaryTree<Double> implements Tree<Double>
{   
    
    public BinarySearchTree(BinaryNode<Double> rt){
        super(rt);
    }
    
    
    public static void main(String args[]){
        BinarySearchTree tree1 = new BinarySearchTree(null);                                        //empty tree
        BinarySearchTree tree2 = new BinarySearchTree(new BinaryNode<Double>(100.0));               //has one node
        BinarySearchTree tree3 = new BinarySearchTree(new BinaryNode<Double>(100.0));               //has 3 nodes (root and 2 nonempty children)  
        BinarySearchTree tree4 = new BinarySearchTree(new BinaryNode<Double>(100.0));               //has more than 3 nodes
        
        Double[] nodes = {99.0,105.0,23.0,126.0,113.0,117.0,15.0,46.0,85.0,345.0,102.0};            //add nodes to the trees
        for (int i = 0; i<nodes.length; i++){
            if(i < 2) tree3.insert(nodes[i]);
            tree4.insert(nodes[i]);
        }
        
        ArrayList<BinarySearchTree> trees = new ArrayList<BinarySearchTree>();                      //a collection of trees
        trees.add(tree1);
        trees.add(tree2);
        trees.add(tree3);
        trees.add(tree4);
        for (int i = 0; i < trees.size(); i++){                                                     //traverse 
            System.out.println("Traversal of tree" + (int)(i+1));
            
            System.out.print("Preorder: ");                                                         //preorder
            trees.get(i).printPreOrder();
            System.out.print("\n");
            
            System.out.print("Postorder: ");                                                       //postorder     
            trees.get(i).printPostOrder();
            System.out.print("\n");
            
            System.out.print("Inorder: ");                                                          //inorder
            trees.get(i).printInOrder();
            System.out.println("\n");
        }
    }
    
    /** contain */
    public boolean contains(Double e){return containsR(this.rt, e);}
    public boolean remove(Double e){
        boolean b = removeR(this.rt,this.rt, e);                                            //remove e if found
        if (b) this.size--;                                                                 //decrease size if e is removed
        return b;
    }
    public boolean insert(Double e){
        boolean b = insertR(this.rt, this.rt, e);                                          //insert e if not found
        if (b) this.size++;                                                                //increase size if e is inserted
        return b;
    }
    public Double findMax(){return findMaxR(this.rt);}
    public Double findMin(){return findMinR(this.rt);}
    
    public boolean containsR(BinaryNode<Double> rt, Double e){
        if(rt == null) return false;                                                       //empty - do nothing
        if (rt.value().compareTo(e) > 0){                                                  //compare e with left node
            return containsR(rt.left(), e);
        } else if (rt.value().compareTo(e) < 0){                                           //compare e with right node
            return containsR(rt.right(),e);
        }
        return true;
    }
    
    public Double findMaxR(BinaryNode<Double> rt){
       if (rt == null) return null;                                                        //empty - do nothing
       if (rt.right() == null) return (Double) rt.value();                                  //go to the futherest right node
       return findMaxR(rt.right());
    }
    
    public Double findMinR(BinaryNode<Double> rt){
        if (rt == null) return null;                                                       //empty - do nothing
        if (rt.left() == null) return (Double) rt.value();                                 //go to the furtherest left node
        return findMinR(rt.left());
    }
    
    public boolean insertR(BinaryNode<Double> parent, BinaryNode<Double> rt,Double e){
        if (rt == null) {
            BinaryNode<Double> toinsert =  new BinaryNode<Double>(e);                      //create a new node 
            if (parent == rt){                                                             //empty tree - insert new node as tree root
                this.rt = toinsert;
            } else { 
                if (parent.value().compareTo(e) < 0) parent.setRight(toinsert);            //insert to the right          
                else parent.setLeft(toinsert);                                             //insert to the left     
            }
            return true;
        }                                                                                   //search for a position to insert the node
        if (rt.value().compareTo(e) < 0) return insertR(rt,rt.right(),e);                   
        if (rt.value().compareTo(e) > 0) return insertR(rt,rt.left(),e);
        return false;
    }
    
    public boolean removeR(BinaryNode<Double> parent, BinaryNode<Double> rt, Double e) {
        if (rt == null) return false;                                               
        if (rt.value() < e) return removeR(rt, rt.right(), e);                      //if e is greater than value of rt, search from the right side
        if (rt.value() > e) return removeR(rt, rt.left(), e);                       //if e is greater than value of rt, search from the left side
          
        if (rt.left() == null) {                                    //leaf node or internal node with a nonempty right child
            if (rt == parent){                                              //if remove tree root, set its right child as the new root
                this.rt = this.rt.right();
            } else if (rt == parent.left()) {                               //root is its parent left's child 
                parent.setLeft(rt.right());                                 //remove connection between parent and root 
            }else {
                parent.setRight(rt.right());                                //root is its parent's right child
            }
        } else if (rt.right() == null) {                            //internal node with a nonempty left child
            if (rt == parent){                                              //if remove tree root, set its left child as the new root
                this.rt = this.rt.left();
            } else if (rt == parent.left()) {                               //root is its parent left child
                parent.setLeft(rt.left());
            } else {                                                        //root is its parent right child
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
