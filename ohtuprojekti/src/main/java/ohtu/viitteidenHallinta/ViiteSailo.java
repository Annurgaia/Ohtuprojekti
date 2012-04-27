/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ViiteSailo implements ViiteSailoInterface {

    private LinkedHashMap<String, ViiteInterface> viitteet;
    

    public ViiteSailo() {
        this.viitteet = new LinkedHashMap<String, ViiteInterface>();
    }

    public ViiteSailo(LinkedHashMap<String, ViiteInterface> viitteet) {
        if (viitteet == null) {
            this.viitteet = new LinkedHashMap<String, ViiteInterface>();
        } else {
            this.viitteet = viitteet;
        }
    }

    public void addViite(ViiteInterface viite) {
        viitteet.put(viite.getId(), viite);
    }

    public boolean muokkaaViitetta(String id, ArrayList<String> tagit,
            LinkedHashMap<String, String> pakollisetKentat, LinkedHashMap<String, String> vapaaehtoisetKentat) {
        if (!viitteet.containsKey(id))
            return false;
        viitteet.get(id).setTagit(tagit);
        viitteet.get(id).setPakollisetKentat(pakollisetKentat);
        viitteet.get(id).setVapaaehtoisetKentat(vapaaehtoisetKentat);
        return true;
    }

    public LinkedHashMap<String, ViiteInterface> getViitteet() {
        return viitteet;
    }
    
    public boolean poistaViite(String id) {
        if (viitteet.containsKey(id)) {
            viitteet.remove(id);
            return true;
        }
        return false;
    }

    public String listaaViitteet() {
        String viitelista = "";
        for (String ids : viitteet.keySet()) {
            viitelista += viitteet.get(ids).toString();
            viitelista += "\n";
        }
        return viitelista;
    }

    public boolean isEmpty() {
        return viitteet.isEmpty();
    }
    
}
