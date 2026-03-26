//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import Utilities.Code;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Reader {
    public static final int CARD_NUMBER_ = 0;
    public static final int NAME_ = 1;
    public static final int PHONE_ = 2;
    public static final int BOOK_COUNT_ = 3;
    public static final int BOOK_START_ = 4;
    private int cardNumber;
    private String name;
    private String Phone;
    private List<Book> books;


    public Reader(int cardNumber, String name, String Phone) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.Phone = Phone;
        this.books = new ArrayList();
    }


    public Code addBook(Book book) {
        if (this.hasBook(book)) {
            return Code.BOOK_ALREADY_CHECKED_OUT_ERROR;
        } else {
            this.books.add(book);
            return Code.SUCCESS;
        }
    }


    public Code removeBook(Book book) {
        if (!this.hasBook(book)) {
            return Code.READER_DOESNT_HAVE_BOOK_ERROR;
        } else {
            return this.books.remove(book) ? Code.SUCCESS : Code.READER_COULD_NOT_REMOVE_BOOK_ERROR;
        }
    }


    public boolean hasBook(Book book) {
        return this.books.contains(book);
    }


    public int getCardNumber() {
        return this.cardNumber;
    }


    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return this.Phone;
    }


    public void setPhone(String phone) {
        this.Phone = phone;
    }


    public List<Book> getBooks() {
        return this.books;
    }


    public void setBooks(List<Book> books) {
        this.books = books;
    }


    public boolean equals(Object object) {
        if (object != null && this.getClass() == object.getClass()) {
            Reader reader = (Reader)object;
            return this.cardNumber == reader.cardNumber && Objects.equals(this.name, reader.name) && Objects.equals(this.Phone, reader.Phone);
        } else {
            return false;
        }
    }


    public int hashCode() {
        return Objects.hash(new Object[]{this.cardNumber, this.name, this.Phone});
    }


    public String toString() {
        String var10000 = this.name;
        return var10000 + "(#" + this.cardNumber + ") has checked out " + String.valueOf(this.books);
    }


    public int getBookCount() {
        return this.books.size();
    }
}


