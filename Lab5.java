// ----------------------------
// Priority Interface
// ----------------------------
package PriorityTaskList;

public interface Priority {

    // Sets the priority of the object (1–5)
    void setPriority(int priority);

    // Returns the current priority
    int getPriority();
}


// -------------------------------
// Task Class implements Priority
// -------------------------------
package PriorityTaskList;

public class Task implements Priority {

    // Instance variables
    private String task;     // Description of the task
    private int priority;    // Task priority (1–5)

    // Constructor
    public Task(String task, int priority) {
        this.task = task;
        setPriority(priority);   // Validate and set priority
    }

    // -----------------------------------------------
    //         Priority interface methods
    // -----------------------------------------------

    // Sets the task priority (forces values into range 1–5)
    @Override
    public void setPriority(int priority) {
        if (priority < 1) {
            this.priority = 1;
        } 
        else if (priority > 5) {
            this.priority = 5;
        } 
        else {
            this.priority = priority;
        }
    }

    // Returns the task priority
    @Override
    public int getPriority() {
        return priority;
    }

    // Returns formatted task information
    @Override
    public String toString() {
        return String.format("%-20s priority: %d", task, priority);
    }
}


// ----------------------------
// TaskList Driver Class
// ----------------------------
package PriorityTaskList;

public class TaskList {

    public static void main(String[] args) {
    	
        System.out.println("Priority Task List");
        System.out.println("------------------");

        // Create tasks with different priorities
        Task t1 = new Task("Attend class", 1);
        Task t2 = new Task("Homework", 2);
        Task t3 = new Task("Exercise", 3);
        Task t4 = new Task("Eat breakfast", 4);
        Task t5 = new Task("Eat lunch", 5);

        // Print the tasks
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t5);
    }
}
