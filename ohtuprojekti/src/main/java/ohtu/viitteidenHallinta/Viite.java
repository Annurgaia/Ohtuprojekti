/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author iimakis
 */
public class Viite implements ViiteInterface {
    private String type;
    private String id;
    private LinkedHashMap<String, String> pakollisetKentat;
    private LinkedHashMap<String, String> vapaaehtoisetKentat;
    
//    private ArrayList<String> pakollisetKentat;
//    private ArrayList<String> vapaaehtoisetKentat;
//    private ArrayList<String> pakollistenKenttienNimet;
//    private ArrayList<String> vapaaehtoistenKenttienNimet;    
    
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
    

    
}
