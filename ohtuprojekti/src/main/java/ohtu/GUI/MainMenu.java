/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
    JButton deleteButton;
    Kuuntelija kuunt = new Kuuntelija();
    
    private class Kuuntelija implements WindowListener {

        public void windowOpened(WindowEvent e) {
        }

        public void windowClosing(WindowEvent e) {
            int n = JOptionPane.showOptionDialog(mainpanel, 
                    "Tallentaanko tiedot?",
                    "Tallennusvalikko", 
                    JOptionPane.YES_NO_CANCEL_OPTION, 
                    JOptionPane.QUESTION_MESSAGE,
                    null, 
                    null,
                    mainframe);
            switch (n) {
                case 0:
                    hallinta.tallennaViitteet();
                    System.exit(0);
                    break;
                case 1:
                    System.exit(0);
                    break;
                case 2:
                    return;
            }
        }

        public void windowClosed(WindowEvent e) {
        }

        public void windowIconified(WindowEvent e) {
        }

        public void windowDeiconified(WindowEvent e) {
        }

        public void windowActivated(WindowEvent e) {
        }

        public void windowDeactivated(WindowEvent e) {
        }
        
    }

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
        deleteButton = new JButton("Poista viite");
        deleteButton.addActionListener(this);
        deleteButton.setActionCommand("6");
        mainpanel.add(deleteButton);

        bibtextButton = new JButton("Tallenna BiBtext");
        bibtextButton.addActionListener(this);
        bibtextButton.setActionCommand("4");
        mainpanel.add(bibtextButton);
        saveButton = new JButton("Tallenna viitteet");
        saveButton.addActionListener(this);
        saveButton.setActionCommand("5");
        mainpanel.add(saveButton);
        
        
        mainframe.add(mainpanel);
        mainframe.setVisible(true);

        mainframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainframe.setLocation(600, 200);
        mainframe.addWindowListener(kuunt);
        hallinta = new ViiteHallinta();

        modifyButton.setEnabled(false);
//        listButton.setEnabled(false);
        deleteButton.setEnabled(false);

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
                new ListMenu(hallinta);
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
                System.exit(0);
                break;
        }
    }
}
