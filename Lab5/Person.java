
public abstract class Person
{
    protected String firstName;
    protected String lastName; 
    
    public Person(String first, String last){
        this.firstName = first;
        this.lastName = last;
    }

    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
  
  
}