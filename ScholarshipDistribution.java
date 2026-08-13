import java.util.Arrays;
import java.util.Scanner;

public class ScholarshipDistribution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of students and total budget
        int n = sc.nextInt();
        long budget = sc.nextLong();

        // Store scholarship requirements
        int[] scholarship = new int[n];

        for (int i = 0; i < n; i++) {
            scholarship[i] = sc.nextInt();
        }

        // Sort scholarship amounts from smallest to largest
        Arrays.sort(scholarship);

        long total = 0;
        int count = 0;

        // Select students starting from the smallest requirement
        for (int i = 0; i < n; i++) {

            if (total + scholarship[i] <= budget) {
                total = total + scholarship[i];
                count++;
            } else {
                // Since the array is sorted,
                // no later student can be selected
                break;
            }
        }

        // Print maximum number of students
        System.out.println(count);

        sc.close();
    }
}