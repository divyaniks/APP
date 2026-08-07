import java.util.Scanner;
public class Bill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] products = new int[5];
        int i,n;
        for(i=0;i<5;i++){
            System.out.println("Enter Product "+(i+1)+"'s price: ");
            products[i] = scanner.nextInt();
        }
        int total = 0;
        for(i=0;i<5;i++){
            total+=products[i];
        }
        System.out.println("Total Bill : "+total);
        if(total>5000){
            System.out.println("Discount Applicable");
        }
        else{
            System.out.println("No Discount");
        }
        scanner.close();
    }
}