/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;
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
        ArrayList<String> list = new ArrayList<String>();
        list.add("asd");
        list.add("asd");
        list.add("asd");
        assertEquals(true, tark.tarkistaPakolliset(list));
    }
    
    @Test
    public void testTarkistaPakollisetEIToimi() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("asd");
        list.add("asd");
        list.add("");
        assertEquals(false, tark.tarkistaPakolliset(list));
    }
}
