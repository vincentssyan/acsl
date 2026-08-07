import java.io.*;
import java.util.*;

public class outofplace {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        int[] sorted = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
            sorted[i] = a[i];
        }

        Arrays.sort(sorted);

        // height -> correct index
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < N; i++) {
            pos.put(sorted[i], i);
        }

        boolean[] visited = new boolean[N];
        int swaps = 0;

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            int cycleSize = 0;
            int cur = i;

            while (!visited[cur]) {
                visited[cur] = true;
                cur = pos.get(a[cur]);
                cycleSize++;
            }

            if (cycleSize > 1) swaps += cycleSize - 1;
        }

        System.out.println(swaps);
    }
}