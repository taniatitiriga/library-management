import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {

    @Test
    void testLibConstructor() throws DuplicateBookException {
        Book testbook = new Book("978-3-16-148410-0", "Book Title", "Author", "Publisher Comp", 1990, 10, 8);


        Library testlibrary = new Library(new LinkedList<>());

        testlibrary.addBook(testbook);

    }

}
