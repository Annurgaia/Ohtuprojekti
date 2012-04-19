/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        mainpanel.add(addButton);
        modifyButton = new JButton("Muokkaa viitettä");
        mainpanel.add(modifyButton);
        listButton = new JButton("Listaa viitteet");
        mainpanel.add(listButton);
        bibtextButton = new JButton("Tallenna BiBtext");
        mainpanel.add(bibtextButton);
        saveButton = new JButton("Tallenna viitteet");
        mainpanel.add(saveButton);
        endButton = new JButton("Lopeta");
        mainpanel.add(endButton);
        
        mainframe.add(mainpanel);
        mainframe.setVisible(true);
        
        
    }
    
    public static void main(String[] args) {
        new MainMenu();
    }
    
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
