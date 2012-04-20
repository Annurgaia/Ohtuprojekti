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

/**
 *
 * @author iimakis
 */
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
        hal.lisaaViite(tyyppi, pKentat, vKentat);
        String expresult = tyyppi;
        String result = hal.getViiteLista().get(0).getType();
        assertEquals(expresult, result);
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
        hal.lisaaViite(tyyppi, pKentat, vKentat);
        LinkedHashMap<String, String> uusi = new LinkedHashMap<String, String>();
        uusi.put("a", "b");
        boolean onnistuiko = hal.muokkaaViitetta("0", uusi, vKentat);
        boolean onnistuiko2 = hal.muokkaaViitetta("3", uusi, vKentat);
        boolean expresult = true;
        boolean result = hal.getViiteLista().get(0).getPakollisetKentat().containsKey("a");
        assertEquals(expresult, result);
        assertTrue(onnistuiko);
        assertFalse(onnistuiko2);
    }

    
    @Test
    public void testMuokkaaViitettaTrue() throws IOException {
        ViiteSailo mockViiteSailo = mock(ViiteSailo.class);
        ViitetyyppienKenttainformaatio mockInfo = mock(ViitetyyppienKenttainformaatio.class);
        Bibtex mockBibtex = mock(Bibtex.class);
        ViiteIO mockViiteIO = mock(ViiteIO.class);
        ViiteHallinta instance = new ViiteHallinta(mockBibtex, mockInfo, mockViiteIO, mockViiteSailo);
        LinkedHashMap<String, String> uusi = new LinkedHashMap<String, String>();
        when(mockViiteSailo.muokkaaViitetta("2", uusi, uusi)).thenReturn(true);
        boolean expResult = true;
        boolean result = instance.muokkaaViitetta("2", uusi, uusi);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMuokkaaViitettaFalse() throws IOException {
        ViiteSailo mockViiteSailo = mock(ViiteSailo.class);
        ViitetyyppienKenttainformaatio mockInfo = mock(ViitetyyppienKenttainformaatio.class);
        Bibtex mockBibtex = mock(Bibtex.class);
        ViiteIO mockViiteIO = mock(ViiteIO.class);
        ViiteHallinta instance = new ViiteHallinta(mockBibtex, mockInfo, mockViiteIO, mockViiteSailo);
        LinkedHashMap<String, String> uusi = new LinkedHashMap<String, String>();
        when(mockViiteSailo.muokkaaViitetta("2", uusi, uusi)).thenReturn(false);
        boolean expResult = false;
        boolean result = instance.muokkaaViitetta("2", uusi, uusi);
        assertEquals(expResult, result);
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
        System.out.println("getTyypinPakollisetKentat");
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
        System.out.println("getTyypinVapaaehtoisetKentat");
        String tyyppi = "";
        ViiteHallinta instance = new ViiteHallinta();
        LinkedHashMap expResult = null;
        LinkedHashMap result = instance.getTyypinVapaaehtoisetKentat(tyyppi);
        assertEquals(expResult, result);
    }
}
