/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ViiteSailo implements ViiteSailoInterface{
    private ArrayList<ViiteInterface> viitteet;
    
    public ViiteSailo() {
        this.viitteet = new ArrayList<ViiteInterface>();
    }
    
    public void addViite(ViiteInterface viite) {
        viitteet.add(viite);
    }
    
    public boolean muokkaaViitetta(String id, LinkedHashMap <String, String> pakollisetKentat,
            LinkedHashMap <String, String> vapaaehtoisetKentat) {
        int indeksi = etsiViite(id);
        if (indeksi == -1)
            return false;
        viitteet.get(indeksi).setPakollisetKentat(pakollisetKentat);
        viitteet.get(indeksi).setVapaaehtoisetKentat(vapaaehtoisetKentat);
        return true;
    }
    
    private int etsiViite(String id) {
        for (int i = 0; i < viitteet.size(); i++) {
            if (viitteet.get(i).getId().equals(id))
                return i;
        }
        return -1;
    }
    
    public ViiteInterface haeViite(String id) {
        for (int i = 0; i < viitteet.size(); i++) {
            if (viitteet.get(i).getId().equals(id))
                return viitteet.get(i);
        }
        return null;
    }
    
    public ArrayList<ViiteInterface> getViitteet() {
        return viitteet;
    }
    
    public String listaaViitteet() {
        String viitelista = "";
        for (int i = 0; i< viitteet.size(); i++) {
            ViiteInterface kasiteltava = viitteet.get(i);
            viitelista += "Tyyppi: " + kasiteltava.getType() + "\n";
            viitelista += "Id: " + kasiteltava.getId() + "\n";
            for (String s : kasiteltava.getPakollisetKentat().keySet()) {
                viitelista += s + ": " + kasiteltava.getPakollisetKentat().get(s) + "\n";
            }
            for (String s : kasiteltava.getVapaaehtoisetKentat().keySet()) {
                viitelista += s + ": " + kasiteltava.getVapaaehtoisetKentat().get(s) + "\n";
            }
            viitelista += "\n";
        }
        return viitelista;
    }
}
 