import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LibAppTests {

    // Test functionalities of the toString() functions
    @Test
    void testBookPrint() {
        Book testbook = new Book("978-3-16-148410-0", "Book Title", "Author", "Publisher Comp", 1990, 10, 8);
        String expectPrint = "Book{isbn='978-3-16-148410-0', title='Book Title', author='Author', publisher='Publisher Comp', publishingYear=1990, totalCopies=10, availableCopies=8}";

        assertEquals(expectPrint, testbook.toString());
    }

    @Test
    void testBRPrint() {
        java.sql.Date testBrDate = Date.valueOf("2025-04-04");
        java.sql.Date testRetDate = Date.valueOf("2025-05-05");
        BorrowRecord testBR = new BorrowRecord(123, 321, "978-3-16-148410-0", testBrDate, testRetDate, 0);
        String expectPrint = "BorrowRecord{id=123, isbn='978-3-16-148410-0', memberId=321, borrowDate=2025-04-04, returnDate=2025-05-05, returned=0}";

        assertEquals(expectPrint, testBR.toString());
    }

}
