import java.util.Scanner;
public class Geometry {
    static class Area{
        double pi = 3.14;
        double radius, areac;
        int length, breadth, side, area;
        void Area_calc(int side){
            this.side = side;
            area = side*side;
            System.out.println("Side of Square: "+side);
            System.out.println("Area of Square: "+area+"\n");
        }
        void Area_calc(double radius){
            this.radius = radius;
            areac = pi*radius*radius;
            System.out.println("Radius of Circle: "+radius);
            System.out.println("Area of Circle: "+areac+"\n");
        }
        void Area_calc(int length, int breadth){
            this.length = length;
            this.breadth = breadth;
            area = length*breadth;
            System.out.println("Length of Recatngle: "+length);
            System.out.println("Breadth of Recatngle: "+breadth);
            System.out.println("Area of Rectangle: "+area+"\n");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Area a = new Area();
        int length, breadth, side;
        double radius;
        System.out.print("Enter Length of Rectangle : ");
        length = scanner.nextInt();
        System.out.print("Enter Breadth of Rectangle : ");
        breadth = scanner.nextInt();
        a.Area_calc(length,breadth);
        System.out.print("Enter Side of Square : ");
        side = scanner.nextInt();
        a.Area_calc(side);
        System.out.print("Enter Radius of Circle : ");
        radius = scanner.nextDouble();
        a.Area_calc(radius);
        scanner.close();
    }
}