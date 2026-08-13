
    import java.util.Scanner;

public class Aggignment3_2{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of topics
        int n = sc.nextInt();

        int[] points = new int[n];

        // Read learning points
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }

        // Special cases
        if (n == 1) {
            System.out.println(points[0]);
            return;
        }

        // dp[i] = maximum points we can get
        // from first i+1 topics
        int[] dp = new int[n];

        // First topic
        dp[0] = points[0];

        // For first two topics, choose the larger one
        dp[1] = Math.max(points[0], points[1]);

        // Calculate for remaining topics
        for (int i = 2; i < n; i++) {

            // Option 1: Skip current topic
            int skip = dp[i - 1];

            // Option 2: Take current topic
            // Then we cannot take previous topic
            int take = points[i] + dp[i - 2];

            // Choose the better option
            dp[i] = Math.max(skip, take);
        }

        // Maximum learning points
        System.out.println(dp[n - 1]);

        sc.close();
    }
}
