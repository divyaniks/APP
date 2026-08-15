import java.util.Scanner;
public class Main{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int i,j,m,n;
        System.out.println("Enter the number of rows and columns: ");
        i = scanner.nextInt();
        j = scanner.nextInt();
        int [][]array = new int [i][j]; 
        int [] row_sum = new int [i];
        int [] col_sum = new int [j];
        for(n=0;n<i;n++){
            for(m=0;m<j;m++){
                System.out.println("Enter element at ["+n+"]["+m+"]");
                array[n][m]=scanner.nextInt();
            }
        }
        System.out.print("Sales = {{");
        for(n=0;n<i;n++){
            System.out.print("(");
            for(m=0;m<j;m++){
                System.out.print(array[n][m]+",");
            }
            System.out.print(")");
        }
        System.out.println("}}");

        for(n=0;n<i;n++){
            row_sum[n]=0;
            for(m=0;m<j;m++){
                row_sum[n]+=array[n][m];
            }
        }
        System.out.print("\nRow Sum = (");
        for(n=0;n<i;n++){
            System.out.print(+row_sum[n]+",");
        }
        System.out.print(")");

          for(n=0;n<i;n++){
            for(m=0;m<j;m++){
                col_sum[m] = 0;
                col_sum[m]+=array[m][n];
            }
        }
        System.out.print("\nColumn Sum = (");
        for(m=0;m<i;m++){
            System.out.print(col_sum[m]+",");
        }
        System.out.print(")");
        scanner.close();
    }
}