
import java.io.*;
import java.util.*;

public class USACO2015DecemberContestSilverProblem3BreedCounting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new FileReader("bcount.in")
        );
        PrintWriter out = new PrintWriter(
            new BufferedWriter(new FileWriter("bcount.out"))
        );

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] prefix = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            int breed = Integer.parseInt(br.readLine());

            for (int j = 0; j < 3; j++) {
                prefix[i][j] = prefix[i - 1][j];
            }

            prefix[i][breed - 1]++;
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int holsteins = prefix[b][0] - prefix[a - 1][0];
            int guernseys = prefix[b][1] - prefix[a - 1][1];
            int jerseys = prefix[b][2] - prefix[a - 1][2];

            out.println(holsteins + " " + guernseys + " " + jerseys);
        }

        br.close();
        out.close();
    }
}
