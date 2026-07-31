import java.util.Scanner;
public class palindrome {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scanner.nextInt();
        int m = n;
        int a = 0;
        int b = 0;
        while(m>0){
            b = m%10;
            a = (a*10)+b;
            m = m/10;
        }
        if(a == n){
            System.out.println("The number is a palindrome!");
        }
        else{

            System.out.println("The number is not a palindrome!");
        }
        scanner.close();
    }
}
