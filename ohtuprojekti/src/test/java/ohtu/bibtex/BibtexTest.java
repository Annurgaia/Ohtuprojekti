package ohtu.bibtex;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BibtexTest{
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Bibtex bt;
    
    @Before
    public void setUp(){
        bt = new Bibtex("book", "testi", "testiTitle", "1985", "Addison-Wesley", "T85");
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void konstruktoi(){
        assertEquals(bt.getAsBibtex(), "@book{T85,\n"
                + "author = {testi},\n"
                + "title = {testiTitle},\n"
                + "year = {1985},\n"
                + "publisher = {Addison-Wesley},\n"
                + "booktitle = {null},\n"
                + "}");
    }
    
    @Test
    public void getAuthorTesti(){
        assertEquals(bt.getAuthor(), "testi");
    }
    
    @Test
    public void setAuthorTesti(){
        bt.setAuthor("testikaks");
        assertEquals(bt.getAuthor(), "testikaks");
    }
    
    @Test
    public void getBookTitleTesti(){
        assertEquals(bt.getBooktitle(), null);
    }
    
    @Test
    public void setBookTitleTesti(){
        bt.setBooktitle("testi");
        assertEquals(bt.getBooktitle(), "testi");
    }
    
    @Test
    public void getPublisherTesti(){
        assertEquals(bt.getPublisher(), "Addison-Wesley");
    }
    
    @Test
    public void setPublisherTesti(){
        bt.setPublisher("O'Reilly");
        assertEquals(bt.getPublisher(), "O'Reilly");
    }
    
    @Test
    public void getTitleTesti(){
        assertEquals(bt.getTitle(), "testiTitle");
    }
    
    @Test
    public void setTitleTesti(){
        bt.setTitle("testikkkk");
        assertEquals(bt.getTitle(), "testikkkk");
    }
    
    @Test
    public void getTypeTest(){
        assertEquals(bt.getType(), "book");
    }
    
    @Test
    public void setTypeTest(){
        bt.setType("inproceedings");
        assertEquals(bt.getType(), "inproceedings");
    }
    
    @Test
    public void getYearTest(){
        assertEquals(bt.getYear(), "1985");
    }
    
    @Test
    public void setYearTest(){
        bt.setYear("1834");
        assertEquals(bt.getYear(), "1834");
    }
    
    @Test
    public void printAsBibtex(){
        bt.printAsBibtex();
        assertEquals(bt.getAsBibtex(), outContent.toString());
    }
    
}