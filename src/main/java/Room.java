import java.util.Scanner;

/**
 * This class represents a Room in a hospital or clinic setting.
 * It tracks the room's usage status, visitation availability, assigned doctor, and current patient.
 */
public class Room {
    private boolean isUsed; // Indicates whether the room is currently in use.
    private boolean canVisit; // Indicates whether the room is available for visitation.
    private String doctor; // Stores the name of the doctor assigned to the room.
    private Patient patient; // Stores the patient currently in the room, if any.
    private static final String DEFAULT_DOCTOR = "N/A";

    /**
     * Default constructor initializing a room with default values.
     */
    public Room() {
        this(false, true, DEFAULT_DOCTOR, null);
    }

    /**
     * Constructs a Room with specified parameters.
     *
     * @param used    Indicates if the room is in use.
     * @param visit   Indicates if the room is available for visitation.
     * @param doc     The name of the doctor assigned to the room.
     * @param patient The patient currently in the room.
     */
    public Room(boolean used, boolean visit, String doc, Patient patient) {
        isUsed = used;
        canVisit = visit;
        doctor = (doc != null && !doc.isEmpty()) ? doc : DEFAULT_DOCTOR;
        this.patient = patient;
    }

    /**
     * Admits a patient to the room.
     * Sets the room to used and not available for visitation.
     *
     * @param patient The patient to be admitted.
     * @throws IllegalStateException If the room is already in use.
     */
    public void admitPatient(Patient patient) {
        if (this.isUsed) {
            throw new IllegalStateException("Room is already in use.");
        }
        setPatient(patient);
        setIsUsed(true);
        setCanVisit(false);
    }

    /**
     * Clears the room by taking doctor's notes and resetting room's status.
     * Sets the room to not used and available for visitation.
     */
    public void clearRoom(){
        Scanner in = new Scanner(System.in);
        System.out.println("Doctor notes: ");
        String notes = in.nextLine();
        getPatient().setDocNotes(notes);
        System.out.println(getPatient());
        setPatient(null);
        setIsUsed(true);
        setCanVisit(true);
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }


    public boolean getCanVisit() {
        return canVisit;
    }


    public boolean getIsUsed() {
        return isUsed;
    }


    public String getDoctor() {
        return doctor;
    }


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public void setCanVisit(boolean canVisit) {
        this.canVisit = canVisit;
    }


    @Override
    public String toString() {
        String patientInfo = (patient != null) ? patient.toString() : "No patient";
        String usedStatus = isUsed ? "Yes" : "No";
        String visitStatus = canVisit ? "Yes" : "No";
        return "--------------------------- \n"
                + "Is Used: " + usedStatus + "\n"
                + "Can Visit: " + visitStatus + "\n"
                + "Doctor: " + doctor + "\n"
                + "Patient: " + patientInfo + "\n"
                + "---------------------------";
    }
}

