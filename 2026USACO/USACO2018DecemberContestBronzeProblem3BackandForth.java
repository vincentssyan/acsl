import java.io.*;
import java.util.*;

public class USACO2018DecemberContestBronzeProblem3BackandForth {

    // Stores all possible final milk amounts in barn 1
    static HashSet<Integer> ans = new HashSet<>();

    // day:
    // 0 = Tuesday
    // 1 = Wednesday
    // 2 = Thursday
    // 3 = Friday
    static void dfs(int day, int milk1,
                    ArrayList<Integer> b1,
                    ArrayList<Integer> b2) {

        // After Friday's transfer, record the result
        if (day == 4) {
            ans.add(milk1);
            return;
        }

        // Tuesday and Thursday:
        // Move a bucket from barn 1 to barn 2
        if (day % 2 == 0) {

            for (int i = 0; i < b1.size(); i++) {

                // Remove bucket from barn 1
                int bucket = b1.remove(i);

                // Add bucket to barn 2
                b2.add(bucket);

                // Continue to next day
                dfs(day + 1,
                    milk1 - bucket,
                    b1,
                    b2);

                // Undo the move
                b2.remove(b2.size() - 1);
                b1.add(i, bucket);
            }

        } else {
            // Wednesday and Friday:
            // Move a bucket from barn 2 to barn 1

            for (int i = 0; i < b2.size(); i++) {

                // Remove bucket from barn 2
                int bucket = b2.remove(i);

                // Add bucket to barn 1
                b1.add(bucket);

                // Continue to next day
                dfs(day + 1,
                    milk1 + bucket,
                    b1,
                    b2);

                // Undo the move
                b1.remove(b1.size() - 1);
                b2.add(i, bucket);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
            new BufferedReader(new FileReader("backforth.in"));

        PrintWriter out =
            new PrintWriter(new FileWriter("backforth.out"));

        ArrayList<Integer> barn1 = new ArrayList<>();
        ArrayList<Integer> barn2 = new ArrayList<>();

        // Read the 10 bucket sizes for barn 1
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            barn1.add(Integer.parseInt(st.nextToken()));
        }

        // Read the 10 bucket sizes for barn 2
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            barn2.add(Integer.parseInt(st.nextToken()));
        }

        // Start simulation
        dfs(0, 1000, barn1, barn2);

        // Print number of distinct final milk amounts
        out.println(ans.size());

        out.close();
    }
}
