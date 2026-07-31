import java.util.Scanner;
class Temperature{
    float fahrenheit,celsius;
     void temp(float celsius){
        this.celsius = celsius;
        System.out.println("Temperature in Celsius : "+celsius);
        fahrenheit = ((celsius*9)/5)+32;
        System.out.println("Temperature in Fahrenheit : "+fahrenheit);
    }
}
public class weather{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Temperature t = new Temperature();
        float celsius;
        System.out.println("Temperature in Celsius : ");
        celsius = scanner.nextFloat();
        t.temp(celsius);
        scanner.close();
    }
}