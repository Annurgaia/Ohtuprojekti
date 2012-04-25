package ohtu.fileIO;
import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.viitteidenHallinta.Viite;
import ohtu.viitteidenHallinta.ViiteInterface;
import ohtu.viitteidenHallinta.ViiteSailo;
import ohtu.viitteidenHallinta.ViiteSailoInterface;


public class ViiteIO{
    
    private BufferedWriter out;
    private BufferedReader in;
    private Gson gson = new Gson();
    
    public ViiteIO(String file) throws IOException{
        String f = appendFileType(file, ".json");
        out = new BufferedWriter(new FileWriter(f, true));
        //in = new BufferedReader(new FileReader(f));
    }
    
    public void tallennaViiteTiedostoon(ViiteInterface viite) throws IOException{
        String jsonData = gson.toJson(viite);
        out.write(jsonData+"\r\n");
    }
    
    public ArrayList<ViiteInterface> lueViitteetTiedostosta(String file) throws IOException{
        file = appendFileType(file, ".json");
        in = new BufferedReader(new FileReader(file));
        String rivi;
        Viite viite;
        ArrayList<ViiteInterface> viitteet = new ArrayList<ViiteInterface>();
        while((rivi = in.readLine()) != null){
            if(!rivi.equals("")){
                viite = gson.fromJson(rivi, Viite.class);
                viitteet.add(viite);
            }
        }
        return viitteet;
    }
    
    public void tallennaViitteetTiedostoon(ViiteSailoInterface sailo){
        for(ViiteInterface viite : sailo.getViitteet()){
            try {
                tallennaViiteTiedostoon(viite);
            } catch (IOException ex) {
                Logger.getLogger(ViiteIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private String appendFileType(String str, String toConcat) {
        if(!str.contains("."))
            return str.concat(toConcat);
        if(str.endsWith(toConcat))
            return str;
        return str;
    }
    
    public static void main(String[] args) throws IOException {
        ViiteIO vio = new ViiteIO("testi");
        LinkedHashMap pakollisetKentat = new LinkedHashMap<String, String>();
        LinkedHashMap vapaaehtoisetKentat = new LinkedHashMap<String, String>();
        pakollisetKentat.put("author", "nimiö");
        pakollisetKentat.put("title", "TestiTitleå");
        pakollisetKentat.put("journal", "TestJournalä");
        pakollisetKentat.put("year", "1994");
        vapaaehtoisetKentat.put("number", "5");
        vapaaehtoisetKentat.put("pages", "18");
                
        Viite viites = new Viite("article", "W06", pakollisetKentat, vapaaehtoisetKentat);
        vio.tallennaViiteTiedostoon(viites);
        
        ArrayList<ViiteInterface> list = vio.lueViitteetTiedostosta("testi");
        System.out.println(list.get(0).getId());
    }
    
}