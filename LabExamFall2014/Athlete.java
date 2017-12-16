import java.util.*;

public class Athlete
{
   private int heightFoot; 
   private int heightInch;
   private int month;
   private int year;
   private String lastName;
   private String firstName;
   private String sport;
   
   public Athlete(int heightFoot, int heightInch, int month, int year, String lastName, String firstName, String sport){
       this.heightFoot = heightFoot;
       this.heightInch = heightInch;
       this.month = month;
       this.year = year;
       this.lastName = lastName; 
       this.firstName = firstName;
       this.sport = sport;
   }
   
   public int getHeightFoot(){return this.heightFoot;}
   public int getHeightInch(){return this.heightInch;}
   public int getHeight(){return heightFoot*12 + heightInch ;}
   public int getMonth(){return month;}
   public int getYear(){return year;}
   public String getLastName(){return lastName;}
   public String getFirstName(){return firstName;}
   public String getSport(){return sport;}
   
}
