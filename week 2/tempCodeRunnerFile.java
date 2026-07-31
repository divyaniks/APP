import java.util.Scanner;
class Student{
    String name;
    int rollno;
     void display(String name, int rollno){
        this.name = name;
        this.rollno = rollno;
        System.out.println("Student Name: "+name);
        System.out.println("Student Roll NO.: "+rollno);
    }
}
public class StudentRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student s = new Student();
        String name;
        int rollno;
        System.out.println("Student Name: ");
        name = scanner.nextLine();
        System.out.println("Student Roll NO.: ");
        rollno = scanner.nextInt();
        s.display(name,rollno);
        scanner.close();
    }
}