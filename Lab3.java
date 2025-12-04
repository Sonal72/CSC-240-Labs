// ----------------------------
// Policy Class
// ----------------------------
package ccwithInheritance;

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
package ccwithInheritance;


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
package ccwithInheritance;

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
package ccwithInheritance;

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
// Commission calculator Class
// ----------------------------
package ccwithInheritance;
import java.util.Scanner;

//Menu-driven commission calculator
public class CommissionCalculator {

 private Auto autoPolicy;
 private Home homePolicy;
 private Life lifePolicy;

 // Constructor - creates empty policy objects
 public CommissionCalculator() {
     autoPolicy = new Auto();
     homePolicy = new Home();
     lifePolicy = new Life();
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
         System.out.println("4) Compute commission and print auto policy");
         System.out.println("5) Compute commission and print home policy");
         System.out.println("6) Compute commission and print life policy");
         System.out.println("7) Quit");

         choice = input.nextInt();
         input.nextLine();

         switch (choice) {

             case 1:
                 System.out.print("Enter first name of insured: ");
                 autoPolicy.setFirstName(input.nextLine());

                 System.out.print("Enter last name of insured: ");
                 autoPolicy.setLastName(input.nextLine());

                 System.out.print("Enter make of vehicle: ");
                 autoPolicy.setMake(input.nextLine());

                 System.out.print("Enter model of vehicle: ");
                 autoPolicy.setModel(input.nextLine());

                 System.out.print("Enter amount of liability: $");
                 autoPolicy.setLiability(input.nextDouble());

                 System.out.print("Enter amount of collision: $");
                 autoPolicy.setCollision(input.nextDouble());
                 break;

             case 2:
                 System.out.print("Enter first name of insured: ");
                 homePolicy.setFirstName(input.nextLine());

                 System.out.print("Enter last name of insured: ");
                 homePolicy.setLastName(input.nextLine());

                 System.out.print("Enter house square footage: ");
                 homePolicy.setFootage(input.nextInt());

                 System.out.print("Enter amount of dwelling: $");
                 homePolicy.setDwelling(input.nextDouble());

                 System.out.print("Enter amount of contents: $");
                 homePolicy.setContents(input.nextDouble());

                 System.out.print("Enter amount of liability: $");
                 homePolicy.setLiability(input.nextDouble());
                 break;

             case 3:
                 System.out.print("Enter first name of insured: ");
                 lifePolicy.setFirstName(input.nextLine());

                 System.out.print("Enter last name of insured: ");
                 lifePolicy.setLastName(input.nextLine());

                 System.out.print("Enter age of insured: ");
                 lifePolicy.setAge(input.nextInt());

                 System.out.print("Enter amount of term: $");
                 lifePolicy.setTerm(input.nextDouble());
                 break;

             case 4:
                 autoPolicy.computeCommission();
                 System.out.println(autoPolicy);
                 break;

             case 5:
                 homePolicy.computeCommission();
                 System.out.println(homePolicy);
                 break;

             case 6:
                 lifePolicy.computeCommission();
                 System.out.println(lifePolicy);
                 break;

             case 7:
                 System.out.println("Goodbye!");
                 break;
         }

     } while (choice != 7);
   input.close();
 }
}


// ----------------------------
// Driver Class
// ----------------------------
package ccwithInheritance;

public class Driver {
    public static void main(String[] args) {

        // Create commission calculator
        CommissionCalculator calc = new CommissionCalculator();

        // Run commission calculator
        calc.Run();
    }
}
