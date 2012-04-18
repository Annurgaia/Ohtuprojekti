package ohtu.fileIO;
import com.google.gson.Gson;
import java.io.*;
import java.util.HashMap;
import ohtu.viitteidenHallinta.Viite;
import ohtu.viitteidenHallinta.ViiteInterface;


public class ViiteIO{
    
    private BufferedWriter out;
    private BufferedReader in;
    private Gson gson = new Gson();
    
    public ViiteIO(String str) throws IOException{
        out = new BufferedWriter(new FileWriter(str, true));
        in = new BufferedReader(new FileReader(str));
    }
    
    public void tallennaViiteTiedostoon(ViiteInterface viite) throws IOException{
        String jsonData = gson.toJson(viite);
        out.write(jsonData+"\n");
        out.close();
    }
    
    public void lueViiteTiedostosta() throws IOException{
        String rivi;
        while((rivi = in.readLine()) != null){
            Viite viite = gson.fromJson(rivi, Viite.class);
            System.out.println(viite.getId());
        }
    }
    
    //Testausta
    public static void main(String[] args) throws IOException {
        ViiteIO vio = new ViiteIO("testi.json");
        HashMap pakollisetKentat = new HashMap<String, String>();
        HashMap vapaaehtoisetKentat = new HashMap<String, String>();

        pakollisetKentat.put("author", "nimiö");
        pakollisetKentat.put("title", "TestiTitleå");
        pakollisetKentat.put("journal", "TestJournalä");
        pakollisetKentat.put("year", "1994");
        vapaaehtoisetKentat.put("number", "5");
        vapaaehtoisetKentat.put("pages", "18");
                
        Viite viite = new Viite("article", "W06", pakollisetKentat, vapaaehtoisetKentat);
        
        //vio.tallennaViiteTiedostoon(viite);
        vio.lueViiteTiedostosta();
    }
}