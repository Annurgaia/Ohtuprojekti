
package ohtu.viitteidenHallinta;

import java.util.ArrayList;
import java.util.HashMap;

public interface ViiteSailoInterface {
    public void addViite(ViiteInterface viite);
    public boolean muokkaaViitetta(String id, HashMap <String, String> pakollisetKentat,
            HashMap <String, String> vapaaehtoisetKentat);
    public ViiteInterface haeViite(String id);
    public ArrayList<ViiteInterface> getViitteet();
    public String listaaViitteet();
}
