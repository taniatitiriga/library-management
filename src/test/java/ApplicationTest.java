import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {

    @Test
    void testAppConstructor(){
        Connection expectConn = DBConnection.establishDatabaseConnection();
        Application testApp = new Application(expectConn);
        assertEquals(expectConn,testApp.getConnection());
    }

}
