import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class HospitalHandlerTest {

    private HospitalHandler hospitalHandler;
    private Patient patient1, patient2, patient3;
    private ArrayList<String> doctors;

    @BeforeEach
    void setUp() {
        hospitalHandler = new HospitalHandler(3);
        patient1 = new Patient("John Doe", 30, "broken arm");
        patient2 = new Patient("Alice Smith", 25, "headache");
        patient3 = new Patient("Bob Johnson", 40, "flu");

        doctors = new ArrayList<>();
        doctors.add("Dr. Smith");
        doctors.add("Dr. Jones");
    }

    @Test
    void testInitialization() {
        assertEquals(3, hospitalHandler.getRooms().size(), "Should have 3 rooms");
    }

    @Test
    void testAddPatientToWaitlist() {
        hospitalHandler.addPatient(patient1);
        assertEquals(1, hospitalHandler.getWaitlist().size(), "Waitlist should have 1 patient");
    }

    @Test
    void testRoomVisitAvailability() {
        hospitalHandler.canVisitRoom(false, 1);
        assertFalse(hospitalHandler.getRooms().get(0).getCanVisit(), "Room 1 should not be available for visitation");
    }

    @Test
    void testSortPatientsByPriority() {
        hospitalHandler.addPatient(patient1); // Priority 3
        hospitalHandler.addPatient(patient2); // Priority 1
        hospitalHandler.addPatient(patient3); // Priority 1
        hospitalHandler.sortPatientByPriority();

        assertEquals(patient1, hospitalHandler.getWaitlist().get(0), "Highest priority patient should be first");
    }

    @Test
    void testAddPatientToRoom() {
        hospitalHandler.addPatient(patient1);
        hospitalHandler.addPatientToRoom();

        assertEquals(patient1, hospitalHandler.getRooms().get(0).getPatient(), "Patient should be added to the first room");
    }

    @Test
    void testFindPatientInRooms() {
        hospitalHandler.addPatient(patient1);
        hospitalHandler.addPatientToRoom();

        int roomNumber = hospitalHandler.findPatient("John Doe");
        assertEquals(1, roomNumber, "Patient John Doe should be in room 1");
    }

    @Test
    void testAddDocToRoom() {
        hospitalHandler.setDoctors(doctors);
        hospitalHandler.addDocToRoom();

        assertEquals("Dr. Smith", hospitalHandler.getRooms().get(0).getDoctor(), "Doctor should be assigned to the first room");
        assertEquals("Dr. Jones", hospitalHandler.getRooms().get(1).getDoctor(), "Doctor should be assigned to the second room");
    }

    @Test
    void testToStringMethod() {
        String output = hospitalHandler.toString();
        assertTrue(output.contains("Room 1"), "Output should contain Room 1 information");
    }
}
