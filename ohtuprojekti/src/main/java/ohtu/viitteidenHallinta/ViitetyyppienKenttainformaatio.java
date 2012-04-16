/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;

/**
 *
 * @author iimakis
 */
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
    
    public ArrayList<String> getTyypinPakollisetKentat(String tyyppi) {
        for (int i = 0; i < tyypit.size(); i++) {
            if (tyyppi.toLowerCase().equals(tyypit.get(i)))  // jos tyyppienPakollisetKentat.size() < i, niin jotain on vikana alustustiedoissa!
                return tyyppienPakollisetKentat.get(i);
        }
        return null;
    }

    public ArrayList<String> getTyypinVapaaehtoisetKentat(String tyyppi) {
        for (int i = 0; i < tyypit.size(); i++) {
            if (tyyppi.toLowerCase().equals(tyypit.get(i))) // jos tyyppienPakollisetKentat.size() < i, niin jotain on vikana alustustiedoissa!
                return tyyppienVapaaehtoisetKentat.get(i);
        }
        return null;
    }
}
