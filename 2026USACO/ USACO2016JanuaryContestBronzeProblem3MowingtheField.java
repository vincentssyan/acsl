import java.io.*;
import java.util.*;

public class USACO2016JanuaryContestBronzeProblem3MowingtheField {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // Store the last time each position was visited.
        Map<String, Integer> lastVisit = new HashMap<>();

        int x = Integer.MAX_VALUE;

        int row = 0;
        int col = 0;
        int time = 0;

        // FJ starts here at t = 0.
        lastVisit.put(row + "," + col, 0);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char direction = st.nextToken().charAt(0);
            int steps = Integer.parseInt(st.nextToken());

            int dr = 0;
            int dc = 0;

            if (direction == 'N') dr = 1;
            if (direction == 'S') dr = -1;
            if (direction == 'E') dc = 1;
            if (direction == 'W') dc = -1;

            for (int j = 0; j < steps; j++) {
                // Move one cell.
                row += dr;
                col += dc;
                time++;

                String pos = row + "," + col;

                if (lastVisit.containsKey(pos)) {
                    int previousTime = lastVisit.get(pos);

                    // Time between consecutive visits.
                    int gap = time - previousTime;

                    x = Math.min(x, gap);
                }

                // Update most recent visit.
                lastVisit.put(pos, time);
            }
        }

        // If no cell was ever revisited, x can be arbitrarily large.
        if (x == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(x);
        }
    }
}
