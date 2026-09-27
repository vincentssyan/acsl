import java.io.*;
import java.util.*;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        int[] color = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            boolean[] used = new boolean[5];

            for (int neighbor : adj[i]) {
                if (color[neighbor] != 0) {
                    used[color[neighbor]] = true;
                }
            }

            for (int c = 1; c <= 4; c++) {
                if (!used[c]) {
                    color[i] = c;
                    break;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(color[i]);
        }
    }
}
