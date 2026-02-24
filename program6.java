public class Program6 {

    // Method to rearrange the input string
    static String rearrangeSTRING(String num) {
        int[] charCount = new int[26]; // To store frequency of each letter
        int maxCount = 0;

        // Count character frequencies
        for (int i = 0; i < num.length(); i++) {
            int index = getIndexOfChar(num.charAt(i));
            if (index != -1) { // Ignore non-alphabetic characters
                charCount[index]++;
                maxCount = Math.max(maxCount, charCount[index]);
            }
        }

        // Rearrange the string
        StringBuilder sb = new StringBuilder();
        char lastChar = ' '; // To track the last added character
        for (int j = 0; j < maxCount; j++) { // Process levels of frequencies
            for (int i = 0; i < 26; i++) { // Check all letters
                if (charCount[i] > j) { // If letter still has occurrences
                    char curChar = (char) ('a' + i);
                    if (lastChar != curChar) { // Avoid consecutive same characters
                        sb.append(curChar);
                        lastChar = curChar;
                    }
                }
            }
        }

        return sb.toString();
    }

    // Helper method to get the index of a character (0 for 'a', 1 for 'b', etc.)
    static int getIndexOfChar(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A'; // Convert uppercase to 0-25 range
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a'; // Convert lowercase to 0-25 range
        }
        return -1; // Ignore non-alphabetic characters
    }

    // Main method to test the rearrangeSTRING function
    public static void main(String[] args) {
        // Example input
        String input = "Peter Piper picked a peck of pickled peppers.";

        // Call the rearrangeSTRING method
        String result = rearrangeSTRING(input);

        // Print the rearranged result
        System.out.println("Input: " + input);
        System.out.println("Rearranged String: " + result);
    }
}
