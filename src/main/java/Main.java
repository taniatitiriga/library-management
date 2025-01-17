import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, DuplicateBookException, DuplicateRecordException, UnexpectedInputException {
        // create connection with database
        Connection connection = DBConnection.establishDatabaseConnection();
        Application app = new Application(connection);

        // query data and display it
        Library newLibrary = DBConnection.loadLibrary(connection);
        assert newLibrary != null;
        OutputDevice.print("\nRetrieved library from database:\n");
        newLibrary.printBooks();

        MasterRecord newMasterRecord = DBConnection.loadMasterRecord(connection);
        assert newMasterRecord != null;
        OutputDevice.print("\nRetrieved borrow records from database:\n");
        newMasterRecord.printRecords();

        // update data into the db
        int newStock = 0;

        OutputDevice.print("\nInput the new stock for book:");
        try{
            newStock = Integer.parseInt(InputDevice.getInput());
        } catch(Exception e){
            throw new UnexpectedInputException("Stock number must be an integer");
        }
        if(newStock < 0){
            throw new UnexpectedInputException("Funny user");
        } else {
            DBConnection.updateBookStock(connection, "9780135166307", newStock);
        }

        Library updatedLibrary = DBConnection.loadLibrary(connection);
        assert updatedLibrary != null;
        OutputDevice.print("\nUpdated library from database:\n");
        updatedLibrary.printBooks();
    }
}
