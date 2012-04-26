/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import ohtu.viitteidenHallinta.*;

/**
 *
 * @author Wampie
 */
public class MainMenu implements ActionListener {

    static ViiteHallinta hallinta;
    JFrame mainframe;
    JPanel mainpanel;
    JButton addButton;
    JButton modifyButton;
    JButton listButton;
    JButton bibtextButton;
    JButton saveButton;
    JButton endButton;

    public MainMenu() throws IOException {
        mainframe = new JFrame();
        mainframe.setSize(400, 400);
        mainframe.setResizable(false);
        mainpanel = new JPanel();
        mainpanel.setLayout(new GridLayout(3, 3));
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

        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hallinta = new ViiteHallinta();

        modifyButton.setEnabled(false);
        listButton.setEnabled(false);

    }

    public static void main(String[] args) throws IOException {

        new MainMenu();
    }

    public void actionPerformed(ActionEvent e) {
        int komento = Integer.parseInt(e.getActionCommand());

        switch (komento) {
            case 1:
                new AddMenu(hallinta);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                try {
                    hallinta.teeViitteistaBibtex("references");
                } catch (IOException ex) {
                    System.out.println("VIRHE");
                }
                break;
            case 5:
                hallinta.tallennaViitteet();
                break;
            case 6:
                System.exit(1);
                break;
        }
    }
}
