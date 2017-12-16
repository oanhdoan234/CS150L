

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest
{
    /**
     * Default constructor for test class BinaryTreeTest
     */
    public BinaryTreeTest()
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
    
    @Test
    public void testAdd(){
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.add(1);
        assertEquals((Integer) 1, (Integer) tree.get(0));
    }
    
    @Test
    public void testAdd2(){
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.add(1);
        tree.add(2); 
        tree.add(2);
        assertEquals((Integer) 1, (Integer) tree.get(0));
        assertEquals((Integer) 2, (Integer) tree.get(1));
        assertEquals((Integer) 2, (Integer) tree.get(2));
    }
    
    @Test
    public void testAdd3(){
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        for (int i = 0; i < 35; i++){
            tree.add(i);
        }
        assertEquals((Integer) 29, (Integer) tree.get(29));
        assertEquals((Integer) 30, (Integer) tree.getSize());
    }
}
