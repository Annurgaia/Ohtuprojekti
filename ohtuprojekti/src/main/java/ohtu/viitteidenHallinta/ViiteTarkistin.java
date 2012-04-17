/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Wampie
 */
public class ViiteTarkistin {

    public ViiteTarkistin() {
    }

    public boolean tarkistaPakolliset(HashMap <String, String> list) {
        for (String s : list.keySet()) {
            if (list.get(s).equals("")) {
                return false;
            }
        }
        return true;
    }
}
