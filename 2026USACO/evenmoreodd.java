public import java.io.*;
import java.util.*;

public class evenmoreodd {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int odd = 0;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x % 2 == 1) {
                odd++;
            }
        }

        for (int k = N; k >= 1; k--) {
            int oddGroups = k / 2;
            if (odd >= oddGroups && (odd - oddGroups) % 2 == 0) {
                System.out.println(k);
                return;
            }
        }
    }
} {
    
}
