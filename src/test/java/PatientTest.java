import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Patient class.
 * Uses JUnit 5 for testing various functionalities of the Patient class.
 */
class PatientTest {

    /**
     * Tests the creation of a Patient object.
     * Ensures that the constructor correctly assigns the name, age, and injury.
     */
    @Test
    void testPatientCreation() {
        // Create a new Patient object
        Patient patient = new Patient("John Doe", 30, "cut");

        // Assert that the name is correctly assigned
        assertEquals("John Doe", patient.getName(), "Name should be John Doe");

        // Assert that the age is correctly assigned
        assertEquals(30, patient.getAge(), "Age should be 30");

        // Assert that the injury is correctly assigned
        assertEquals("cut", patient.getInjury(), "Injury should be cut");
    }

    /**
     * Tests the automatic priority assignment based on the injury description.
     * Verifies that the priority is set correctly for different types of injuries.
     */
    @Test
    void testPriorityAssignment() {
        // Assert that a severe injury results in priority 3
        assertEquals(3, new Patient("Alice", 25, "broken arm").getPriority(), "Priority should be 3 for severe injury");

        // Assert that a moderate injury results in priority 2
        assertEquals(2, new Patient("Bob", 40, "burnt hand").getPriority(), "Priority should be 2 for moderate injury");

        // Assert that a mild injury results in priority 1
        assertEquals(1, new Patient("Charlie", 35, "headache").getPriority(), "Priority should be 1 for mild injury");
    }

    /**
     * Tests the toString method of the Patient class.
     * Checks if the method returns a correctly formatted string representing the patient's details.
     */
    @Test
    void testToStringMethod() {
        // Create a new Patient object
        Patient patient = new Patient("David", 28, "sprained ankle");

        // Expected string representation of the patient
        String expectedString = "-----------------------\nName: David\nAge: 28\nInjury: sprained ankle\nPriority: 2\nDoctor Notes: N/A\n-----------------------";

        // Assert that the toString method returns the expected string
        assertEquals(expectedString, patient.toString(), "toString output does not match expected string");
    }

    /**
     * Tests the functionality of setting and getting doctor's notes for a Patient.
     * Ensures that the notes set by the setDocNotes method are correctly retrieved.
     */
    @Test
    void testSetAndGetDocNotes() {
        Patient patient = new Patient("Emily", 22, "flu");
        patient.setDocNotes("Regular checkup needed");
        assertEquals("Regular checkup needed", patient.getDocNotes(), "Doctor's notes should match the input");
    }

    /**
     * Tests the exception handling for setting an invalid priority value for a Patient.
     * Ensures that setting a priority outside the valid range throws an IllegalArgumentException.
     */
    @Test
    void testPriorityExceptionHandling() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Patient("Fred", 45, "cold").setPriority(4);
        });
        String expectedMessage = "Priority must be between 1 and 3";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Tests priority assignment for various types of injuries.
     * Ensures that different injuries are assigned the correct priority.
     */
    @Test
    void testVariousInjuriesAndPriorities() {
        assertEquals(3, new Patient("George", 30, "heart attack").getPriority(), "Heart attack should be priority 3");
        assertEquals(2, new Patient("Hannah", 27, "deep wound").getPriority(), "Deep wound should be priority 2");
        assertEquals(1, new Patient("Ian", 50, "common cold").getPriority(), "Common cold should be priority 1");
    }

    /**
     * Tests if the Patient class correctly handles edge cases for patient ages.
     * Ensures the age is correctly assigned for very young and very old patients.
     */
    @Test
    void testPatientAgeEdgeCases() {
        assertEquals(1, new Patient("Baby", 1, "cough").getAge(), "Age should handle very young ages");
        assertEquals(100, new Patient("Centenarian", 100, "fatigue").getAge(), "Age should handle very old ages");
    }

    /**
     * Tests if the Patient class correctly handles edge cases for patient names.
     * Ensures the name is correctly assigned for names with special characters and very long names.
     */
    @Test
    void testPatientNameEdgeCases() {
        assertEquals("A-very-very-very-long-name", new Patient("A-very-very-very-long-name", 30, "sprain").getName(), "Should handle very long names");
        assertEquals("N@m3$W1th$pec!al", new Patient("N@m3$W1th$pec!al", 30, "sprain").getName(), "Should handle names with special characters");
    }
}
