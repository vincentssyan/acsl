import java.io.*;      // Allows reading input
import java.util.*;    // Imports utility classes (not actually needed here)

public class MilkPails {
    public static void main(String[] args) throws Exception {

        // Create an object to read input from the keyboard
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the size of the first pail
        int X = Integer.parseInt(br.readLine());

        // Read the size of the second pail
        int Y = Integer.parseInt(br.readLine());

        // Read the maximum amount of milk allowed
        int M = Integer.parseInt(br.readLine());

        // Stores the best (largest) amount found that does not exceed M
        int best = 0;

        // Try every possible number of X-sized pails
        for (int i = 0; i <= M / X; i++) {

            // Try every possible number of Y-sized pails
            for (int j = 0; j <= M / Y; j++) {

                // Calculate the total milk using i X-pails and j Y-pails
                int total = i * X + j * Y;

                // If the total is not too large and is better than our current best
                if (total <= M && total > best) {

                    // Save this new best answer
                    best = total;
                }
            }
        }

        // Print the largest amount that does not exceed M
        System.out.println(best);
    }
}