/**
 * Represents a patient in a medical context, encapsulating details such as the patient's name,
 * age, the nature of their injury, and an associated priority level for treatment. The priority
 * level is determined automatically based on the severity and type of injury, adhering to pre-defined
 * criteria. This class provides a structured way to manage patient data in a healthcare setting.
 */
public class Patient {
    private String name; // Represents the patient's name.
    private int age; // Represents the patient's age.
    private int priority; // Indicates the priority level of the patient for medical attention.
    private String injury; // Describes the patient's injury.

    /**
     * Constructs a new Patient instance with specified name, age, and injury.
     * Automatically assigns a priority level based on the provided injury description.
     *
     * @param n The full name of the patient.
     * @param a The age of the patient in years.
     * @param i A descriptive string detailing the patient's injury.
     */
    public Patient(String n, int a, String i){
        name = n;
        age = a;
        injury = i;
        priority = autoPriority();
    }

    /**
     * Determines the priority level for medical attention based on the injury description.
     * Priority levels are assigned as follows:
     * 3 for critical conditions (e.g., broken bones, pregnancy complications, stab wounds),
     * 2 for moderate conditions (e.g., cuts, burns, bleeding),
     * 1 for less severe conditions.
     *
     * @return An integer value representing the assigned priority level.
     */
    private int autoPriority() {
        if(injury.contains("broken") ||
            injury.contains("pregnant") ||
            injury.contains("stab"))
                return 3;
        else if(injury.contains("cut") ||
                injury.contains("burnt") ||
                injury.contains("bleeding") ||
                injury.contains("sprained"))
                    return 2;
        else
            return 1;
    }

    /**
     * Sets the patient's priority level. If the specified priority is outside the range of 1 to 3,
     * it defaults to 1. This method ensures that the priority level remains within the valid range.
     *
     * @param p The desired priority level (between 1 and 3).
     */
    private void setPriority(int p) {
        if(p >= 1 && p <= 3)
            priority = p;
        else {
            System.out.println("Not valid priority setting it to 1");
            priority = 1;
        }
    }

    /**
     * Retrieves the current priority level of the patient.
     *
     * @return The patient's priority level as an integer.
     */
    int getPriority(){ return priority;}

    /**
     * Retrieves a description of the patient's injury.
     *
     * @return A string describing the patient's injury.
     */
    public String getInjury() { return injury; }

    /**
     * Retrieves a description of the patient's name.
     *
     * @return A string describing the patient's name.
     */
    public String getName() { return name;}

    /**
     * Retrieves a description of the patient's age.
     *
     * @return A string describing the patient's age.
     */
    public int getAge() { return age;}

    /**
     * Provides a formatted string representation of the patient's details including
     * name, age, injury description, and priority level. This representation is useful
     * for logging and display purposes in a medical information system.
     *
     * @return A formatted string containing the patient's information.
     */
    @Override
    public String toString(){
        return "Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "Injury: " + injury + "\n"
                + "Priority: " + priority + "\n"
                + "-----------------------";
    }
}
