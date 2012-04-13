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
public class ViiteSailo {
    private ArrayList<ViiteInterface> viitteet;
    
    public ViiteSailo() {
        this.viitteet = new ArrayList<ViiteInterface>();
    }
    
    public void addViite(ViiteInterface viite) {
        viitteet.add(viite);
    }
    
    public boolean muokkaaViitetta() {
        return false;
    }
    
    public int etsiViite(String id) {
        for (int i = 0; i < viitteet.size(); i++) {
            if (viitteet.get(i).getId().equals(id))
                return i;
        }
        return -1;
    }
    
    public ArrayList<ViiteInterface> getViitteet() {
        return viitteet;
    }
    
    public String listaaViitteet() {
        return "";
    }
}
