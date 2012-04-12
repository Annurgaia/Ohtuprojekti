package ohtu.bibtex;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import ohtu.viitteidenHallinta.Viite;
import ohtu.viitteidenHallinta.ViiteInterface;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BibtexTest{
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Bibtex bt;
    
    @Before
    public void setUp(){
        ArrayList pakollisetKentat = new ArrayList<String>();
        ArrayList pakollistenKenttienNimet = new ArrayList<String>();
        ArrayList vapaaehtoisetKentat = new ArrayList<String>();
        ArrayList vapaaehtoistenKenttienNimet = new ArrayList<String>();
        pakollisetKentat.add("nimiö");
        pakollisetKentat.add("TestiTitleå");
        pakollisetKentat.add("TestJournalä");
        pakollisetKentat.add("1994");
        pakollistenKenttienNimet.add("author");
        pakollistenKenttienNimet.add("title");
        pakollistenKenttienNimet.add("journal");
        pakollistenKenttienNimet.add("year");
        vapaaehtoisetKentat.add("5");
        vapaaehtoisetKentat.add("18");
        vapaaehtoistenKenttienNimet.add("number");
        vapaaehtoistenKenttienNimet.add("pages");
        
        Viite viites = new Viite("article", "W06", pakollisetKentat, vapaaehtoisetKentat,
                pakollistenKenttienNimet, vapaaehtoistenKenttienNimet);
        bt = new Bibtex(viites);
        System.setOut(new PrintStream(outContent));
    }
    
    @Test
    public void testPrintAsBibtex(){
        bt.printAsBibtex();
        assertEquals(bt.getAsBibtex(), outContent.toString());
    }
    
    @Test
    public void testGetAsBibtex(){
        String exp = "@article{W06,\n"
                + "\tauthor = \"nimi\\\"{o}\",\n"
                + "\ttitle = \"TestiTitle\\aa\",\n"
                + "\tjournal = \"TestJournal\\\"{a}\",\n"
                + "\tyear = \"1994\",\n"
                + "\tnumber = \"5\",\n"
                + "\tpages = \"18\",\n"
                + "}";
        assertEquals(bt.getAsBibtex(), exp);
    }    ViiteInterface viite;
}