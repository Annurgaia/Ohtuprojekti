/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.HashMap;

/**
 *
 * @author iimakis
 */
public class Viite implements ViiteInterface {
    private String type;
    private String id;
    private HashMap<String, String> pakollisetKentat;
    private HashMap<String, String> vapaaehtoisetKentat;
    
//    private ArrayList<String> pakollisetKentat;
//    private ArrayList<String> vapaaehtoisetKentat;
//    private ArrayList<String> pakollistenKenttienNimet;
//    private ArrayList<String> vapaaehtoistenKenttienNimet;    
    
    public Viite(String type, String id, HashMap <String, String> pakollisetKentat, HashMap<String, String> vapaaehtoisetKentat) {
        this.type = type;
        this.id = id;
        this.pakollisetKentat = pakollisetKentat;
        this.vapaaehtoisetKentat = vapaaehtoisetKentat;
    }
   
    // getterit

    public String getId() {
        return id;
    }

    public HashMap <String, String> getPakollisetKentat() {
        return pakollisetKentat;
    }

    public String getType() {
        return type;
    }

    public HashMap <String, String> getVapaaehtoisetKentat() {
        return vapaaehtoisetKentat;
    }
  
    // setterit

    public void setPakollisetKentat(HashMap <String, String> pakollisetKentat) {
        this.pakollisetKentat = pakollisetKentat;
    }

    public void setVapaaehtoisetKentat(HashMap <String, String> vapaaehtoisetKentat) {
        this.vapaaehtoisetKentat = vapaaehtoisetKentat;
    }
    

    
}
