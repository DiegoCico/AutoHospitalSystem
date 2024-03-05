/**
 * The Patient class represents a patient in a medical context.
 * It stores the patient's name, age, injury description, and priority level for medical attention.
 * The priority level is automatically determined based on the injury description.
 */
public class Patient {
    private String name; // Represents the patient's name.
    private int age; // Represents the patient's age.
    private int priority; // Indicates the priority level of the patient for medical attention.
    private String injury; // Describes the patient's injury.
    private String docNotes; // Stores the doctor's notes for the patient.

    private static final int PRIORITY_HIGH = 3;
    private static final int PRIORITY_MEDIUM = 2;
    private static final int PRIORITY_LOW = 1;

    /**
     * Constructs a new Patient with the specified name, age, and injury.
     * The priority level is automatically set based on the injury.
     *
     * @param name   the name of the patient
     * @param age    the age of the patient
     * @param injury the description of the patient's injury
     */
    public Patient(String name, int age, String injury) {
        this.name = name;
        this.age = age;
        this.injury = injury;
        this.priority = autoPriority();
        this.docNotes = "N/A";
    }

    // InjurySeverity is an internal enum used to categorize injury severity.
    private enum InjurySeverity {
        CRITICAL, MODERATE, MINOR
    }

    // Auto-calculates the priority based on the injury severity.
    private int autoPriority() {
        InjurySeverity injurySeverity = categorizeInjury();

        switch (injurySeverity) {
            case CRITICAL:
                return PRIORITY_HIGH;
            case MODERATE:
                return PRIORITY_MEDIUM;
            case MINOR:
            default:
                return PRIORITY_LOW;
        }
    }

    // Categorizes the injury into a severity level.
    private InjurySeverity categorizeInjury() {
        if (injury.contains("broken") || injury.contains("pregnant") || injury.contains("stab") ||
                injury.contains("gunshot") || injury.contains("concussion") || injury.contains("heart attack")) {
            return InjurySeverity.CRITICAL;
        } else if (injury.contains("cut") || injury.contains("burnt") || injury.contains("bleeding") ||
                injury.contains("sprained") || injury.contains("fracture") || injury.contains("dislocation") ||
                injury.contains("deep wound") || injury.contains("severe allergy")) {
            return InjurySeverity.MODERATE;
        } else{
            return InjurySeverity.MINOR;
        }
    }

    /**
     * Sets the priority level of the patient.
     * The priority must be between PRIORITY_LOW and PRIORITY_HIGH.
     *
     * @param p the new priority level
     * @throws IllegalArgumentException if the priority is not in the valid range
     */
    public void setPriority(int p) {
        if (p >= PRIORITY_LOW && p <= PRIORITY_HIGH) {
            priority = p;
        } else {
            throw new IllegalArgumentException("Priority must be between " + PRIORITY_LOW + " and " + PRIORITY_HIGH);
        }
    }

    /**
     * Returns the priority level of the patient.
     *
     * @return the priority level
     */
    public int getPriority(){ return priority;}

    /**
     * Returns the injury description of the patient.
     *
     * @return the injury description
     */
    public String getInjury() { return injury; }

    /**
     * Returns the name of the patient.
     *
     * @return the name of the patient
     */
    public String getName() { return name;}

    /**
     * Returns the age of the patient.
     *
     * @return the age of the patient
     */
    public int getAge() { return age;}

    /**
     * Sets the doctor's notes for this patient.
     *
     * @param notes the doctor's notes to be set
     */
    public void setDocNotes(String notes){ docNotes = notes;}

    /**
     * Returns the doctor's notes for this patient.
     *
     * @return the doctor's notes
     */
    public String getDocNotes() { return docNotes;}

    /**
     * Returns a string representation of the patient, including their name, age, injury, and priority.
     *
     * @return a string representation of the patient
     */
    @Override
    public String toString(){
        return  "-----------------------" + "\n"
                + "Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "Injury: " + injury + "\n"
                + "Priority: " + priority + "\n"
                + "Doctor Notes: " + docNotes + "\n"
                + "-----------------------";
    }
}
