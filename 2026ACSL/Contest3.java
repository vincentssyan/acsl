import java.io.*;
class Result {
    public static String playCards(String hand, String piles) {
        String[] pileWords = piles.split(" ");
        String[] arr = new String[pileWords.length * 2];
        for (int i = 0; i < pileWords.length; i++) {
            arr[i * 2] = pileWords[i];
        }
        String[] handWords = hand.split(" ");
        boolean[] used = new boolean[handWords.length];
        for (int i = 0; i < handWords.length; i++) {
            if (getRank(handWords[i]) == 13) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == null) {
                        arr[j] = handWords[i];
                        used[i] = true;
                        break;
                    }
                }
            }
        }
        boolean changed;
        do {
            changed = false;
            for (int i = 0; i < handWords.length; i++) {
                if (used[i]) continue;
                String card = handWords[i];
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == null) continue;
                    if (canReplace(card, arr[j])) {
                        arr[j] = card;
                        used[i] = true;
                        changed = true;
                        break;
                    }
                }
            }

        } while (changed);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] != null ? arr[i] : "E");
            if (i != arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    private static int getRank(String card) {
        String r = card.substring(0, card.length() - 1);
        switch (r) {
            case "A": return 1;
            case "T": return 10;
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            default: return Integer.parseInt(r);
        }
    }
    private static boolean isRed(char suit) {
        return suit == 'H' || suit == 'D';
    }
    private static boolean canReplace(String a, String b) {
        int rankA = getRank(a);
        int rankB = getRank(b);
        char suitA = a.charAt(a.length() - 1);
        char suitB = b.charAt(b.length() - 1);
        return (rankA == rankB - 1) && (isRed(suitA) != isRed(suitB));
    }
}
public class Contest3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String hand = br.readLine();
        String piles = br.readLine();
        System.out.println(Result.playCards(hand, piles));
    }
}
