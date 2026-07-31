import java.util.Scanner;
class Student{
    String name;
    int rollno;
    String department;
     void display_details(String name, int rollno, String department){
        this.name = name;
        this.rollno = rollno;
        this.department = department;
        System.out.println("Student Name: "+name);
        System.out.println("Student Roll No.: "+rollno);
        System.out.println("Department: "+department);
    }
}
public class College{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student s = new Student();
        String name;
        int rollno;
        String department;
        System.out.println("Student Name: ");
        name = scanner.nextLine();
        System.out.println("Student Roll No.: ");
        rollno = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Department: ");
        department = scanner.nextLine();
        s.display_details(name,rollno,department);
        scanner.close();
    }
}
