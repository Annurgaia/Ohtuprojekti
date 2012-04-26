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
<<<<<<< HEAD
    LinkedHashMap <String, String> getVapaaehtoisetKentat();
=======
    LinkedHashMap <String, String> getVapaaehtoisetKentat();;
>>>>>>> 362ed0cccad2f50b96bc276497d478991cb2f54b
    void setPakollisetKentat(LinkedHashMap <String, String> pakollisetKentat);
    void setVapaaehtoisetKentat(LinkedHashMap <String, String> vapaaehtoisetKentat);
}
