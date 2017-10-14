

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class FacultyListTest
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
    public void testAddFaculty(){
        Faculty f1 = new Faculty("John","Wilson",4340590, "wilsonj@lafayette.edu");                           //create Facultys
        Faculty f2 = new Faculty("Marry","Thompson", 4349270, "thompsonm@lafayette.edu");
        Faculty f3 = new Faculty("Ted", "Zulli", 4352183, "zullit@lafayette.edu");
        FacultyList list = new FacultyList();                                           //create list and add Facultys to list
        list.addElement(f1);
        list.addElement(f2);
        list.addElement(f3);
        assertEquals("John",list.getElement(0).getFirstName());                         //assert
        assertEquals("Marry",list.getElement(1).getFirstName());
        assertEquals("Ted",list.getElement(2).getFirstName());
        assertEquals("Wilson",list.getElement(0).getLastName());
        assertEquals("Thompson",list.getElement(1).getLastName());
        assertEquals("Zulli",list.getElement(2).getLastName());
    }
    
    @Test
    public void testSwap(){
        Faculty f1 = new Faculty("John","Wilson",4340590, "wilsonj@lafayette.edu");                           //create Facultys
        Faculty f2 = new Faculty("Marry","Thompson", 4349270, "thompsonm@lafayette.edu");
        FacultyList list = new FacultyList();
        list.addElement(f1);
        list.addElement(f2);
        list.swap(0,1);                                                                 //swap 2 Facultys
        assertEquals("John",list.getElement(1).getFirstName());
        assertEquals("Marry",list.getElement(0).getFirstName());
        assertEquals("Wilson",list.getElement(1).getLastName());
        assertEquals("Thompson",list.getElement(0).getLastName());
    }
    
    @Test
    public void testfindPivot(){
        FacultyList list = new FacultyList();
        int p1 = list.findpivot(1,2);
        int p2 = list.findpivot(3,3);
        assertEquals(1,p1);
        assertEquals(3,p2);
    }
    
    //Consider empty lists
    @Test
    public void testQuickSort(){
        FacultyList list = new FacultyList();
        Faculty f1 = new Faculty("John","Wilson",4340590, "wilsonj@lafayette.edu");                           //create Facultys
        Faculty f2 = new Faculty("Marry","Thompson", 4349270, "thompsonm@lafayette.edu");
        Faculty f3 = new Faculty("Ted", "Zulli", 4352183, "zullit@lafayette.edu");
        Faculty f4 = new Faculty("Tony","Wilson",4312356, "wilsont@lafayette.edu");
        list.addElement(f1);
        list.addElement(f2);
        list.addElement(f3);
        list.addElement(f4);
        list.quickSort(0, list.size()-1);
        assertEquals("Marry",list.getElement(0).getFirstName());
        assertEquals("John",list.getElement(1).getFirstName());
        assertEquals("Tony",list.getElement(2).getFirstName());
        assertEquals("Ted",list.getElement(3).getFirstName());

    }
    
    @Test
    public void testSelectionSort(){
        FacultyList list = new FacultyList();
        Faculty f1 = new Faculty("John","Wilson",4340590, "wilsonj@lafayette.edu");                           //create Facultys
        Faculty f2 = new Faculty("Marry","Thompson", 4349270, "thompsonm@lafayette.edu");
        Faculty f3 = new Faculty("Ted", "Zulli", 4352183, "zullit@lafayette.edu");
        Faculty f4 = new Faculty("Tony","Wilson",4312356, "wilsont@lafayette.edu");
        list.addElement(f1);
        list.addElement(f2);
        list.addElement(f3);
        list.addElement(f4);
        list.selectionSort();
        assertEquals("Marry",list.getElement(0).getFirstName());
        assertEquals("John",list.getElement(1).getFirstName());
        assertEquals("Tony",list.getElement(2).getFirstName());
        assertEquals("Ted",list.getElement(3).getFirstName());
    }
}
