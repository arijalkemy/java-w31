package documents;

public class Book implements IDocument, IPrintable {
    private String author;
    private String title;
    private String genre;
    private Integer pagesAmt;

    public Book(String author, String title, String genre, Integer pagesAmt) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.pagesAmt = pagesAmt;
    }

    @Override
    public void print() {
        System.out.println("\nPrinting book...\n");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Book:" +
                "\nTitle= " + title +
                "\nAuthor= " + author +
                "\nGenre= " + genre +
                "\nPages = " + pagesAmt;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getPagesAmt() {
        return pagesAmt;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPagesAmt(Integer pagesAmt) {
        this.pagesAmt = pagesAmt;
    }
}
