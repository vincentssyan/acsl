public import java.io.*;
import java.util.*;

public class Practicequestion1
 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] start = new int[N];
        int[] end = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int remove = 0; remove < N; remove++) {
            boolean[] covered = new boolean[1000];

            for (int i = 0; i < N; i++) {
                if (i == remove) continue;

                for (int t = start[i]; t < end[i]; t++) {
                    covered[t] = true;
                }
            }

            int total = 0;
            for (int t = 0; t < 1000; t++) {
                if (covered[t]) total++;
            }

            ans = Math.max(ans, total);
        }

        System.out.println(ans);
    }
} 
