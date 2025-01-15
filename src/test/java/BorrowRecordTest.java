import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BorrowRecordTest {

    @Test
    void testBRConstructor(){
        int expectID = 123;
        int expectUserID = 3210;
        String expectISBN = "978-3-16-148410-0";
        java.sql.Date expectBrDate = Date.valueOf("2025-01-01");
        java.sql.Date expectRDate = Date.valueOf("2025-02-01");
        int returned = 0;

        BorrowRecord testRecord = new BorrowRecord(expectID,expectUserID,expectISBN,expectBrDate,expectRDate,returned);

        assertEquals(expectID, testRecord.getId());
        assertEquals(expectUserID, testRecord.getUserId());
        assertEquals(expectISBN, testRecord.getIsbn());
        assertEquals(expectBrDate, testRecord.getBorrowDate());
        assertEquals(expectRDate, testRecord.getReturnDate());
        assertEquals(returned, testRecord.getReturnedState());
    }

}
