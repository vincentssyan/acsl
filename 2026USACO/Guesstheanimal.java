import java.io.*;
import java.util.*;
public class Guesstheanimal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] words = input.split("\\s+");
        HashMap<String, Integer> map = new HashMap<>();
        // Count frequency of each word
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // Find the most common word
        String mostCommon = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommon = entry.getKey();
            }
        }
        System.out.println(maxCount + 1);
    }
}