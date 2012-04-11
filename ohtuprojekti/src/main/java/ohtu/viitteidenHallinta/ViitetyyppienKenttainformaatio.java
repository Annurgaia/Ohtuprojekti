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
    
    public ViitetyyppienKenttainformaatio(AlustajaInterface alustaja) {
        tyypit = alustaja.alustaTyypit();
        tyyppienPakollisetKentat = alustaja.alustaPakollisetKentat();
        tyyppienVapaaehtoisetKentat = alustaja.alustaVapaaehtoisetKentat();
    }
    
    public ArrayList<String> getTyypinPakollisetKentat(String tyyppi) {
        for (int i = 0; i < tyypit.size(); i++) {
            if (tyyppi.toLowerCase().equals(tyypit.get(i)))
                return tyyppienPakollisetKentat.get(i);
        }
        return null;
    }

    public ArrayList<String> getTyypinVapaaehtoisetKentat(String tyyppi) {
        for (int i = 0; i < tyypit.size(); i++) {
            if (tyyppi.toLowerCase().equals(tyypit.get(i)))
                return tyyppienVapaaehtoisetKentat.get(i);
        }
        return null;
    }
}
