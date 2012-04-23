/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Viite implements ViiteInterface {
    private String type;
    private String id;
    private LinkedHashMap<String, String> pakollisetKentat;
    private LinkedHashMap<String, String> vapaaehtoisetKentat;
    
    public Viite(String type, String id, LinkedHashMap<String, String> pakollisetKentat, LinkedHashMap<String, String> vapaaehtoisetKentat) {
        this.type = type;
        this.id = id;
        this.pakollisetKentat = pakollisetKentat;
        this.vapaaehtoisetKentat = vapaaehtoisetKentat;
    }
   
    // getterit

    public String getId() {
        return id;
    }

    public LinkedHashMap <String, String> getPakollisetKentat() {
        return pakollisetKentat;
    }

    public String getType() {
        return type;
    }

    public LinkedHashMap <String, String> getVapaaehtoisetKentat() {
        return vapaaehtoisetKentat;
    }
  
    // setterit

    public void setPakollisetKentat(LinkedHashMap <String, String> pakollisetKentat) {
        this.pakollisetKentat = pakollisetKentat;
    }

    public void setVapaaehtoisetKentat(LinkedHashMap <String, String> vapaaehtoisetKentat) {
        this.vapaaehtoisetKentat = vapaaehtoisetKentat;
    }
    
    private String pakollisetToString() {
        String pakolliset = "";
        for (String s : pakollisetKentat.keySet()) {
                pakolliset += s + ": " + pakollisetKentat.get(s) + "\n";
            }
        return pakolliset;
    }
    
    private String vapaaehtoisetToString() {
        String vapaaehtoiset = "";
        for (String s : vapaaehtoisetKentat.keySet()) {
            vapaaehtoiset += s + ": " + vapaaehtoisetKentat.get(s) + "\n";
        }
        return vapaaehtoiset;
    }
    
    public String toString() {
        return "Tyyppi: " + type + "\n" + "Id: " + id + "\n" +
                pakollisetToString() + vapaaehtoisetToString();
    }
    
}
