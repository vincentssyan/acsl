public import java.util.*;

public class Permutator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read size of arrays
        int n = sc.nextInt();

        // Array to store weighted values of a
        long[] weight = new long[n];

        // Read array a and compute its contribution weight
        for (int i = 0; i < n; i++) {
            long a = sc.nextLong();

            // Number of subarrays containing index i
            long cnt = (long) (i + 1) * (n - i);

            // Weighted value
            weight[i] = a * cnt;
        }

        // Read array b
        Long[] b = new Long[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextLong();
        }

        // Sort weights in ascending order
        Arrays.sort(weight);

        // Sort b in descending order
        Arrays.sort(b, Collections.reverseOrder());

        // Compute minimum possible sum
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += weight[i] * b[i];
        }

        // Print answer
        System.out.println(ans);
    }
} {
    
}
