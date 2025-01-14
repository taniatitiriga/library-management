import java.util.ArrayList;
import java.util.List;

public class MasterRecord {

    List<BorrowRecord> masterRecord = new ArrayList<BorrowRecord>();

    public void addBRecord(BorrowRecord record) throws DuplicateRecordException, IllegalArgumentException{
        for (BorrowRecord existingBR : masterRecord) {
            if (existingBR.getId() == record.getId()) {
                throw new DuplicateRecordException("Duplicate record... how did this even happen-");
            }
        }
        masterRecord.add(record);
    }
}
