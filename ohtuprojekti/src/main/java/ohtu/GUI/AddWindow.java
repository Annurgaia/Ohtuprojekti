/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.GUI;

/**
 *
 * @author Wampie
 */
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.*;
import ohtu.viitteidenHallinta.*;

public class AddWindow implements ActionListener {

    JFrame mainframe;
    JPanel pakolliset;
    JPanel vapaaehtoiset;
    JButton submit;
    Container panel;
    ViiteHallinta hallinta;
    JTextField tag;
    LinkedHashMap<String, String> vapMap = new LinkedHashMap<String, String>();
    LinkedHashMap<String, String> pakMap = new LinkedHashMap<String, String>();
    ArrayList<JTextField> pakText = new ArrayList<JTextField>();
    ArrayList<JTextField> vapText = new ArrayList<JTextField>();
    String valinta = "";

    public AddWindow(ViiteHallinta hal) {
        mainframe = new JFrame();
        hallinta = hal;
        mainframe.setBounds(350, 300, 250, 400);
        mainframe.setVisible(true);
    }

    public void pullThePlug() {
        WindowEvent wev = new WindowEvent(mainframe, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
    }

    public void lisaa(String tyyppi) {
        valinta = tyyppi;
        pakText = new ArrayList<JTextField>();
        vapText = new ArrayList<JTextField>();
        LinkedHashMap<String, String> p = hallinta.getTyypinPakollisetKentat(tyyppi);
        LinkedHashMap<String, String> v = hallinta.getTyypinVapaaehtoisetKentat(tyyppi);

        pakolliset = new JPanel();
        vapaaehtoiset = new JPanel();

        pakolliset.setLayout(new GridLayout((p.size() + 1), 0));
        vapaaehtoiset.setLayout(new GridLayout(((v.size() * 2) + 2), 0));
        JLabel temppu = new JLabel("Pakolliset:");
        pakolliset.add(temppu);
        temppu = new JLabel("      ");
        pakolliset.add(temppu);
        for (String s : p.keySet()) {
            JLabel temp = new JLabel(s);
            JTextField temp2 = new JTextField();
            temp2.addActionListener(this);
            pakText.add(temp2);
            pakolliset.add(temp);
            pakolliset.add(temp2);
        }
        temppu = new JLabel("Vapaaehtoiset:");
        vapaaehtoiset.add(temppu);
        temppu = new JLabel("      ");
        vapaaehtoiset.add(temppu);
        for (String s : v.keySet()) {
            JLabel temp = new JLabel(s);
            JTextField temp2 = new JTextField();
            temp2.addActionListener(this);
            vapText.add(temp2);
            vapaaehtoiset.add(temp);
            vapaaehtoiset.add(temp2);
        }
        JLabel temp = new JLabel("tägit");
        JTextField temp2 = new JTextField();
        temp2.addActionListener(this);
        tag = temp2;
        vapaaehtoiset.add(temp);
        vapaaehtoiset.add(tag);
        submit = new JButton("Lisää");
        submit.addActionListener(this);
        vapaaehtoiset.add(submit);

        mainframe.getContentPane().setLayout(new BoxLayout(mainframe.getContentPane(), BoxLayout.Y_AXIS));
        pakolliset.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainframe.getContentPane().add(pakolliset);
        vapaaehtoiset.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainframe.getContentPane().add(vapaaehtoiset);

    }

    public void actionPerformed(ActionEvent e) {
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
        hallinta.lisaaViite(valinta, tag.getText(), pakMap, vapMap);
    }
}
