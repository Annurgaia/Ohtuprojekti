/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import ohtu.bibtex.Bibtex;
import ohtu.fileIO.ViiteIO;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ViiteHallintaTest {

    public ViiteHallintaTest() {
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
     * Test of lisaaViite method, of class ViiteHallinta.
     */
    @Test
    public void testLisaaViite() throws IOException {
        ViiteHallinta hal = new ViiteHallinta();
        String tyyppi = "article";
        LinkedHashMap<String, String> pKentat = null;
        LinkedHashMap<String, String> vKentat = null;
        hal.lisaaViite(tyyppi, "koira,kissa,kala", pKentat, vKentat);
        String expresult = tyyppi;
        Object[] duh = hal.getViiteLista().values().toArray();
        Viite viite = (Viite) duh[duh.length - 1];
        String result = viite.getType();
        assertEquals(expresult, result);
        
        assertTrue(hal.getTagit().containsKey("koira"));
        assertTrue(hal.getTagit().containsKey("kissa"));
        assertTrue(hal.getTagit().containsKey("kala"));
    }

    /**
     * Test of muokkaaViitetta method, of class ViiteHallinta.
     */
    @Test
    public void testMuokkaaViite() throws IOException {
        ViiteHallinta hal = new ViiteHallinta();
        String tyyppi = "Article";
        LinkedHashMap<String, String> pKentat = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> vKentat = new LinkedHashMap<String, String>();
        hal.lisaaViite(tyyppi, "", pKentat, vKentat);
        LinkedHashMap<String, String> uusi = new LinkedHashMap<String, String>();
        uusi.put("a", "b");
        boolean onnistuiko = hal.muokkaaViitetta("0", "",uusi, vKentat);
        boolean onnistuiko2 = hal.muokkaaViitetta("asd", "",uusi, vKentat);
        boolean expresult = true;
        boolean result = hal.getViiteLista().get("0").getPakollisetKentat().containsKey("a");
        assertEquals(expresult, result);
        assertTrue(onnistuiko);
        assertFalse(onnistuiko2);
    }

    /**
     * Test of getViitteetTekstina method, of class ViiteHallinta.
     */
    @Test
    public void testGetViitteetTekstina() throws IOException {
        ViiteSailo mockViiteSailo = mock(ViiteSailo.class);
        ViitetyyppienKenttainformaatio mockInfo = mock(ViitetyyppienKenttainformaatio.class);
        Bibtex mockBibtex = mock(Bibtex.class);
        ViiteIO mockViiteIO = mock(ViiteIO.class);
        ViiteHallinta instance = new ViiteHallinta(mockBibtex, mockInfo, mockViiteIO, mockViiteSailo);
        instance.getViitteetTekstina();
        verify(mockViiteSailo, times(1)).listaaViitteet();
    }

    /**
     * Test of getViiteLista method, of class ViiteHallinta.
     */
    @Test
    public void testGetViiteLista() throws IOException {
        ViiteSailo mockViiteSailo = mock(ViiteSailo.class);
        ViitetyyppienKenttainformaatio mockInfo = mock(ViitetyyppienKenttainformaatio.class);
        Bibtex mockBibtex = mock(Bibtex.class);
        ViiteIO mockViiteIO = mock(ViiteIO.class);
        ViiteHallinta instance = new ViiteHallinta(mockBibtex, mockInfo, mockViiteIO, mockViiteSailo);
        instance.getViiteLista();
        verify(mockViiteSailo, times(1)).getViitteet();
    }

    /**
     * Test of teeViitteistaBibtex method, of class ViiteHallinta.
     */
    @Test
    public void testTeeViitteistaBibtex() throws Exception {
        ViiteSailo mockViiteSailo = mock(ViiteSailo.class);
        ViitetyyppienKenttainformaatio mockInfo = mock(ViitetyyppienKenttainformaatio.class);
        Bibtex mockBibtex = mock(Bibtex.class);
        ViiteIO mockViiteIO = mock(ViiteIO.class);
        ViiteHallinta instance = new ViiteHallinta(mockBibtex, mockInfo, mockViiteIO, mockViiteSailo);
        instance.teeViitteistaBibtex("filu");
        verify(mockBibtex, times(1)).tallennaBibtexitTiedostoon(mockViiteSailo, "filu");
    }

    /**
     * Test of tallennaViitteet method, of class ViiteHallinta.
     */
    @Test
    public void testTallennaViitteet() throws Exception {
        ViiteSailo mockViiteSailo = mock(ViiteSailo.class);
        ViitetyyppienKenttainformaatio mockInfo = mock(ViitetyyppienKenttainformaatio.class);
        Bibtex mockBibtex = mock(Bibtex.class);
        ViiteIO mockViiteIO = mock(ViiteIO.class);
        ViiteHallinta instance = new ViiteHallinta(mockBibtex, mockInfo, mockViiteIO, mockViiteSailo);
        instance.tallennaViitteet();
        verify(mockViiteIO, times(1)).tallennaViitteetTiedostoon(mockViiteSailo);
    }

    /**
     * Test of getTyypit method, of class ViiteHallinta.
     */
    @Test
    public void testGetTyypit() throws IOException {
        ViiteHallinta instance = new ViiteHallinta();
        String expResult = "article";
        String result = instance.getTyypit().get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTyypinPakollisetKentat method, of class ViiteHallinta.
     */
    @Test
    public void testGetTyypinPakollisetKentat() throws IOException {
        String tyyppi = "";
        ViiteHallinta instance = new ViiteHallinta();
        LinkedHashMap expResult = null;
        LinkedHashMap result = instance.getTyypinPakollisetKentat(tyyppi);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTyypinVapaaehtoisetKentat method, of class ViiteHallinta.
     */
    @Test
    public void testGetTyypinVapaaehtoisetKentat() throws IOException {
        String tyyppi = "";
        ViiteHallinta instance = new ViiteHallinta();
        LinkedHashMap expResult = null;
        LinkedHashMap result = instance.getTyypinVapaaehtoisetKentat(tyyppi);
        assertEquals(expResult, result);
    }

    @Test
    public void testPoistaViite() throws IOException {
        ViiteHallinta hal = new ViiteHallinta();
        String tyyppi = "article";
        LinkedHashMap<String, String> pKentat = null;
        LinkedHashMap<String, String> vKentat = null;
        hal.lisaaViite(tyyppi, "", pKentat, vKentat);
        Object[] duh = hal.getViiteLista().values().toArray();
        Viite viite = (Viite) duh[duh.length - 1];
        boolean result = hal.poistaViite(viite.getId());
        boolean result2 = hal.poistaViite(viite.getId());
        boolean expResult = true;
        boolean expResult2 = false;
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
    }
}
