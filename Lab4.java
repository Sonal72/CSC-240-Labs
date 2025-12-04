// ----------------------------
// Policy Class
// ----------------------------
package ccwithPolymorphism;

public abstract class Policy {

    // Common instance variables
    protected String firstName;
    protected String lastName;
    protected double commission;

    // Constructors
    public Policy() { }

    public Policy(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters
    public String getFirstName() {
    	return firstName; 
    }
    public void setFirstName(String firstName) {
    	this.firstName = firstName; 
    }

    public String getLastName() {
    	return lastName; 
    }
    public void setLastName(String lastName) {
    	this.lastName = lastName; 
    }

    public double getCommission() {
    	return commission; 
    }
    public void setCommission(double commission) {
        this.commission = commission;
    }
    
    // Abstract method to be implemented by child classes
    public abstract void computeCommission();
}


// ----------------------------
// Auto Class
// ----------------------------
package ccwithPolymorphism;


public class Auto extends Policy {

    // Auto-specific instance variables
    private String make;
    private String model;
    private double liability;
    private double collision;

    // Default Constructor
    // Creates an empty Auto object
    public Auto() {
        super();   // calls Policy default constructor
    }

    // Full Constructor
    public Auto(String firstName, String lastName,
                String make, String model,
                double liability, double collision) {

        super(firstName, lastName);  // parent constructor

        this.make = make;
        this.model = model;
        this.liability = liability;
        this.collision = collision;
    }

    // Getters and Setters
    public String getMake() { 
    	return make; 
    }
    public void setMake(String make) {
    	this.make = make; 
    }

    public String getModel() {
    	return model; 
    }
    public void setModel(String model) {
    	this.model = model; 
    }

    public double getLiability() {
    	return liability; 
    }
    public void setLiability(double liability) {
    	this.liability = liability;
}

    public double getCollision() {
    	return collision; 
    }
    public void setCollision(double collision) {
    	this.collision = collision; 
    }

    // Computes commission (implementation of abstract method)
    @Override
    public void computeCommission() {
        commission = liability * 0.02 + collision * 0.025;
    }

    // toString Method
    @Override
    public String toString() {
        return "Auto Policy\n-----------" +
               "\nName: " + firstName + " " + lastName +
               "\nMake: " + make +
               "\nModel: " + model +
               String.format("\nLiability: $%,.2f", liability) +
               String.format("\nCollision: $%,.2f", collision) +
               String.format("\nCommission: $%,.2f\n", commission);
    }
}


// ----------------------------
// Home Class
// ----------------------------
package ccwithPolymorphism;

public class Home extends Policy {

    // Home-specific variables
    private int footage;
    private double dwelling;
    private double contents;
    private double liability;

    // Default constructor
    public Home() {
        super();
    }

    // Full constructor
    public Home(String firstName, String lastName, int footage,
                double dwelling, double contents, double liability) {

        super(firstName, lastName);  // send name to Policy constructor

        this.footage = footage;
        this.dwelling = dwelling;
        this.contents = contents;
        this.liability = liability;
    }

    // Getters & Setters
    public int getFootage() {
        return footage;
    }

    public void setFootage(int footage) {
        this.footage = footage;
    }

    public double getDwelling() {
        return dwelling;
    }

    public void setDwelling(double dwelling) {
        this.dwelling = dwelling;
    }

    public double getContents() {
        return contents;
    }

    public void setContents(double contents) {
        this.contents = contents;
    }

    public double getLiability() {
        return liability;
    }

    public void setLiability(double liability) {
        this.liability = liability;
    }

    // Override computeCommission from Policy
    @Override
    public void computeCommission() {
        // Commission formula for Home insurance
        double c = (liability * 0.30) + ((dwelling + contents) * 0.20);
        setCommission(c);   // store in parent class variable
    }

    @Override
    public String toString() {
        return "Home Policy\n-----------" +
               "\nName: " + getFirstName() + " " + getLastName() +
               "\nFootage: " + footage +
               String.format("\nDwelling: $%,.2f", dwelling) +
               String.format("\nContents: $%,.2f", contents) +
               String.format("\nLiability: $%,.2f", liability) +
               String.format("\nCommission: $%,.2f", getCommission()) +
               "\n";
    }
}


// ----------------------------
// Life Class
// ----------------------------
package ccwithPolymorphism;

public class Life extends Policy {

    // Life-specific variables
    private int age;
    private double term;

    // Default constructor
    public Life() {
        super();
    }

    // Full constructor
    public Life(String firstName, String lastName, int age, double term) {
        super(firstName, lastName);   // send name to Policy
        this.age = age;
        this.term = term;
    }

    // Getters and Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getTerm() {
        return term;
    }

    public void setTerm(double term) {
        this.term = term;
    }

    // Override computeCommission from Policy
    @Override
    public void computeCommission() {
        // Life insurance commission formula
        double c = term * 0.20;
        setCommission(c);   // store in parent class variable
    }

    // toString
    @Override
    public String toString() {
        return "Life Policy\n-----------" +
               "\nName: " + getFirstName() + " " + getLastName() +
               "\nAge: " + age +
               String.format("\nTerm: $%,.2f", term) +
               String.format("\nCommission: $%,.2f", getCommission()) +
               "\n";
    }
}


// ----------------------------
// Commission Calculator Class
// ----------------------------
package ccwithPolymorphism;

import java.util.ArrayList;
import java.util.Scanner;

public class CommissionCalculator {

    // ArrayList to store ANY type of policy (Auto, Home, Life)
    private ArrayList<Policy> policies;

    // Constructor
    public CommissionCalculator() {
        policies = new ArrayList<>();
    }

    // Runs the interactive menu
    public void Run() {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("-----------------------------");
            System.out.println("Welcome to Parkland Insurance");
            System.out.println("-----------------------------");
            System.out.println("Enter any of the following:");
            System.out.println("1) Enter auto insurance policy information");
            System.out.println("2) Enter home insurance policy information");
            System.out.println("3) Enter life insurance policy information");
            System.out.println("4) Print all sales entered");
            System.out.println("5) Quit");

            choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {

                // Enter Auto Policy
                case 1: {
                    Auto auto = new Auto();

                    System.out.print("Enter first name of insured: ");
                    auto.setFirstName(input.nextLine());

                    System.out.print("Enter last name of insured: ");
                    auto.setLastName(input.nextLine());

                    System.out.print("Enter make of vehicle: ");
                    auto.setMake(input.nextLine());

                    System.out.print("Enter model of vehicle: ");
                    auto.setModel(input.nextLine());

                    System.out.print("Enter amount of liability: $");
                    auto.setLiability(input.nextDouble());

                    System.out.print("Enter amount of collision: $");
                    auto.setCollision(input.nextDouble());

                    policies.add(auto);
                    break;
                }

                // Enter Home Policy
                case 2: {
                    Home home = new Home();

                    System.out.print("Enter first name of insured: ");
                    home.setFirstName(input.nextLine());

                    System.out.print("Enter last name of insured: ");
                    home.setLastName(input.nextLine());

                    System.out.print("Enter house square footage: ");
                    home.setFootage(input.nextInt());

                    System.out.print("Enter amount of dwelling: $");
                    home.setDwelling(input.nextDouble());

                    System.out.print("Enter amount of contents: $");
                    home.setContents(input.nextDouble());

                    System.out.print("Enter amount of liability: $");
                    home.setLiability(input.nextDouble());

                    policies.add(home);
                    break;
                }

                // Enter Life Policy
                case 3: {
                    Life life = new Life();

                    System.out.print("Enter first name of insured: ");
                    life.setFirstName(input.nextLine());

                    System.out.print("Enter last name of insured: ");
                    life.setLastName(input.nextLine());

                    System.out.print("Enter age of insured: ");
                    life.setAge(input.nextInt());

                    System.out.print("Enter amount of term: $");
                    life.setTerm(input.nextDouble());

                    policies.add(life);
                    break;
                }

                // Print All Policies (Polymorphism!)
                case 4:
                    System.out.println("\n--- All Policies Entered ---");

                    for (Policy policy : policies) {
                        policy.computeCommission();  // polymorphic call
                        System.out.println(policy);  // polymorphic toString
                    }
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;
            }

        } while (choice != 5);

        input.close();
    }
}


// ----------------------------
// Driver Class
// ----------------------------
package ccwithPolymorphism;

public class Driver {
    public static void main(String[] args) {

        // Create commission calculator
        CommissionCalculator calc = new CommissionCalculator();

        // Run commission calculator
        calc.Run();
    }
}
