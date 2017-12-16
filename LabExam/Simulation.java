import java.util.*;
import java.lang.*;

public class Simulation
{   
    /** Simulate 2 gradebooks */
    public static void main(String args[]){
        GradeBook<String> letterGrade = new GradeBook<String>();                    //create a letter gradebook 
        letterGrade.addGrade("A");                                                  //add grades 
        letterGrade.addGrade("B");  
        letterGrade.addGrade("B+");
        letterGrade.addGrade("A-");
        letterGrade.addGrade("C");
        letterGrade.printGrades();                                                  //print
        
        GradeBook<Double> numericGrade = new GradeBook<Double>();                   //create a numeric gradebook
        numericGrade.addGrade(4.0);                                                 //add grades
        numericGrade.addGrade(3.0);
        numericGrade.addGrade(3.7);
        numericGrade.addGrade(3.3);
        numericGrade.addGrade(3.0);
        numericGrade.printGrades();                                                 //print
    }
}
