package ohtu.bibtex;
import ohtu.viitteidenHallinta.ViiteInterface;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BibtexTest{
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Bibtex bt;
    ViiteInterface viite;
    
    @Before
    public void setUp(){
        bt = new Bibtex(viite);
        System.setOut(new PrintStream(outContent));
    }
    
}