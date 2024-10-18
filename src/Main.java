import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Random rand = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        System.out.println("Welcome to Craps!");

        do {
            playCraps();
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.nextLine().trim().toLowerCase();
        } while (playAgain.equals("yes"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static void playCraps() {
        int roll = rollDice();
        System.out.println("Initial roll: " + roll);

        if (roll == 2 || roll == 3 || roll == 12) {
            System.out.println("Craps! You crapped out and lost the game.");
        } else if (roll == 7 || roll == 11) {
            System.out.println("Natural! You won the game.");
        } else {
            int point = roll;
            System.out.println("The point is now " + point + ". Rolling for point...");
            boolean continueRolling = true;
            while (continueRolling) {
                roll = rollDice();
                if (roll == 7) {
                    System.out.println("Rolled a seven and lost the game.");
                    continueRolling = false;
                } else if (roll == point) {
                    System.out.println("Made the point " + point + " and won the game!");
                    continueRolling = false;
                }
            }
        }
    }

    private static int rollDice() {
        int die1 = rand.nextInt(6) + 1;
        int die2 = rand.nextInt(6) + 1;
        int sum = die1 + die2;
        System.out.println("Die 1: " + die1 + ", Die 2: " + die2 + ", Sum: " + sum);
        return sum;
    }
}
