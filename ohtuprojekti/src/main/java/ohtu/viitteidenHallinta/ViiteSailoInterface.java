
package ohtu.viitteidenHallinta;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface ViiteSailoInterface {
    public void addViite(ViiteInterface viite);
    public boolean muokkaaViitetta(String id, LinkedHashMap <String, String> pakollisetKentat,
            LinkedHashMap <String, String> vapaaehtoisetKentat);
    public LinkedHashMap<String, ViiteInterface> getViitteet();
    boolean poistaViite(String id);
    public String listaaViitteet();
    public boolean isEmpty();
}
