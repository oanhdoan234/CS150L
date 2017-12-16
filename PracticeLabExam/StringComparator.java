import java.util.*; 

public class StringComparator implements Comparator<String>
{
    public int compare(String s1, String s2){
        return s1.compareToIgnoreCase(s2);
    }
    
    public boolean equals(StringComparator obj){
        return true;
    }
}
