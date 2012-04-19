/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
    public LinkedHashMap<String, String> kysyPakollisetKentat(LinkedHashMap<String, String> nimet) {
        System.out.println("Syötä pakolliset kentät:");
        LinkedHashMap<String, String> palautus = new LinkedHashMap<String, String>();
        for (String s : nimet.keySet()) {
            System.out.print(s + ": ");
            palautus.put(s, lukija.nextLine());
        }
        return palautus;
    }
    public LinkedHashMap<String, String> kysyVapaaehtoisetKentat(LinkedHashMap<String, String> nimet) {
        System.out.println("Syötä vapaaehtoiset kentät:");
        LinkedHashMap<String, String> palautus = new LinkedHashMap<String, String>();
        for (String s : nimet.keySet()) {
            System.out.print(s + ": ");
            palautus.put(s, lukija.nextLine());
        }
        return palautus;
    }
    
    
}
