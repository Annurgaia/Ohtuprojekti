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
        tyyppienVapaaehtoisetKentat.add(alustaVapaaehtoisetKentat("volume",
                "number", "pages", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaVapaaehtoisetKentat("volume",
                "series", "address", "edition", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaVapaaehtoisetKentat("author",
                "howpublished", "address", "month", "year", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaVapaaehtoisetKentat("editor",
                "pages", "organization", "publisher", "address", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaVapaaehtoisetKentat("volume",
                "series", "address", "edition", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaVapaaehtoisetKentat("editor",
                "pages", "organization", "publisher", "address", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaVapaaehtoisetKentat("editor",
                "pages", "organization", "publisher", "address", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaVapaaehtoisetKentat("author",
                "organization", "address", "edition", "month", "year", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaVapaaehtoisetKentat("address", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaVapaaehtoisetKentat("author",
                "title", "howpublished", "month", "year", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaVapaaehtoisetKentat("address", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaVapaaehtoisetKentat("editor",
                "publisher", "organization", "address", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaVapaaehtoisetKentat("type",
                "number", "address", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaVapaaehtoisetKentat("month", "year", "key"));        
    }
    
    private ArrayList<String> alustaVapaaehtoisetKentat(String kentta1, String kentta2,
            String kentta3) {
        ArrayList<String> vapaaehtoisetKentat = new ArrayList<String>();
        vapaaehtoisetKentat.add(kentta1);
        vapaaehtoisetKentat.add(kentta2);
        vapaaehtoisetKentat.add(kentta3);
        return vapaaehtoisetKentat;
    }
    
    private ArrayList<String> alustaVapaaehtoisetKentat(String kentta1, String kentta2,
            String kentta3, String kentta4) {
        ArrayList<String> vapaaehtoisetKentat = alustaVapaaehtoisetKentat(kentta1, kentta2, kentta3);
        vapaaehtoisetKentat.add(kentta4);
        return vapaaehtoisetKentat;
    }
    
    private ArrayList<String> alustaVapaaehtoisetKentat(String kentta1, String kentta2,
            String kentta3, String kentta4, String kentta5, String kentta6) {
        ArrayList<String> vapaaehtoisetKentat = alustaVapaaehtoisetKentat(kentta1, kentta2, kentta3, kentta4);
        vapaaehtoisetKentat.add(kentta5);
        vapaaehtoisetKentat.add(kentta6);
        return vapaaehtoisetKentat;
    }
    
    private ArrayList<String> alustaVapaaehtoisetKentat(String kentta1, String kentta2, String kentta3,
            String kentta4, String kentta5, String kentta6, String kentta7) {
        ArrayList<String> vapaaehtoisetKentat = alustaVapaaehtoisetKentat(kentta1, kentta2, kentta3, kentta4, kentta5, kentta6);
        vapaaehtoisetKentat.add(kentta7);
        return vapaaehtoisetKentat;
    }
    
    private ArrayList<String> alustaVapaaehtoisetKentat(String kentta1, String kentta2, String kentta3,
            String kentta4, String kentta5, String kentta6, String kentta7, String kentta8) {
        ArrayList<String> vapaaehtoisetKentat = alustaVapaaehtoisetKentat(kentta1, kentta2, kentta3, kentta4, kentta5, kentta6, kentta7);
        vapaaehtoisetKentat.add(kentta8);
        return vapaaehtoisetKentat;
    }
    
}
