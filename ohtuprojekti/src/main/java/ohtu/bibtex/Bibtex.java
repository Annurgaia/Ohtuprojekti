package ohtu.bibtex;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import ohtu.viitteidenHallinta.ViiteInterface;
import ohtu.viitteidenHallinta.ViiteSailoInterface;

public class Bibtex{


    public void tallennaBibtexitTiedostoon(ViiteSailoInterface sailo, String file) throws IOException{
        file = appendFileType(file, ".bibtex");
        BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
        for (ViiteInterface viite : sailo.getViitteet()) {
            String asBibTex = getAsBibtex(viite);
            out.write(asBibTex);
            out.write("\n");
        }
        out.close();
    }
    public void printAsBibtex(ViiteInterface viite){
        Set<Entry<String, String>> pakolliset = viite.getPakollisetKentat().entrySet();
        Set<Entry<String, String>> vapaaehtoiset = viite.getVapaaehtoisetKentat().entrySet();
        System.out.print("@"+viite.getType()+"{"+viite.getId()+",\n");
        for(Map.Entry<String, String> entry : pakolliset){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.print("\t"+key+" = "+"\""+skanditBibtexiin(value)+
                    "\",\n");
        }
        for(Map.Entry<String, String> entry : vapaaehtoiset){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.print("\t"+key+" = "+"\""+skanditBibtexiin(value)+
                    "\",\n");
        }
        System.out.print("}");
    }
    
    private String skanditBibtexiin(String str){
        String korjattu;
        korjattu = str.replaceAll("ä", "\\\\\"{a}");
        korjattu = korjattu.replaceAll("ö", "\\\\\"{o}");
        korjattu = korjattu.replaceAll("å", "\\\\aa");
        korjattu = korjattu.replaceAll("Ä", "\\\\\"{A}");
        korjattu = korjattu.replaceAll("Ö", "\\\\\"{O}");
        korjattu = korjattu.replaceAll("Å", "\\\\aa");
        return korjattu;
    }
    
    public String getAsBibtex(ViiteInterface viite){
        Set<Entry<String, String>> pakolliset = viite.getPakollisetKentat().entrySet();
        Set<Entry<String, String>> vapaaehtoiset = viite.getVapaaehtoisetKentat().entrySet();
        String bibtex;
        bibtex = "@"+viite.getType()+"{"+viite.getId()+",\n";
        
        for(Map.Entry<String, String> entry : pakolliset){
            String key = entry.getKey();
            String value = entry.getValue();
            bibtex += "\t"+key+" = "+"\""+skanditBibtexiin(value)+"\",\n";
        }
        
        for(Map.Entry<String, String> entry : vapaaehtoiset){
            String key = entry.getKey();
            String value = entry.getValue();
            bibtex += "\t"+key+" = "+"\""+skanditBibtexiin(value)+"\",\n";
        }
        bibtex += "}";
        return bibtex;
    }
    
        private String appendFileType(String str, String toConcat) {
        if(!str.contains("."))
            return str.concat(toConcat);
        if(str.endsWith(toConcat))
            return str;
        return str;
    }

}