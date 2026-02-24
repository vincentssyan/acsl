import java.io.*;
import java.util.Scanner;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static String verifyPlate(String plate, String day) {
        Scanner scanner = new Scanner(System.in);

        int letterCount = 0;
        int numberCount = 0;
        String lettersFound = "";
        String numbersFound = "";

        // Check repeated 6, 8, 9 → lucky
        int count6 = 0, count8 = 0, count9 = 0;
        for (int i = 0; i < plate.length(); i++) {
            char c = plate.charAt(i);
            if (c == '6')
                count6++;
            else if (c == '8')
                count8++;
            else if (c == '9')
                count9++;
        }
        if (count6 > 1 || count8 > 1 || count9 > 1)
            return "lucky";

        // Count letters and numbers and build strings
        for (int i = 0; i < plate.length(); i++) {
            char c = plate.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                letterCount++;
                lettersFound += c + " ";
            } else if (c >= '0' && c <= '9') {
                numberCount++;
                numbersFound += c + " ";
            }
        }

        if (letterCount <= 0 || numberCount <= 1)
            return "invalid";

        // Check 3 consecutive numbers or letters → fortunate
        for (int i = 0; i < plate.length() - 2; i++) {
            char c1 = plate.charAt(i), c2 = plate.charAt(i + 1), c3 = plate.charAt(i + 2);
            if (c1 >= '0' && c1 <= '9' && c2 == c1 + 1 && c3 == c2 + 1)
                return "fortunate";
            if (((c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z')) &&
                    ((c2 >= 'a' && c2 <= 'z') || (c2 >= 'A' && c2 <= 'Z')) &&
                    ((c3 >= 'a' && c3 <= 'z') || (c3 >= 'A' && c3 <= 'Z'))) {
                char l1 = Character.toLowerCase(c1), l2 = Character.toLowerCase(c2), l3 = Character.toLowerCase(c3);
                if (l2 == l1 + 1 && l3 == l2 + 1)
                    return "fortunate";
            }
        }

        int total = letterCount + numberCount;

        if (total == 8 || total == 6) {
            char lastChar = plate.charAt(plate.length() - 1);
            if ((lastChar >= '0' && lastChar <= '9' && (lastChar - '0') % 2 != 0) ||
                    ((lastChar >= 'a' && lastChar <= 'z') || (lastChar >= 'A' && lastChar <= 'Z')) &&
                            (Character.toLowerCase(lastChar) - 'a') % 2 != 0) {
                return "restricted";
            }
            return "blue";
        } else if (total == 7) {
            return "green";
        }

        return "Letters (" + letterCount + "): " + lettersFound + " | Numbers (" + numberCount + "): " + numbersFound;
    }
}

public class Contest2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String plate = bufferedReader.readLine();
        String day = bufferedReader.readLine();
        String result = Result.verifyPlate(plate, day);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
