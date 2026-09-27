import java.io.*;

public class USACO2016FebruaryContestBronzeProblem1MilkPails {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int Y = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int best = 0;

        // Check every possible amount from 0 to M
        for (int amount = 0; amount <= M; amount++) {

            // Check if amount can be made using X and Y
            for (int x = 0; x <= amount; x += X) {
                if ((amount - x) % Y == 0) {
                    best = amount;
                    break;
                }
            }
        }

        System.out.println(best);
    }
}
