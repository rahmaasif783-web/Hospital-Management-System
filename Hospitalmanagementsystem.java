import java.util.*; 

class Patient {
    private int patientID; 
    private String name; 
    private int age; 
    private String medicalHistory;
    private Doctor assignedDoctor; 

    public Patient(int patientID, String name, int age, String medicalHistory) { 
        this.patientID = patientID; 
        this.name = name; 
        this.age = age; 
        this.medicalHistory = medicalHistory; 
    }

    public int getPatientID() { return patientID; }

    public String getName() { return name; } 

    public void assignDoctor(Doctor doctor) { assignedDoctor = doctor; }

    public Doctor getAssignedDoctor() { return assignedDoctor; } 

    public void display() { 
        System.out.println("Patient ID: " + patientID); 
        System.out.println("Name: " + name);
        System.out.println("Age: " + age); 
        System.out.println("Medical History: " + medicalHistory); 
        if (assignedDoctor != null) System.out.println("Assigned Doctor: " + assignedDoctor.getName()); 
    }
}

abstract class Staff {
    protected int staffID; 
    protected String name; 
    protected String department; 

    public Staff(int staffID, String name, String department) { 
        this.staffID = staffID; 
        this.name = name; 
        this.department = department; 
    }

    public String getName() { return name; }

    public abstract void handleTreatment(); 
}

class Doctor extends Staff {
    private String specialization; 

    public Doctor(int staffID, String name, String department, String specialization) {
        super(staffID, name, department);
        this.specialization = specialization; 
    }


    @Override
    public void handleTreatment() { System.out.println("Doctor treating patient."); } 
}

class Nurse extends Staff {
    public Nurse(int staffID, String name, String department) {
        super(staffID, name, department); 
    }

    @Override
    public void handleTreatment() { System.out.println("Nurse assisting treatment."); } 
}

class Treatment {
    private String treatmentName; 
    private String status; 

    public Treatment(String treatmentName) {
        this.treatmentName = treatmentName; 
        status = "Not Started"; 
    }

    public void startTreatment() { status = "In Progress"; } 

    public void completeTreatment() { status = "Completed"; } 

    public void display() {
        System.out.println("Treatment: " + treatmentName); 
        System.out.println("Status: " + status); 
    }
}

class Appointment {
    private Patient patient; 
    private Doctor doctor; 
    private String date; 

    public Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient; 
        this.doctor = doctor; 
        this.date = date; 
    }

    public void display() {
        System.out.println("Patient: " + patient.getName()); 
        System.out.println("Doctor: " + doctor.getName()); 
        System.out.println("Date: " + date); 
    }
}

class Hospital {
    ArrayList<Patient> patients = new ArrayList<>(); 
    ArrayList<Doctor> doctors = new ArrayList<>(); 
    ArrayList<Appointment> appointments = new ArrayList<>(); 

    public void addPatient(Patient p) { patients.add(p); }

    public void addDoctor(Doctor d) { doctors.add(d); } 

    public Patient findPatient(int id) { 
        for (Patient p : patients) if (p.getPatientID() == id) return p; 
        return null; 
    }

    public Doctor getDoctor(int index) { 
        if (index >= 0 && index < doctors.size()) return doctors.get(index); 
        return null; 
    }

    public void assignDoctor(int patientID, Doctor doctor) {
        Patient p = findPatient(patientID); 
        if (p != null) { p.assignDoctor(doctor); System.out.println("Doctor Assigned Successfully!"); } 
        else System.out.println("Patient Not Found!");
    }

    public void scheduleAppointment(Patient p, Doctor d, String date) { 
        appointments.add(new Appointment(p, d, date));
        System.out.println("Appointment Scheduled!");
    }

    public void showPatients() { for (Patient p : patients) p.display(); } 

    public void showAppointments() { for (Appointment a : appointments) a.display(); } 
}

public class Hospitalmanagementsystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 
        Hospital hospital = new Hospital(); 

        hospital.addDoctor(new Doctor(101, "Dr Ahmed", "Cardiology", "Heart")); 
        hospital.addDoctor(new Doctor(102, "Dr Sara", "Neurology", "Brain")); 

        int choice; 

        do {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM ====="); 
            System.out.println("1. Register Patient"); 
            System.out.println("2. Assign Doctor"); 
            System.out.println("3. Schedule Appointment"); 
            System.out.println("4. View Patients"); 
            System.out.println("5. View Appointments"); 
            System.out.println("0. Exit"); 

            System.out.print("Enter Choice: "); 
            choice = sc.nextInt(); 

            switch (choice) {

                case 1:
                    System.out.print("Patient ID: "); int id = sc.nextInt(); sc.nextLine(); 
                    System.out.print("Patient Name: "); String name = sc.nextLine(); 
                    System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine(); 
                    System.out.print("Medical History: "); String history = sc.nextLine(); 
                    hospital.addPatient(new Patient(id, name, age, history)); 
                    System.out.println("Patient Registered Successfully!"); 
                    break;

                case 2:
                    System.out.print("Enter Patient ID: "); int pid = sc.nextInt(); 
                    System.out.println("1. Dr Ahmed\n2. Dr Sara"); 
                    System.out.print("Select Doctor: "); int doctorChoice = sc.nextInt(); 
                    hospital.assignDoctor(pid, hospital.getDoctor(doctorChoice - 1)); 
                    break;

                case 3:
                    System.out.print("Enter Patient ID: "); int patientID = sc.nextInt(); sc.nextLine(); 
                    Patient patient = hospital.findPatient(patientID); 
                    if (patient != null && patient.getAssignedDoctor() != null) { 
                        System.out.print("Enter Appointment Date: "); String date = sc.nextLine(); 
                        hospital.scheduleAppointment(patient, patient.getAssignedDoctor(), date);
                    } else System.out.println("Assign Doctor First!"); 
                    break;

                case 4: hospital.showPatients(); break; 

                case 5: hospital.showAppointments(); break; 

                case 0: System.out.println("Program Ended."); break; 

                default: System.out.println("Invalid Choice!"); 
            }
        }
 while (choice != 0);

    }
}






