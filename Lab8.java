// ----------------------------
// Rational Number Class
// ----------------------------
package GCDRecursion;

public class RationalNumber {

    // Fields to store the numerator and denominator
    private int numerator;
    private int denominator;

    // Constructor: stores the two positive integers
    public RationalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Public method the driver calls to get the GCD
    public int getGCD() {
        // Use absolute values to ensure recursion works safely
        return gcd(Math.abs(numerator), Math.abs(denominator));
    }

    // ---------------------------------------------------------
    // gcd (Recursive Euclid's Algorithm)
    // Base case: if b is 0, gcd is a
    // Recursive case: gcd(a, b) = gcd(b, a % b)
    // ---------------------------------------------------------
    private int gcd(int a, int b) {
        if (b == 0) {
            return a; // Base case: remainder is 0 → GCD found
        }
        return gcd(b, a % b); // Recursive call
    }
}


// ----------------------------
// Driver Class
// ----------------------------
package GCDRecursion;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input;

        // Main program loop
        while (true) {

            System.out.print("Enter positive integer as numerator (or quit): ");
            input = scan.nextLine();

            // Allow user to exit the program
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Program ended. Goodbye!");
                break;
            }

            int num = 0;
            int den = 0;

            // Validate numerator input
            try {
                num = Integer.parseInt(input);
                if (num <= 0) {
                    System.out.println("ERROR: Numerator must be a positive integer.");
                    continue; // restart loop
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid input. Enter a positive integer.");
                continue; // restart loop
            }

            // Prompt & validate denominator
            System.out.print("Enter positive integer as denominator: ");
            try {
                den = Integer.parseInt(scan.nextLine());
                if (den <= 0) {
                    System.out.println("ERROR: Denominator must be a positive integer greater than zero.");
                    continue; // restart loop
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid input. Enter a positive integer.");
                continue; // restart loop
            }

            // Create RationalNumber object
            RationalNumber rn = new RationalNumber(num, den);

            // Compute GCD using recursion
            int gcd = rn.getGCD();

            // Output the results
            System.out.println("Greatest common denominator of " + num + "/" + den + " is " + gcd);
            System.out.println(); // blank line for readability
        }

        scan.close();
    }
}
