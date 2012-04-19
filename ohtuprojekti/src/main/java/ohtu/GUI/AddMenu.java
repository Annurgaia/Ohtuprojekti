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
    ArrayList<JTextField> pakText = new ArrayList<JTextField>();
    ArrayList<JTextField> vapText = new ArrayList<JTextField>();
    boolean submit = false;
    LinkedHashMap<String, String> vapMap = new LinkedHashMap<String, String>();
    LinkedHashMap<String, String> pakMap = new LinkedHashMap<String, String>();

    public AddMenu(LinkedHashMap<String, String> pakolliset, LinkedHashMap<String, String> vapaaehtoiset) {
        pakMap = pakolliset;
        vapMap = vapaaehtoiset;
        pak.setLayout(new GridLayout(pakolliset.size(), 1));
        vap.setLayout(new GridLayout(vapaaehtoiset.size() + 1, 1));
        for (String s : pakolliset.keySet()) {
            JLabel temp = new JLabel(s);
            JTextField temp2 = new JTextField();
            temp2.addActionListener(this);
            pakText.add(temp2);
            pak.add(temp);
            pak.add(temp2);
        }

        for (String s : vapaaehtoiset.keySet()) {
            JLabel temp = new JLabel(s);
            JTextField temp2 = new JTextField();
            temp2.addActionListener(this);
            vapText.add(temp2);
            vap.add(temp);
            vap.add(temp2);
        }

        JButton sub = new JButton("Lisää");
        ikkuna.setLayout(new GridLayout(2, 0));
        sub.addActionListener(this);
        vap.add(sub);
        ikkuna.setSize(200, 300);
        ikkuna.add(pak);
        ikkuna.add(vap);
        ikkuna.setVisible(true);
    }

    public LinkedHashMap<String, String> getPakolliset() {
        while (submit == false) {
        }
        return pakMap;
    }

    public LinkedHashMap<String, String> getVapaaehtoiset() {
        while (submit == false) {
        }
        return vapMap;
    }

    public void actionPerformed(ActionEvent e) {
        int i = 0;
        for (String s : pakMap.keySet()) {
            String ss = pakText.get(i).getText();
            pakMap.put(s, ss);
            i ++;
        }
        i = 0;
        for (String s : vapMap.keySet()) {
            vapMap.put(s, vapText.get(i).getText());
            i ++;
        }
        submit = true;
        
    }
}
