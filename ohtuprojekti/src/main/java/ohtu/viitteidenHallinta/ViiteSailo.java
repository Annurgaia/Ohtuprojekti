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
    
    public ViiteSailo(ArrayList<ViiteInterface> viitteet) {
        this.viitteet = viitteet;
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
            viitelista += viitteet.get(i).toString();
            viitelista += "\n";
        }
        return viitelista;
    }
}
 