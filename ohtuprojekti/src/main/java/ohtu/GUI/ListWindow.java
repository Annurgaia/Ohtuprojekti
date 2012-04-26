/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.GUI;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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
    boolean tavaraa = false;

    public void listWindowViite(ViiteInterface viite) {
        if (tavaraa) {
            mainframe.removeAll();
            scrollpanel.removeAll();
        }
        String[] lista = viite.toString().split("\n");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(14, 0));
        for (String string : lista) {
            JLabel temp = new JLabel(string);
            panel.add(temp);
        }
        scrollpanel = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainframe.add(scrollpanel);

        mainframe.repaint();
        tavaraa = true;
    }

    public void listWindowTag(LinkedHashMap<String, ViiteInterface> taglist) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(14*taglist.size(), 0));

        for (String s : taglist.keySet()) {
            Viite viite = (Viite) taglist.get(s);
            String[] lista = viite.toString().split("\n");
            for (String string : lista) {
                JLabel temp = new JLabel(string);
                panel.add(temp);
            }
            JLabel temp = new JLabel("-----");
            panel.add(temp);
        }
        scrollpanel = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        mainframe.add(scrollpanel);
    }

    public void pullThePlug() {
        WindowEvent wev = new WindowEvent(mainframe, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
    }

    public ListWindow() {
        mainframe = new JFrame();
        mainframe.setVisible(true);
        mainframe.setBounds(1000, 350, 300, 300);
        mainframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
}
