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
public class ViiteHallinta {

    private static TestiSyote test = new TestiSyote();
    private static ViitetyyppienKenttainformaatio info = new ViitetyyppienKenttainformaatio();
    private static ViiteTarkistin tarkkailija = new ViiteTarkistin();
    private static ViiteSailo sailo = new ViiteSailo();
    private static String id = "1";

    public static void main(String[] args) {
        while (true) {
            switch (test.alkumenu()) {
                case 1:
                    int temp;
                    while (true) {
                        while ((temp = test.kysyViitetyyppi(info.getViiteTyypit())) == -1) {
                            continue;
                        }
                        String nimi = info.getViiteTyypit().get(temp - 1);
                        HashMap <String, String> pakolliset = test.kysyPakollisetKentat(info.getTyypinPakollisetKentat(nimi));
                        HashMap <String, String> vapaaehtoiset = test.kysyVapaaehtoisetKentat(info.getTyypinVapaaehtoisetKentat(nimi));
                        if (!tarkkailija.tarkistaPakolliset(pakolliset)) {
                            continue;
                        }
                        Viite viite = new Viite(nimi, id, pakolliset, vapaaehtoiset);
                        sailo.addViite(viite);
                        id = "" + Integer.parseInt(id) + 1;
                        break;
                    }
                    continue;
                case 2:
                    while (true) {
                        String id = test.kysyId();
                        ViiteInterface viite;
                        if ((viite = sailo.haeViite(id)) == null) {
                            System.out.println("Viitettä ei löydy");
                            continue;
                        }
                        HashMap <String, String> pakolliset = test.kysyPakollisetKentat(viite.getPakollisetKentat());
                        HashMap <String, String> vapaaehtoiset = test.kysyVapaaehtoisetKentat(viite.getVapaaehtoisetKentat());
                        if (!tarkkailija.tarkistaPakolliset(pakolliset)) {
                            continue;
                        }
                        sailo.muokkaaViitetta(id, pakolliset, vapaaehtoiset);
                        break;
                    }
                    continue;
                case 3:
                    System.out.println(sailo.listaaViitteet());
                    continue;
                case 4:
                    break;
                default:
                    continue;
            }
            break;

        }
    }
}
