import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Room class.
 * Uses JUnit 5 to test various functionalities of the Room class.
 */
class RoomTest {

    /**
     * Tests the creation of a Room object with the default constructor.
     * Ensures the room is not in use, is available for visitation, has no assigned doctor, and no patient by default.
     */
    @Test
    void testDefaultRoomCreation() {
        Room room = new Room();

        assertFalse(room.getIsUsed(), "New room should not be in use");
        assertTrue(room.getCanVisit(), "New room should be available for visitation");
        assertEquals("N/A", room.getDoctor(), "New room should have no assigned doctor");
        assertNull(room.getPatient(), "New room should have no patient");
    }

    /**
     * Tests the creation of a Room object with specified parameters including a patient.
     * Verifies that the room reflects the specified usage status, visitation availability, assigned doctor, and patient.
     */
    @Test
    void testParameterizedRoomCreation() {
        Patient patient = new Patient("John Doe", 30, "flu");
        Room room = new Room(true, false, "Dr. Smith", patient);

        assertTrue(room.getIsUsed(), "Room should be in use");
        assertFalse(room.getCanVisit(), "Room should not be available for visitation");
        assertEquals("Dr. Smith", room.getDoctor(), "Assigned doctor should be Dr. Smith");
        assertNotNull(room.getPatient(), "Room should have a patient");
        assertEquals("John Doe", room.getPatient().getName(), "Patient in the room should be John Doe");
    }

    /**
     * Tests the toString method of the Room class.
     * Checks if the method returns a correctly formatted string representing the room's status, including patient information.
     */
    @Test
    void testToStringMethod() {
        Patient patient = new Patient("David", 28, "sprained ankle");
        Room room = new Room(false, true, "Dr. Jones", patient);
        String expectedString = "--------------------------- \n" +
                "Is Used: false\n" +
                "Can Visit: true\n" +
                "Doctor: Dr. Jones\n" +
                "Patient: " + patient.toString() + "\n" +
                "---------------------------";

        assertEquals(expectedString, room.toString(), "toString output does not match expected string");
    }
}
