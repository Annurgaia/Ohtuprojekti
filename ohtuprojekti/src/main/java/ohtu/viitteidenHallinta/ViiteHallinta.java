package ohtu.viitteidenHallinta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.Tagit.TaginHallinta;
import ohtu.bibtex.Bibtex;
import ohtu.fileIO.ViiteIO;

public class ViiteHallinta {
    private ViiteSailo sailo;
    private ViitetyyppienKenttainformaatio info;
    private Bibtex bibtex;
    private ViiteIO viiteIO;
    private int viitelaskuri;
    private TaginHallinta tag;
    
    public ViiteHallinta() throws IOException {
        bibtex = new Bibtex();
        info = new ViitetyyppienKenttainformaatio();
        viiteIO = new ViiteIO("viitteet");
        LinkedHashMap<String, ViiteInterface> tallennetutViitteet = viiteIO.lueViitteetTiedostosta("viitteet");
        sailo = new ViiteSailo(tallennetutViitteet);
        viitelaskuri = sailo.getViitteet().size();
        tag = new TaginHallinta();
        for (String id : tallennetutViitteet.keySet()) {
                if (tallennetutViitteet.get(id).getTagit() != null)
                    tag.lisaaTageihinViite(tallennetutViitteet.get(id), tallennetutViitteet.get(id).getTagit());
        }
    }
    
    public ViiteHallinta(Bibtex bibtex, ViitetyyppienKenttainformaatio info, 
            ViiteIO vio, ViiteSailo sailo) {
        this.bibtex = bibtex;
        this.info = info;
        this.viiteIO = vio;
        this.sailo = sailo;
        viitelaskuri = 0;
        tag = new TaginHallinta();
    }
    
    public void lisaaViite(String tyyppi, String tagit, LinkedHashMap<String, String> pKentat, LinkedHashMap<String, String> vKentat) {
        String[] tagiTemp = tagit.split(",");
        ArrayList<String> tagitArrayListina = new ArrayList<String>(Arrays.asList(tagiTemp));
        Viite uusiViite = new Viite(tyyppi, ""+viitelaskuri, tagitArrayListina, pKentat, vKentat);
        if (!tagit.equals(""))
            tag.lisaaTageihinViite(uusiViite, tagitArrayListina);
        sailo.addViite(uusiViite);
        viitelaskuri++;
    }
    
    public boolean poistaViite(String id) {
        if (sailo.getViitteet().containsKey(id)) {
            ViiteInterface poistettava = sailo.getViitteet().get(id);
            tag.poistaTageistaViite(poistettava, poistettava.getTagit());
        }
        return sailo.poistaViite(id);
    }
    
    public boolean muokkaaViitetta(String id, String tagit, LinkedHashMap<String, String> pKentat, LinkedHashMap<String, String> vKentat)  {
        if (sailo.getViitteet().containsKey(id)) {
            String[] tagiTemp = tagit.split(",");
            ArrayList<String> uudetTagit = new ArrayList<String>(Arrays.asList(tagiTemp));
            ArrayList<String> vanhatTagit = sailo.getViitteet().get(id).getTagit();
            tag.poistaTageistaViite(sailo.getViitteet().get(id), vanhatTagit);
            tag.lisaaTageihinViite(sailo.getViitteet().get(id), vanhatTagit);
            return sailo.muokkaaViitetta(id, uudetTagit, pKentat, vKentat);
        }
        return false;
    }
    
    public LinkedHashMap<String, LinkedHashMap<String, ViiteInterface>> getTagit() {
        return tag.getTagit();
    }
    
    public String getViitteetTekstina() {
        return sailo.listaaViitteet();
    }
    
    public LinkedHashMap<String, ViiteInterface> getViiteLista() {
        return sailo.getViitteet();
    }
    
    public void teeViitteistaBibtex(String filename) throws IOException {
        bibtex.tallennaBibtexitTiedostoon(sailo, filename);
    }
    
    public void tallennaViitteet(){
        try {
            viiteIO.tallennaViitteetTiedostoon(sailo);
        } catch (IOException ex) {
            Logger.getLogger(ViiteHallinta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<String> getTyypit() {
       return info.getViiteTyypit();
    }
    
    public LinkedHashMap<String, String> getTyypinPakollisetKentat(String tyyppi) {
        return info.getTyypinPakollisetKentat(tyyppi);
    }
    
    public LinkedHashMap<String, String> getTyypinVapaaehtoisetKentat(String tyyppi) {
        return info.getTyypinVapaaehtoisetKentat(tyyppi);
    }
}

