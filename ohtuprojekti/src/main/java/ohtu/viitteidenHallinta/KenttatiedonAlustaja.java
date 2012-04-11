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
public class KenttatiedonAlustaja {

   public static ArrayList<String> alustaTyypit() {
        ArrayList<String> tyypit = new ArrayList<String>();
        tyypit.add("article");
        tyypit.add("book");
        tyypit.add("booklet");
        tyypit.add("conference");
        tyypit.add("inbook");
        tyypit.add("incollection");
        tyypit.add("inproceedings");
        tyypit.add("manual");
        tyypit.add("mastersthesis");
        tyypit.add("misc");
        tyypit.add("phdthesis");
        tyypit.add("proceedings");
        tyypit.add("techreport");
        tyypit.add("unpublished");
        return tyypit;
    }
    
    public static ArrayList<ArrayList<String>> alustaPakollisetKentat() {
        ArrayList<ArrayList<String>> tyyppienPakollisetKentat = new ArrayList<ArrayList<String>>();
        tyyppienPakollisetKentat.add(alustaKentat("author", "title", "journal", "year"));
        tyyppienPakollisetKentat.add(alustaKentat("author", "title", "publisher", "year"));
        tyyppienPakollisetKentat.add(alustaKentat("title"));
        tyyppienPakollisetKentat.add(alustaKentat("author", "title", "booktitle", "year"));
        tyyppienPakollisetKentat.add(alustaKentat("author", "title", "pages", "publisher", "year"));
        tyyppienPakollisetKentat.add(alustaKentat("author", "title", "booktitle", "year"));
        tyyppienPakollisetKentat.add(alustaKentat("author", "title", "booktitle", "year"));
        tyyppienPakollisetKentat.add(alustaKentat("title"));
        tyyppienPakollisetKentat.add(alustaKentat("author", "title", "school", "year"));
        tyyppienPakollisetKentat.add(new ArrayList<String>());
        tyyppienPakollisetKentat.add(alustaKentat("author", "title", "school", "year"));
        tyyppienPakollisetKentat.add(alustaKentat("title", "year"));
        tyyppienPakollisetKentat.add(alustaKentat("author", "title", "institution", "year"));
        tyyppienPakollisetKentat.add(alustaKentat("author", "title", "note"));
        return tyyppienPakollisetKentat;
    }
    
    public static ArrayList<ArrayList<String>> alustaVapaaehtoisetKentat() {
        ArrayList<ArrayList<String>> tyyppienVapaaehtoisetKentat = new ArrayList<ArrayList<String>>();
        tyyppienVapaaehtoisetKentat.add(alustaKentat("volume",
                "number", "pages", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaKentat("volume",
                "series", "address", "edition", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaKentat("author",
                "howpublished", "address", "month", "year", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaKentat("editor",
                "pages", "organization", "publisher", "address", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaKentat("volume",
                "series", "address", "edition", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaKentat("editor",
                "pages", "organization", "publisher", "address", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaKentat("editor",
                "pages", "organization", "publisher", "address", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaKentat("author",
                "organization", "address", "edition", "month", "year", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaKentat("address", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaKentat("author",
                "title", "howpublished", "month", "year", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaKentat("address", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaKentat("editor",
                "publisher", "organization", "address", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaKentat("type",
                "number", "address", "month", "note", "key"));
        tyyppienVapaaehtoisetKentat.add(alustaKentat("month", "year", "key"));
        return tyyppienVapaaehtoisetKentat;
    }
    
    
    private static ArrayList<String> alustaKentat(String kentta1) {
        ArrayList<String> kentat = new ArrayList<String>();
        kentat.add(kentta1);
        return kentat;
    }
    
    private static ArrayList<String> alustaKentat(String kentta1, String kentta2) {
        ArrayList<String> kentat = alustaKentat(kentta1);
        kentat.add(kentta2);
        return kentat;
    }
    
    private static ArrayList<String> alustaKentat(String kentta1, String kentta2, String kentta3) {
        ArrayList<String> kentat = alustaKentat(kentta1, kentta2);
        kentat.add(kentta3);
        return kentat;
    }
    
    private static ArrayList<String> alustaKentat(String kentta1, String kentta2,
            String kentta3, String kentta4) {
        ArrayList<String> kentat = alustaKentat(kentta1, kentta2, kentta3);
        kentat.add(kentta4);
        return kentat;
    }
    
    private static ArrayList<String> alustaKentat(String kentta1, String kentta2,
            String kentta3, String kentta4, String kentta5) {
        ArrayList<String> kentat = alustaKentat(kentta1, kentta2, kentta3, kentta4);
        kentat.add(kentta5);
        return kentat;
    }
    
    private static ArrayList<String> alustaKentat(String kentta1, String kentta2,
            String kentta3, String kentta4, String kentta5, String kentta6) {
        ArrayList<String> kentat = alustaKentat(kentta1, kentta2, kentta3, kentta4, kentta5);
        kentat.add(kentta6);
        return kentat;
    }
    
    private static ArrayList<String> alustaKentat(String kentta1, String kentta2, String kentta3,
            String kentta4, String kentta5, String kentta6, String kentta7) {
        ArrayList<String> kentat = alustaKentat(kentta1, kentta2, kentta3, kentta4, kentta5, kentta6);
        kentat.add(kentta7);
        return kentat;
    }
    
    private static ArrayList<String> alustaKentat(String kentta1, String kentta2, String kentta3,
            String kentta4, String kentta5, String kentta6, String kentta7, String kentta8) {
        ArrayList<String> kentat = alustaKentat(kentta1, kentta2,
                kentta3, kentta4, kentta5, kentta6, kentta7);
        kentat.add(kentta8);
        return kentat;
    }
}
