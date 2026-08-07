import java.util.Scanner;
public class Eligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] total_days = new int[7];
        int pres=0,i;
        for(i=0;i<7;i++){
            System.out.println("Enter the attendance for Day "+(i+1)+" : ");
            total_days[i]=scanner.nextInt();
        }
        for(i=0;i<7;i++){
            if(total_days[i]==1){
                pres+=1;
            }
        }
        double perc = ((double)pres*100)/7;
        if(perc>=75){
            System.out.println("Eligible for Exam");
        }
        else{
            System.out.println("Not Eligible");
        }
        scanner.close();
    }
}