import java.io.*;

public class USACO2021JanuaryContestBronzeProblem2EvenMoreOddPhotos {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int odd = 0;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x % 2 != 0) {
                odd++;
            }
        }

        int k = 2 * odd;

        if (k > N) {
            k = N;
        }

        // Adjust until the parity condition is satisfied
        while (k >= 1 && (odd - k / 2) % 2 != 0) {
            k--;
        }

        System.out.println(k);
    }
}
