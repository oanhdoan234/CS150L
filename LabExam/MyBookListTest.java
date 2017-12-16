

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MyBookListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MyBookListTest
{
    /**
     * Default constructor for test class MyBookListTest
     */
    public MyBookListTest()
    {
    }

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
    
    /** add a book to an empty list */
    @Test
    public void testAdd1(){
        MyBookList list = new MyBookList();                                         //create list and add a book
        MyBook aBook = new MyBook("Chun Wai Liew", "Java");
        list.add(aBook);
        
        BNode head = list.getHead();
        BNode firstNode = head.getNext();                                           //get first node
        BNode secondNode = firstNode.getNext();
        assertEquals("Chun Wai Liew", firstNode.getAuthor());                       //assert first node's properties
        assertEquals("Java", firstNode.getTitle());
        assertEquals(head, secondNode); 
    }
    
    /** add 2 books to an empty list */
    @Test
    public void testAdd2(){
        MyBookList list = new MyBookList();                                        //create list and add 2 books
        MyBook b1 = new MyBook("Chun Wai Liew", "Java");
        MyBook b2 = new MyBook("Oanh Doan", "Java");                               
        list.add(b1);
        list.add(b2);
        
        BNode head = list.getHead();                                               //get nodes 
        BNode firstNode = head.getNext(); 
        BNode secondNode = firstNode.getNext();
        BNode thirdNode = secondNode.getNext(); 
        
        assertEquals("Oanh Doan", firstNode.getAuthor());                         //assert nodes' properties 
        assertEquals("Java", firstNode.getTitle());
        assertEquals("Chun Wai Liew", secondNode.getAuthor());
        assertEquals("Java", secondNode.getTitle());
        
        assertEquals(head, thirdNode); 
    }
    
    /** add three books where the last one should be inserted at list start */
    @Test 
    public void testAdd3(){
        MyBookList list = new MyBookList();                             
        MyBook b1 = new MyBook("Chun Wai Liew", "Java");
        MyBook b2 = new MyBook("Oanh Doan", "Java");
        MyBook b3 = new MyBook("A B", "AbC");
        list.add(b1);
        list.add(b2);
        list.add(b3); 
        
        BNode head = list.getHead(); 
        BNode firstNode = head.getNext(); 
        BNode secondNode = firstNode.getNext();
        BNode thirdNode = secondNode.getNext(); 
        BNode forthNode = thirdNode.getNext();
        
        assertEquals("A B", firstNode.getAuthor());
        assertEquals("AbC", firstNode.getTitle());
        assertEquals("Oanh Doan", secondNode.getAuthor());
        assertEquals("Java", secondNode.getTitle());
        assertEquals("Chun Wai Liew", thirdNode.getAuthor());
        assertEquals("Java",thirdNode.getTitle());
        
        assertEquals(head, forthNode); 
    }
    
    /** add three books where the last one should be inserted in the middle */
    @Test 
    public void testAdd4(){
        MyBookList list = new MyBookList();
        MyBook b1 = new MyBook("Chun Wai Liew", "Java");
        MyBook b2 = new MyBook("Oanh Doan", "Java");
        MyBook b3 = new MyBook("A Elisa", "AbC");
        list.add(b1);
        list.add(b2);
        list.add(b3); 
        
        BNode head = list.getHead(); 
        BNode firstNode = head.getNext(); 
        BNode secondNode = firstNode.getNext();
        BNode thirdNode = secondNode.getNext(); 
        BNode forthNode = thirdNode.getNext();
        
        assertEquals("Oanh Doan", firstNode.getAuthor());
        assertEquals("Java", firstNode.getTitle());
        assertEquals("A Elisa", secondNode.getAuthor());
        assertEquals("AbC", secondNode.getTitle());
        assertEquals("Chun Wai Liew", thirdNode.getAuthor());
        assertEquals("Java",thirdNode.getTitle());
        
        assertEquals(head, forthNode); 
    }
    
    
    /** add three books where the last one should be inserted at list end */
     @Test 
    public void testAdd5(){
        MyBookList list = new MyBookList();
        MyBook b1 = new MyBook("Chun Wai Liew", "Java");
        MyBook b2 = new MyBook("Oanh Doan", "Java");
        MyBook b3 = new MyBook("A Wilson", "AbC");
        list.add(b1);
        list.add(b2);
        list.add(b3); 
        
        BNode head = list.getHead(); 
        BNode firstNode = head.getNext(); 
        BNode secondNode = firstNode.getNext();
        BNode thirdNode = secondNode.getNext(); 
        BNode forthNode = thirdNode.getNext();
        
        assertEquals("Oanh Doan", firstNode.getAuthor());
        assertEquals("Java", firstNode.getTitle());
        assertEquals("Chun Wai Liew", secondNode.getAuthor());
        assertEquals("Java", secondNode.getTitle());
        assertEquals("A Wilson", thirdNode.getAuthor());
        assertEquals("AbC",thirdNode.getTitle());
        
        assertEquals(head, forthNode); 
    }
}
