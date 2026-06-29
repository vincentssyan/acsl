import java.util.*;
import java.io.*;

public class Triangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] x = new int[N];
        int[] y = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int i = 0; i < N; i++) {
            int maxVertical = 0;
            int maxHorizontal = 0;

            for (int j = 0; j < N; j++) {
                if (x[i] == x[j]) {
                    maxVertical = Math.max(maxVertical, Math.abs(y[i] - y[j]));
                }
                if (y[i] == y[j]) {
                    maxHorizontal = Math.max(maxHorizontal, Math.abs(x[i] - x[j]));
                }
            }

            ans = Math.max(ans, maxVertical * maxHorizontal);
        }

        System.out.println(ans);
    }
}