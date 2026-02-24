import java.util.StringTokenizer;

public class Problem5 {

    // Define a function that prints "Hello, World!"
    public static int findDiscardSum(int originalRows, String tiles) {
        int[] rows = new int[4];
        for (int i = 3; i >= 0; i--) 
        {
            rows[i] = originalRows % 10;
            originalRows /=10;
        }
        int result = 0;
        StringTokenizer st = new StringTokenizer(tiles);
        while (st.hasMoreTokens())
        {
            int cur = Integer.parseInt(st.nextToken());
            int front = cur / 10;
            int back = cur % 10;
            Boolean isMatched = false;
            for (int i = 0; i < 4; i++)
        {
            if (rows[i] == front) {
                isMatched = true;
                rows[i] = back;
                break;
            }
            else if (rows[i] == back) {
                isMatched = true;
                rows[i] = front;
                break;
            }
        }
        if (isMatched) {
            result += (front + back);
        }
        }
    return result;
    }

    // Main method
    public static void main(String[] args) {
        //
        int result = findDiscardSum(5293, "56 85 27 73 14 34 62");
        System.out.println(result);
    }
}