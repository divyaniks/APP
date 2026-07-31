import java.util.Scanner;
class Employee{
    String name,dept;
    int age;
    float salary;
     void display(String name, int age,float salary,String dept){
        this.name = name;
        this.age = age;
        this.dept = dept;
        this.salary = salary;
        System.out.println("Employee Name: "+name);
        System.out.println("Employee Age: "+age);
        System.out.println("Employee Salary: "+salary);
        System.out.println("Employee Department: "+dept);
        System.out.println("\n");
    }
}
public class Company {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee e1 = new Employee();
        String name1,name2;
        int age1,age2;
        float salary1,salary2;
        String dept1,dept2;
        System.out.println("Employee Name: ");
        name1 = scanner.nextLine();
        System.out.println("Employee Age: ");
        age1 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Employee Salary: ");
        salary1 = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Employee Department: ");
        dept1 = scanner.nextLine();
        System.out.println("\n");
        e1.display(name1,age1,salary1,dept1);
        Employee e2 = new Employee();
        System.out.println("Employee Name: ");
        name2 = scanner.nextLine();
        System.out.println("Employee Age: ");
        age2 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Employee Salary: ");
        salary2 = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Employee Department: ");
        dept2 = scanner.nextLine();
        System.out.println("\n");
        e1.display(name2,age2,salary2,dept2);
        scanner.close();
    }
}