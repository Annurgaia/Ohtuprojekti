
package ohtu.viitteidenHallinta;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface ViiteSailoInterface {
    void addViite(ViiteInterface viite);
    boolean muokkaaViitetta(String id, ArrayList<String> tagit, LinkedHashMap <String, String> pakollisetKentat, LinkedHashMap <String, String> vapaaehtoisetKentat);
    LinkedHashMap<String, ViiteInterface> getViitteet();
    boolean poistaViite(String id);
    String listaaViitteet();
    boolean isEmpty();
}
