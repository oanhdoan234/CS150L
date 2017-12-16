import java.util.*; 

public class AthleteComparator implements Comparator<Athlete> 
{
    public int compare(Athlete a, Athlete b){
        if(compareHeight(a,b) == 1){                    
            return 1;
        } else if (compareHeight(a,b) == -1){
            return -1;
        } else {                                                                        //same height => compare Birth
            if(compareBirth(a,b) == 1){
                return 1;
            } else if (compareBirth(a,b) == -1){
                return -1; 
            } else {                                                                   //same height and Birth => compare LastName
                if(compareLastName(a,b) == 1){
                    return 1;
                } else if (compareLastName(a,b) == -1){
                    return -1; 
                } else {                                                               //Same height, lastname, birth => compare Sport
                    if(compareSport(a,b) == 1){
                        return 1;
                    } else if (compareSport(a,b) == -1){
                        return -1;
                    } 
                    return 0;
                }
            }
        }
    }
    
    public boolean equals(Comparator obj){
        return false;
    }
    
    public int compareHeight(Athlete a, Athlete b){
        if (a.getHeight() == b.getHeight()) {
            return 0;
        } else if (a.getHeight() > b.getHeight()){
            return 1;
        } 
        return -1;
    }
    
    public int compareBirth(Athlete a, Athlete b){
        if(a.getYear() == b.getYear()){
            if (a.getMonth() == b.getMonth()){
                return 0;
            } else if (a.getMonth() > b.getMonth()){
                return 1;
            } 
            return -1;
        } else if (a.getYear() > b.getYear()){
            return 1;
        }
        return -1;
    }
    
    public int compareLastName(Athlete a, Athlete b){
        return a.getLastName().compareTo(b.getLastName());
    }
    
    public int compareSport(Athlete a, Athlete b){
        return a.getSport().compareTo(b.getSport());
    }
}
