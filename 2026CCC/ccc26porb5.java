import java.util.*;
public class ccc26porb5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // number of parking spots
        int L = sc.nextInt();  // number of lights
        int Q = sc.nextInt();  // number of questions
        boolean[] illuminated = new boolean[N + 1];
        // process lights
        for (int i = 0; i < L; i++) {
            int P = sc.nextInt(); // position of light
            int S = sc.nextInt(); // spread
            int left = Math.max(1, P - S);
            int right = Math.min(N, P + S);
            for (int j = left; j <= right; j++) {
                illuminated[j] = true;
            }
        }
        // check parking spots
        for (int i = 0; i < Q; i++) {
            int spot = sc.nextInt();  // which parking spot to check
            if (illuminated[spot]) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            } 
        }

        sc.close();
    }
}