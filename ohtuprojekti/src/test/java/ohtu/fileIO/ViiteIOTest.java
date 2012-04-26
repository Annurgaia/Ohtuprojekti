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
        LinkedHashMap<String, ViiteInterface> viite = vio.lueViitteetTiedostosta("testit");
        assertEquals(true, viite.containsKey(viites.getId()));
    }
    
    @Test
    public void tallenna100TiedostoonTesti() throws IOException{
        ViiteSailo s = new ViiteSailo();
        for(int i = 0; i <= 100; i++){
            s.addViite(viites);
        }
        vio.tallennaViitteetTiedostoon(s);
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
        LinkedHashMap<String, ViiteInterface> testi;
        testi = vio.lueViitteetTiedostosta("testit");
        assertEquals(true, testi.containsKey("W06"));
    }
    
    @Test
    public void poistaTiedostoTesti(){
        File f = new File("testit.json");
        vio.poistaViiteTiedosto("testit.json");
        assertEquals(false, f.exists());
    }
    
}