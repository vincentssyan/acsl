import java.util.Scanner;

public class Hi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = convert(input);
        System.out.println(result);
        scanner.close();
    }

    public static String convert(String input) {
        StringBuilder result = new StringBuilder();
        StringBuilder numberBuffer = new StringBuilder();
        // Buffer to hold numbers

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                // If it's a digit, add it to the number buffer
                numberBuffer.append(ch);
            } else {
                // If we encounter a non-digit character, process the buffered number
                if (numberBuffer.length() > 0) {
                    // Convert the number to a letter if it's between 1 and 26
                    int number = Integer.parseInt(numberBuffer.toString());
                    if (number >= 1 && number <= 26) {
                        result.append((char) ('a' + number - 1));
                        // Convert to lowercase letter
                    } else {
                        result.append(numberBuffer.toString());
                        // Keep the number if out of range
                    }
                    numberBuffer.setLength(0);
                    // Reset the number buffer
                }

                // Convert uppercase letters to lowercase, leave lowercase letters unchanged
                if (Character.isUpperCase(ch)) {
                    result.append(Character.toLowerCase(ch));
                } else {
                    result.append(ch);
                    // Keep other characters unchanged
                }
            }
        }

        // Handle any remaining numbers at the end of the input
        if (numberBuffer.length() > 0) {
            int number = Integer.parseInt(numberBuffer.toString());
            if (number >= 1 && number <= 26) {
                result.append((char) ('a' + number - 1));
            } else {
                result.append(numberBuffer.toString());
                // Keep the number if out of range
            }
        }

        return result.toString();
    }
}
