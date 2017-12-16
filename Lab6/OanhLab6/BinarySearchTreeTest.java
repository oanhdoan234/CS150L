

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
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode<Double>(100.0)); 
        assertTrue(tree.contains(100.0));
        assertFalse(tree.contains(101.0));
        assertEquals(1, tree.size());
    }
    
    @Test
    public void testInsert1(){                                                   //insert 2 nodes to tree
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode<Double>(100.0)); 
        tree.insert(101.0);
        tree.insert(99.0);
        assertEquals(3,tree.size());
        assertEquals((Double) 101.0, tree.root().right().value());
        assertEquals((Double) 99.0, tree.root().left().value());
    }
    
    @Test
    public void testInsert2(){                                                   //insert 1 node that is already in the tree
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode<Double>(100.0)); 
        tree.insert(100.0);
        assertEquals(1,tree.size());
        assertTrue(tree.root().right()==null);
        assertTrue(tree.root().left()==null);
    }
    
    @Test
    public void testInsert3(){                                                   //insert 4 nodes to tree
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode<Double>(100.0)); 
        tree.insert(101.0);
        tree.insert(99.0);
        tree.insert(100.2);
        tree.insert(99.8);
        assertEquals(5,tree.size());
        assertEquals((Double)101.0, tree.root().right().value());
        assertTrue(tree.root().right().right()==null);
        assertEquals((Double)100.2, tree.root().right().left().value());
        assertEquals((Double)99.0, tree.root().left().value());
        assertTrue(tree.root().left().left()==null);
        assertEquals((Double)99.8, tree.root().left().right().value());
    }
    
    @Test 
    public void testInsert4(){                                                  //insert a new root to an empty tree
        BinarySearchTree tree = new BinarySearchTree(null);
        tree.insert(100.0);
    }
    
    @Test
    public void findMaxMin1(){                                                  //min/max of an empty tree
        BinarySearchTree tree = new BinarySearchTree(null); 
        assertEquals(null, tree.findMax());
        assertEquals(null, tree.findMin());
    }
    
    @Test
    public void findMaxMin2(){                                                  //min/max of a tree with 1 node
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode<Double>(100.0)); 
        assertEquals((Double)100.0, tree.findMax(),0);
        assertEquals((Double)100.0, tree.findMin(),0);
    }
    
    @Test 
    public void findMax2(){                                                    //max of a tree with multiple nodes
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode<Double>(100.0)); 
        tree.insert(101.0);
        tree.insert(150.0);
        tree.insert(99.0);
        tree.insert(100.2);
        tree.insert(99.8);
        assertEquals((Double) 150.0,tree.findMax(), 0);
    }
    
    @Test 
    public void findMin1(){                                                     //min of a tree with multiple nodes
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode<Double>(100.0)); 
        tree.insert(101.0);
        tree.insert(150.0);
        tree.insert(99.0);
        tree.insert(100.2);
        tree.insert(99.8);
        assertEquals((Double) 99.0,tree.findMin());
    }
    
    @Test
    public void testRemove1(){                                                  //remove root of a one-node tree
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode<Double>(100.0)); 
        tree.remove(100.0);
        assertEquals(0, tree.size());
        assertTrue(tree.root() == null);
    }
    
    @Test
    public void testRemove2(){                                                  //remove root of a tree with multiple nodes
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode<Double>(100.0));            //create tree
        tree.insert(101.0);
        tree.insert(99.0);
        tree.insert(100.2);
        tree.remove(100.0);                                                                     //remove root
                            
        assertEquals(3, tree.size());                                                           //assert size
        assertEquals((Double)100.2, tree.root().value() ,0);                                    //assert new root
        assertEquals((Double)101.0, tree.root().right().value());                               //assert children of new root
        assertEquals((Double)99.0,  tree.root().left().value());
        assertTrue(tree.root().right().right() == null);                                        //assert grandchildren of new root
        assertTrue(tree.root().right().left() == null);
        assertTrue(tree.root().left().right() == null);
        assertTrue(tree.root().left().left() == null);
    }
    
    @Test
    public void testRemove3(){                                                  //remove a leaf node
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode<Double>(100.0));            //create tree
        tree.insert(101.0);
        tree.insert(99.0);
        assertTrue(tree.remove(99.0));
        
        assertEquals(2, tree.size());
        assertEquals((Double) 100.0, tree.root().value(), 0);
        assertEquals((Double) 101.0, tree.root().right().value(),0);
        assertTrue(tree.root().right().right() == null);                                    
        assertTrue(tree.root().right().left() == null);
    }
    
    @Test
    public void testRemove4(){                                                  //remove an internal node with an nonempty left child
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode<Double>(100.0));            //create tree
        tree.insert(101.0);
        tree.insert(99.0);
        tree.insert(98.0);
        assertTrue(tree.remove(99.0));                                                          //remove
        
        assertEquals(3, tree.size());                                                           //assert size
        assertEquals((Double) 100.0, tree.root().value(), 0);                                   //assert  root    
        assertEquals((Double) 101.0, tree.root().right().value(),0);                            //assert root's children
        assertEquals((Double) 98.0, tree.root().left().value(),0);
        assertTrue(tree.root().right().right() == null);                                        //assert root's grandchildren
        assertTrue(tree.root().right().left() == null);
        assertTrue(tree.root().left().right() == null);
        assertTrue(tree.root().left().left() == null);
    }
    
    @Test
    public void testRemove5(){                                                  //remove an internal node with an nonempty right child
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode<Double>(100.0));            //create tree
        tree.insert(101.0);
        tree.insert(99.0);
        tree.insert(99.1);
        assertTrue(tree.remove(99.0));                                                          //remove
        
        assertEquals(3, tree.size());                                                           //assert size
        assertEquals((Double) 100.0, tree.root().value(), 0);                                   //assert  root    
        assertEquals((Double) 101.0, tree.root().right().value(),0);                            //assert root's children
        assertEquals((Double) 99.1, tree.root().left().value(),0);
        assertTrue(tree.root().right().right() == null);                                        //assert root's grandchildren
        assertTrue(tree.root().right().left() == null);
        assertTrue(tree.root().left().right() == null);
        assertTrue(tree.root().left().left() == null);
    }
    
    @Test
    public void testRemove6(){                                                  //remove an internal node with 2 nonempty children
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode<Double>(100.0));            //create tree
        tree.insert(101.0);
        tree.insert(99.0);
        tree.insert(99.9);
        tree.insert(98.0);
        tree.insert(99.5);
        assertTrue(tree.remove(99.0));                                                          //remove
        
        assertEquals(5, tree.size());                                                           //assert size
        assertEquals((Double) 100.0, tree.root().value(), 0);                                   //assert  root    
        assertEquals((Double) 101.0, tree.root().right().value(),0);                            //assert root's children
        assertEquals((Double) 99.5,  tree.root().left().value(),0);
        assertEquals((Double) 98.0, tree.root().left().left().value(),0);                       //assert root's grandchildren    
        assertEquals((Double) 99.9, tree.root().left().right().value(),0);
        
        assertTrue(tree.root().right().right() == null);                                        //assert other descendants
        assertTrue(tree.root().right().left() == null);
        assertTrue(tree.root().left().left().right() == null);
        assertTrue(tree.root().left().left().left() == null);
        assertTrue(tree.root().left().right().right() == null);
        assertTrue(tree.root().left().right().left() == null);
    }
    
    @Test
    public void testIsEmpty(){
        BinarySearchTree tree = new BinarySearchTree(null);
        assertTrue(tree.isEmpty());
    }
    
    @Test
    public void testEmpty(){
        BinarySearchTree tree = new BinarySearchTree(new BinaryNode<Double>(100.0));
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
