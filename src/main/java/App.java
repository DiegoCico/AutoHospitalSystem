import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int UI;
        System.out.println("How many hospital room do you have");
        int roomNumber = in.nextInt();
        HospitalHandler hh = new HospitalHandler(roomNumber);

        do {
            optionsTable();
            UI = in.nextInt();
            switch (UI){
                case 1:
                    System.out.println("Name");
                    String name = in.nextLine();
                    System.out.println("Age");
                    int age = in.nextInt();
                    System.out.println("Injury");
                    String injury = in.nextLine();
                    Patient patient = new Patient(name, age, injury);
                    hh.addPatient(patient);
                    break;
                case 2:
                    System.out.println("Patient Room");
                    roomNumber = in.nextInt();
                    hh.dispatchPatient(roomNumber);
                    break;
                case 3:
                    System.out.println("Find of Patient");
                    String patientName = in.nextLine();
                    System.out.println("Room: " + hh.findPatient(patientName));
                    hh.getSpecificRoom(hh.findPatient(patientName));
                    break;
                case 7:
                    hh.toString();
                    break;
                case 8:
                    System.out.println("Type the doctor name and click enter, once done type DONE. REMINDER: everything should be one word");
                    ArrayList<String> doctors = new ArrayList<>();
                    while (true) {
                        System.out.print("Enter doctor's name: ");
                        String docName = in.next();
                        if (docName.equalsIgnoreCase("DONE")) {
                            break;
                        }
                        doctors.add(docName);
                    }
                    hh.setDoctors(doctors);
                    break;
                case 9:
                    hh.addRooms();
                    System.out.println("Room Added");
                    break;
                case 0:
                    hh.addPatientToRoom();
                    System.out.println("Hospital Open, Patients in Rooms");
                    break;
                case -1:
                    in.close();
                default:
                    System.out.println("Please select correct option");
                    break;

            }
        } while (UI != -1);
    }

    public static void optionsTable(){
        System.out.println("1. Add Patient");
        System.out.println("2. Dispatch Patient");
        System.out.println("3. Can Visit");
        System.out.println("7. Show All Rooms");
        System.out.println("8. Add/Change Doctors");
        System.out.println("9. Add Room");
        System.out.println("0. Open Hospital");
        System.out.println("-1. Close Hospital");
    }
}
