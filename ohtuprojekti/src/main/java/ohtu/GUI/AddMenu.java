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
public class AddMenu implements ActionListener {

    JFrame ikkuna = new JFrame();
    JComboBox lista = new JComboBox();
    ViiteHallinta hallinta;
    String valinta = "";
    AddWindow add;

    public AddMenu(ViiteHallinta hal) {
        hallinta = hal;
        for (String s : hal.getTyypit()) {
            lista.addItem(s);
        }
        lista.addActionListener(this);
        lista.setActionCommand("muutos");
        JLabel x = new JLabel("Valitse tyyppi");
        JPanel pikkuna = new JPanel();
        pikkuna.add(x);
        pikkuna.add(lista);
        ikkuna.add(pikkuna);
        ikkuna.setVisible(true);
        ikkuna.setSize(150, 100);
        ikkuna.setLocation(450, 200);
        add = new AddWindow(hallinta);
    }

    public void actionPerformed(ActionEvent e) {
        add.pullThePlug();
        if (e.getActionCommand().equals("muutos")) {
            add = new AddWindow(hallinta);
            JComboBox cb = (JComboBox) e.getSource();
            valinta = (String) cb.getSelectedItem();
            add.lisaa(valinta);
            return;
        }
    }
}
