package documents;

public class Report implements IDocument, IPrintable {
    private String title;
    private String author;
    private String reviser;
    private String text;
    private Integer pagesAmt;

    public Report(String title, String author, String reviser, String text, Integer pagesAmt) {
        this.title = title;
        this.author = author;
        this.reviser = reviser;
        this.text = text;
        this.pagesAmt = pagesAmt;
    }

    @Override
    public void print() {
        System.out.println("\nPrinting report...\n");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Report:" +
                "\nTitle=" + title  +
                "\nAuthor= " + author +
                "\nReviser= " + reviser +
                "\nText= " + text +
                "\nPages Amount= " + pagesAmt;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getReviser() {
        return reviser;
    }

    public String getText() {
        return text;
    }

    public Integer getPagesAmt() {
        return pagesAmt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setReviser(String reviser) {
        this.reviser = reviser;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPagesAmt(Integer pagesAmt) {
        this.pagesAmt = pagesAmt;
    }
}
