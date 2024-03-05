import java.util.ArrayList;
import java.util.Stack;

public class HospitalHandler {
    private ArrayList<Patient> waitlist;
    private ArrayList<Room> rooms;
    private ArrayList<String> doctors;

    public HospitalHandler(int numberOfRooms){
        rooms = new ArrayList<>();
        for(int i = 0; i < numberOfRooms; i++){
            rooms.add(new Room());
        }
        waitlist = new ArrayList<>();
        doctors = new ArrayList<>();
    }

    public HospitalHandler(int numberOfRooms, ArrayList<Patient> waitlist, ArrayList<String> doctors){
        this(numberOfRooms);
        this.waitlist = waitlist;
        this.doctors = doctors;
    }

    public void addPatient(Patient patient){
        waitlist.add(patient);
    }

    public void sortPatientByPriority(){
        for(int i = 0; i < waitlist.size()-1; i++){
            for(int j = i+1; j<waitlist.size();j++){
                if(waitlist.get(i).getPriority() < waitlist.get(j).getPriority()){
                    Patient temp = waitlist.get(i);
                    waitlist.set(i, waitlist.get(j));
                    waitlist.set(j, temp);
                }
            }
        }
    }

    public void addPatientToRoom() {
        sortPatientByPriority();
        if (waitlist.isEmpty()) {
            System.out.println("No patient in the wait list");
            return;
        }

        for (Room room : rooms) {
            if (room.getPatient() == null && !waitlist.isEmpty()) {
                room.setPatient(waitlist.remove(0));
            }
        }
    }


    public void addDocToRoom(){
        if (doctors.isEmpty() || rooms.isEmpty()) {
            return;
        }

        int doctorIndex = 0;
        for (Room room : rooms) {
            room.setDoctor(doctors.get(doctorIndex));
            doctorIndex = (doctorIndex + 1) % doctors.size();
        }
    }

}
