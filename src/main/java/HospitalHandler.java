import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * This class represents a hospital management system.
 * It manages a list of rooms, patients on a waitlist, and doctors.
 */
public class HospitalHandler {
    private ArrayList<Patient> waitlist;
    private ArrayList<Room> rooms;
    private ArrayList<String> doctors;

    /**
     * Constructor to create a hospital handler with a specified number of rooms.
     *
     * @param numberOfRooms The number of rooms to be created in the hospital.
     */
    public HospitalHandler(int numberOfRooms){
        rooms = new ArrayList<>();
        for(int i = 0; i < numberOfRooms; i++){
            rooms.add(new Room());
        }
        waitlist = new ArrayList<>();
        doctors = new ArrayList<>();
    }

    /**
     * Constructor to create a hospital handler with a specific number of rooms, a waitlist of patients, and a list of doctors.
     *
     * @param numberOfRooms The number of rooms to be created in the hospital.
     * @param waitlist      The list of patients waiting to be admitted.
     * @param doctors       The list of doctors in the hospital.
     */
    public HospitalHandler(int numberOfRooms, ArrayList<Patient> waitlist, ArrayList<String> doctors){
        this(numberOfRooms);
        this.waitlist = waitlist;
        this.doctors = doctors;
    }

    /**
     * Adds a patient to the waitlist.
     *
     * @param patient The patient to be added to the waitlist.
     */
    public void addPatient(Patient patient){
        waitlist.add(patient);
    }

    /**
     * Sets whether a specific room can be visited.
     *
     * @param canVisit Indicates if the room can be visited.
     * @param room     The room number to set this property.
     */
    public void canVisitRoom(boolean canVisit, int room) {
        if (room < 1 || room > rooms.size()) {
            System.out.println("Invalid room number.");
            return;
        }
        rooms.get(room - 1).setCanVisit(canVisit);
    }

    /**
     * Sorts patients on the waitlist by priority.
     */
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

    /**
     * Assigns patients from the waitlist to rooms based on priority.
     */
    public void addPatientToRoom() {
        if (waitlist.isEmpty()) {
            System.out.println("No patient in the wait list");
            return;
        }
        sortPatientByPriority();

        for (Room room : rooms) {
            if (room.getPatient() == null && !waitlist.isEmpty()) {
                room.admitPatient(waitlist.removeFirst());
                System.out.println("PATIENT ADDED TO ROOM");
                System.out.println(room.getPatient());
            }
        }
    }

    /**
     * Finds a patient in the rooms by their name.
     *
     * @param name The name of the patient to find.
     * @return The room number where the patient is found, or -1 if not found.
     */
    public int findPatient(String name){
        for(int i = 0; i < rooms.size(); i++){
            if(rooms.get(i).getPatient() != null){
                if(rooms.get(i).getPatient().getName().equalsIgnoreCase(name))
                    return ++i;
            }
        }
        return -1;
    }

    /**
     * Dispatches a patient from a specified room and then tries to fill the room with a new patient from the waitlist.
     */
    public void dispatchPatient(int roomNumebr){
        int roomIndex = roomNumebr - 1;

        if (roomIndex >= 0 && roomIndex < rooms.size()) {
            if (rooms.get(roomIndex) != null) {
                rooms.get(roomIndex).clearRoom();
                System.out.println("Patient Dispatched!");
                addPatientToRoom();
            } else {
                System.out.println("Invalid operation: Room is null.");
            }
        } else {
            System.out.println("Invalid room number.");
        }
    }

    /**
     * Assigns doctors to each room in a round-robin fashion.
     */
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

    public ArrayList<Patient> getWaitlist(){ return waitlist; }
    public ArrayList<Room> getRooms() { return rooms; }
    public Room getSpecificRoom(int roomNumber) { return rooms.get(--roomNumber);}
    public void addRooms() { rooms.add(new Room()); }
    public ArrayList<String> getDoctors() { return doctors; }
    public void setDoctors(ArrayList<String> doc) { doctors = doc; }

    @Override
    public String toString() {
        StringBuilder all = new StringBuilder();
        for (int i = 0; i < rooms.size(); i++) {
            all.append("Room ").append(i + 1).append("\n");
            all.append(rooms.get(i).getPatient());
        }
        return all.toString();
    }

}
