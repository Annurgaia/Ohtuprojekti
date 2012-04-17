/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.*;

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
        HashMap<String, String> resultList = new HashMap<String, String>();
        resultList.put("author", null);
        resultList.put("title", null);
        resultList.put("journal", null);
        resultList.put("year", null);
        boolean toimiiko = true;
        ViitetyyppienKenttainformaatio instance = new ViitetyyppienKenttainformaatio();
        HashMap<String, String> result = instance.getTyypinPakollisetKentat(tyyppi);
        for(Map.Entry<String, String> entry : result.entrySet()){
            if(!resultList.containsKey(entry.getKey()))
                toimiiko = false;
        }
        assertTrue(toimiiko);
    }
    
    @Test
    public void testGetTyypinPakollisetKentat2() {
        String tyyppi = "articla";
        HashMap<String, String> resultList = new HashMap<String, String>();
        ViitetyyppienKenttainformaatio instance = new ViitetyyppienKenttainformaatio();
        HashMap<String, String> result = instance.getTyypinPakollisetKentat(tyyppi);
        HashMap expresult = null;
        assertEquals(expresult, result);
    }


    /**
     * Test of getTyypinVapaaehtoisetKentat method, of class ViitetyyppienKenttainformaatio.
     */
    @Test
    public void testGetTyypinVapaaehtoisetKentat() {
        String tyyppi = "article";
        HashMap<String, String> resultList = new HashMap<String, String>();
        resultList.put("volume", null);
        resultList.put("number", null);
        resultList.put("pages", null);
        resultList.put("month", null);
        resultList.put("note", null);
        resultList.put("key", null);
        boolean toimiiko = true;
        ViitetyyppienKenttainformaatio instance = new ViitetyyppienKenttainformaatio();
        HashMap<String, String> result = instance.getTyypinVapaaehtoisetKentat(tyyppi);
        for(Map.Entry<String, String> entry : result.entrySet()){
            if(!resultList.containsKey(entry.getKey()))
                toimiiko = false;
        }
        assertTrue(toimiiko);
    }
    
    
    
    @Test
    public void testGetTyypinVapaaehtoisetKentat2() {
        String tyyppi = "";
        HashMap<String, String> resultList = new HashMap<String, String>();
        ViitetyyppienKenttainformaatio instance = new ViitetyyppienKenttainformaatio();
        HashMap<String, String> result = instance.getTyypinVapaaehtoisetKentat(tyyppi);
        HashMap expresult = null;
        assertEquals(expresult, result);
    }
    
        @Test
    public void testGetTyypinVapaaehtoisetKentat3() {
        String tyyppi = "ARTICLE";
        HashMap<String, String> resultList = new HashMap<String, String>();
        resultList.put("volume", null);
        resultList.put("number", null);
        resultList.put("pages", null);
        resultList.put("month", null);
        resultList.put("note", null);
        resultList.put("key", null);
        boolean toimiiko = true;
        ViitetyyppienKenttainformaatio instance = new ViitetyyppienKenttainformaatio();
        HashMap<String, String> result = instance.getTyypinVapaaehtoisetKentat(tyyppi);

        for(Map.Entry<String, String> entry : result.entrySet()){
            if(!resultList.containsKey(entry.getKey()))
                toimiiko = false;
        }
        assertTrue(toimiiko);
    }
}
