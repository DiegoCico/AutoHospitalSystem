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
        String expectedString = "Name: David\nAge: 28\nInjury: sprained ankle\nPriority: 2\n-----------------------";

        // Assert that the toString method returns the expected string
        assertEquals(expectedString, patient.toString(), "toString output does not match expected string");
    }
}
