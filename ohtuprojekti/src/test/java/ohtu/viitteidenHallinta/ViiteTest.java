/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author iimakis
 */
public class ViiteTest {
    
    public ViiteTest() {
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
     * Test of getId method, of class Viite.
     */
    @Test
    public void testGetId() {
        Viite instance = new Viite("article", "W06", new ArrayList<String>(), new ArrayList<String>());
        String expResult = "W06";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPakollisetKentat method, of class Viite.
     */
    @Test
    public void testGetPakollisetKentat() {
        ArrayList<String> pakollisetKentat = new ArrayList<String>();
        pakollisetKentat.add("nimi");
        Viite instance = new Viite("article", "W06", pakollisetKentat, new ArrayList<String>());
        String expResult = "nimi";
        String result = instance.getPakollisetKentat().get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class Viite.
     */
    @Test
    public void testGetType() {
        Viite instance = new Viite("article", "W06", new ArrayList<String>(), new ArrayList<String>());
        String expResult = "article";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVapaaehtoisetKentat method, of class Viite.
     */
    @Test
    public void testGetVapaaehtoisetKentat() {
        ArrayList<String> vapaaehtoisetKentat = new ArrayList<String>();
        vapaaehtoisetKentat.add("nimi");
        Viite instance = new Viite("article", "W06", new ArrayList<String>(), vapaaehtoisetKentat);
        String expResult = "nimi";
        String result = instance.getVapaaehtoisetKentat().get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of setPakollisetKentat method, of class Viite.
     */
    @Test
    public void testSetPakollisetKentat() {
        ArrayList<String> pakollisetKentat = new ArrayList<String>();
        pakollisetKentat.add("nimi");
        Viite instance = new Viite("article", "W06", pakollisetKentat, new ArrayList<String>());
        ArrayList<String> uusi = new ArrayList<String>();
        uusi.add("nimuh");
        instance.setPakollisetKentat(uusi);
        String expResult = "nimuh";
        String result = instance.getPakollisetKentat().get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of setVapaaehtoisetKentat method, of class Viite.
     */
    @Test
    public void testSetVapaaehtoisetKentat() {
        ArrayList<String> vapaaehtoisetKentat = new ArrayList<String>();
        vapaaehtoisetKentat.add("nimi");
        Viite instance = new Viite("article", "W06", new ArrayList<String>(), vapaaehtoisetKentat);
        ArrayList<String> uusi = new ArrayList<String>();
        uusi.add("nimuh");
        instance.setVapaaehtoisetKentat(uusi);
        String expResult = "nimuh";
        String result = instance.getVapaaehtoisetKentat().get(0);
        assertEquals(expResult, result);
    }
}
