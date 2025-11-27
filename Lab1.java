// ----------------------------
// Auto Class
// ----------------------------
package insurancePolicies;

public class Auto {
    // Instance variables
    private String firstName;
    private String lastName;
    private String make;
    private String model;
    private double liability;
    private double collision;
    private double commission;

    // Constructor
    public Auto(String firstName, String lastName, String make, String model, double liability, double collision) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.make = make;
        this.model = model;
        this.liability = liability;
        this.collision = collision;
    }

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public double getLiability() { return liability; }
    public void setLiability(double liability) { this.liability = liability; }

    public double getCollision() { return collision; }
    public void setCollision(double collision) { this.collision = collision; }

    public double getCommission() { return commission; }

    // Compute commission
    public void computeCommission() {
        commission = (liability + collision) * 0.30;
    }

    // toString
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
package insurancePolicies;

public class Home {
    // Instance variables
    private String firstName;
    private String lastName;
    private int footage;
    private double dwelling;
    private double contents;
    private double liability;
    private double commission;

    // No-arg constructor
    public Home() { }

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getFootage() { return footage; }
    public void setFootage(int footage) { this.footage = footage; }

    public double getDwelling() { return dwelling; }
    public void setDwelling(double dwelling) { this.dwelling = dwelling; }

    public double getContents() { return contents; }
    public void setContents(double contents) { this.contents = contents; }

    public double getLiability() { return liability; }
    public void setLiability(double liability) { this.liability = liability; }

    public double getCommission() { return commission; }

    // Compute commission
    public void computeCommission() {
        commission = (liability * 0.30) + ((dwelling + contents) * 0.20);
    }

    // toString
    public String toString() {
        return "Home Policy\n-----------" +
               "\nName: " + firstName + " " + lastName +
               "\nFootage: " + footage +
               String.format("\nDwelling: $%,.2f", dwelling) +
               String.format("\nContents: $%,.2f", contents) +
               String.format("\nLiability: $%,.2f", liability) +
               String.format("\nCommission: $%,.2f\n", commission);
    }
}


// ----------------------------
// Life Class
// ----------------------------
package insurancePolicies;

public class Life {
    // Instance variables
    private String firstName;
    private String lastName;
    private int age;
    private double term;
    private double commission;

    // Constructor
    public Life(String firstName, String lastName, int age, double term) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.term = term;
    }

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getTerm() { return term; }
    public void setTerm(double term) { this.term = term; }

    public double getCommission() { return commission; }

    // Compute commission
    public void computeCommission() {
        commission = term * 0.20;
    }

    // toString
    public String toString() {
        return "Life Policy\n-----------" +
               "\nName: " + firstName + " " + lastName +
               "\nAge: " + age +
               String.format("\nTerm: $%,.2f", term) +
               String.format("\nCommission: $%,.2f\n", commission);
    }
}


// ----------------------------
// PolicyTest Driver Class
// ----------------------------
package insurancePolicies;

public class PolicyTest {

    public static void main(String[] args) {

        // Auto policy using constructor
        Auto a = new Auto("Jerry", "Seinfed", "Chevy", "Malibu", 10000.0, 50000.0);

        // Compute and print
        a.computeCommission();
        System.out.println(a);

        // Home policy using setters
        Home h = new Home();
        h.setFirstName("Elaine");
        h.setLastName("Benes");
        h.setContents(5000);
        h.setDwelling(32000);
        h.setFootage(4000);
        h.setLiability(10000);

        // Compute and print
        h.computeCommission();
        System.out.println(h);

        // Life policy using constructor
        Life l = new Life("Cosmo", "Kramer", 35, 50000);

        // Compute and print
        l.computeCommission();
        System.out.println(l);

        // Testing getters
        System.out.println("Get life firstName: " + l.getFirstName());
        System.out.println("Get life lastName: " + l.getLastName());
        System.out.println("Get life age: " + l.getAge());
        System.out.println("Get life term: " + l.getTerm());
    }
}
