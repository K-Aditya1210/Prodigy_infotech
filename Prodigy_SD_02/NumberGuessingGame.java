import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String args[]) {
        Random rdm = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO THE NUMBER GUESSING GAME!");
        System.out.println("************************************");
        System.out.println("Rules.\n1, guess the number between 1-100");
        System.out.println("2, You have infinite number of attempts to guess the number");

        boolean choice = true;
        while (choice) {

            int RandomNumber = rdm.nextInt(1, 101);
            int attempt = 1;

            while (true) {

                System.out.print("Guess the number : ");
                int guess_number = sc.nextInt();

                if (RandomNumber == guess_number) {
                    System.out.println("Congratulation! you guessed the number " + guess_number + " in " + attempt + " attempts.");
                    break;
                } 
                else if (RandomNumber > guess_number) {
                    System.out.println("Too low");
                } 
                else if (RandomNumber < guess_number) {
                    System.out.println("Too high");
                }
                attempt++;
            }
          
            System.out.println("*************************************");
            System.out.println("do you want to play again (yes/no)");
            String option = sc.next();
            choice = option.equalsIgnoreCase("yes");

        }
        System.out.println("Game Over...");
        sc.close();

    }
}
