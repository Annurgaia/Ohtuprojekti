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
        // tapaus, jossa Viite on null ja viiteTagit olemassa
        ViiteInterface viite = null;
        ArrayList<String> viiteTagit = new ArrayList<String>();
        TaginHallinta instance = new TaginHallinta();
        boolean expResult = false;
        boolean result = instance.lisaaTageihinViite(viite, viiteTagit);
        assertEquals(expResult, result);
        
        //tapaus, jossa Viite olemassa, mutta viitetagit null
        viite = new Viite("Article", "2", null, null, null);
        viiteTagit = null;
        result = instance.lisaaTageihinViite(viite, viiteTagit);
        assertEquals(expResult, result);
        
        //tarkistetaan, että viitteen lisäys onnistuu ja että asiat on todella lisätty
        viiteTagit = new ArrayList<String>();
        viiteTagit.add("koira");
        viiteTagit.add("kissa");
        viite.setTagit(viiteTagit);
        expResult = true;
        result = instance.lisaaTageihinViite(viite, viiteTagit);
        assertEquals(expResult, result);
        assertTrue(instance.getTagit().containsKey("koira"));
        assertTrue(instance.getTagit().containsKey("kissa"));
        assertFalse(instance.getTagit().containsKey("kissat"));
        
        //tarkistetaan, että toisen asian lisääminen onnistuu ja sisältö tämän jälkeen kunnossa
        ArrayList<String> viiteTagit2 = new ArrayList<String>();
        viiteTagit2.add("kissa");
        viiteTagit2.add("kala");
        ViiteInterface viite2 = new Viite("Book", "3", viiteTagit2, null, null);
        result = instance.lisaaTageihinViite(viite2, viiteTagit2);
        assertEquals(expResult, result);
        assertTrue(instance.getTagit().get("kissa").containsKey("2"));
        assertTrue(instance.getTagit().get("kissa").containsKey("3"));
        assertTrue(instance.getTagit().get("koira").containsKey("2"));
        assertTrue(instance.getTagit().get("kala").containsKey("3"));
        assertFalse(instance.getTagit().get("kala").containsKey("2"));
        assertFalse(instance.getTagit().get("koira").containsKey("3"));
        
        // tarkistetaan, ettei lisääminen olemassaolevaan viite-tagi -pariin onnistu
        expResult = false;
        result = instance.lisaaTageihinViite(viite, viiteTagit);
        assertEquals(expResult, result);
    }

    /**
     * Test of poistaTageistaViite method, of class TaginHallinta.
     */
    @Test
    public void testPoistaTageistaViite() {
        // lisätään ensin 2 viitettä, joilla tägejä ja tarkistetaan että kaikki aluksi kunnossa
        TaginHallinta instance = new TaginHallinta();
        ArrayList<String> viiteTagit = new ArrayList<String>();
        viiteTagit.add("yksi");
        viiteTagit.add("kaksi");
        viiteTagit.add("kolme");
        ViiteInterface viite = new Viite("Book", "3", viiteTagit, null, null);
        instance.lisaaTageihinViite(viite, viiteTagit);
        
        ArrayList<String> viiteTagit2 = new ArrayList<String>();
        viiteTagit2.add("yksi");
        viiteTagit2.add("nelja");
        viiteTagit2.add("viisi");
        ViiteInterface viite2 = new Viite("Book", "4", viiteTagit2, null, null);
        instance.lisaaTageihinViite(viite2, viiteTagit2);
        assertTrue(instance.getTagit().containsKey("yksi"));
        assertTrue(instance.getTagit().containsKey("kaksi"));
        assertTrue(instance.getTagit().containsKey("kolme"));
        assertTrue(instance.getTagit().containsKey("nelja"));
        assertTrue(instance.getTagit().containsKey("viisi"));
        
        //yritetään poistaa niin, että viite on null (ei pitäisi onnistua)
        boolean expResult = false;
        boolean result = instance.poistaTageistaViite(null, viiteTagit);
        assertEquals(expResult, result);
        
        // yritetään poistaa niin, että tägilista on null (ei pitäisi onnistua)
        result = instance.poistaTageistaViite(viite, null);
        assertEquals(expResult, result);
        
        // poistetaan ensimmäinen viite ja sen tägit ja katsotaan että toisen
        // tiedot säilyneet ja ensimmäisen poistuneet
        expResult = true;
        result = instance.poistaTageistaViite(viite, viiteTagit);
        assertEquals(expResult, result);
        assertTrue(instance.getTagit().containsKey("yksi"));
        assertFalse(instance.getTagit().containsKey("kaksi"));
        assertFalse(instance.getTagit().containsKey("kolme"));
        assertTrue(instance.getTagit().containsKey("nelja"));
        assertTrue(instance.getTagit().containsKey("viisi"));
        assertFalse(instance.getTagit().get("yksi").containsValue(viite));
        assertTrue(instance.getTagit().get("yksi").containsValue(viite2));
        
        //yritetään poistaa viitettä, jota ei ole olemassa ja katsotaan etteivät tiedot muutu
        result = instance.poistaTageistaViite(viite, viiteTagit);
        assertEquals(expResult, result);
        assertTrue(instance.getTagit().containsKey("yksi"));
        assertFalse(instance.getTagit().containsKey("kaksi"));
        assertFalse(instance.getTagit().containsKey("kolme"));
        assertTrue(instance.getTagit().containsKey("nelja"));
        assertTrue(instance.getTagit().containsKey("viisi"));
        assertFalse(instance.getTagit().get("yksi").containsValue(viite));
        assertTrue(instance.getTagit().get("yksi").containsValue(viite2));
        
        // poistetaan jäljellä oleva tägi ja varmistetaan että tiedot oikein.
        result = instance.poistaTageistaViite(viite2, viiteTagit2);
        assertEquals(expResult, result);
        assertFalse(instance.getTagit().containsKey("yksi"));
        assertFalse(instance.getTagit().containsKey("kaksi"));
        assertFalse(instance.getTagit().containsKey("kolme"));
        assertFalse(instance.getTagit().containsKey("nelja"));
        assertFalse(instance.getTagit().containsKey("viisi"));
    }

    /**
     * Test of getTagit method, of class TaginHallinta.
     */
    @Test
    public void testGetTagit() {
        TaginHallinta instance = new TaginHallinta();
        ArrayList<String> viiteTagit = new ArrayList<String>();
        viiteTagit.add("yksi");
        viiteTagit.add("kaksi");
        viiteTagit.add("kolme");
        ViiteInterface viite = new Viite("Book", "3", viiteTagit, null, null);
        instance.lisaaTageihinViite(viite, viiteTagit);
        
        ArrayList<String> viiteTagit2 = new ArrayList<String>();
        viiteTagit2.add("yksi");
        viiteTagit2.add("nelja");
        viiteTagit2.add("viisi");
        ViiteInterface viite2 = new Viite("Book", "4", viiteTagit2, null, null);
        instance.lisaaTageihinViite(viite2, viiteTagit2);
        
        assertTrue(instance.getTagit().containsKey("yksi"));
        assertTrue(instance.getTagit().containsKey("kaksi"));
        assertTrue(instance.getTagit().containsKey("kolme"));
        assertTrue(instance.getTagit().containsKey("nelja"));
        assertTrue(instance.getTagit().containsKey("viisi"));
        assertTrue(instance.getTagit().get("yksi").containsValue(viite));
        assertTrue(instance.getTagit().get("yksi").containsValue(viite2));
        assertFalse(instance.getTagit().get("nelja").containsValue(viite));
    }
}
