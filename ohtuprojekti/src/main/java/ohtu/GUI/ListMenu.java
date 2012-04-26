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
public class ListMenu implements ActionListener {

    ViiteHallinta hallinta;
    JFrame frame;
    JComboBox id;
    JComboBox tags;
    JLabel idLabel;
    JLabel tagLabel;
    JPanel main;
    ListWindow win;

    public ListMenu(ViiteHallinta h) {
        hallinta = h;
        frame = new JFrame();
        main = new JPanel();
        idLabel = new JLabel("Valitse ID:n mukaan");
        tagLabel = new JLabel("Valitse tägien mukaan");
        id = new JComboBox();
        tags = new JComboBox();
        win = new ListWindow();

        for (String key : hallinta.getViiteLista().keySet()) {
            id.addItem(key);
        }
        for (String key : hallinta.getTagit().keySet()) {
            tags.addItem(key);
        }
        id.addActionListener(this);
        id.setActionCommand("id");
        tags.addActionListener(this);
        tags.setActionCommand("tag");

        main.add(idLabel);
        main.add(id);
        main.add(tagLabel);
        main.add(tags);
        frame.add(main);
        frame.setBounds(1000, 200, 150, 150);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        win.pullThePlug();
        JComboBox valittu = (JComboBox) e.getSource();
        if (e.getActionCommand() == "id") {
            win = new ListWindow();
            String s = (String) valittu.getSelectedItem();
            win.listWindowViite(hallinta.getViiteLista().get(s));
        }
        if (e.getActionCommand() == "tag") {
            win = new ListWindow();
            String s = (String) valittu.getSelectedItem();
            win.listWindowTag(hallinta.getTagit().get(s));
        }
    }
}
