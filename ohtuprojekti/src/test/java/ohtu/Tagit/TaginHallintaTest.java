/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.Tagit;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import ohtu.viitteidenHallinta.Viite;
import ohtu.viitteidenHallinta.ViiteInterface;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author iimakis
 */
public class TaginHallintaTest {
    
    public TaginHallintaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of lisaaTageihinViite method, of class TaginHallinta.
     */
    @Test
    public void testLisaaTageihinViite() {
        ViiteInterface viite = null;
        ArrayList<String> viiteTagit = new ArrayList<String>();
        TaginHallinta instance = new TaginHallinta();
        boolean expResult = false;
        boolean result = instance.lisaaTageihinViite(viite, viiteTagit);
        assertEquals(expResult, result);
        
        viite = new Viite("Article", "2", null, null, null);
        viiteTagit = null;
        result = instance.lisaaTageihinViite(viite, viiteTagit);
        assertEquals(expResult, result);
        
        viiteTagit = new ArrayList<String>();
        viiteTagit.add("koira");
        viiteTagit.add("kissa");
        viite.setTagit(viiteTagit);
        
    }

    /**
     * Test of poistaTageistaViite method, of class TaginHallinta.
     */
    @Test
    public void testPoistaTageistaViite() {
        System.out.println("poistaTageistaViite");
        ViiteInterface viite = null;
        ArrayList<String> viiteTagit = null;
        TaginHallinta instance = new TaginHallinta();
        instance.poistaTageistaViite(viite, viiteTagit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTagit method, of class TaginHallinta.
     */
    @Test
    public void testGetTagit() {
        System.out.println("getTagit");
        TaginHallinta instance = new TaginHallinta();
        LinkedHashMap expResult = null;
        LinkedHashMap result = instance.getTagit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
