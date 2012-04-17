/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;
import java.util.HashMap;
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
        Viite instance = new Viite("article", "W06", new HashMap<String, String>(), new HashMap<String, String>());
        String expResult = "W06";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPakollisetKentat method, of class Viite.
     */
    @Test
    public void testGetPakollisetKentat() {
        HashMap<String, String> pakollisetKentat = new HashMap<String, String>();
        pakollisetKentat.put("nimi", null);
        Viite instance = new Viite("article", "W06", pakollisetKentat, new HashMap<String, String>());
        String expResult = "nimi";
        Boolean result = instance.getPakollisetKentat().containsKey(expResult);
        assertEquals(true, result);
    }
    
    /**
     * Test of getType method, of class Viite.
     */
    @Test
    public void testGetType() {
        Viite instance = new Viite("article", "W06", new HashMap<String, String>(), new HashMap<String, String>());
        String expResult = "article";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVapaaehtoisetKentat method, of class Viite.
     */
    @Test
    public void testGetVapaaehtoisetKentat() {
        HashMap<String, String> vapaaehtoisetKentat = new HashMap<String, String>();
        vapaaehtoisetKentat.put("nimi", null);
        Viite instance = new Viite("article", "W06", new HashMap<String, String>(), vapaaehtoisetKentat);
        String expResult = "nimi";
        Boolean result = instance.getVapaaehtoisetKentat().containsKey(expResult);
        assertEquals(true, result);
    }

    /**
     * Test of setPakollisetKentat method, of class Viite.
     */
    @Test
    public void testSetPakollisetKentat() {
        HashMap<String, String> pakollisetKentat = new HashMap<String, String>();
        pakollisetKentat.put("nimi", null);
        Viite instance = new Viite("article", "W06", pakollisetKentat, new HashMap<String, String>());
        HashMap<String, String> uusi = new HashMap<String, String>();
        uusi.put("nimuh", null);
        instance.setPakollisetKentat(uusi);
        String expResult = "nimuh";
        Boolean result = instance.getPakollisetKentat().containsKey(expResult);
        assertEquals(true, result);
    }

    /**
     * Test of setVapaaehtoisetKentat method, of class Viite.
     */
    @Test
    public void testSetVapaaehtoisetKentat() {
        HashMap<String, String> vapaaehtoisetKentat = new HashMap<String, String>();
        vapaaehtoisetKentat.put("nimi", null);
        Viite instance = new Viite("article", "W06", new HashMap<String, String>(), vapaaehtoisetKentat);
        HashMap<String, String> uusi = new HashMap<String, String>();
        uusi.put("nimuh", null);
        instance.setVapaaehtoisetKentat(uusi);
        String expResult = "nimuh";
        Boolean result = instance.getVapaaehtoisetKentat().containsKey(expResult);
        assertEquals(true, result);
    }
}
