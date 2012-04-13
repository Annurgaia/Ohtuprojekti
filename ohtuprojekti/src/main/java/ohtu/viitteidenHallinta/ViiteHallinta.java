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
public class ViiteHallinta {
    private static TestiSyote test = new TestiSyote();
    private static ViitetyyppienKenttainformaatio info = new ViitetyyppienKenttainformaatio();
    public static void main(String [] args) {
        while (true) {
            switch (test.alkumenu()) {
                case 1:
                    int temp;
                    while ((temp = test.kysyViitetyyppi(info.getViiteTyypit())) == -1) {
                        continue;
                    }
                    ArrayList<String> pakolliset = test.kysyPakollisetKentat(info.getTyypinPakollisetKentat(info.getViiteTyypit().get(temp-1)));
                    ArrayList<String> vapaaehtoiset = test.kysyVapaaehtoisetKentat(info.getTyypinVapaaehtoisetKentat(info.getViiteTyypit().get(temp-1)));
                    break;
                case 2:
                case 3:
                case 4:
                    break;
                default: continue;
            }
            break;
            
        }
    }
    
}
