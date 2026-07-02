public import java.util.*;

public class lair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of cows
        int N = sc.nextInt();

        char[] type = new char[N];
        int[] p = new int[N];

        // Candidate positions to test
        ArrayList<Integer> candidates = new ArrayList<>();
        candidates.add(0);
        candidates.add(1000000000);

        // Read statements
        for (int i = 0; i < N; i++) {
            type[i] = sc.next().charAt(0);
            p[i] = sc.nextInt();
            candidates.add(p[i]);
        }

        int answer = N;

        // Try every possible candidate position
        for (int x : candidates) {
            int lies = 0;

            // Count how many cows would be lying
            for (int i = 0; i < N; i++) {
                if (type[i] == 'L') {
                    // Statement: x <= p
                    if (x > p[i]) {
                        lies++;
                    }
                } else {
                    // Statement: x >= p
                    if (x < p[i]) {
                        lies++;
                    }
                }
            }

            answer = Math.min(answer, lies);
        }

        // Print minimum number of lying cows
        System.out.println(answer);
    }
} {
    
}
