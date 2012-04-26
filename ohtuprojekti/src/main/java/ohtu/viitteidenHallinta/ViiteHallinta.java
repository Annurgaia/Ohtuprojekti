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
        viitelaskuri = 0;
        tag = new TaginHallinta();
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
        String[] tagiTemp = tagit.split(",");
        ArrayList<String> tagitArrayListina = new ArrayList<String>(Arrays.asList(tagiTemp));
        return sailo.muokkaaViitetta(id, tagitArrayListina, pKentat, vKentat);
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


///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package ohtu.viitteidenHallinta;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Scanner;
//import ohtu.bibtex.Bibtex;
//import ohtu.fileIO.ViiteIO;
//
///**
// *
// * @author Wampie
// */
//public class ViiteHallinta {
//
//    private static TestiSyote test = new TestiSyote();
//    private static ViitetyyppienKenttainformaatio info = new ViitetyyppienKenttainformaatio();
//    private static ViiteTarkistin tarkkailija = new ViiteTarkistin();
//    private static ViiteSailoInterface sailo = new ViiteSailo();
//    private static Bibtex bt;
//    private static String id = "1";
//
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            switch (test.alkumenu()) {
//                case 1:
//                    int temp;
//                    while (true) {
//                        while ((temp = test.kysyViitetyyppi(info.getViiteTyypit())) == -1) {
//                            continue;
//                        }
//                        String nimi = info.getViiteTyypit().get(temp - 1);
//                        LinkedHashMap<String, String> pakolliset = test.kysyPakollisetKentat(info.getTyypinPakollisetKentat(nimi));
//                        LinkedHashMap<String, String> vapaaehtoiset = test.kysyVapaaehtoisetKentat(info.getTyypinVapaaehtoisetKentat(nimi));
//                        if (!tarkkailija.tarkistaPakolliset(pakolliset)) {
//                            continue;
//                        }
//                        Viite viite = new Viite(nimi, id, pakolliset, vapaaehtoiset);
//                        sailo.addViite(viite);
//                        id = "" + Integer.parseInt(id) + 1;
//                        break;
//                    }
//                    continue;
//                case 2:
//                    while (true) {
//                        String id = test.kysyId();
//                        ViiteInterface viite;
//                        if ((viite = sailo.haeViite(id)) == null) {
//                            System.out.println("Viitettä ei löydy");
//                            continue;
//                        }
//                        LinkedHashMap<String, String> pakolliset = test.kysyPakollisetKentat(viite.getPakollisetKentat());
//                        LinkedHashMap<String, String> vapaaehtoiset = test.kysyVapaaehtoisetKentat(viite.getVapaaehtoisetKentat());
//                        if (!tarkkailija.tarkistaPakolliset(pakolliset)) {
//                            continue;
//                        }
//                        sailo.muokkaaViitetta(id, pakolliset, vapaaehtoiset);
//                        break;
//                    }
//                    continue;
//                case 3:
//                    System.out.println(sailo.listaaViitteet());
//                    continue;
//
//                case 4:
//                    break;
//                default:
//                    continue;
//            }
//            break;
//
//        }
//    }
//}
