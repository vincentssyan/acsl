public class Problem2 {

    static int sumOflastRow(int s, int d, int r) {
        int sum = 0;
        int numbersToSkip = r * (r - 1) / 2;
        int firstNumberRthRow = transformToSingleDigit(s);
        for (int i = 0; i < numbersToSkip; i++) {
            firstNumberRthRow += d;
            firstNumberRthRow = transformToSingleDigit(firstNumberRthRow);
        }
        for (int i = 0; i < r; i++) {
            sum += transformToSingleDigit(firstNumberRthRow);
            firstNumberRthRow += d;
        }
        return sum;
    }

    static int transformToSingleDigit(int number) {
        while (number > 9) {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            number = sum;
        }
        return number;
    }

    public static void main(String[] args) {
        int result = sumOflastRow(599, 23, 43);
        System.out.println(result);
    }
}
