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
public class Viite {
    private String type;
    private String id;
    private ArrayList<String> pakolliset_kentat;
    private ArrayList<String> vapaaehtoiset_kentat;
    
    public Viite(String type, String id, ArrayList<String> pakolliset_kentat,
            ArrayList<String> vapaaehtoiset_kentat) {
        this.type = type;
        this.id = id;
        this.pakolliset_kentat = pakolliset_kentat;
        this.vapaaehtoiset_kentat = vapaaehtoiset_kentat;
    }
   
    // getterit

    public String getId() {
        return id;
    }

    public ArrayList<String> getPakolliset_kentat() {
        return pakolliset_kentat;
    }

    public String getType() {
        return type;
    }

    public ArrayList<String> getVapaaehtoiset_kentat() {
        return vapaaehtoiset_kentat;
    }
    
    // setterit

    public void setPakolliset_kentat(ArrayList<String> pakolliset_kentat) {
        this.pakolliset_kentat = pakolliset_kentat;
    }

    public void setVapaaehtoiset_kentat(ArrayList<String> vapaaehtoiset_kentat) {
        this.vapaaehtoiset_kentat = vapaaehtoiset_kentat;
    }
    

    
}
