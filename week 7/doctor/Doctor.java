package doctor;

public class Doctor {
    private int doctorId;
    private String name;
    private String specialization;
    private double consultationFee;
    private int patientCount;

    public Doctor(int doctorId, String name, String specialization, double consultationFee) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.patientCount = 0;
    }

    public int getDoctorId() { return doctorId; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public double getConsultationFee() { return consultationFee; }
    
    public void incrementPatientCount() {
        this.patientCount++;
    }

    public double calculateTotalFees() {
        return this.patientCount * this.consultationFee;
    }

    public void displayDoctor() {
        System.out.println("Doctor [ID: " + doctorId + ", Name: " + name + 
                           ", Specialization: " + specialization + ", Fee: $" + consultationFee + "]");
    }
}