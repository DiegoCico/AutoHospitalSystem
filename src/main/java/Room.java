/**
 * Represents a room within a healthcare facility, encapsulating its current usage status,
 * availability for visitation, the assigned doctor, and a patient if present. This class provides
 * a structured way to manage and track room allocations and their current state in a medical environment.
 */
public class Room {
    private boolean isUsed; // Indicates whether the room is currently in use.
    private boolean canVisit; // Indicates whether the room is available for visitation.
    private String doctor; // Stores the name of the doctor assigned to the room.
    private Patient patient; // Stores the patient currently in the room, if any.

    /**
     * Constructs a new Room instance with default settings.
     * Initially, the room is not in use, is available for visitation, has no assigned doctor, and no patient.
     */
    public Room() {
        isUsed = false;
        canVisit = true;
        doctor = "N/A";
        patient = null;
    }

    /**
     * Constructs a new Room instance with specified usage status, visitation availability, doctor, and patient.
     *
     * @param used    Specifies whether the room is currently in use.
     * @param visit   Specifies whether the room is available for visitation.
     * @param doc     The name of the doctor assigned to the room.
     * @param patient The patient assigned to the room.
     */
    public Room(boolean used, boolean visit, String doc, Patient patient) {
        isUsed = used;
        canVisit = visit;
        doctor = doc;
        this.patient = patient;
    }

    /**
     * Returns whether the room is available for visitation.
     *
     * @return {@code true} if the room is available for visitation, {@code false} otherwise.
     */
    public boolean getCanVisit() { return canVisit; }

    /**
     * Returns whether the room is currently in use.
     *
     * @return {@code true} if the room is in use, {@code false} otherwise.
     */
    public boolean getIsUsed() { return isUsed; }

    /**
     * Returns the name of the doctor assigned to the room.
     *
     * @return The name of the doctor.
     */
    public String getDoctor() { return doctor; }

    /**
     * Returns the patient currently in the room.
     *
     * @return The patient in the room, or null if no patient is present.
     */
    public Patient getPatient() { return patient; }

    /**
     * Sets or updates the patient in the room.
     *
     * @param patient The patient to be placed in the room.
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Provides a formatted string representation of the room's status, including whether it's in use,
     * available for visitation, the assigned doctor's name, and the patient's information if present.
     * Useful for display in a medical information system.
     *
     * @return A formatted string containing the room's status information.
     */
    @Override
    public String toString() {
        String patientInfo = (patient != null) ? patient.toString() : "No patient";
        return "--------------------------- \n"
                + "Is Used: " + isUsed + "\n"
                + "Can Visit: " + canVisit + "\n"
                + "Doctor: " + doctor + "\n"
                + "Patient: " + patientInfo + "\n"
                + "---------------------------";
    }
}
