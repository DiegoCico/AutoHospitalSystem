
public class Room {
    private boolean isUsed; // Indicates whether the room is currently in use.
    private boolean canVisit; // Indicates whether the room is available for visitation.
    private String doctor; // Stores the name of the doctor assigned to the room.
    private Patient patient; // Stores the patient currently in the room, if any.
    private static final String DEFAULT_DOCTOR = "N/A";


    public Room() {
        this(false, true, DEFAULT_DOCTOR, null);
    }

    public Room(boolean used, boolean visit, String doc, Patient patient) {
        isUsed = used;
        canVisit = visit;
        doctor = (doc != null && !doc.isEmpty()) ? doc : DEFAULT_DOCTOR;
        this.patient = patient; // Assuming it's okay to have a null patient
    }

    public void admitPatient(Patient patient, String doctor) {
        if (this.isUsed) {
            throw new IllegalStateException("Room is already in use.");
        }
        setPatient(patient);
        setDoctor(doctor);
        setIsUsed(true);
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

