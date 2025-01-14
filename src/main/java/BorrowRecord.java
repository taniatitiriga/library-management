public class BorrowRecord {
    private int id;
    private String isbn; // ISBN
    private int userId;
    private java.sql.Date borrowDate;
    private java.sql.Date returnDate;
    private int returned;

    public BorrowRecord(int id, int userId,  String isbn, java.sql.Date borrowDate, java.sql.Date returnDate, int returned) {
        this.id = id;
        this.isbn = isbn;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.returned = returned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int memberId) {
        this.userId = memberId;
    }

    public java.sql.Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(java.sql.Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public java.sql.Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(java.sql.Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getReturnedState() {
        return returned;
    }

    public void setReturnedState(int returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "BorrowRecord{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", memberId=" + userId +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", returned=" + returned +
                '}';
    }
}
