import java.util.Scanner;
public class Employees {
    static class Employee{
        int ID,Salary;
        String name;
        Employee(Scanner scanner){
            System.out.print("Employee ID : ");
            ID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Employee Name : ");
            name = scanner.nextLine() ;
            System.out.print("Salary : ");
            Salary = scanner.nextInt();
        }
        void details(){
            System.out.println("\nEmployee ID : "+ID+"\nEmployee Name : "+name+"\nSalary : "+Salary);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee(scanner);
        employee.details();
        scanner.close();
    }
}