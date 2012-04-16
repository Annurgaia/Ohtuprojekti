/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.viitteidenHallinta;

import java.util.ArrayList;
import java.util.Arrays;

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
        String [] temp = {"author", "title", "journal", "year"};
        tyyppienPakollisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"author", "title", "publisher", "year"};
        tyyppienPakollisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"title"};
        tyyppienPakollisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"author", "title", "booktitle", "year"};
        tyyppienPakollisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"author", "title", "pages", "publisher", "year"};
        tyyppienPakollisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"author", "title", "booktitle", "year"};
        tyyppienPakollisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"author", "title", "booktitle", "year"};
        tyyppienPakollisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"title"};
        tyyppienPakollisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"author", "title", "school", "year"};
        tyyppienPakollisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        tyyppienPakollisetKentat.add(new ArrayList<String>());
        temp = new String [] {"author", "title", "school", "year"};
        tyyppienPakollisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"title", "year"};
        tyyppienPakollisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"author", "title", "institution", "year"};
        tyyppienPakollisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"author", "title", "note"};
        tyyppienPakollisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        return tyyppienPakollisetKentat;
    }
    
    public static ArrayList<ArrayList<String>> alustaVapaaehtoisetKentat() {
        ArrayList<ArrayList<String>> tyyppienVapaaehtoisetKentat = new ArrayList<ArrayList<String>>();
        String [] temp = {"volume",
                "number", "pages", "month", "note", "key"};
        tyyppienVapaaehtoisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"volume",
                "series", "address", "edition", "month", "note", "key"};
        tyyppienVapaaehtoisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"author",
                "howpublished", "address", "month", "year", "note", "key"};
        tyyppienVapaaehtoisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"editor",
                "pages", "organization", "publisher", "address", "month", "note", "key"};
        tyyppienVapaaehtoisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"volume",
                "series", "address", "edition", "month", "note", "key"};
        tyyppienVapaaehtoisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"editor",
                "pages", "organization", "publisher", "address", "month", "note", "key"};
        tyyppienVapaaehtoisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"editor",
                "pages", "organization", "publisher", "address", "month", "note", "key"};
        tyyppienVapaaehtoisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"author",
                "organization", "address", "edition", "month", "year", "note", "key"};
        tyyppienVapaaehtoisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"address", "month", "note", "key"};
        tyyppienVapaaehtoisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"author",
                "title", "howpublished", "month", "year", "note", "key"};
        tyyppienVapaaehtoisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"address", "month", "note", "key"};
        tyyppienVapaaehtoisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"editor",
                "publisher", "organization", "address", "month", "note", "key"};
        tyyppienVapaaehtoisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"type",
                "number", "address", "month", "note", "key"};
        tyyppienVapaaehtoisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        temp = new String [] {"month", "year", "key"};
        tyyppienVapaaehtoisetKentat.add(new ArrayList<String>(Arrays.asList(temp)));
        return tyyppienVapaaehtoisetKentat;
    }
}
