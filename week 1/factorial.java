import java.util.Scanner;
public class factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scanner.nextInt();
        int a = n;
        int b = 1;
        while(a>1){
            b*=a;
            a--;
        }
        System.out.println("Factorial of "+n+" is: "+b);
        scanner.close();
    }
}
