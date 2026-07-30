import java.io.*;
import java.util.*;

public class swamp {
    static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long K = Long.parseLong(br.readLine());

        st = new StringTokenizer(br.readLine());
        int A1 = Integer.parseInt(st.nextToken()) - 1;
        int A2 = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int B1 = Integer.parseInt(st.nextToken()) - 1;
        int B2 = Integer.parseInt(st.nextToken()) - 1;

        // pos[i] = original position currently at index i
        int[] pos = new int[N];
        for (int i = 0; i < N; i++) pos[i] = i;

        reverse(pos, A1, A2);
        reverse(pos, B1, B2);

        // perm[oldPos] = newPos after one full operation
        int[] perm = new int[N];
        for (int newPos = 0; newPos < N; newPos++) {
            perm[pos[newPos]] = newPos;
        }

        int[] ans = new int[N];
        boolean[] vis = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (vis[i]) continue;

            ArrayList<Integer> cycle = new ArrayList<>();
            int cur = i;
            while (!vis[cur]) {
                vis[cur] = true;
                cycle.add(cur);
                cur = perm[cur];
            }

            int len = cycle.size();
            int shift = (int)(K % len);

            for (int j = 0; j < len; j++) {
                int oldPos = cycle.get(j);
                int newPos = cycle.get((j + shift) % len);
                ans[newPos] = oldPos + 1; // cow labels are 1-indexed
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : ans) {
            sb.append(x).append('\n');
        }
        System.out.print(sb);
    }
}