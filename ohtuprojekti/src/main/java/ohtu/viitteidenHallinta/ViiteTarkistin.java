/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;

/**
 *
 * @author Wampie
 */
public class ViiteTarkistin {

    public ViiteTarkistin() {
    }

    public boolean tarkistaPakolliset(ArrayList<String> list) {
        for (String s : list) {
            if (s.equals("")) {
                return false;
            }
        }
        return true;
    }
}
