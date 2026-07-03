import java.io.*;
import java.util.*;

public class backforth {

    // Stores all possible final milk amounts in barn 1
    static HashSet<Integer> ans = new HashSet<>();

    // day:
    // 0 = Tuesday
    // 1 = Wednesday
    // 2 = Thursday
    // 3 = Friday
    static void dfs(int day, int milk1, int milk2,)
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

            // Try every possible bucket in barn 1
            for (int i = 0; i < b1.size(); i++) {

                int bucket = b1.get(i);

                // Make copies so this recursive call
                // doesn't affect other choices
                ArrayList<Integer> nb1 = new ArrayList<>(b1);
                ArrayList<Integer> nb2 = new ArrayList<>(b2);

                // Remove bucket from barn 1
                nb1.remove(i);

                // Leave bucket in barn 2
                nb2.add(bucket);

                // Transfer milk equal to bucket size
                dfs(day + 1,
                        milk1 - bucket,
                        milk2 + bucket,
                        nb1,
                        nb2);
            }

        } else {
            // Wednesday and Friday:
            // Move a bucket from barn 2 to barn 1

            // Try every possible bucket in barn 2
            for (int i = 0; i < b2.size(); i++) {

                int bucket = b2.get(i);

                // Copy current bucket lists
                ArrayList<Integer> nb1 = new ArrayList<>(b1);
                ArrayList<Integer> nb2 = new ArrayList<>(b2);

                // Move bucket back to barn 1
                nb2.remove(i);
                nb1.add(bucket);

                // Transfer milk
                dfs(day + 1,
                        milk1 + bucket,
                        milk2 - bucket,
                        nb1,
                        nb2);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
        PrintWriter out = new PrintWriter(new FileWriter("backforth.out"));

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
        dfs(0, 1000, 1000, barn1, barn2);

        // Print number of distinct final milk amounts
        out.println(ans.size());
        out.close();
    }
}