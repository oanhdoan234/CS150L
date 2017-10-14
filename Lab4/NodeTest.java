import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class NodeTest<E>
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

    
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testGetELement(){
        Node<Integer> node1 = new Node(12, null);                               
        assertEquals((Integer) 12, node1.getElement());
    }
    
    @Test
    public void testSetElement(){
        Node<Integer> node1 = new Node(null);
        node1.setElement(12);                                               //set element
        assertEquals(node1.getElement(),(Integer) 12);                     //get element and test
    }
    
    @Test 
    public void testNext(){
        Node<Integer> node1 = new Node(12, new Node(3, null));
        Node<Integer> node2 = node1.next(); 
        assertEquals(node2.getElement(), (Integer) 3 );
    }
    
    @Test
    public void testSetNext(){
        Node<Integer> node1 = new Node(12, null);
        Node<Integer> node2 = new Node(3,null);
        node1.setNext(node2);
        assertEquals((Integer) 3, node1.next().getElement());
    }
    
}
