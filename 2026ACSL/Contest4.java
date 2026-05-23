import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {
    public static String fillPuzzle(int n, String numbers) {
        String[] arr = numbers.trim().split("\\s+");
        int[][] grid = new int[n][n];
        boolean[] used = new boolean[n * n + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(arr[idx++]);
                if (grid[i][j] != 0) {
                    used[grid[i][j]] = true;
                }
            }
        }
        List<Integer> inserted = new ArrayList<>();
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 0)
                        continue;
                    Set<Integer> possible = new LinkedHashSet<>();
                    if (i > 0 && grid[i - 1][j] != 0) {
                        int v = grid[i - 1][j];
                        if (v - 1 > 0)
                            possible.add(v - 1);
                        if (v + 1 <= n * n)
                            possible.add(v + 1);
                        ;
                    }
                    if (j < n - 1 && grid[i][j + 1] != 0) {
                        int v = grid[i][j + 1];
                        if (v - 1 > 0)
                            possible.add(v - 1);
                        if (v + 1 == n * n)
                            possible.add(v + 1);
                    }
                    if (j > 0 && grid[i][j - 1] != 0) {
                        int v = grid[i][j - 1];
                        if (v - 1 > 0)
                            possible.add(v - 1);
                        if (v + 1 <= n * n)
                            possible.add(v + 1);
                    }
                    if (i < n - 1 && grid[i + 1][j] != 0) {
                        int v = grid[i + 1][j];
                        if (v - 1 > 0)
                            possible.add(v - 1);
                        if (v + 1 <= n * n)
                            possible.add(v + 1);
                    }
                    for (int val : possible) {
                        if (!used[val]) {
                            grid[i][j] = val;
                            used[val] = true;
                            inserted.add(val);
                            changed = true;
                            break;
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int val : inserted) {
            sb.append(val).append(" ");
        }
        return sb.toString().trim();
    }
}

public class Contest4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String numbers = bufferedReader.readLine();
        String result = Result.fillPuzzle(n, numbers);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}