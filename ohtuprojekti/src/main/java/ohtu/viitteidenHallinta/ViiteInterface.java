/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author iimakis
 */
public interface ViiteInterface {
    String getId();
    String getType();
    HashMap <String, String> getPakollisetKentat();
    HashMap <String, String> getVapaaehtoisetKentat();;
    void setPakollisetKentat(HashMap <String, String> pakollisetKentat);
    void setVapaaehtoisetKentat(HashMap <String, String> vapaaehtoisetKentat);
}
