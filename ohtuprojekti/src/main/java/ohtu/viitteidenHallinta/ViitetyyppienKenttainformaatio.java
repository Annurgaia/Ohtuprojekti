/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;

/**
 *
 * @author iimakis
 */
public class ViitetyyppienKenttainformaatio {
    private ArrayList<String> tyypit;
    private ArrayList<ArrayList<String>> tyyppienPakollisetKentat;
    private ArrayList<ArrayList<String>> tyyppienVapaaehtoisetKentat;
    
    public ViitetyyppienKenttainformaatio() {
        alustaTyypit();
        alustaTyyppienPakollisetKentat();
        alustaTyyppienVapaaehtoisetKentat();
    }

    private void alustaTyypit() {
        tyypit = new ArrayList<String>();
        tyypit.add("article");
        tyypit.add("book");
        tyypit.add("booklet");
        tyypit.add("conference");
        tyypit.add("inbook");
        tyypit.add("incollection");
        tyypit.add("inproceedings");
        tyypit.add("manual");
        tyypit.add("masterthesis");
        tyypit.add("misc");
        tyypit.add("phdthesis");
        tyypit.add("proceedings");
        tyypit.add("techreport");
        tyypit.add("unpublished");
    }

    private void alustaTyyppienPakollisetKentat() {
        tyyppienPakollisetKentat = new ArrayList<ArrayList<String>>();
        tyyppienPakollisetKentat.add(alustaPakollisetKentat("author", "title", "journal", "year"));
        tyyppienPakollisetKentat.add(alustaPakollisetKentat("author", "title", "publisher", "year"));
        tyyppienPakollisetKentat.add(alustaPakollisetKentat("title"));
        tyyppienPakollisetKentat.add(alustaPakollisetKentat("author", "title", "booktitle", "year"));
        tyyppienPakollisetKentat.add(alustaPakollisetKentat("author", "title", "pages", "publisher", "year"));
        tyyppienPakollisetKentat.add(alustaPakollisetKentat("author", "title", "booktitle", "year"));
        tyyppienPakollisetKentat.add(alustaPakollisetKentat("author", "title", "booktitle", "year"));
        tyyppienPakollisetKentat.add(alustaPakollisetKentat("title"));
        tyyppienPakollisetKentat.add(alustaPakollisetKentat("author", "title", "school", "year"));
        tyyppienPakollisetKentat.add(new ArrayList<String>());
        tyyppienPakollisetKentat.add(alustaPakollisetKentat("author", "title", "school", "year"));
        tyyppienPakollisetKentat.add(alustaPakollisetKentat("title", "year"));
        tyyppienPakollisetKentat.add(alustaPakollisetKentat("author", "title", "institution", "year"));
        tyyppienPakollisetKentat.add(alustaPakollisetKentat("author", "title", "note"));
    }
    
    private ArrayList<String> alustaPakollisetKentat(String kentta1) {
        ArrayList<String> pakollisetKentat = new ArrayList<String>();
        pakollisetKentat.add(kentta1);
        return pakollisetKentat;
    }
    
    private ArrayList<String> alustaPakollisetKentat(String kentta1, String kentta2) {
        ArrayList<String> pakollisetKentat = alustaPakollisetKentat(kentta1);
        pakollisetKentat.add(kentta2);
        return pakollisetKentat;
    }
    
    private ArrayList<String> alustaPakollisetKentat(String kentta1,
            String kentta2, String kentta3) {
        ArrayList<String> pakollisetKentat = alustaPakollisetKentat(kentta1, kentta2);
        pakollisetKentat.add(kentta3);
        return pakollisetKentat;
    }
    
    private ArrayList<String> alustaPakollisetKentat(String kentta1,
            String kentta2, String kentta3, String kentta4) {
        ArrayList<String> pakollisetKentat = alustaPakollisetKentat(kentta1, kentta2, kentta3);
        pakollisetKentat.add(kentta4);
        return pakollisetKentat;
    }
    
    private ArrayList<String> alustaPakollisetKentat(String kentta1,
            String kentta2, String kentta3, String kentta4, String kentta5) {
        ArrayList<String> pakollisetKentat = alustaPakollisetKentat(kentta1, kentta2, kentta3, kentta4);
        pakollisetKentat.add(kentta5);
        return pakollisetKentat;
    }

    private void alustaTyyppienVapaaehtoisetKentat() {
        tyyppienVapaaehtoisetKentat = new ArrayList<ArrayList<String>>();
    }
    
    
}
