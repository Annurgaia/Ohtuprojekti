package ohtu.bibtex;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import ohtu.viitteidenHallinta.ViiteInterface;
import ohtu.viitteidenHallinta.ViiteSailo;

public class Bibtex{


    //private ViiteSailo viitteet;
    
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
    
    public void tallennaTiedostoon(String tiedosto){
        
    }
}