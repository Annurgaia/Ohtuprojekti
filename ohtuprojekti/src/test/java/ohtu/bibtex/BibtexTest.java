package ohtu.bibtex;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import ohtu.viitteidenHallinta.Viite;
import ohtu.viitteidenHallinta.ViiteInterface;
import ohtu.viitteidenHallinta.ViiteSailo;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BibtexTest{
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Bibtex bt;
    Viite viites;
    ViiteSailo sailo;
    
    @Before
    public void setUp(){
        LinkedHashMap pakollisetKentat = new LinkedHashMap<String, String>();
        LinkedHashMap vapaaehtoisetKentat = new LinkedHashMap<String, String>();

        pakollisetKentat.put("author", "nimiö");
        pakollisetKentat.put("title", "TestiTitleå");
        pakollisetKentat.put("journal", "TestJournalä");
        pakollisetKentat.put("year", "1994");
        vapaaehtoisetKentat.put("number", "5");
        vapaaehtoisetKentat.put("pages", "18");
                
        viites = new Viite("article", "W06", pakollisetKentat, vapaaehtoisetKentat);
        sailo = new ViiteSailo();
        sailo.addViite(viites);
        bt = new Bibtex();
        System.setOut(new PrintStream(outContent));
    }
    
    @Test
    public void testPrintAsBibtex(){
        bt.printAsBibtex(viites);
        assertEquals(bt.getAsBibtex(viites), outContent.toString());
    }
    
    @Test
    public void testGetAsBibtexId(){
        String id = "@article{W06,\r\n";
        assertEquals(bt.getAsBibtex(viites).contains(id), true);
    }
    
    @Test
    public void testGetAsBibtexAuthor(){
        String author = "\tauthor = \"nimi\\\"{o}\",\r\n";
        assertEquals(bt.getAsBibtex(viites).contains(author), true);
    }
    
    @Test
    public void testGetAsBibtexTitle(){
        String title = "\ttitle = \"TestiTitle\\aa\",\r\n";
        assertEquals(bt.getAsBibtex(viites).contains(title), true);
    }
    
    @Test
    public void testGetAsBibtexJournal(){
        String journal = "\tjournal = \"TestJournal\\\"{a}\",\r\n";
        assertEquals(bt.getAsBibtex(viites).contains(journal), true);
    }
    
    @Test
    public void testGetAsBibtexYear(){
        String year = "\tyear = \"1994\",\r\n";
        assertEquals(bt.getAsBibtex(viites).contains(year), true);
    }
    
    @Test
    public void testGetAsBibtexNumber(){
        String number = "\tnumber = \"5\",\r\n";
        assertEquals(bt.getAsBibtex(viites).contains(number), true);
    }
    
    @Test
    public void testGetAsBibtexPages(){
        String pages = "\tpages = \"18\",\r\n";
        assertEquals(bt.getAsBibtex(viites).contains(pages), true);
    }
    
    @Test
    public void testGetAsBibtexClosingBracket(){
        assertEquals(bt.getAsBibtex(viites).contains("}"), true);
    }
    
    @Test
    public void bibTexienTallennus() throws IOException{
        bt.tallennaBibtexitTiedostoon(sailo, "testi.bib");
    }
    
    @Test
    public void testAppendFile(){
        String result = bt.appendFileType("testi", ".json");
        String expected = "testi.json";
        assertEquals(expected, result);
    }
    
    @Test
    public void testAppendFileOutoNimi(){
        String result = bt.appendFileType("testi...exe", ".json");
        String expected = "testi...exe.json";
        assertEquals(expected, result);
    }
    
    @Test
    public void testAppendFilePiste(){
        String result = bt.appendFileType("tes.ti", ".json");
        String expected = "tes.ti.json";
        assertEquals(expected, result);
    }
    
    @Test
    public void testPoistaBibtexTiedosto(){
        File f = new File("testi.bib");
        bt.poistaBibtexTiedosto("testi.bib");
        assertEquals(false, f.exists());
    }
}