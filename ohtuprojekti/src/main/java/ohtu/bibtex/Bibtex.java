package ohtu.bibtex;
import ohtu.viitteidenHallinta.ViiteInterface;

public class Bibtex{


    ViiteInterface viite;
        
    public Bibtex(ViiteInterface viite){
        this.viite = viite;
    }
    
    public void printAsBibtex(){
        System.out.print("@"+viite.getType()+"{"+viite.getId()+",\n");
        for (int i = 0; i < viite.getPakollisetKentat().size(); i++) {
            System.out.print("\t"+viite.getPakollistenKenttienNimet().get(i) +" = "
                    +"\""+skanditBibtexiin(viite.getPakollisetKentat().get(i))+"\",\n");
            
        }
        for (int i = 0; i < viite.getVapaaehtoisetKentat().size(); i++) {
            System.out.print("\t"+viite.getVapaaehtoistenKenttienNimet().get(i) +" = "
                    +"\""+skanditBibtexiin(viite.getVapaaehtoisetKentat().get(i))+"\",\n");
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
    
    public String getAsBibtex(){
        String bibtex;
        bibtex = "@"+viite.getType()+"{"+viite.getId()+",\n";
        for (int i = 0; i < viite.getPakollisetKentat().size(); i++) {
            bibtex += "\t"+viite.getPakollistenKenttienNimet().get(i) +" = "
                    +"\""+skanditBibtexiin(viite.getPakollisetKentat().get(i))+"\",\n";
            
        }
        for (int i = 0; i < viite.getVapaaehtoisetKentat().size(); i++) {
            bibtex += "\t"+viite.getVapaaehtoistenKenttienNimet().get(i) +" = "
                    +"\""+skanditBibtexiin(viite.getVapaaehtoisetKentat().get(i))+"\",\n";
        }
        bibtex += "}";
        return bibtex;
    }
}