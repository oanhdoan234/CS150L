

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StudentListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentListTest
{

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test 
    public void testAddStudent(){
        Student s1 = new Student("Oanh","Doan",4340590,2018);                           //create students
        Student s2 = new Student("Thanh","Vu", 4349270,2018);
        Student s3 = new Student("Huy", "Nguyen", 4352183,2018);
        StudentList list = new StudentList();                                           //create list and add students to list
        list.addElement(s1);
        list.addElement(s2);
        list.addElement(s3);
        assertEquals("Oanh",list.getElement(0).getFirstName());                         //assert
        assertEquals("Thanh",list.getElement(1).getFirstName());
        assertEquals("Huy",list.getElement(2).getFirstName());
        assertEquals("Doan",list.getElement(0).getLastName());
        assertEquals("Vu",list.getElement(1).getLastName());
        assertEquals("Nguyen",list.getElement(2).getLastName());
    }
    
    @Test
    public void testSwap(){
        Student s1 = new Student("Oanh","Doan",4340590,2018);                           //create students and add students to a new list
        Student s2 = new Student("Thanh","Vu", 4349270,2018);
        StudentList list = new StudentList();
        list.addElement(s1);
        list.addElement(s2);
        list.swap(0,1);                                                                 //swap 2 students
        assertEquals("Oanh",list.getElement(1).getFirstName());
        assertEquals("Thanh",list.getElement(0).getFirstName());
        assertEquals("Doan",list.getElement(1).getLastName());
        assertEquals("Vu",list.getElement(0).getLastName());
    }
    
    @Test
    public void testfindPivot(){
        StudentList list = new StudentList();
        int p1 = list.findpivot(1,2);
        int p2 = list.findpivot(3,3);
        assertEquals(1,p1);
        assertEquals(3,p2);
    }
    
    //Consider empty lists
    @Test
    public void testQuickSort(){
        StudentList list = new StudentList();
        Student s1 = new Student("Oanh","Doan",  4340590,2018);                           //create students
        Student s2 = new Student("Thanh","Vu",   4349270,2018);
        Student s3 = new Student("Huy", "Nguyen",4342183,2018);
        Student s4 = new Student("Khun","B",     4312356, 2018);
        list.addElement(s1);
        list.addElement(s2);
        list.addElement(s3);
        list.addElement(s4);
        list.quickSort(0, list.size()-1);
        assertEquals("Khun",list.getElement(0).getFirstName());
        assertEquals("Oanh",list.getElement(1).getFirstName());
        assertEquals("Huy",list.getElement(2).getFirstName());
        assertEquals("Thanh",list.getElement(3).getFirstName());

    }
    
    @Test
    public void testSelectionSort(){
        StudentList list = new StudentList();
        Student s1 = new Student("Oanh","Doan",  4340590,2018);                           //create students
        Student s2 = new Student("Thanh","Vu",   4349270,2018);
        Student s3 = new Student("Huy", "Nguyen",4342183,2018);
        Student s4 = new Student("Khun","B",     4312356, 2018);
        list.addElement(s1);
        list.addElement(s2);
        list.addElement(s3);
        list.addElement(s4);
        list.selectionSort();
        assertEquals("Khun",list.getElement(0).getFirstName());
        assertEquals("Oanh",list.getElement(1).getFirstName());
        assertEquals("Huy",list.getElement(2).getFirstName());
        assertEquals("Thanh",list.getElement(3).getFirstName());
    }
    
}
