/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author iimakis
 */
public interface ViiteInterface {
    String getId();
    String getType();
    LinkedHashMap <String, String> getPakollisetKentat();
    LinkedHashMap <String, String> getVapaaehtoisetKentat();
    ArrayList<String> getTagit();
    void setTagit(ArrayList<String> tagit);
    void setPakollisetKentat(LinkedHashMap <String, String> pakollisetKentat);
    void setVapaaehtoisetKentat(LinkedHashMap <String, String> vapaaehtoisetKentat);
}
