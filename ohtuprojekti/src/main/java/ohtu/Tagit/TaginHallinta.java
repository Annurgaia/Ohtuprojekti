/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.Tagit;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import ohtu.viitteidenHallinta.ViiteInterface;

/**
 *
 * @author iimakis
 */
public class TaginHallinta {

    private LinkedHashMap<String, ArrayList<ViiteInterface>> tagit;

    public TaginHallinta() {
    }

    public void lisaaTageihinViite(ViiteInterface viite, String[] viiteTagit) {
        for (String viiteTagi : viiteTagit) {
            if (tagit.containsKey(viiteTagi)) {
                if (tagit.get(viiteTagi).contains(viite)) {
                    return;
                }
                tagit.get(viiteTagi).add(viite);
            } else {
                tagit.put(viiteTagi, new ArrayList<ViiteInterface>());
                tagit.get(viiteTagi).add(viite);
            }
        }
    }
}
