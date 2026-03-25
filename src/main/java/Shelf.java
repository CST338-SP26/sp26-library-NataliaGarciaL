import Utilities.Code;

import java.util.HashMap;
import java.util.Objects;

public class Shelf {
    public static final int SHELF_NUMBER_=0;
    public static final int SUBJECT_=1;
    private HashMap<Book, Integer> books;
    private int ShelfNumber;
    private String subject;

    public Shelf(){
        books=new HashMap<>();
    }
    public Shelf(int shelfNumber, String subject) {
        this();
        ShelfNumber = shelfNumber;
        this.subject = subject;

    }

    public int getBookCount(Book book){
        if(!books.containsKey(book)){
            return -1;
        }
        return books.get(book);
    }

    public Code addBook(Book book){
        int count= getBookCount(book);
        if(books.containsKey(book)){
            books.put(book,count+1);
            return Code.SUCCESS;
        }else{
            if(book.getSubject().equals(this.subject)){
                books.put(book,1);
                System.out.println(books.toString() + " added to shelf "+ this.toString());
                return Code.SUCCESS;
            }else{
                return Code.SHELF_SUBJECT_MISMATCH_ERROR;
            }
        }
    }
    public Code removeBook(Book book){
        int count= getBookCount(book);
        if(!books.containsKey(book)){
            System.out.println(books.toString()+ " is not on shelf "+ this.toString());
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        }else{
            if(count==0){
                System.out.println("No copies of "+books.toString()+" remain on shelf "+this.toString());
                return Code.BOOK_NOT_IN_INVENTORY_ERROR;
            } else {
                books.put(book,count-1);
                System.out.println(books.toString()+ " successfully removed from shelf "+ this.toString());
                return Code.SUCCESS;
            }
        }
    }

    public String listBooks(){
        String check="";
        int total =0;
        for(Integer i: books.values()){
            total+=i;
        }
        if(total==1){
            check+="1 book on shelf: " + getShelfNumber()+ " : "+getSubject();
        }else{
            check+=books.size() + " books on shelf: "+getShelfNumber()+ " : "+getSubject();
        }

        return check;
    }

    public HashMap<Book, Integer> getBooks() {
        return books;
    }

    public void setBooks(HashMap<Book, Integer> books) {
        this.books = books;
    }

    public int getShelfNumber() {
        return ShelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        ShelfNumber = shelfNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Shelf shelf = (Shelf) object;
        return ShelfNumber == shelf.ShelfNumber && Objects.equals(subject, shelf.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ShelfNumber, subject);
    }

    @Override
    public String toString() {
        return ShelfNumber +
                " : "  +
                 subject ;
    }
}
