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
public interface AlustajaInterface {
    
    ArrayList<String> alustaTyypit();
    ArrayList<ArrayList<String>> alustaPakollisetKentat();
    ArrayList<ArrayList<String>> alustaVapaaehtoisetKentat();
}
