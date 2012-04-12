/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;

/**
 *
 * @author iimakis
 */
interface ViiteInterface {
    String getId();
    String getType();
    ArrayList<String> getPakollisetKentat();
    ArrayList<String> getVapaaehtoisetKentat();
    ArrayList<String> getPakollistenKenttienNimet();
    ArrayList<String> getVapaaehtoistenKenttienNimet();
    void setPakollisetKentat(ArrayList<String> pakollisetKentat);
    void setVapaaehtoisetKentat(ArrayList<String> vapaaehtoisetKentat);
}
