

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TourTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TourTest
{
    /**
     * Default constructor for test class TourTest
     */
    public TourTest()
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
    
    public DirectedGraph<Integer> createMap(){
        Controller c = new Controller();
        DirectedGraph<Integer> g = c.createMap("city_ex.txt", "sites_ex.txt");
        return g;
    }
    
    @Test
    public void testAddDesiredSites(){
        DirectedGraph<Integer> g = createMap();
        Tour<Integer> t = new Tour(g, g.find(10), 100);
        t.addDesiredSite(15);
        t.addDesiredSite(30);
        assertEquals(1,t.getDesiredSites().size());
        assertEquals((Integer) 15,t.getDesiredSites().get(0).key());
    }
    
    @Test
    public void testVisitDesiredSites(){
        DirectedGraph<Integer> g = createMap();
        Tour<Integer> t = new Tour(g, g.find(10), 100);
        t.addDesiredSite(15);
        t.visitDesiredSite();
        Path<Integer> p = t.path(); 
        assertEquals((Integer) 10, p.getRoute().get(0).key());
        assertEquals((Integer) 15, p.getRoute().get(1).key());
    }
}
