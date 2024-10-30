package lambda;

import java.util.Scanner;

public class InputChecker {
    static Scanner scanner = new Scanner(System.in);

    public static boolean isEmpty() {
        return !scanner.hasNext();
    }

    public static void main(String[] args) {
        System.out.println("Enter some input (or press Enter to skip):");

        if (isEmpty()) {
            System.out.println("No input provided.");
        } else {
            String input = scanner.nextLine();
            System.out.println("You entered: " + input);
        }

        scanner.close(); // Always close the scanner when done
    }
}
