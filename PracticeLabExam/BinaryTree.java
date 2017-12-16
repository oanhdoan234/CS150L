import java.util.*;

public class BinaryTree<E extends Comparable<E>>
{
   private ArrayList<E> list; 
   private int currSize;
   private int maxSize;
   
   public static void main(String[] args){
       BinaryTree<Integer> treeInt = new BinaryTree<Integer>();
       for (int i = 0; i<10; i++) treeInt.add(i);
       //System.out.println(treeInt.toString(0));
       
       BinaryTree<String> treeStr = new BinaryTree<String>();
       String[] ch = {"a","b","c","d","e","f","g","h","i","k","l","m","n"};
       for (int i = 0; i<10;i++) treeStr.add(ch[i]);
       //treeStr.toString(0);
   }
    
   public BinaryTree(){
       this.list = new ArrayList<E>();
       this.maxSize = 30;
       for (int i = 0; i < maxSize; i++) list.add(null);
       this.currSize = 0;
   }
   
   public void add(E e){
       if (currSize >= maxSize) return; 
       this.list.set(currSize,e);
       this.currSize++;
   }
   
   public String toString(){
       return this.toString(0);
   }
    
   public String toString(int pos){
       if(pos > currSize-1) return "";
       String output="";
       output += toString(pos*2+1);
       output += String.valueOf(list.get(pos));
       output += toString(pos*2+2); 
       return output;
    }
   
   public E get(int pos){ return list.get(pos);}
   public int getSize(){return currSize;}
}
