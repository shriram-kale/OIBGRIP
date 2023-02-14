import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    int range = 100; // change the range according to your preference
    int target = rand.nextInt(range) + 1;
    int guess, attempts = 0;

    System.out.println("I've chosen a number between 1 and " + range + ". Can you guess it?");

    do {
      guess = sc.nextInt();
      attempts++;

      if (guess < target) {
        System.out.println("The number is higher.");
      } else if (guess > target) {
        System.out.println("The number is lower.");
      }
    } while (guess != target);

    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
  }
}
