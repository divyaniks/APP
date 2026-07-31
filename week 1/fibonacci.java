import java.util.Scanner;
public class fibonacci {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of values to be displayed: ");
        n = scanner.nextInt();
        System.out.println("\n");
        int a = 0; 
        int b = 1;
        if(n>=1){
            for(int i = 0;i<=n-1;i++){
                System.out.println(a);
                a=b;
                b+=a;
            }
        }
        else{
            System.out.println("Value must be greater than 0");
        }
        scanner.close();
    }
}
