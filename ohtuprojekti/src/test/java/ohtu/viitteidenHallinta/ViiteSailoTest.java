/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wampie
 */
public class ViiteSailoTest {
    Viite viite;
    ViiteSailo sailo;
    public ViiteSailoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        String nimi = "testiviite";
        String id = "1";
        HashMap<String, String> pn = new HashMap<String, String>();
        pn.put("Nimi", "Pekka");
        pn.put("Titteli", "Tutkimus olusenjuonnista");
        HashMap<String, String> v = new HashMap<String, String>();
        v.put("Vuosi", "1245");
        
        viite = new Viite(nimi, id, pn, v);
        sailo = new ViiteSailo();
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testViiteListaOnTyhjaAlussa() {
        assertEquals(0, sailo.getViitteet().size());
    }
    
    @Test
    public void testViiteAddToimii() {
        sailo.addViite(viite);
        assertEquals(1, sailo.getViitteet().size());
    }
    
    @Test
    public void testMuokkaaPalauttaaFalseJosVääräID() {
        assertEquals(false, sailo.muokkaaViitetta("asdf", null, null));
    }
    @Test
    public void testMuokkaaPalauttaaTrueJosOikeaID() {
        sailo.addViite(viite);
        assertEquals(true, sailo.muokkaaViitetta("1", null, null));
    }
    @Test
    public void testMuokkaaMuokkaa() {
        sailo.addViite(viite);
        HashMap<String, String> p = new HashMap<String, String>();
        p.put("Nimi", "Mikko");
        p.put("Titteli", "Tutkimus olusenjuonnista");
        HashMap<String, String> v = new HashMap<String, String>();
        v.put("Vuosi", "");
        sailo.muokkaaViitetta("1", p, v);
        HashMap<String, String> viite = sailo.haeViite("1").getPakollisetKentat();
        assertEquals(true, viite.containsValue("Mikko")
                && viite.containsValue("Tutkimus olusenjuonnista"));
    }
    @Test
    public void testHaePalauttaNullJosVääräID() {
        assertEquals(null, sailo.haeViite("asdff"));
    }
    @Test
    public void testHaePalauttaViite() {
        sailo.addViite(viite);
        assertEquals(viite, sailo.haeViite("1"));
    }
    @Test
    public void printTyhjaLista() {
        assertEquals("", sailo.listaaViitteet());
    }
    @Test
    public void printLista() {
        sailo.addViite(viite);
        assertEquals(true, sailo.listaaViitteet().length() > 0);
    }
    
    
}
