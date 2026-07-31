import java.util.Scanner;
public class prime {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scanner.nextInt();
        if (n <= 1) {
            System.out.println("Not a prime number!");
        } 
        else if (n == 2) {
            System.out.println("Prime!");
        } 
        else if (n % 2 == 0) {
            System.out.println("Not a prime number!");
        } 
        else {
            boolean isPrime = true; 
            for (int i = 3; i <= Math.sqrt(n); i += 2) {
                if (n % i == 0) {
                    isPrime = false; 
                    break;           
                }
            }
            if (isPrime) {
                System.out.println("Prime!");
            }
            else {
                System.out.println("Not a prime number!");
            }
        }
        scanner.close();
    }
}
