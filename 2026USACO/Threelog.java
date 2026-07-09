import java.util.*;
//https://codeforces.com/problemset/problem/581/D

public class Threelog {

    // Rectangle class
    static class Rect {
        int w, h;
        char ch;

        Rect(int w, int h, char ch) {
            this.w = w;
            this.h = h;
            this.ch = ch;
        }
    }

    static int side;
    static char[][] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] x = new int[3];
        int[] y = new int[3];
        char[] letter = {'A', 'B', 'C'};

        for (int i = 0; i < 3; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int area = x[0] * y[0] + x[1] * y[1] + x[2] * y[2];

        // Total area must be a perfect square
        side = (int) Math.sqrt(area);
        if (side * side != area) {
            System.out.println(-1);
            return;
        }

        // Try every rotation (2^3 possibilities)
        for (int mask = 0; mask < 8; mask++) {

            Rect[] r = new Rect[3];

            for (int i = 0; i < 3; i++) {
                if ((mask & (1 << i)) == 0)
                    r[i] = new Rect(x[i], y[i], letter[i]);
                else
                    r[i] = new Rect(y[i], x[i], letter[i]);
            }

            // Try every permutation
            int[] p = {0, 1, 2};

            do {
                Rect a = r[p[0]];
                Rect b = r[p[1]];
                Rect c = r[p[2]];

                // Case 1:
                // One rectangle occupies the whole top.
                if (a.w == side) {
                    int rem = side - a.h;

                    if (rem > 0 &&
                        b.h == rem &&
                        c.h == rem &&
                        b.w + c.w == side) {

                        ans = new char[side][side];

                        fill(0, 0, a.w, a.h, a.ch);
                        fill(0, a.h, b.w, b.h, b.ch);
                        fill(b.w, a.h, c.w, c.h, c.ch);

                        printAnswer();
                        return;
                    }
                }

                // Case 2:
                // One rectangle occupies the whole left side.
                if (a.h == side) {
                    int rem = side - a.w;

                    if (rem > 0 &&
                        b.w == rem &&
                        c.w == rem &&
                        b.h + c.h == side) {

                        ans = new char[side][side];

                        fill(0, 0, a.w, a.h, a.ch);
                        fill(a.w, 0, b.w, b.h, b.ch);
                        fill(a.w, b.h, c.w, c.h, c.ch);

                        printAnswer();
                        return;
                    }
                }

            } while (nextPermutation(p));
        }

        System.out.println(-1);
    }

    // Fill rectangle in the answer grid
    static void fill(int x, int y, int w, int h, char ch) {
        for (int i = y; i < y + h; i++) {
            for (int j = x; j < x + w; j++) {
                ans[i][j] = ch;
            }
        }
    }

    // Print solution
    static void printAnswer() {
        System.out.println(side);
        for (int i = 0; i < side; i++) {
            System.out.println(new String(ans[i]));
        }
    }

    // Generate next permutation
    static boolean nextPermutation(int[] a) {
        int i = a.length - 2;

        while (i >= 0 && a[i] > a[i + 1])
            i--;

        if (i < 0)
            return false;

        int j = a.length - 1;
        while (a[j] < a[i])
            j--;

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        int l = i + 1;
        int r = a.length - 1;

        while (l < r) {
            temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
        return true;
    }
}