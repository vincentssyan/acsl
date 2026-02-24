import java.util.*;

public class Program9 {

    // Method to play the Rack-O game
    public static int playRackOGame(int slots, int totalCards, int[] initialRack, int[] drawPile) {
        int[] rack = Arrays.copyOf(initialRack, slots); // Copy initial rack
        int drawIndex = 0; // Index to track cards in the draw pile

        // Process cards from the draw pile
        while (drawIndex < drawPile.length) {
            int drawnCard = drawPile[drawIndex];
            boolean cardUsed = false;

            // Rule 1: Replace card before if drawn card is 1 less than any card in the rack
            for (int i = 1; i < slots; i++) {
                if (drawnCard == rack[i] - 1) {
                    rack[i - 1] = drawnCard;
                    cardUsed = true;
                    break;
                }
            }

            // Rule 2: Replace card after if drawn card is 1 greater than any card in the rack
            if (!cardUsed) {
                for (int i = 0; i < slots - 1; i++) {
                    if (drawnCard == rack[i] + 1) {
                        rack[i + 1] = drawnCard;
                        cardUsed = true;
                        break;
                    }
                }
            }

            // Rule 3: Replace middle card if drawn card is between the first and last of 3 adjacent cards
            if (!cardUsed) {
                for (int i = 1; i < slots - 1; i++) {
                    if (rack[i] < rack[i - 1] || rack[i] > rack[i + 1]) {
                        if (drawnCard > rack[i - 1] && drawnCard < rack[i + 1]) {
                            rack[i] = drawnCard;
                            cardUsed = true;
                            break;
                        }
                    }
                }
            }

            // Rule 4: Replace first card if drawn card is less than the second card
            if (!cardUsed && drawnCard < rack[1] && rack[0] > rack[1]) {
                rack[0] = drawnCard;
                cardUsed = true;
            }

            // Rule 5: Replace last card if drawn card is greater than the second-to-last card
            if (!cardUsed && drawnCard > rack[slots - 2] && rack[slots - 1] < rack[slots - 2]) {
                rack[slots - 1] = drawnCard;
                cardUsed = true;
            }

            // Rule 6: Do not use the drawn card if no other rules apply
            if (!cardUsed) {
                drawIndex++;
                continue;
            }

            // Check if rack is in ascending order
            if (isAscending(rack)) {
                return sumOfRack(rack); // Return the sum of the rack if it's in ascending order
            }

            drawIndex++;
        }

        // If draw pile is empty and rack is not in ascending order, return 0
        return isAscending(rack) ? sumOfRack(rack) : 0;
    }

    // Helper method to check if the rack is in ascending order
    private static boolean isAscending(int[] rack) {
        for (int i = 1; i < rack.length; i++) {
            if (rack[i] < rack[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Helper method to calculate the sum of the rack
    private static int sumOfRack(int[] rack) {
        int sum = 0;
        for (int card : rack) {
            sum += card;
        }
        return sum;
    }

    // Main method to test the program
    public static void main(String[] args) {
        // Input values for the game
        int slots = 10; // Number of slots in the rack
        int totalCards = 60; // Total number of cards in the game
        int[] initialRack = {10, 60, 40, 35, 20, 56, 32, 58, 42, 17, 45, 34, 31, 44, 10, 28, 19, 46, 7, 37, 16, 2}; // Initial rack
        int[] drawPile = {10, 40, 56}; // Draw pile

        // Play the game
        int result = playRackOGame(slots, totalCards, initialRack, drawPile);

        // Output the result
        System.out.println("Final Rack Value: " + result);
    }
}