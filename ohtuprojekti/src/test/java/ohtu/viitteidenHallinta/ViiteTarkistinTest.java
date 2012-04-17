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
public class ViiteTarkistinTest {
    ViiteTarkistin tark;
    public ViiteTarkistinTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        tark = new ViiteTarkistin();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testTarkistaPakollisetToimii() {
        HashMap<String, String> list = new HashMap<String, String>();
        list.put("asd", "asd");
        list.put("123", "123");
        list.put("tttt", "asdsdd");
        assertEquals(true, tark.tarkistaPakolliset(list));
    }
    
    @Test
    public void testTarkistaPakollisetEIToimi() {
        HashMap<String, String> list = new HashMap<String, String>();
        list.put("asd", "asdsad");
        list.put("asd", "adälg");
        list.put("", "");
        assertEquals(false, tark.tarkistaPakolliset(list));
    }
}
