package ohtu.fileIO;
import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
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
        out.close();
    }
    
    public ArrayList<Viite> lueViitteetTiedostosta(String file) throws IOException{
        file = appendFileType(file, ".json");
        in = new BufferedReader(new FileReader(file));
        String rivi;
        Viite viite;
        ArrayList<Viite> viitteet = new ArrayList<Viite>();
        while((rivi = in.readLine()) != null){
            if(!rivi.equals("")){
                viite = gson.fromJson(rivi, Viite.class);
                viitteet.add(viite);
            }
        }
        return viitteet;
    }
    
    public void tallennaViitteetTiedostoon(ViiteSailoInterface sailo) throws IOException{
        for(ViiteInterface viite : sailo.getViitteet()){
            tallennaViiteTiedostoon(viite);
        }
        out.close();
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
        HashMap pakollisetKentat = new HashMap<String, String>();
        HashMap vapaaehtoisetKentat = new HashMap<String, String>();
        pakollisetKentat.put("author", "nimiö");
        pakollisetKentat.put("title", "TestiTitleå");
        pakollisetKentat.put("journal", "TestJournalä");
        pakollisetKentat.put("year", "1994");
        vapaaehtoisetKentat.put("number", "5");
        vapaaehtoisetKentat.put("pages", "18");
                
        Viite viites = new Viite("article", "W06", pakollisetKentat, vapaaehtoisetKentat);
        vio.tallennaViiteTiedostoon(viites);
        
        ArrayList<Viite> list = vio.lueViitteetTiedostosta("testi");
        System.out.println(list.get(0).getId());
    }
    
}