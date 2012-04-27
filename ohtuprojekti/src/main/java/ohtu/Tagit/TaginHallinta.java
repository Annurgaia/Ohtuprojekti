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

    public boolean lisaaTageihinViite(ViiteInterface viite, ArrayList<String> viiteTagit) {
        if (viiteTagit == null || viite == null)
            return false;
        for (String viiteTagi : viiteTagit) {
            if (tagit.containsKey(viiteTagi)) {
                if (tagit.get(viiteTagi).containsKey(viite.getId())) {
                    return false;
                }
                tagit.get(viiteTagi).put(viite.getId(), viite);
            } else {
                tagit.put(viiteTagi, new LinkedHashMap<String, ViiteInterface>());
                tagit.get(viiteTagi).put(viite.getId(), viite);
            }
        }
        return true;
    }
    
    public boolean poistaTageistaViite(ViiteInterface viite, ArrayList<String> viiteTagit) {
        if (viiteTagit == null || viite == null)
            return false;
        for (String viiteTagi : viiteTagit) {
            if (tagit.containsKey(viiteTagi)) {
                if (tagit.get(viiteTagi).containsKey(viite.getId())) {
                    tagit.get(viiteTagi).remove(viite.getId());
                    if (tagit.get(viiteTagi).isEmpty())
                        tagit.remove(viiteTagi);
                }
            }
        }
        return true;
    }
    
    public LinkedHashMap<String, LinkedHashMap<String, ViiteInterface>> getTagit() {
        return tagit;
    }
}
