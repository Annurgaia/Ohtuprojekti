/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Wampie
 */


public class TestiSyote {
    static Scanner lukija = new Scanner(System.in);
    public TestiSyote() {
        
    }
    
    public int alkumenu() {
        System.out.println("Valitse toiminto:");
        System.out.println("1. Lisää viite");
        System.out.println("2. Muokkaa viitettä");
        System.out.println("3. Listaa viitteet");
        System.out.println("4. Lopeta");
        return kysyInt();
    }
    public int kysyViitetyyppi(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ". " + list.get(i));
        }
        return kysyInt();
    }
    private int kysyInt() {
        try {
            return Integer.parseInt(lukija.nextLine());
        } catch (Exception e) {
            System.out.println("Virheellinen syöte");
            return -1;
        }
    }
    public String kysyId() {
        System.out.println("Anna ID:");
        return lukija.nextLine();
    }
    public ArrayList<String> kysyPakollisetKentat(ArrayList<String> nimet) {
        System.out.println("Syötä pakolliset kentät:");
        ArrayList<String> palautus = new ArrayList<String>();
        for (String s : nimet) {
            System.out.print(s + ": ");
            palautus.add(lukija.nextLine());
        }
        return palautus;
    }
    public ArrayList<String> kysyVapaaehtoisetKentat(ArrayList<String> nimet) {
        System.out.println("Syötä vapaaehtoiset kentät:");
        ArrayList<String> palautus = new ArrayList<String>();
        for (String s : nimet) {
            System.out.print(s + ": ");
            palautus.add(lukija.nextLine());
        }
        return palautus;
    }
}
