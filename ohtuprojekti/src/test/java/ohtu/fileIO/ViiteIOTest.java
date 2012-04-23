package ohtu.fileIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.viitteidenHallinta.Viite;
import ohtu.viitteidenHallinta.ViiteInterface;
import ohtu.viitteidenHallinta.ViiteSailo;
import ohtu.viitteidenHallinta.ViiteSailoInterface;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;



public class ViiteIOTest{
    
    Viite viites;
    ViiteIO vio;
    
    @Before
    public void setUp() throws IOException{
        LinkedHashMap pakollisetKentat = new LinkedHashMap<String, String>();
        LinkedHashMap vapaaehtoisetKentat = new LinkedHashMap<String, String>();
        
        pakollisetKentat.put("author", "nimiö");
        pakollisetKentat.put("title", "TestiTitleå");
        pakollisetKentat.put("journal", "TestJournalä");
        pakollisetKentat.put("year", "1994");
        vapaaehtoisetKentat.put("number", "5");
        vapaaehtoisetKentat.put("pages", "18");
        vio = new ViiteIO("testit");
        viites = new Viite("article", "W06", pakollisetKentat, vapaaehtoisetKentat);
    }
    
    @Test
    public void tallenaTiedostoonTesti() throws IOException{
        vio.tallennaViiteTiedostoon(viites);
        ArrayList<ViiteInterface> viite = vio.lueViitteetTiedostosta("testit");
        assertEquals(true, viites.getId().equals(viite.get(0).getId()));
    }
    
    @Test
    public void tallenaViitteetTiedostoonTesti(){
        ViiteSailoInterface sailio = new ViiteSailo();
        sailio.addViite(viites);
        sailio.addViite(viites);
        try {
            vio.tallennaViitteetTiedostoon(sailio);
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
    }
    
    @Test
    public void lueTiedostostaTesti() throws IOException{
        ArrayList<ViiteInterface> testi;
        testi = vio.lueViitteetTiedostosta("testit");
        System.out.println(testi.get(0).getId());
    }
    
    @Test
    public void poistaTiedostoTesti(){
        File f = new File("testit.json");
        vio.poistaViiteTiedosto("testit.json");
        assertEquals(false, f.exists());
    }
    
}