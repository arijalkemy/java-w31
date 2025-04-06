package co.com.mercadolibre.practicaclaseabstracteeinterfaces.pojos;

import co.com.mercadolibre.practicaclaseabstracteeinterfaces.enums.Genres;

public class PdfBook extends Document {

    private int pagesNumber;
    private Genres genres;
    private String authorName;
    private String title;   
    
    public PdfBook() {
    }

    public PdfBook(int pagesNumber, Genres genres, String authorName, String title) {
        this.pagesNumber = pagesNumber;
        this.genres = genres;
        this.authorName = authorName;
        this.title = title;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }
    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }
    public Genres getGenres() {
        return genres;
    }
    public void setGenres(Genres genres) {
        this.genres = genres;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return "PdfBook [pagesNumber=" + pagesNumber + ", genres=" + genres + ", authorName=" + authorName + ", title="
                + title + "]";
    }

    
    
}
