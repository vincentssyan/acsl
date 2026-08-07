public import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cowtipper {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] grid = new char[N][N];

        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        int ans = 0;

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (grid[i][j] == '1') {
                    ans++;
                    // Flip the rectangle (0,0) to (i,j)
                    for (int x = 0; x <= i; x++) {
                        for (int y = 0; y <= j; y++) {
                            grid[x][y] = (grid[x][y] == '1') ? '0' : '1';
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
} {
    
}
