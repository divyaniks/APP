import java.util.Scanner;
class Marks{
    String name;
    float m1,m2,m3,avg,total;
     void calc_marks(float m1,float m2,float m3){
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        total = (m1+m2+m3);
        avg = (m1+m2+m3)/3;
        System.out.println("Marks in 1st Subject : "+m1);
        System.out.println("Marks in 2nd Subject : "+m2);
        System.out.println("Marks in 3rd Subject : "+m3);
        System.out.println("Total Marks : "+total);
        System.out.println("Average Marks : "+avg);
        System.out.println("\n");
    }
}
public class Exams{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Marks m = new Marks();
        float m1,m2,m3;
        System.out.println("Marks in 1st Subject : ");
        m1 = scanner.nextFloat();
        System.out.println("Marks in 2nd Subject : ");
        m2 = scanner.nextFloat();
        System.out.println("Marks in 3rd Subject : ");
        m3 = scanner.nextFloat();
        System.out.println("\n");
        m.calc_marks(m1,m2,m3);
        scanner.close();
    }
}