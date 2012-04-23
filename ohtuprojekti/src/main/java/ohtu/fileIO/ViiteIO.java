package ohtu.fileIO;
import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.viitteidenHallinta.Viite;
import ohtu.viitteidenHallinta.ViiteInterface;
import ohtu.viitteidenHallinta.ViiteSailoInterface;


public class ViiteIO{
    
    private static BufferedWriter out;
    private static BufferedReader in;
    private String filename;
    private Gson gson = new Gson();
    
    public ViiteIO(String file) throws IOException{
        this.filename = appendFileType(file, ".json");
    }
    
    public void tallennaViiteTiedostoon(ViiteInterface viite) throws IOException{
        String jsonData = gson.toJson(viite);
        out = new BufferedWriter(new FileWriter(filename, true));
        out.write(jsonData+"\r\n");
        out.close();
    }
    
    public ArrayList<ViiteInterface> lueViitteetTiedostosta(String file){
        file = appendFileType(file, ".json");
        try{
        in = new BufferedReader(new FileReader(file));
        }catch(IOException e){
            System.out.println("Tiedostoa ei löydy!");
        }
        String rivi;
        Viite viite;
        ArrayList<ViiteInterface> viitteet = new ArrayList<ViiteInterface>();
        try {
            while((rivi = in.readLine()) != null){
                if(!rivi.equals("")){
                    viite = gson.fromJson(rivi, Viite.class);
                    viitteet.add(viite);
                }
            }
            in.close();
        } catch (IOException ex) {
            System.out.println("Tiedostoa ei löydy2!");
        }
        return viitteet;
    }
    
    public void tallennaViitteetTiedostoon(ViiteSailoInterface sailo) throws IOException{
        for(ViiteInterface viite : sailo.getViitteet()){
            tallennaViiteTiedostoon(viite);
        }
    }

    private String appendFileType(String str, String toConcat) {
        if(!str.contains("."))
            return str.concat(toConcat);
        if(str.endsWith(toConcat))
            return str;
        return str;
    }
    
}