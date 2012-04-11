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
    private ArrayList<String> pakollisetKentat;
    private ArrayList<String> vapaaehtoisetKentat;
    
    public Viite(String type, String id, ArrayList<String> pakollisetKentat,
            ArrayList<String> vapaaehtoisetKentat) {
        this.type = type;
        this.id = id;
        this.pakollisetKentat = pakollisetKentat;
        this.vapaaehtoisetKentat = vapaaehtoisetKentat;
    }
   
    // getterit

    public String getId() {
        return id;
    }

    public ArrayList<String> getPakollisetKentat() {
        return pakollisetKentat;
    }

    public String getType() {
        return type;
    }

    public ArrayList<String> getVapaaehtoisetKentat() {
        return vapaaehtoisetKentat;
    }
    
    // setterit

    public void setPakollisetKentat(ArrayList<String> pakollisetKentat) {
        this.pakollisetKentat = pakollisetKentat;
    }

    public void setVapaaehtoisetKentat(ArrayList<String> vapaaehtoisetKentat) {
        this.vapaaehtoisetKentat = vapaaehtoisetKentat;
    }
    

    
}
