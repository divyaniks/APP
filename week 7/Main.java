import doctor.Doctor;
import java.util.Scanner;
import patient.Patient;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Doctor[] doctors = new Doctor[2];
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter details for Doctor " + (i + 1) + ":");
            System.out.print("ID: ");
            int docId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: ");
            String docName = scanner.nextLine();
            System.out.print("Specialization: ");
            String spec = scanner.nextLine();
            System.out.print("Consultation Fee: ");
            double fee = scanner.nextDouble();
            doctors[i] = new Doctor(docId, docName, spec, fee);
        }

        Patient[] patients = new Patient[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter details for Patient " + (i + 1) + ":");
            System.out.print("ID: ");
            int patId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: ");
            String patName = scanner.nextLine();
            System.out.print("Disease: ");
            String disease = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            patients[i] = new Patient(patId, patName, disease, age);
        }

        System.out.println("\n=== Processing & Assignments ===");
        for (Patient p : patients) {
            System.out.print("Assign doctor index (0 for " + doctors[0].getName() + ", 1 for " + doctors[1].getName() + ") for " + p.getName() + ": ");
            int docChoice = scanner.nextInt();
            
            if (docChoice >= 0 && docChoice < 2) {
                doctors[docChoice].incrementPatientCount();
                p.displayPatient();
                System.out.print("   ↳ Treated by: ");
                doctors[docChoice].displayDoctor();
            }
            System.out.println();
        }

        System.out.println("=== Financial Summary ===");
        System.out.println(doctors[0].getName() + " total fees collected: $" + doctors[0].calculateTotalFees());
        System.out.println(doctors[1].getName() + " total fees collected: $" + doctors[1].calculateTotalFees());
        
        scanner.close();
    }
}