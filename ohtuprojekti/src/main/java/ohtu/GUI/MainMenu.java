/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import javax.swing.*;
/**
 *
 * @author Wampie
 */
public class MainMenu implements ActionListener {
    JFrame mainframe;
    JPanel mainpanel;
    JButton addButton;
    JButton modifyButton;
    JButton listButton;
    JButton bibtextButton;
    JButton saveButton;
    JButton endButton;
    
    
    public MainMenu() {
        mainframe = new JFrame();
        mainframe.setSize(400, 400);
        mainframe.setResizable(false);
        mainpanel = new JPanel();
        mainpanel.setLayout(new GridLayout(3,3));
        addButton = new JButton("Lisää viite");
        addButton.addActionListener(this);
        addButton.setActionCommand("1");
        mainpanel.add(addButton);
        modifyButton = new JButton("Muokkaa viitettä");
        modifyButton.addActionListener(this);
        modifyButton.setActionCommand("2");
        mainpanel.add(modifyButton);
        listButton = new JButton("Listaa viitteet");
        listButton.addActionListener(this);
        listButton.setActionCommand("3");
        mainpanel.add(listButton);
        bibtextButton = new JButton("Tallenna BiBtext");
        bibtextButton.addActionListener(this);
        bibtextButton.setActionCommand("4");
        mainpanel.add(bibtextButton);
        saveButton = new JButton("Tallenna viitteet");
        saveButton.addActionListener(this);
        saveButton.setActionCommand("5");
        mainpanel.add(saveButton);
        endButton = new JButton("Lopeta");
        endButton.addActionListener(this);
        endButton.setActionCommand("6");
        mainpanel.add(endButton);
        
        mainframe.add(mainpanel);
        mainframe.setVisible(true);
        
        
    }
    
    public static void main(String[] args) {
        new MainMenu();
        LinkedHashMap<String, String> test = new LinkedHashMap<String, String>();
        test.put("1", "1");
        test.put("2", "2");
        test.put("3", "1");
        test.put("4", "2");
        test.put("5", "1");
        test.put("6", "2");
        new AddMenu(test, test);
    }
    
    public void actionPerformed(ActionEvent e) {
        int komento = Integer.parseInt(e.getActionCommand());
        
        switch (komento) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
        }
    }
    
}
