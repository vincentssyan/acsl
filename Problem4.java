 public class Problem4 {
    static int findDigitSum(int num, int base, long start) {
        int result = 0;
        long startValue = Long.parseLong(Long.toString(start), base);
        for (int i = 0; i < num; i++) {
            long number = startValue + i;
            int sum = 0;
            while (number > 0) {
                sum += (int) (number % base);
                number /= base;
            }
            result += sum;
        }
        return result;
    }

    public static void main(String[] args) {
        //
        int result = findDigitSum(1000, 8, 10);
        System.out.println(result);
        result = findDigitSum(50, 4, 13);
        System.out.println(result);
    }
}