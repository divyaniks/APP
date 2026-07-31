import java.util.Scanner;
public class reverse {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scanner.nextInt();
        int a = 0;
        int b = 0;
        while(n>0){
            b = n%10;
            a = (a*10)+b;
            n = n/10;
        }
        System.out.println("Reversed Number: " + a);
        scanner.close();
    }
}
