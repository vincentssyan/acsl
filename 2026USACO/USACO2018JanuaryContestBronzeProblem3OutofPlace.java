import java.io.*;
import java.util.*;

public class USACO2018JanuaryContestBronzeProblem3OutofPlace {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        int[] sorted = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
            sorted[i] = a[i];
        }

        Arrays.sort(sorted);

        int left = 0;
        while (left < N && a[left] == sorted[left]) {
            left++;
        }

        // Already sorted
        if (left == N) {
            System.out.println(0);
            return;
        }

        int right = N - 1;
        while (right >= 0 && a[right] == sorted[right]) {
            right--;
        }

        System.out.println(right - left);
    }
}
