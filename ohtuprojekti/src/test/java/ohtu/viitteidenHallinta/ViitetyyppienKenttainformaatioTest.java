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
public class ViitetyyppienKenttainformaatioTest {
    
    public ViitetyyppienKenttainformaatioTest() {
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
     * Test of getTyypinPakollisetKentat method, of class ViitetyyppienKenttainformaatio.
     */
    @Test
    public void testGetTyypinPakollisetKentat() {
        String tyyppi = "article";
        ArrayList<String> resultList = new ArrayList<String>();
        resultList.add("author");
        resultList.add("title");
        resultList.add("journal");
        resultList.add("year");
        boolean toimiiko = true;
        ViitetyyppienKenttainformaatio instance = new ViitetyyppienKenttainformaatio();
        ArrayList result = instance.getTyypinPakollisetKentat(tyyppi);
        for (int i = 0; i < resultList.size(); i++) {
            if (!result.get(i).equals(resultList.get(i)))
                toimiiko = false;
        }
        assertTrue(toimiiko);
    }
    
    @Test
    public void testGetTyypinPakollisetKentat2() {
        String tyyppi = "articla";
        ArrayList<String> resultList = new ArrayList<String>();
        ViitetyyppienKenttainformaatio instance = new ViitetyyppienKenttainformaatio();
        ArrayList result = instance.getTyypinPakollisetKentat(tyyppi);
        ArrayList expresult = null;
        assertEquals(expresult, result);
    }


    /**
     * Test of getTyypinVapaaehtoisetKentat method, of class ViitetyyppienKenttainformaatio.
     */
    @Test
    public void testGetTyypinVapaaehtoisetKentat() {
        String tyyppi = "article";
        ArrayList<String> resultList = new ArrayList<String>();
        resultList.add("volume");
        resultList.add("number");
        resultList.add("pages");
        resultList.add("month");
        resultList.add("note");
        resultList.add("key");
        boolean toimiiko = true;
        ViitetyyppienKenttainformaatio instance = new ViitetyyppienKenttainformaatio();
        ArrayList result = instance.getTyypinVapaaehtoisetKentat(tyyppi);
        for (int i = 0; i < resultList.size(); i++) {
            if (!result.get(i).equals(resultList.get(i)))
                toimiiko = false;
        }
        assertTrue(toimiiko);
    }
    
    @Test
    public void testGetTyypinVapaaehtoisetKentat2() {
        String tyyppi = "";
        ArrayList<String> resultList = new ArrayList<String>();
        ViitetyyppienKenttainformaatio instance = new ViitetyyppienKenttainformaatio();
        ArrayList result = instance.getTyypinVapaaehtoisetKentat(tyyppi);
        ArrayList expresult = null;
        assertEquals(expresult, result);
    }
}
