
package ohtu.viitteidenHallinta;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface ViiteSailoInterface {
    public void addViite(ViiteInterface viite);
    public boolean muokkaaViitetta(String id, LinkedHashMap <String, String> pakollisetKentat,
            LinkedHashMap <String, String> vapaaehtoisetKentat);
//    public ViiteInterface haeViite(String id);
    public LinkedHashMap<String, ViiteInterface> getViitteet();
    public String listaaViitteet();
    public boolean isEmpty();
}
