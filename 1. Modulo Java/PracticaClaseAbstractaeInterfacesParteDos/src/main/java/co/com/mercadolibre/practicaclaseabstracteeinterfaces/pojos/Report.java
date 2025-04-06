package co.com.mercadolibre.practicaclaseabstracteeinterfaces.pojos;

public class Report extends Document {

    private long textLength;
    private int pageNumber;
    private String authorName;
    private String reviewer;

    public Report(){

    }

    public Report(long textLength, int pageNumber, String authorName, String reviewer) {
        this.textLength = textLength;
        this.pageNumber = pageNumber;
        this.authorName = authorName;
        this.reviewer = reviewer;
    }

    public long getTextLength() {
        return textLength;
    }

    public void setTextLength(long textLength) {
        this.textLength = textLength;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return "Report [textLength=" + textLength + ", pageNumber=" + pageNumber + ", authorName=" + authorName
                + ", reviewer=" + reviewer + "]";
    }
    
    

    
    
    
}
