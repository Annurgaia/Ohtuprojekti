/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;

/**
 *
 * @author anis
 */
public interface ViiteInterface {
   public String getId();
   public ArrayList<String> getPakollisetKentat();
   public String getType();
   public ArrayList<String> getVapaaehtoisetKentat();
   public ArrayList<String> getPakollistenKenttienNimet();
   public ArrayList<String> getVapaaehtoistenKenttienNimet();
   public void setPakollisetKentat(ArrayList<String> pakollisetKentat);
   public void setVapaaehtoisetKentat(ArrayList<String> vapaaehtoisetKentat);
}
