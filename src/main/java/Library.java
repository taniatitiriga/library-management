import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> books = new ArrayList<Book>();

    public Library(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) throws DuplicateBookException,IllegalArgumentException{
        for (Book existingBook : books) {
            if (existingBook.getISBN().equals(book.getISBN())) {
                throw new DuplicateBookException("Book already exists. Try adding stock instead.");
            }
        }
        if(book.getISBN() == null || book.getISBN().trim().isEmpty()) {
            throw new IllegalArgumentException("Book ISBN must be added.");
        }
        books.add(book);
    }
    public void printBooks() {
        for (Book book : books) {
            OutputDevice.print(book.toString());
        }
    }
}
