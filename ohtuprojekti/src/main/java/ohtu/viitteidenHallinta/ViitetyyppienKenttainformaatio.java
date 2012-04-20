/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ViitetyyppienKenttainformaatio {

    private ArrayList<String> tyypit;
    private ArrayList<ArrayList<String>> tyyppienPakollisetKentat;
    private ArrayList<ArrayList<String>> tyyppienVapaaehtoisetKentat;

    public ViitetyyppienKenttainformaatio() {
        tyypit = KenttatiedonAlustaja.alustaTyypit();
        tyyppienPakollisetKentat = KenttatiedonAlustaja.alustaPakollisetKentat();
        tyyppienVapaaehtoisetKentat = KenttatiedonAlustaja.alustaVapaaehtoisetKentat();
    }

    public ArrayList<String> getViiteTyypit() {
        return tyypit;
    }

    public LinkedHashMap<String, String> getTyypinPakollisetKentat(String tyyppi) {
        LinkedHashMap<String, String> palautus = new LinkedHashMap<String, String>();
        for (int i = 0; i < tyypit.size(); i++) {
            if (tyyppi.toLowerCase().equals(tyypit.get(i))) // jos tyyppienPakollisetKentat.size() < i, niin jotain on vikana alustustiedoissa!
            {
                for (String string : tyyppienPakollisetKentat.get(i)) {
                    palautus.put(string, "");
                }
                return palautus;
            }
        }
        return null;
    }

    public LinkedHashMap<String, String> getTyypinVapaaehtoisetKentat(String tyyppi) {
        LinkedHashMap<String, String> palautus = new LinkedHashMap<String, String>();
        for (int i = 0; i < tyypit.size(); i++) {
            if (tyyppi.toLowerCase().equals(tyypit.get(i))) // jos tyyppienPakollisetKentat.size() < i, niin jotain on vikana alustustiedoissa!
            {
                for (String string : tyyppienVapaaehtoisetKentat.get(i)) {
                    palautus.put(string, "");
                }
                return palautus;
            }
        }
        return null;
    }
}
