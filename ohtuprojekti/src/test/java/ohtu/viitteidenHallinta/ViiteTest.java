/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
        Viite instance = new Viite("article", "W06", new LinkedHashMap<String, String>(), new LinkedHashMap<String, String>());
        String expResult = "W06";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPakollisetKentat method, of class Viite.
     */
    @Test
    public void testGetPakollisetKentat() {
        LinkedHashMap<String, String> pakollisetKentat = new LinkedHashMap<String, String>();
        pakollisetKentat.put("nimi", null);
        Viite instance = new Viite("article", "W06", pakollisetKentat, new LinkedHashMap<String, String>());
        String expResult = "nimi";
        Boolean result = instance.getPakollisetKentat().containsKey(expResult);
        assertEquals(true, result);
    }
    
    /**
     * Test of getType method, of class Viite.
     */
    @Test
    public void testGetType() {
        Viite instance = new Viite("article", "W06", new LinkedHashMap<String, String>(), new LinkedHashMap<String, String>());
        String expResult = "article";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVapaaehtoisetKentat method, of class Viite.
     */
    @Test
    public void testGetVapaaehtoisetKentat() {
        LinkedHashMap<String, String> vapaaehtoisetKentat = new LinkedHashMap<String, String>();
        vapaaehtoisetKentat.put("nimi", null);
        Viite instance = new Viite("article", "W06", new LinkedHashMap<String, String>(), vapaaehtoisetKentat);
        String expResult = "nimi";
        Boolean result = instance.getVapaaehtoisetKentat().containsKey(expResult);
        assertEquals(true, result);
    }

    /**
     * Test of setPakollisetKentat method, of class Viite.
     */
    @Test
    public void testSetPakollisetKentat() {
        LinkedHashMap<String, String> pakollisetKentat = new LinkedHashMap<String, String>();
        pakollisetKentat.put("nimi", null);
        Viite instance = new Viite("article", "W06", pakollisetKentat, new LinkedHashMap<String, String>());
        LinkedHashMap<String, String> uusi = new LinkedHashMap<String, String>();
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
        LinkedHashMap<String, String> vapaaehtoisetKentat = new LinkedHashMap<String, String>();
        vapaaehtoisetKentat.put("nimi", null);
        Viite instance = new Viite("article", "W06", new LinkedHashMap<String, String>(), vapaaehtoisetKentat);
        LinkedHashMap<String, String> uusi = new LinkedHashMap<String, String>();
        uusi.put("nimuh", null);
        instance.setVapaaehtoisetKentat(uusi);
        String expResult = "nimuh";
        Boolean result = instance.getVapaaehtoisetKentat().containsKey(expResult);
        assertEquals(true, result);
    }
}
