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

    private LinkedHashMap<String, LinkedHashMap<String, ViiteInterface>> tagit;

    public TaginHallinta() {
        tagit = new LinkedHashMap<String, LinkedHashMap<String, ViiteInterface>>();
    }

    public void lisaaTageihinViite(ViiteInterface viite, String[] viiteTagit) {
        for (String viiteTagi : viiteTagit) {
            if (tagit.containsKey(viiteTagi)) {
                if (tagit.get(viiteTagi).containsKey(viite.getId())) {
                    return;
                }
                tagit.get(viiteTagi).put(viite.getId(), viite);
            } else {
                tagit.put(viiteTagi, new LinkedHashMap<String, ViiteInterface>());
                tagit.get(viiteTagi).put(viite.getId(), viite);
            }
        }
    }
    
    public void poistaTageistaViite(ViiteInterface viite, String[] viiteTagit) {
        for (String viiteTagi : viiteTagit) {
            if (tagit.containsKey(viiteTagi)) {
                if (tagit.get(viiteTagi).containsKey(viite.getId())) {
                    tagit.get(viiteTagi).remove(viite.getId());
                    if (tagit.get(viiteTagi).isEmpty())
                        tagit.remove(viiteTagi);
                }
            }
        }
    }
}
