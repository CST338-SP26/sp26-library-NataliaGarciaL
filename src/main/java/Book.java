/* Title: Book
 * Abstract: This is book class that gets input of book information and structure a to String so in output in orderly academic sentence.
 * Author: Natalia Garcia
 * Date: 3/13/2026
 */
import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private String ISBN;
    public final static int ISBN_ = 0;
    public final static int TITLE_ = 1;
    public final static int SUBJECT_ = 2;
    public final static int PAGE_COUNT_ = 3;
    public final static int AUTHOR_ = 4;
    public final static int DUE_DATE_ = 5;
    private String author;
    private LocalDate dueDate;

    private int pageCount;
    private String subject;
    private String title;

    public Book(String ISBN, String title, String subject, int pageCount, String author, LocalDate dueDate){
        this.ISBN=ISBN;
        this.title=title;
        this.subject=subject;
        this.pageCount=pageCount;
        this.author=author;
        this.dueDate=dueDate;

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setISBN(String ISBN) {
        this.ISBN=ISBN;

    }
    public String getISBN() {
        return ISBN;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * altered the equals method
     * @equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pageCount == book.pageCount && Objects.equals(author, book.author)  && Objects.equals(ISBN, book.ISBN) && Objects.equals(subject, book.subject) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, ISBN, pageCount, subject, title);
    }

    /**
     * Orders the inputted information into a structure sentence
     * @toString
     */

        @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append(" by ");
        sb.append(author);
        sb.append(" ISBN: ").append(ISBN);
        return sb.toString();
    }

}
