import java.util.Scanner;
class Student{
    String name;
    int age;
     void display(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("Student Name: "+name);
        System.out.println("Student Age: "+age);
        System.out.println("\n");
    }
}
public class School{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student s1 = new Student();
        String name1,name2;
        int age1,age2;
        System.out.println("Student Name: ");
        name1 = scanner.nextLine();
        System.out.println("Student Age: ");
        age1 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("\n");
        s1.display(name1,age1);
        Student s2 = new Student();
        System.out.println("Student Name: ");
        name2 = scanner.nextLine();
        System.out.println("Student Age: ");
        age2 = scanner.nextInt();
        System.out.println("\n");
        s2.display(name2,age2);
        scanner.close();
    }
}