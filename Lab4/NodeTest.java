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
        node1.setElement(12);
        assertEquals((Integer) 12, node1.getElement());
    }
    
    @Test 
    public void testNext(){
        Node<Integer> node1 = new Node(12, new Node(3, null));
        Node<Integer> node2 = node1.next(); 
        assertEquals((Integer) 3, node2.getElement());
    }
    
    @Test
    public void testSetNext(){
        
    }
    
}
