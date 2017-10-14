import java.util.*;
import java.io.PrintWriter;

public class ExperimentController
{
    public static void main(String[] args){
        ExperimentController c = new ExperimentController();
        
        //list of 50 names, ids, years, emails, and phones
        
        String[] lastNames = {"Mitchell","Allan","Lyman","MacDonald","Cameron","Davidson","Hardacre","Rees","Morgan","Morgan","Graham","May",
            "Lawrence","Alsop","Black","Thomson","Lawrence","Mackenzie","McGrath","Hodges","Lee","Alsop","Churchill","Churchill","Sanderson",
            "Chapman","Parr","Welch","Arnold","North","Fraser","Paige","Mackay","Newman","Wright","Berry","Butler","May","Burgess","Buckland",
            "Wright","Rampling","Mathis","Gray","Bailey","Bell","Ferguson","White","Hardacre","Forsyth"};
        String[] firstNames = {"Lily","Sam","Grace","Vanessa","Karen","Penelope","Dylan","Tracey","Richard","Yvonne","Luke","Amelia","Robert",
            "Lucas","Richard","Brian","Fiona","Eric","Emma","Sophie","Dorothy","Joanne","Ruth","Angela","Leah","Amanda","Jack","Simon","Sophie",
            "Nicholas","Edward","Liam","Chloe","Joshua","Heather","Penelope","Jan","Virginia","Nicholas","Fiona","Alexandra","Fiona","Matt",
            "Pippa","Carl","Gordon","Amy","Virginia","Jonathan","Lisa"};
        
        long[] id = {4341010,4340750,4340600,4340770,4340950,4341070,4340860,4340630,4340930,4340970,4340720,4341000,4340620,4340820,4340760,
            4340780,4340920,4340640,4340610,4340980,4340840,4340650,4340680,4340900,4340690,4341040,4340660,4340810,4341020,4340700,4340990,
            4340710,4340880,4340910,4341060,4340670,4340740,4340590,4341080,4340890,4340870,4341050,4340800,4341030,4340960,4340730,4340850,
            4340830,4340940,4340790};
        
        int[] year = {2019,2019,2018,2021,2020,2020,2018,2019,2021,2019,2018,2020,2020,2020,2018,2018,2021,2021,2018,2021,2021,2018,2018,2021,
            2020,2020,2018,2018,2018,2018,2018,2020,2019,2020,2020,2020,2021,2020,2018,2020,2021,2019,2019,2018,2018,2018,2018,2018,2020,2021};
            
        String[] emails = {"Mitchell@lafayette.edu","Allan@lafayette.edu","Lyman@lafayette.edu","MacDonald@lafayette.edu",
            "Cameron@lafayette.edu","Davidson@lafayette.edu","Hardacre@lafayette.edu","Rees@lafayette.edu","Morgan@lafayette.edu",
            "Morgan@lafayette.edu","Graham@lafayette.edu","May@lafayette.edu","Lawrence@lafayette.edu","Alsop@lafayette.edu",
            "Black@lafayette.edu","Thomson@lafayette.edu","Lawrence@lafayette.edu","Mackenzie@lafayette.edu","McGrath@lafayette.edu",
            "Hodges@lafayette.edu","Lee@lafayette.edu","Alsop@lafayette.edu","Churchill@lafayette.edu","Churchill@lafayette.edu",
            "Sanderson@lafayette.edu","Chapman@lafayette.edu","Parr@lafayette.edu","Welch@lafayette.edu","Arnold@lafayette.edu",
            "North@lafayette.edu","Fraser@lafayette.edu","Paige@lafayette.edu","Mackay@lafayette.edu","Newman@lafayette.edu",
            "Wright@lafayette.edu","Berry@lafayette.edu","Butler@lafayette.edu","May@lafayette.edu","Burgess@lafayette.edu",
            "Buckland@lafayette.edu","Wright@lafayette.edu","Rampling@lafayette.edu","Mathis@lafayette.edu","Gray@lafayette.edu",
            "Bailey@lafayette.edu","Bell@lafayette.edu","Ferguson@lafayette.edu","White@lafayette.edu","Hardacre@lafayette.edu",
            "Forsyth@lafayette.edu"};
            
        int[] phones = {43410103,43407504,43406005,43407705,43409502,43410705,43408605,43406302,43409302,43409703,43407202,43410001,43406203,
            43408201,43407605,43407805,43409203,43406404,43406105,43409802,43408404,43406503,43406804,43409004,43406905,43410402,43406602,
            43408105,43410204,43407004,43409901,43407101,43408801,43409104,43410603,43406701,43407403,43405904,43410805,43408905,43408702,
            43410505,43408004,43410302,43409604,43407301,43408502,43408302,43409402,43407902};
        
        //student lists of various sizes
        StudentList s5 = new StudentList();
        StudentList s15 = new StudentList();
        StudentList s30 = new StudentList();
        StudentList s40 = new StudentList();
        StudentList s50 = new StudentList();
        
        //add students to lists
        for (int i = 0; i < id.length; i++){
            Student s = new Student(firstNames[i], lastNames[i], id[i], year[i]);
            if (i < 5) {s5.addElement(s);}
            if (i < 15) {s15.addElement(s);}
            if (i < 30) {s30.addElement(s);}
            if (i < 40) {s40.addElement(s);}
            s50.addElement(s);
        }
        
        //faculty lists of various sizes
        FacultyList f5 = new FacultyList();
        FacultyList f15 = new FacultyList();
        FacultyList f30 = new FacultyList();
        FacultyList f40 = new FacultyList();
        FacultyList f50 = new FacultyList();
        
        //add faculty to lists
        for (int i = 0; i < id.length; i++){
            Faculty f = new Faculty(firstNames[i], lastNames[i], phones[i], emails[i]);
            if (i < 5) {f5.addElement(f);}
            if (i < 15) {f15.addElement(f);}
            if (i < 30) {f30.addElement(f);}
            if (i < 40) {f40.addElement(f);}
            f50.addElement(f);
        }
        
        //print sort time
        System.out.println("Quick sort for students");
        System.out.println(c.timeQuickSortStudent(s5));
        System.out.println(c.timeQuickSortStudent(s15));
        System.out.println(c.timeQuickSortStudent(s30));
        System.out.println(c.timeQuickSortStudent(s40));
        System.out.println(c.timeQuickSortStudent(s50));
        
        System.out.println("Selection sort for students");
        System.out.println(c.timeSelectionSortStudent(s5));
        System.out.println(c.timeSelectionSortStudent(s15));
        System.out.println(c.timeSelectionSortStudent(s30));
        System.out.println(c.timeSelectionSortStudent(s40));
        System.out.println(c.timeSelectionSortStudent(s50));
        
        System.out.println("Quick sort for faculty");
        System.out.println(c.timeQuickSortFaculty(f5));
        System.out.println(c.timeQuickSortFaculty(f15));
        System.out.println(c.timeQuickSortFaculty(f30));
        System.out.println(c.timeQuickSortFaculty(f40));
        System.out.println(c.timeQuickSortFaculty(f50));
        
        System.out.println("Selection sort for faculty");
        System.out.println(c.timeSelectionSortFaculty(f5));
        System.out.println(c.timeSelectionSortFaculty(f15));
        System.out.println(c.timeSelectionSortFaculty(f30));
        System.out.println(c.timeSelectionSortFaculty(f40));
        System.out.println(c.timeSelectionSortFaculty(f50));
    }
    
    
    public long timeQuickSortStudent(StudentList list){
        long startTime = System.nanoTime();                                 //sort and record time
        list.quickSort(0,list.size()-1);
        long endTime = System.nanoTime(); 
        long totalTime = endTime-startTime; 
        return totalTime;
    }
    
    public long timeSelectionSortStudent(StudentList list){
        long startTime = System.nanoTime();
        list.selectionSort();                                               //sort and record time
        long endTime = System.nanoTime(); 
        long totalTime = endTime-startTime; 
        return totalTime;
    }
    
    public long timeQuickSortFaculty(FacultyList list){
        long startTime = System.nanoTime();
        list.quickSort(0,list.size()-1);                                    //sort and record time
        long endTime = System.nanoTime(); 
        long totalTime = endTime-startTime; 
        return totalTime;
    }
    
    public long timeSelectionSortFaculty(FacultyList list){
        long startTime = System.nanoTime();
        list.selectionSort();                                               //sort and record time
        long endTime = System.nanoTime(); 
        long totalTime = endTime-startTime; 
        return totalTime;
    }
}
