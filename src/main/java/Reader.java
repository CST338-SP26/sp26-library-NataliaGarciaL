/* Title: Reader
 * Abstract: This is the reader clas which checks the information of the reader and what book they got.
 * Author: Natalia Garcia
 * Date: 3/16/2026
 */
import Utilities.Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reader {
    public static final int CARD_NUMBER_ =0;
    public static final int NAME_ =1;
    public static final  int PHONE_ =2;
    public static final int  BOOK_COUNT_ =3;
    public static final int BOOK_START_=4;
    private int cardNumber;
    private String name;
    private String Phone;
    private List<Book> books;

    public Reader(int cardNumber, String name, String Phone) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.Phone = Phone;
        books = new ArrayList<>();
    }

    public Code addBook(Book book){
        if(hasBook(book)){
            return Code.BOOK_ALREADY_CHECKED_OUT_ERROR;
        }else{
            books.add(book);
            return Code.SUCCESS;
        }
    }

    public Code removeBook(Book book){
        if(!hasBook(book)){
            return Code.READER_DOESNT_HAVE_BOOK_ERROR;
        }
        if(books.remove(book)){
            return  Code.SUCCESS;
        }
        return Code.READER_COULD_NOT_REMOVE_BOOK_ERROR;
    }

    public boolean hasBook(Book book){
        return books.contains(book);
    }
    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Reader reader = (Reader) object;
            return cardNumber == reader.cardNumber && Objects.equals(name, reader.name) && Objects.equals(Phone, reader.Phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, name, Phone);
    }
    /**
     * Orders the inputted information into a structure sentence
     * @toString
     */
    @Override
    public String toString() {
        return name +
                "(#" + cardNumber +
                ")" + " has checked out "  +
                books;
    }

    public int getBookCount() {
        return books.size();
    }
}
