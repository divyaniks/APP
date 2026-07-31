import java.util.Scanner;
class Rectangle{
    float length,breadth,area;
     void area(float  length,float breadth){
        this.length = length;
        this.breadth = breadth;
        System.out.println("Length : "+length);
        System.out.println("Breadth : "+breadth);
        area = length*breadth;
        System.out.println("Area of the Rectangle : "+area);
    }
}
public class Area{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rectangle r = new Rectangle();
        float length,breadth;
        System.out.println("Length : ");
        length = scanner.nextFloat();
        System.out.println("Breadth : ");
        breadth = scanner.nextFloat();
        r.area(length,breadth);
        scanner.close();
    }
}