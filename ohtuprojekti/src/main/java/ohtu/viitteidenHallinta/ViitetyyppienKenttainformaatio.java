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
public class ViitetyyppienKenttainformaatio {
    private ArrayList<String> tyypit;
    private ArrayList<ArrayList<String>> tyyppienPakollisetKentat;
    private ArrayList<ArrayList<String>> tyyppienVapaaehtoisetKentat;
    
    public ViitetyyppienKenttainformaatio() {
        tyypit = KenttatiedonAlustaja.alustaTyypit();
        tyyppienPakollisetKentat = KenttatiedonAlustaja.alustaTyyppienPakollisetKentat();
        tyyppienVapaaehtoisetKentat = KenttatiedonAlustaja.alustaVapaaehtoisetKentat();
    }


}
