import java.sql.*;
import java.util.LinkedList;

public class DBConnection {
    public static Connection establishDatabaseConnection() {
        Connection connection = null;
        try {
            // database connection parameters
            String jdbcUrl = "jdbc:mysql://localhost:3308/library_management";
            String dbUsername = "root";
            String dbPassword = "root_password";

            connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to connect to the database!");
        }
        return connection;
    }
    public static Library loadLibrary(Connection connection) throws SQLException, DuplicateBookException {
        String selectSQL = "SELECT * FROM Books";
        Library library = new Library(new LinkedList<>());

        if (connection == null) {
            System.err.println("DB not available");
            return null;
        }

        Statement statement = connection.createStatement();
        ResultSet resultSetBooks = statement.executeQuery(selectSQL);

        while (resultSetBooks.next()) {
            String bookISBN = resultSetBooks.getString("isbn");
            String bookTitle = resultSetBooks.getString("title");
            String bookAuth = resultSetBooks.getString("author");
            String bookPublisher = resultSetBooks.getString("publisher");
            int bookPublishingYear = Integer.parseInt(String.valueOf(resultSetBooks.getDate("publishing_year")).substring(0, 4));
            int bookTotalCopies = resultSetBooks.getInt("total_copies");
            int bookAvailableCopies = resultSetBooks.getInt("available_copies");

            Book book = new Book(bookISBN, bookTitle, bookAuth, bookPublisher, bookPublishingYear, bookTotalCopies, bookAvailableCopies);
            //OutputDevice.print(book.toString());
            library.addBook(book);
        }
        return library;
    }

    public static void updateBookStock(Connection connection, String isbn, int new_stock) throws SQLException, DuplicateBookException {
        if (connection == null) {
            System.err.println("Database connection is not available.");
            return;
        }

        try{
            String updateSQL = "UPDATE Books SET total_copies = ? WHERE isbn = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setInt(1, new_stock);
            preparedStatement.setString(2, isbn);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Stock updated successfully!");
            } else {
                System.err.println("Book not found or update failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error updating stock in DB.");
        }
    }

    public static MasterRecord loadMasterRecord(Connection connection) throws SQLException, DuplicateRecordException {
        String selectSQL = "SELECT * FROM BorrowingRecords";
        MasterRecord masterRec = new MasterRecord(new LinkedList<>());

        if (connection == null) {
            System.err.println("DB not available");
            return null;
        }

        Statement statement = connection.createStatement();
        ResultSet resultSetBRs = statement.executeQuery(selectSQL);

        while (resultSetBRs.next()) {
            int recordId = resultSetBRs.getInt("record_id");
            int userId = resultSetBRs.getInt("user_id");
            String isbn = resultSetBRs.getString("isbn");
            java.sql.Date borrowDate = resultSetBRs.getDate("borrow_date");
            java.sql.Date returnDate = resultSetBRs.getDate("return_date");
            int returned = resultSetBRs.getInt("returned");

            BorrowRecord borrowRecord = new BorrowRecord(recordId, userId, isbn, borrowDate, returnDate, returned);
            //OutputDevice.print(borrowRecord.toString());
            masterRec.addBRecord(borrowRecord);
        }
        return masterRec;
    }

}