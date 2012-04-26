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
    
    
    public LinkedHashMap<String, ViiteInterface> lueViitteetTiedostosta(String file){
        file = appendFileType(file, ".json");
        File f = new File(file);
        if(!f.exists())
            return null;
        try{
        in = new BufferedReader(new FileReader(file));
        }catch(IOException e){
            System.out.println("Tiedostoa ei löydy!");
        }
        String rivi;
        Viite viite;
        LinkedHashMap<String, ViiteInterface> viitteet = new LinkedHashMap<String, ViiteInterface>();
        try {
            while((rivi = in.readLine()) != null){
                if(!rivi.equals("")){
                    viite = gson.fromJson(rivi, Viite.class);
                    viitteet.put(viite.getId(), viite);
                }
            }
            in.close();
        } catch (IOException ex) {
            System.out.println("Tiedostoa ei löydy2!");
        }
        return viitteet;
    }
    

    public void tallennaViitteetTiedostoon(ViiteSailoInterface sailo) throws IOException{
        if(sailo.isEmpty())
            return;
        out = new BufferedWriter(new FileWriter(filename));
        for(ViiteInterface viite : sailo.getViitteet().values()){
                String jsonData = gson.toJson(viite);
                out.write(jsonData+"\r\n");
        }
        out.close();
    }

    protected static String appendFileType(String str, String toConcat) {
        if(!str.contains("."))
            return str.concat(toConcat);
        if(str.endsWith(toConcat))
            return str;
        return str.concat(toConcat);
    }
    
    public void poistaViiteTiedosto(String tiedostonimi){
            tiedostonimi = appendFileType(tiedostonimi, ".json");
            File f = new File(tiedostonimi);
            if(!f.exists())
                System.out.println("Tiedostoa ei ole olemassa"+tiedostonimi);
            if(!f.canWrite())
                throw new IllegalArgumentException("Kirjoitus suojattu: "+tiedostonimi);
            boolean poistettu = f.delete();
            
            if(!poistettu)
                throw new IllegalArgumentException("Poistaminen epäonnistui");
    }
    
}