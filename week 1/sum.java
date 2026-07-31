import java.util.Scanner;
public class sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scanner.nextInt();
        int a = 0;
        int b = 0;
        while(n>0){
            a = n%10;
            b += a;
            n/=10;
        }
        System.out.println("Sum of digits: "+b);
        scanner.close();
    }
}
