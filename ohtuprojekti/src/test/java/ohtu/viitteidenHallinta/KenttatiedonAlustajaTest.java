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
public class KenttatiedonAlustajaTest {
    
    public KenttatiedonAlustajaTest() {
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
     * Test of alustaTyypit method, of class KenttatiedonAlustaja.
     */
    @Test
    public void testAlustaTyypit() {
        boolean onkoOikein = true;
        ArrayList result = KenttatiedonAlustaja.alustaTyypit();
        ArrayList<String> testi = new ArrayList<String>();
        testi.add("article");
        testi.add("book");
        testi.add("booklet");
        testi.add("conference");
        testi.add("inbook");
        testi.add("incollection");
        testi.add("inproceedings");
        testi.add("manual");
        testi.add("mastersthesis");
        testi.add("misc");
        testi.add("phdthesis");
        testi.add("proceedings");
        testi.add("techreport");
        testi.add("unpublished");
        for (int i = 0; i < testi.size(); i++) {
            if (!result.get(i).equals(testi.get(i)))
                onkoOikein = false;
        }
        assertTrue(onkoOikein);
    }
    
    @Test
    public void testAlustaTyypitKoko() {
        boolean onkoOikein = true;
        ArrayList result = KenttatiedonAlustaja.alustaTyypit();
        int haluttuKoko = 14;
        assertEquals(haluttuKoko, result.size());
    }
    
    @Test
    public void testAlustaPakollisetKentatKoko() {
        ArrayList result = KenttatiedonAlustaja.alustaPakollisetKentat();
        int haluttuKoko = 14;
        assertEquals(haluttuKoko, result.size());
    }
    
    @Test
    public void testAlustaVapaaehtoisetKentatKoko() {
        ArrayList result = KenttatiedonAlustaja.alustaVapaaehtoisetKentat();
        int haluttuKoko = 14;
        assertEquals(haluttuKoko, result.size());
    }
    
    
}
