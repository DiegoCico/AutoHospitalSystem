import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    /**
     * Test the initialization of a Room object.
     * This includes checking the default constructor and the constructor with parameters.
     */
    @Test
    void testRoomInitialization() {
        Room defaultRoom = new Room();
        assertEquals("N/A", defaultRoom.getDoctor(), "Default doctor should be N/A");
        assertNull(defaultRoom.getPatient(), "Default patient should be null");
        assertFalse(defaultRoom.getIsUsed(), "Default room should not be in use");

        Patient patient = new Patient("John Doe", 30, "cold");
        Room room = new Room(true, false, "Dr. Smith", patient);
        assertEquals("Dr. Smith", room.getDoctor(), "Doctor should be Dr. Smith");
        assertEquals(patient, room.getPatient(), "Patient should be John Doe");
        assertTrue(room.getIsUsed(), "Room should be in use");
    }

    /**
     * Test admitting a patient into the room.
     * It verifies that the room's status is correctly updated and an exception is thrown if the room is already in use.
     */
    @Test
    void testAdmitPatient() {
        Room room = new Room();
        Patient patient = new Patient("Alice", 25, "flu");

        room.admitPatient(patient);
        assertTrue(room.getIsUsed(), "Room should be in use after admitting a patient");
        assertFalse(room.getCanVisit(), "Room should not be available for visitation after admitting a patient");
        assertEquals(patient, room.getPatient(), "Admitted patient should be Alice");

        assertThrows(IllegalStateException.class, () -> room.admitPatient(new Patient("Bob", 30, "cold")), "Should throw IllegalStateException when admitting a patient to an occupied room");
    }

    /**
     * Test the set and get methods of the Room class.
     * It checks whether the room's properties are correctly updated and retrieved.
     */
    @Test
    void testSetAndGetMethods() {
        Room room = new Room();
        room.setDoctor("Dr. Jones");
        assertEquals("Dr. Jones", room.getDoctor(), "Doctor should be set to Dr. Jones");

        room.setIsUsed(true);
        assertTrue(room.getIsUsed(), "Room should be marked as used");

        room.setCanVisit(false);
        assertFalse(room.getCanVisit(), "Room should not be available for visitation");

        Patient patient = new Patient("Charlie", 28, "headache");
        room.setPatient(patient);
        assertEquals(patient, room.getPatient(), "Patient should be set to Charlie");
    }

    /**
     * Test the toString method of the Room class.
     * It verifies that the method returns the expected string representation of a Room object.
     */
    @Test
    void testToStringMethod() {
        Room room = new Room(false, true, "Dr. Johnson", null);
        String expectedString = "--------------------------- \nIs Used: No\nCan Visit: Yes\nDoctor: Dr. Johnson\nPatient: No patient\n---------------------------";
        assertEquals(expectedString, room.toString(), "toString output does not match expected string");
    }
}
