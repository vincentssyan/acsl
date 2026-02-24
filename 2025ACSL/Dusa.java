import java.util.Scanner;

public class Dusa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the size of the Dusa.");
        int D = scanner.nextInt();
        for (int i = 0; i < 10000; i++) {
            System.out.println("Please enter the size of Yobis.");
            int Y = scanner.nextInt();
            if (D <= Y) {
                System.out.println("Dusa runs away with size: " + D + " as Yorbis is of larger size: " + Y);
                break;
            } else {
                D += Y;
                System.out.println("New Dusa size is:" + D);
            }
        }
        scanner.close();
    }
}