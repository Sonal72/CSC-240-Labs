// ----------------------------
// Monetary Class
// ----------------------------
package MonetaryValue;

public class Monetary {

    private double amount;

    public Monetary(double amount) {
        this.amount = amount;
    }

    // Breakdown amount into bills and coins
    public void breakdown() {
        int remainingCents = (int) Math.round(amount * 100);

        int tens = remainingCents / 1000;
        remainingCents %= 1000;

        int fives = remainingCents / 500;
        remainingCents %= 500;

        int ones = remainingCents / 100;
        remainingCents %= 100;

        int quarters = remainingCents / 25;
        remainingCents %= 25;

        int dimes = remainingCents / 10;
        remainingCents %= 10;

        int nickels = remainingCents / 5;
        remainingCents %= 5;

        int pennies = remainingCents;

        // Print with proper singular/plural
        System.out.println(tens + " " + (tens == 1 ? "ten dollar bill" : "ten dollar bills"));
        System.out.println(fives + " " + (fives == 1 ? "five dollar bill" : "five dollar bills"));
        System.out.println(ones + " " + (ones == 1 ? "one dollar bill" : "one dollar bills"));
        System.out.println(quarters + " " + (quarters == 1 ? "quarter" : "quarters"));
        System.out.println(dimes + " " + (dimes == 1 ? "dime" : "dimes"));
        System.out.println(nickels + " " + (nickels == 1 ? "nickel" : "nickels"));
        System.out.println(pennies + " " + (pennies == 1 ? "penny" : "pennies"));
    }
}


// ----------------------------
// Drive Class
// ----------------------------
package MonetaryValue;
import java.util.Scanner;

public class Driver {
 public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     String userInput;

     while (true) {
         System.out.print("Enter a monetary amount (or type 'quit' to exit): ");
         userInput = input.nextLine();

         if (userInput.equalsIgnoreCase("quit")) {
             break;
         }

         try {
             double amount = Double.parseDouble(userInput);
             Monetary money = new Monetary(amount);
             money.breakdown();
         } catch (NumberFormatException e) {
             System.out.println("EXCEPTION: Invalid input");
         }
     }

     input.close();
 }
}
