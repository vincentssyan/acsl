import java.io.*;
import java.util.*;

public class USACO2019JanuaryContestBronzeproblem3GuesstheAnimal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Set<String>> animals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split("\\s+");

            int k = Integer.parseInt(parts[1]);

            Set<String> characteristics = new HashSet<>();

            for (int j = 2; j < 2 + k; j++) {
                characteristics.add(parts[j]);
            }

            animals.add(characteristics);
        }

        int maxCommon = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int common = 0;

                for (String characteristic : animals.get(i)) {
                    if (animals.get(j).contains(characteristic)) {
                        common++;
                    }
                }

                maxCommon = Math.max(maxCommon, common);
            }
        }

        System.out.println(maxCommon + 1);
    }
}