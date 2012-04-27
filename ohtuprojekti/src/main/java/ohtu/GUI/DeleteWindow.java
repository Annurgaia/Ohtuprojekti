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
public class DeleteWindow implements ActionListener {
    JFrame mainframe;
    JPanel panel;
    JComboBox delete;
    JLabel delLabel = new JLabel("Valitse poistettavan viitteen ID");
    JButton delBut;
    ViiteHallinta hallinta;
    
    public DeleteWindow(ViiteHallinta h) {
        hallinta = h;
        mainframe = new JFrame();
        mainframe.setBounds(1000, 100, 200, 100);
        mainframe.setVisible(true);
        delete = new JComboBox();
        panel = new JPanel();
        LinkedHashMap<String, ViiteInterface> viitteet = hallinta.getViiteLista();
        Object[] viiteArray = viitteet.keySet().toArray();
        for (Object s : viiteArray) {
            delete.addItem((String)s);
        }
        panel.add(delLabel);
        panel.add(delete);
        delBut = new JButton("Poista");
        delBut.addActionListener(this);
        delBut.setActionCommand("d");
        panel.add(delBut);
        mainframe.add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        hallinta.poistaViite((String)delete.getSelectedItem());
        delete.removeItem(delete.getSelectedItem());
    }
}
