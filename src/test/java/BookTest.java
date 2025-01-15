import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

    @Test
    void testBookConstructor(){
        String expectISBN = "978-3-16-148410-0";
        String expectTitle = "Book Title";
        String expectAuthor = "Author";
        String expectPublisher = "Publisher Comp";
        int expectPublishingYear = 1990;
        int expectTCop = 10;
        int expectACop = 8;

        Book testbook = new Book(expectISBN, expectTitle, expectAuthor, expectPublisher, expectPublishingYear, expectTCop, expectACop);

        assertEquals(expectISBN, testbook.getISBN());
        assertEquals(expectTitle, testbook.getTitle());
        assertEquals(expectAuthor, testbook.getAuthor());
        assertEquals(expectPublisher, testbook.getPublisher());
        assertEquals(expectPublishingYear, testbook.getPublishingYear());
        assertEquals(expectTCop, testbook.getTotalCopies());
        assertEquals(expectACop, testbook.getAvailableCopies());
    }

}
