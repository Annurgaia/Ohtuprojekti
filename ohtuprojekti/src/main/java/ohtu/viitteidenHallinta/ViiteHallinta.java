package ohtu.viitteidenHallinta;

import ohtu.bibtex.Bibtex;
import ohtu.fileIO.ViiteIO;

public class ViiteHallinta {
    private ViiteSailo sailo;
    private ViitetyyppienKenttainformaatio info;
    private Bibtex bibtex;
    
    public ViiteHallinta() {
        sailo = new ViiteSailo();
        bibtex = new Bibtex();
        info = new ViitetyyppienKenttainformaatio();
    }
    
    public void lisaaViite() {
        
    }
    
    public void muokkaaViitetta() {
        
    }
    
    public void getViiteLista() {
        
    }
    
    public void getViitteetBibtexina() {
        
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
