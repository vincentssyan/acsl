import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class USACO2017JanuaryContestBronzeProblem3CowTipping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] grid = new char[N][N];

        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        int[][] parity = new int[N + 1][N + 1];
        int ans = 0;

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {

                // Number of previous flips affecting (i, j), modulo 2
                parity[i][j] ^= parity[i + 1][j]
                              ^ parity[i][j + 1]
                              ^ parity[i + 1][j + 1];

                int value = (grid[i][j] - '0') ^ parity[i][j];

                if (value == 1) {
                    ans++;

                    // Flip (0,0) -> (i,j).
                    // From the perspective of our reverse scan, this adds
                    // one flip to the suffix represented by (i,j).
                    parity[i][j] ^= 1;
                }
            }
        }

        System.out.println(ans);
    }
}
