

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BinarySearchTreeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BinarySearchTreeTest
{
    /**
     * Default constructor for test class BinarySearchTreeTest
     */
    public BinarySearchTreeTest()
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
    public void testContains(){
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode(100.0)); 
        assertTrue(tree.contains(100.0));
        assertFalse(tree.contains(101.0));
        assertEquals(1, tree.size());
    }
    
    @Test
    public void testInsert1(){                                                   //insert 2 nodes to tree
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode(100.0)); 
        tree.insert(101.0);
        tree.insert(99.0);
        assertEquals(3,tree.size());
        assertEquals(101.0, tree.root().right().value());
        assertEquals(99.0, tree.root().left().value());
    }
    
    @Test
    public void testInsert2(){                                                   //insert 1 node that is already in the tree
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode(100.0)); 
        tree.insert(100.0);
        assertEquals(1,tree.size());
        assertTrue(tree.root().right()==null);
        assertTrue(tree.root().left()==null);
    }
    
    @Test
    public void testInsert3(){                                                   //insert 4 nodes to tree
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode(100.0)); 
        tree.insert(101.0);
        tree.insert(99.0);
        tree.insert(100.2);
        tree.insert(99.8);
        assertEquals(5,tree.size());
        assertEquals(101.0, tree.root().right().value());
        assertTrue(tree.root().right().right()==null);
        assertEquals(100.2, tree.root().right().left().value());
        assertEquals(99.0, tree.root().left().value());
        assertTrue(tree.root().left().left()==null);
        assertEquals(99.8, tree.root().left().right().value());
    }
    
    @Test
    public void findMaxMin1(){
        BinarySearchTree tree = new BinarySearchTree(null); 
        assertEquals(null, tree.findMax());
        assertEquals(null, tree.findMin());
    }
    
    @Test
    public void findMaxMin2(){
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode(100.0)); 
        assertEquals(100.0, (double) tree.findMax(),0);
        assertEquals(100.0, (double) tree.findMin(),0);
    }
    
    @Test 
    public void findMax2(){
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode(100.0)); 
        tree.insert(101.0);
        tree.insert(150.0);
        tree.insert(99.0);
        tree.insert(100.2);
        tree.insert(99.8);
        assertEquals(150.0,(double) tree.findMax(), 0);
    }
    
    @Test 
    public void findMin1(){
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode(100.0)); 
        tree.insert(101.0);
        tree.insert(150.0);
        tree.insert(99.0);
        tree.insert(100.2);
        tree.insert(99.8);
        assertEquals((Double) 99.0,(Double) tree.findMin());
    }
    
    @Test
    public void testRemove1(){
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode(100.0)); 
        tree.remove(100.0);
        assertEquals(0, tree.size());
        assertTrue(tree.root() == null);
    }
    
    @Test
    public void testRemove2(){
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode(100.0)); 
        tree.insert(101.0);
        tree.insert(99.0);
        tree.insert(100.2);
        tree.remove(100.0);
        assertEquals(3, tree.size());
        assertEquals(100.2, (double) tree.root().value() ,0);
        assertEquals(101.0, tree.root().right().value());
        assertEquals(99.0, tree.root().left().value());
        assertTrue(tree.root().right().right() == null);
        assertTrue(tree.root().right().left() == null);
        assertTrue(tree.root().left().right() == null);
        assertTrue(tree.root().left().left() == null);
    }
    
    
    @Test
    public void testIsEmpty(){
        BinarySearchTree tree = new BinarySearchTree(null);
        assertTrue(tree.isEmpty());
    }
    
    @Test
    public void testEmpty(){
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode(100.0));
        tree.insert(101.0);
        tree.insert(99.0);
        tree.insert(100.2);
        tree.insert(123.1);
        tree.empty();
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
        assertTrue(tree.root() == null);
    }
}
