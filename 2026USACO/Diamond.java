import java.io.*;
import java.util.*;

public class Diamond {
    public static void main(String[] args) throws Exception {
        // Read input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of diamonds (N) and maximum allowed size difference (K)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // Store all diamond sizes
        int[] diamonds = new int[N];
        for (int i = 0; i < N; i++) {
            diamonds[i] = Integer.parseInt(br.readLine());
        }

        // Sort the diamond sizes
        Arrays.sort(diamonds);

        // Sliding window pointers
        int left = 0;
        int ans = 0;

        // Expand the right end of the window
        for (int right = 0; right < N; right++) {
            // Shrink the window until the size difference is within K
            while (diamonds[right] - diamonds[left] > K) {
                left++;
            }

            // Update the maximum number of diamonds in a valid window
            ans = Math.max(ans, right - left + 1);
        }

        // Output the answer
        System.out.println(ans);
    }
}