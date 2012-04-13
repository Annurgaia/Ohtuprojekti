/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;

public class ViiteSailo {
    private ArrayList<ViiteInterface> viitteet;
    
    public ViiteSailo() {
        this.viitteet = new ArrayList<ViiteInterface>();
    }
    
    public void addViite(ViiteInterface viite) {
        viitteet.add(viite);
    }
    
    public boolean muokkaaViitetta(String id, ArrayList<String> pakollisetKentat,
            ArrayList<String> vapaaehtoisetKentat) {
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
            for (int j = 0; j< kasiteltava.getPakollisetKentat().size(); j++) {
                viitelista += kasiteltava.getPakollistenKenttienNimet().get(j) +
                        ": " + kasiteltava.getPakollisetKentat().get(j) + "\n";
            }
            for (int j = 0; j< kasiteltava.getVapaaehtoisetKentat().size(); j++) {
                viitelista += kasiteltava.getVapaaehtoistenKenttienNimet().get(j) +
                        ": " + kasiteltava.getVapaaehtoisetKentat().get(j) + "\n";
            }
            viitelista += "\n";
        }
        return viitelista;
    }
}
 