import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, DuplicateBookException, DuplicateRecordException {
        Connection connection = DBConnection.establishDatabaseConnection();
        Application app = new Application(connection);
        DBConnection.updateBookStock(connection, "9780135166307", 6);
        DBConnection.loadLibrary(connection);
        DBConnection.loadMasterRecord(connection);
    }
}
