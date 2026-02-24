public class func {

    // Recursive function outside main
    public static long func(long x) {
        if (x > 1) {
            return func(x - 1) + func(x - 2);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        int n = 50; // example input
        System.out.println("func(" + n + ") = " + func(n));
    }
}