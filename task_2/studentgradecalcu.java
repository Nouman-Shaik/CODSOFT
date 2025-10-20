import java.util.*;

public class studentgradecalcu {
  public static void main(String[] args) {
    
    Scanner sn = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int n = sn.nextInt();

        int[] marks = new int[n];
        int total = 0;

        System.out.println("Enter marks obtained (out of 100) for each subject:");
        for (int i = 0; i < n; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sn.nextInt();

            // Validation check
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Please enter marks between 0 and 100.");
                return;
            }

            total += marks[i];
        }

        double average = (double) total / n;
        char grade;

        if (average >= 90)
            grade = 'A';
        else if (average >= 80)
            grade = 'B';
        else if (average >= 70)
            grade = 'C';
        else if (average >= 60)
            grade = 'D';
        else
            grade = 'F';

        System.out.println("\n--- Result ---");
        System.out.println("Total Marks: " + total + " / " + (n * 100));
        System.out.println("Average Percentage: " + String.format("%.2f", average) + "%");
        System.out.println("Grade: " + grade);

        sn.close();
  }

  
}
