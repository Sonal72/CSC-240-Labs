// ----------------------------
// Student Class
// ----------------------------
package SortedGradebook;

public class Student implements Comparable<Student> {
 private String firstName;
 private String lastName;
 private int score;

 // Constructor
 public Student(String firstName, String lastName, int score) {
     this.firstName = firstName;
     this.lastName = lastName;
     this.score = score;
 }

 // Getters
 public String getFirstName() {
	 return firstName; 
	 }
 public String getLastName() {
	 return lastName; 
	 }
 public int getScore() {
	 return score; 
	 }

 // Implement compareTo for descending order by score
 @Override
 public int compareTo(Student other) {
     return this.score - other.score; // default ascending
     // Make it descending in Sorting class
 }

 @Override
 public String toString() {
     return firstName + " " + lastName + " " + score;
 }
}


// ----------------------------
// Sorting Class
// ----------------------------
package SortedGradebook;

public class Sorting<T> {
    // Selection sort in descending order
    public void selectionSort(Student[] list) {
        int max;
        Student temp;

        for (int index = 0; index < list.length - 1; index++) {
            max = index;
            for (int scan = index + 1; scan < list.length; scan++) {
                if (list[scan].compareTo(list[max]) > 0) { // descending
                    max = scan;
                }
            }

            // Swap
            temp = list[max];
            list[max] = list[index];
            list[index] = temp;
        }
    }
}


// ----------------------------
// Gradebook Class
// ----------------------------
package SortedGradebook;

public class Gradebook {

    // Store array of students
    private Student[] students;
    private int count;

    // Constructor
    public Gradebook(int size) {
        students = new Student[size];
        count = 0;
    }

    // Add a student
    public void addStudent(Student s) {
        if (count < students.length) {
            students[count] = s;
            count++;
        }
    }
    
    // Get the array of students
    public Student[] getStudents() {
        return students;
    }

    // Get number of students added
    public int getCount() {
        return count;
    }
}


// ----------------------------
// Driver Class
// ----------------------------
package SortedGradebook;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Gradebook gradebook = new Gradebook(5);

        // Prompt for 5 students
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter student <firstName> <lastName> <score>: ");
            String first = input.next();
            String last = input.next();
            int score = input.nextInt();

            gradebook.addStudent(new Student(first, last, score));
        }

        // Get students array
        Student[] students = gradebook.getStudents();

        // Sort in descending order
        Sorting<Student> sorter = new Sorting<>();
        sorter.selectionSort(students);

        // Print students in sorted order
        for (Student s : students) {
            System.out.println(s);
        }

        input.close();
    }
}
