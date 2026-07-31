import java.util.Scanner;
public class largest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three numbers:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if(a==b){
            if(b==c){
                System.out.println("All are equal");
            }
            else if(c>a){
                System.out.println("Greatest: "+c);
            }
            else{
                System.out.println("Greatest is: "+a);
            }
        }
        else if(b==c){
            if(a==c){
                System.out.println("All are equal");
            }
            else if(c>a){
                System.out.println("Greatest: "+c);
            }
            else{
                System.out.println("Greatest is: "+a);
            }
        }
        else if(a==c){
            if(a==b){
                System.out.println("All are equal");
            }
            else if(c>b){
                System.out.println("Greatest: "+c);
            }
            else{
                System.out.println("Greatest is: "+b);
            }
        }
        else if(a>c){
            if(a>b){
                System.out.println("Greatest is: "+a);
            }
            else{
                System.out.println("Greatest is: "+b);
            }
        }
        else if(b>c){
            if(a>b){
                System.out.println("Greatest is: "+a);
            }
            else{
                System.out.println("Greatest is: "+b);
            }
        }
        else if(c>a){
            if(c>b){
                System.out.println("Greatest is: "+c);
            }
            else{
                System.out.println("Greatest is: "+b);
            }
        }
        scanner.close();
    }
    }
