import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void testUserConstructor(){
        int expectID = 123;
        String expectName = "John";
        String expectEmail = "john@test.com";
        String expectPN = "+40799111222";

        User testUser = new User(expectID, expectName, expectEmail, expectPN);

        assertEquals(expectID, testUser.getId());
        assertEquals(expectName, testUser.getName());
        assertEquals(expectEmail, testUser.getEmail());
        assertEquals(expectPN, testUser.getPhone());
    }

}
