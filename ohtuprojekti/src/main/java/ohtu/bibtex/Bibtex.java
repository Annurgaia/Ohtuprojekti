package ohtu.bibtex;
import java.util.ArrayList;
import static ohtu.viitteidenHallinta.KenttatiedonAlustaja.alustaPakollisetKentat;
import static ohtu.viitteidenHallinta.KenttatiedonAlustaja.alustaVapaaehtoisetKentat;
import ohtu.viitteidenHallinta.Viite;
import ohtu.viitteidenHallinta.ViiteInterface;
import ohtu.viitteidenHallinta.KenttatiedonAlustaja;

public class Bibtex{


    ViiteInterface viite;
    KenttatiedonAlustaja alustaja;
    
    public Bibtex(ViiteInterface viite){
        this.viite = viite;
    }
    
    public void printAsBibtex(){
        for (int i = 0; i < viite.getPakollisetKentat().size(); i++) {
            System.out.println(viite.getPakollisetKentat().get(i));
            
        }
    }
    
    public static void main(String[] args) {
        ArrayList pakollisetKentat = new ArrayList<String>();
        pakollisetKentat.add("nimi");
        pakollisetKentat.add("TestiTitle");
        pakollisetKentat.add("TestJournal");
        pakollisetKentat.add("1994");
        Viite viite = new Viite("article", "W06", pakollisetKentat, new ArrayList<String>());
        Bibtex bt = new Bibtex(viite);
        bt.printAsBibtex();
    }
}