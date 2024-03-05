import java.util.ArrayList;
import java.util.Stack;

public class HospitalHandler {
    private ArrayList<Patient> waitlist;
    private ArrayList<Room> rooms;
    private int numberOfRooms;
    private ArrayList<String> doctors;

    public HospitalHandler(int numberOfRooms){
        this.numberOfRooms = numberOfRooms;
        rooms = new ArrayList<>();
        waitlist = new ArrayList<>();
        doctors = new ArrayList<>();
    }

    public HospitalHandler(int numberOfRooms,ArrayList<Patient> waitlist, ArrayList<String> doctors){
        this.numberOfRooms = numberOfRooms;
        rooms = new ArrayList<>();
        this.waitlist = waitlist;
        this.doctors = doctors;
    }

    public void addPatient(Patient patient){
        waitlist.add(patient);
        sortPatientByPriority();
    }

    public void sortPatientByPriority(){
        for(int i = 0; i < waitlist.size() -1; i++){
                if(waitlist.get(i).getPriority() < waitlist.get(i+1).getPriority()){
                    Patient temp = waitlist.get(i);
                    waitlist.set(i, waitlist.get(i+1));
                    waitlist.set(i+1, temp);
                }
        }
    }

}
