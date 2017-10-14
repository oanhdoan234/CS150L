import java.util.*; 

public class StudentList extends SortedList<Student> 
{

    public StudentList(){
        this.list = new LinkedList<Student>();
    }
    
    public void printData(){
        for (int i = 0; i < list.size(); i++){           //print each element in list
            list.get(i).toString();
        }
    }
    
}
