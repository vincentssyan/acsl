public import java.io.*;
import java.util.*;

public class Lineup {
    // List of cows in alphabetical order
    static String[] cows = {
            "Beatrice", "Belinda", "Bella", "Bessie",
            "Betsy", "Blue", "Buttercup", "Sue"
    };

    static ArrayList<String[]> constraints = new ArrayList<>();
    static boolean[] used = new boolean[8];
    static String[] order = new String[8];
    static boolean found = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // Read constraints
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            constraints.add(new String[]{s[0], s[5]});
        }

        // Generate permutations in alphabetical order
        dfs(0);
    }

    // Backtracking to generate all permutations
    static void dfs(int idx) {
        if (found) return;

        if (idx == 8) {
            if (valid()) {
                found = true;
                for (String cow : order) {
                    System.out.println(cow);
                }
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!used[i]) {
                used[i] = true;
                order[idx] = cows[i];
                dfs(idx + 1);
                used[i] = false;
            }
        }
    }

    // Check whether all adjacency constraints are satisfied
    static boolean valid() {
        HashMap<String, Integer> pos = new HashMap<>();

        // Store each cow's position
        for (int i = 0; i < 8; i++) {
            pos.put(order[i], i);
        }

        // Every constrained pair must be adjacent
        for (String[] c : constraints) {
            if (Math.abs(pos.get(c[0]) - pos.get(c[1])) != 1) {
                return false;
            }
        }

        return true;
    }
} {
    
}
