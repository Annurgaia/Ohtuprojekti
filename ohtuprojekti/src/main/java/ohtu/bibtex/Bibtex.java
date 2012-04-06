package ohtu.bibtex;


public class Bibtex{
    private String type;
    private String author;
    //id koostuu nimikirjaimista ja vuosiluvusta, esim. Beck, Kent and Andres, Cynthia, 2004 id olisi BA04
    private String id;
    private String title;
    private String year;
    private String booktitle;
    private String publisher;
    
    public Bibtex(String type, String author, String title, String year, String publisher, String id){
        this.type = type;
        this.author = author;
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    public void printAsBibtex(){
        System.out.print("@"+type+"{"+id+",\n");
        System.out.print("author = {"+author+"},\n");
        System.out.print("title = {"+title+"},\n");
        System.out.print("year = {"+year+"},\n");
        System.out.print("publisher = {"+publisher+"},\n");
        System.out.print("booktitle = {"+booktitle+"},\n");
        System.out.print("}");
    }
    
    public String getAsBibtex(){
        return "@"+type+"{"+id+",\n"
                + "author = {"+author+"},\n"
                + "title = {"+title+"},\n"
                + "year = {"+year+"},\n"
                + "publisher = {"+publisher+"},\n"
                + "booktitle = {"+booktitle+"},\n"
                + "}";
    }
}