import java.io.*;
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

    /*
     * Complete the 'printPile' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING pile
     *  2. STRING hand
     */


    /*
     * Complete the 'printPile' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING pile
     *  2. STRING hand
     */

    public static String printPile(String pile, String hand) {
        String[] cards = hand.split(" ");
        StringBuilder result = new StringBuilder(pile);
        
        for (String card : cards) {
            
            if (card.charAt(0) == pile.charAt(0) ||
                card.charAt(1) == pile.charAt(1) ||
                card.charAt(2) == pile.charAt(2)) {
                result.append(" ").append(card);
                pile = card;
            }
        }
        
        return result.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String pile = bufferedReader.readLine();

        String hand = bufferedReader.readLine();

        String result = Result.printPile(pile, hand);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    

            if (result.size() == 7) {
                break;
        }
        
        return result;
        
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String pile = bufferedReader.readLine();

        String hand = bufferedReader.readLine();

        String result = Result.printPile(pile, hand);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}