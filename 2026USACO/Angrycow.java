import java.io.*;
import java.util.*;

public class Angrycow {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N];

        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(x);

        int answer = 1;

        // try every hay bale as the starting point
        for (int start = 0; start < N; start++) {

            // ---------- expand to the left ----------
            int left = start;
            int radius = 1;

            while (true) {
                int next = left;

                // find all hay bales reachable with current radius
                while (next - 1 >= 0 &&
                        x[left] - x[next - 1] <= radius) {
                    next--;
                }

                // no new hay bale reached
                if (next == left) break;

                left = next;
                radius++;
            }

            // ---------- expand to the right ----------
            int right = start;
            radius = 1;

            while (true) {
                int next = right;

                // find all hay bales reachable with current radius
                while (next + 1 < N &&
                        x[next + 1] - x[right] <= radius) {
                    next++;
                }

                // no new hay bale reached
                if (next == right) break;

                right = next;
                radius++;
            }

            // update maximum exploded hay bales
            answer = Math.max(answer, right - left + 1);
        }

        System.out.println(answer);
    }
}