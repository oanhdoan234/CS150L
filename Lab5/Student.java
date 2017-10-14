import java.lang.*; 

public class Student extends Person implements Comparable<Student>
{
    private long id;
    private int year;
    
    public Student(String firstName, String lastName, long id, int year){
        super(firstName, lastName);
        this.id = id;
        this.year = year;
    }
   
    public int compareTo(Student obj){
        if (this.id == obj.id){
            return 0;
        } else if (this.id < obj.id){
            return -1;
        } else{
            return 1;
        }
    }
    
    public String toString(){
        String message = "";
        message = message + "First name is " + super.firstName + "\nLast name is " + super.lastName + "\nID: " + id + "\nClass year" + year;
        System.out.println(message);
        return message;
    }
    
    
}
