import java.util.*;

public class FacultyList extends SortedList<Faculty>
{
    
    public FacultyList(){
        this.list = new LinkedList<Faculty>();
    }
    
    public void printData(){
        for (int i = 0; i < list.size(); i++){                  //print each element from list
            list.get(i).toString();
        }
    }
}
