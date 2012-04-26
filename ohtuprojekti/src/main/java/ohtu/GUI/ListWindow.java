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
public class ListWindow {

    JFrame mainframe;
    JScrollPane scrollpanel;
    JPanel godpanel;

    public ListWindow(ViiteInterface viite) {
        alusta();
        String[] lista = viite.toString().split("\n");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(14,0));
        for (String string : lista) {
            JLabel temp = new JLabel(string);
            panel.add(temp);
        }
        scrollpanel = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        mainframe.add(scrollpanel);
    }

    public void alusta() {
        godpanel = new JPanel();
        mainframe = new JFrame();
        
        mainframe.setVisible(true);
        mainframe.setBounds(1000, 350, 300, 300);
    }
}
