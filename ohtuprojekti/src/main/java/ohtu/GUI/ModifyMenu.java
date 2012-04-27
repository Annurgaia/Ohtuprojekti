/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.GUI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.*;
import ohtu.viitteidenHallinta.*;
/**
 *
 * @author Wampie
 */
public class ModifyMenu implements ActionListener {
        JFrame ikkuna = new JFrame();
    JComboBox lista = new JComboBox();
    ViiteHallinta hallinta;
    String valinta = "";
    ModifyWindow modify;

    public ModifyMenu(ViiteHallinta hal) {
        hallinta = hal;
        for (String s : hal.getViiteLista().keySet()) {
            lista.addItem(s);
        }
        lista.addActionListener(this);
        lista.setActionCommand("muutos");
        JLabel x = new JLabel("Valitse ID");
        JPanel pikkuna = new JPanel();
        pikkuna.add(x);
        pikkuna.add(lista);
        ikkuna.add(pikkuna);
        ikkuna.setVisible(true);
        ikkuna.setSize(150, 100);
        ikkuna.setLocation(450, 200);
        modify = new ModifyWindow(hallinta);
    }

    public void actionPerformed(ActionEvent e) {
        modify.pullThePlug();
        if (e.getActionCommand().equals("muutos")) {
            modify = new ModifyWindow(hallinta);
            JComboBox cb = (JComboBox) e.getSource();
            valinta = (String) cb.getSelectedItem();
            modify.muokkaa(hallinta.getViiteLista().get(valinta));
            return;
        }
    }
}
