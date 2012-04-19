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

/**
 *
 * @author Wampie
 */
public class AddMenu implements ActionListener {
    JFrame ikkuna = new JFrame();
    JPanel pak = new JPanel();
    JPanel vap = new JPanel();
    ArrayList pakText = new ArrayList();
    ArrayList vapText = new ArrayList();
    
    public AddMenu (LinkedHashMap<String, String> pakolliset, LinkedHashMap<String, String> vapaaehtoiset) {
        pak.setLayout(new GridLayout(pakolliset.size(), 1));
        vap.setLayout(new GridLayout(vapaaehtoiset.size(), 1));
        for (String s : pakolliset.keySet()) {
            JLabel temp = new JLabel(s);
            JTextField temp2 = new JTextField();
            pakText.add(temp2);
            pak.add(temp);
            pak.add(temp2);
        }
        
        for (String s : vapaaehtoiset.keySet()) {
            JLabel temp = new JLabel(s);
            JTextField temp2 = new JTextField();
            vapText.add(temp2);
            vap.add(temp);
            vap.add(temp2);
        }
        ikkuna.setLayout(new GridLayout(2,0));
        ikkuna.setSize(100, 300);
        ikkuna.add(pak);
        ikkuna.add(vap);
        ikkuna.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
