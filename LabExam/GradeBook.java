import java.util.*;

public class GradeBook<E extends Comparable<E>>
{
    private ArrayList<E> gradeList; 
    
    /** initiate an empty list */
    public GradeBook(){
        this.gradeList = new ArrayList<E>();
    }
    
    /** add a grade */
    public void addGrade(E e){
        this.gradeList.add(e);
    }
    
    /** delete first occurence of a grade if found */
    public boolean delete(E e){
        if (gradeList.contains(e)){
            gradeList.remove(e);
            return true;
        }
        return false;
    }
    
    /** find a grade using iterator*/
    public int find(E e){
        int index = 0;                                                  //index to keep track
        Iterator<E> myIterator =  this.gradeList.iterator();            //iterate
        while (myIterator.hasNext()){
            if (myIterator.next().compareTo(e) == 0){
                index++;                                                
                return index;
            }
            index ++;                                                   //increase index after each iteration
        }
        return -1;
    }
    
    /** print grades using iterator */
    public void printGrades(){
        System.out.println("All grades are listed below: ");
        Iterator<E> myIterator =  this.gradeList.iterator();
        while (myIterator.hasNext()){                                       //print
            E nextGrade = myIterator.next();
            System.out.println(nextGrade);
        }
    }
    
    
}
