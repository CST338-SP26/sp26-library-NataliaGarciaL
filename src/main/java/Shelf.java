//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import Utilities.Code;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Objects;


public class Shelf {
    public static final int SHELF_NUMBER_ = 0;
    public static final int SUBJECT_ = 1;
    private HashMap<Book, Integer> books;
    private int ShelfNumber;
    private String subject;


    public Shelf() {
        this.books = new HashMap();
    }


    public Shelf(int shelfNumber, String subject) {
        this();
        this.ShelfNumber = shelfNumber;
        this.subject = subject;
    }
    //rember to push


    public int getBookCount(Book book) {
        return !this.books.containsKey(book) ? -1 : (Integer)this.books.get(book);
    }


    public Code addBook(Book book) {
        int count = this.getBookCount(book);
        if (this.books.containsKey(book)) {
            this.books.put(book, count + 1);
            return Code.SUCCESS;
        } else if (book.getSubject().equals(this.subject)) {
            this.books.put(book, 1);
            PrintStream var10000 = System.out;
            String var10001 = this.books.toString();
            var10000.println(var10001 + " added to shelf " + this.toString());
            return Code.SUCCESS;
        } else {
            return Code.SHELF_SUBJECT_MISMATCH_ERROR;
        }
    }


    public Code removeBook(Book book) {
        int count = this.getBookCount(book);
        if (!this.books.containsKey(book)) {
            PrintStream var4 = System.out;
            String var6 = this.books.toString();
            var4.println(var6 + " is not on shelf " + this.toString());
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        } else if (count == 0) {
            PrintStream var3 = System.out;
            String var5 = this.books.toString();
            var3.println("No copies of " + var5 + " remain on shelf " + this.toString());
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        } else {
            this.books.put(book, count - 1);
            PrintStream var10000 = System.out;
            String var10001 = this.books.toString();
            var10000.println(var10001 + " successfully removed from shelf " + this.toString());
            return Code.SUCCESS;
        }
    }


    public String listBooks() {
        String check = "";
        int total = 0;


        for(Integer i : this.books.values()) {
            total += i;
        }


        if (total == 1) {
            check = check + "1 book on shelf: " + this.getShelfNumber() + " : " + this.getSubject();
        } else {
            check = check + this.books.size() + " books on shelf: " + this.getShelfNumber() + " : " + this.getSubject();
        }


        return check;
    }


    public HashMap<Book, Integer> getBooks() {
        return this.books;
    }


    public void setBooks(HashMap<Book, Integer> books) {
        this.books = books;
    }


    public int getShelfNumber() {
        return this.ShelfNumber;
    }


    public void setShelfNumber(int shelfNumber) {
        this.ShelfNumber = shelfNumber;
    }


    public String getSubject() {
        return this.subject;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }


    public boolean equals(Object object) {
        if (object != null && this.getClass() == object.getClass()) {
            Shelf shelf = (Shelf)object;
            return this.ShelfNumber == shelf.ShelfNumber && Objects.equals(this.subject, shelf.subject);
        } else {
            return false;
        }
    }


    public int hashCode() {
        return Objects.hash(new Object[]{this.ShelfNumber, this.subject});
    }


    public String toString() {
        return this.ShelfNumber + " : " + this.subject;
    }
}
