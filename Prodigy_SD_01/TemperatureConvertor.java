#Task1 
import java.util.Scanner;

public class TemperatureConvertor {
  
    public static void main(String args[]) {
      
        System.out.println("Temperature Convertor.");
        double celsius, fahrenheit, kelvin;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1 for Celsius");
        System.out.println("Enter 2 for Fahrenheit");
        System.out.println("Enter 3 for Kelvin");
      
        System.out.print("Enter your choice : ");
        int choice = sc.nextInt();

        switch (choice) {
            
            case 1:
                System.out.print("Enter Temperature : ");
                celsius = sc.nextDouble();
            
                fahrenheit = (celsius * (9.0 / 5.0) + 32);
                kelvin = celsius + 273.15;
            
                System.out.println("Fahrenheit : "+fahrenheit);
                System.out.println("Kelvin : "+kelvin);
                break;
            
            case 2:
                System.out.print("Enter Temperature : ");
                fahrenheit = sc.nextDouble();
            
                celsius = ((fahrenheit - 32) * (5.0 / 9.0));
                kelvin = ((fahrenheit - 32) * (5.0 / 9.0) + 273.15);
            
                System.out.println("Celsius : "+celsius);
                System.out.println("Kelvin : "+kelvin);
                break;
            
            case 3:
                System.out.print("Enter Temperature : ");
                kelvin = sc.nextDouble();
            
                celsius = kelvin - 273.15;
                fahrenheit = ((kelvin - 273.15) * (9.0 / 5.0) + 32);
            
                System.out.println("celsius : "+celsius);
                System.out.println("Fahrenheit : "+fahrenheit);
                break;
            
            default:
                System.out.println("invalid input...");
        }
      
        sc.close();
    }
}
