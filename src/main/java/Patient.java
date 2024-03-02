
public class Patient {
    private String name; // Represents the patient's name.
    private int age; // Represents the patient's age.
    private int priority; // Indicates the priority level of the patient for medical attention.
    private String injury; // Describes the patient's injury.

    private static final int PRIORITY_HIGH = 3;
    private static final int PRIORITY_MEDIUM = 2;
    private static final int PRIORITY_LOW = 1;



    public Patient(String name, int age, String injury) {
        this.name = name;
        this.age = age;
        this.injury = injury;
        this.priority = autoPriority();
    }

    private enum InjurySeverity {
        CRITICAL, MODERATE, MINOR
    }

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

    private void setPriority(int p) {
        if (p >= PRIORITY_LOW && p <= PRIORITY_HIGH) {
            priority = p;
        } else {
            throw new IllegalArgumentException("Priority must be between " + PRIORITY_LOW + " and " + PRIORITY_HIGH);
        }
    }


    int getPriority(){ return priority;}

    public String getInjury() { return injury; }


    public String getName() { return name;}


    public int getAge() { return age;}

    @Override
    public String toString(){
        return "Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "Injury: " + injury + "\n"
                + "Priority: " + priority + "\n"
                + "-----------------------";
    }
}
