import java.util.*;

public class USACO2022USOpencontestBronzeProblem2CountingLiars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        char[] type = new char[N];
        int[] p = new int[N];

        // Read statements
        for (int i = 0; i < N; i++) {
            type[i] = sc.next().charAt(0);
            p[i] = sc.nextInt();
        }

        int answer = N;

        // Try each given p[i] as the possible position
        for (int x : p) {
            int lies = 0;

            for (int i = 0; i < N; i++) {
                if (type[i] == 'L') {
                    // Statement: x <= p[i]
                    if (x > p[i]) {
                        lies++;
                    }
                } else {
                    // Statement: x >= p[i]
                    if (x < p[i]) {
                        lies++;
                    }
                }
            }

            answer = Math.min(answer, lies);
        }

        System.out.println(answer);
    }
}