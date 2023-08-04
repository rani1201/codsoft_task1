import java.util.Random;
import java.util.Scanner;

public class NumberGuesiingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int rounds = 0;

        do {
            System.out.println("=== Number Guessing Game ===");
            if (playGame(scanner, random)) {
                score++;
            }
            rounds++;

            System.out.println("=== Game Over ===");
            System.out.println("Your score: " + score);
        } while (playAgain(scanner));
    }

    public static boolean playGame(Scanner scanner, Random random) {
        int number = random.nextInt(100) + 1;
        int maxAttempts = 5;
        int attempts = 0;

        while (true) {
            System.out.print("Enter your guess (between 1 and 100): ");
            int guess = scanner.nextInt();

            if (guess == number) {
                System.out.println("Congratulations! You guessed the correct number.");
                return true;
            } else if (guess < number) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }

            attempts++;

            if (attempts == maxAttempts) {
                System.out.println("Oops! You've reached the maximum number of attempts.");
                System.out.println("The correct number was " + number);
                return false;
            }
        }
    }

    public static boolean playAgain(Scanner scanner) {
        while (true) {
            System.out.print("Do you want to play again? (yes/no): ");
            String play = scanner.next();

            if (play.equalsIgnoreCase("yes")) {
                return true;
            } else if (play.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }
}