import java.lang.*; 

public class Faculty extends Person implements Comparable<Faculty>
{
    private int phone;
    private String email; 
    
    public Faculty(String firstName, String lastName, int phone, String email){
        super(firstName, lastName);
        this.phone = phone;
        this.email = email;
    }
    
    public int compareToFirstName(Faculty obj){
        String ch = "abcdefghijklmnopqrstuvwxyz";                               //order of alphabets
        String thisName = super.firstName.toLowerCase();                        //turn names into lower case
        String objName = obj.getFirstName().toLowerCase();
        String thisNameFirstChar = thisName.substring(0,1);                     //get the first character of first name
        String objNameFirstChar = objName.substring(0,1);
 
        int thisNameOrder = ch.indexOf(thisNameFirstChar);                      //get position of the character in the alphabet list
        int objNameOrder = ch.indexOf(objNameFirstChar);
        
                                                                        //compare the positions of first characters
        if (thisNameOrder == objNameOrder){
            return 0;
        } else if (thisNameOrder < objNameOrder){                       //first name of this is ordered before first name of obj
            return -1;
        } else {
            return 1;                                                  //first name of this is ordered after first name of obj
        }
    }
    
    public int compareToLastName(Faculty obj){
        String ch = "abcdefghijklmnopqrstuvwxyz";                               //order of alphabets
        String thisName = super.lastName.toLowerCase();                         //turn names into lower case
        String objName  = obj.getLastName().toLowerCase();
        
        String thisNameFirstChar = thisName.substring(0,1);                     //get the first character of first name
        String objNameFirstChar = objName.substring(0,1);
        
        int thisNameOrder = ch.indexOf(thisNameFirstChar);                      //get position of the character in the alphabet list
        int objNameOrder = ch.indexOf(objNameFirstChar);
        
        //compare the positions of first characters
        if (thisNameOrder == objNameOrder){
            return 0;
        } else if (thisNameOrder < objNameOrder){
            return -1;
        } else {
            return 1;
        }
    }
    
    public int compareTo(Faculty obj){
        if (this.compareToLastName(obj) == 0){                       //same last names
            return (this.compareToFirstName(obj));                   //compare first names
        } 
        return (this.compareToLastName(obj));                       //otherwise, order by last name
    }
    
    public String toString(){
        String message = "";
        message = message + "First name is " + super.firstName + "\nLast name is " + super.lastName + "\nPhone: " + phone + "\nEmail" + email;
        System.out.println(message);
        return message;
    }
}
