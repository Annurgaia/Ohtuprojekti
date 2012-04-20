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
    JPanel pak = new JPanel();
    JPanel vap = new JPanel();
    ArrayList<JTextField> pakText = new ArrayList<JTextField>();
    ArrayList<JTextField> vapText = new ArrayList<JTextField>();
    boolean submit = false;
    LinkedHashMap<String, String> vapMap = new LinkedHashMap<String, String>();
    LinkedHashMap<String, String> pakMap = new LinkedHashMap<String, String>();
    JComboBox lista = new JComboBox();
    ViiteHallinta hallinta;
    String valinta = "";

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
        ikkuna.setLayout(new GridLayout(3, 0));
        ikkuna.add(pikkuna);
        ikkuna.add(pak);
        ikkuna.add(vap);

        ikkuna.setVisible(true);
        ikkuna.setSize(200, 400);



    }

    public void alustaForm(LinkedHashMap<String, String> pakolliset, LinkedHashMap<String, String> vapaaehtoiset) {
        vap.removeAll();
        pak.removeAll();
        pakMap = pakolliset;
        vapMap = vapaaehtoiset;
        pak.setLayout(new GridLayout(5, 1));
        vap.setLayout(new GridLayout(8 + 1, 1));
        pakText = new ArrayList<JTextField>();
        vapText = new ArrayList<JTextField>();
        for (String s : pakolliset.keySet()) {
            JLabel temp = new JLabel(s);

            JTextField temp2 = new JTextField();

            temp2.addActionListener(this);
            pakText.add(temp2);
            pak.add(temp);
            pak.add(temp2);
            temp.revalidate();
            temp2.revalidate();
        }

        for (String s : vapaaehtoiset.keySet()) {
            JLabel temp = new JLabel(s);
            JTextField temp2 = new JTextField();
            temp2.addActionListener(this);
            vapText.add(temp2);
            vap.add(temp);
            vap.add(temp2);
            temp.revalidate();
            temp2.revalidate();
        }

        JButton sub = new JButton("Lisää");
        sub.addActionListener(this);
        vap.add(sub);
//        
//        ikkuna.add(pak);
//        ikkuna.add(vap);
        ikkuna.setSize(400, 500);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("muutos")) {
            JComboBox cb = (JComboBox) e.getSource();
            valinta = (String) cb.getSelectedItem();
            alustaForm(hallinta.getTyypinPakollisetKentat(valinta), hallinta.getTyypinVapaaehtoisetKentat(valinta));
            return;
        }

        int i = 0;
        for (String s : pakMap.keySet()) {
            String ss = pakText.get(i).getText();
            
            pakMap.put(s, ss);
            pakText.get(i).setText("");
            i++;
        }
        i = 0;
        for (String s : vapMap.keySet()) {
            String ss = vapText.get(i).getText();
            vapMap.put(s, ss);
            vapText.get(i).setText("");
            i++;
            
        }
        if (!valinta.equals("")) {
            hallinta.lisaaViite(valinta, pakMap, vapMap);
        }

    }
}
