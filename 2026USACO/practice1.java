import java.io.*;
import java.util.*;

public class practice1 {

    static class SegmentTree {
        int n;
        long[] tree;

        SegmentTree(long[] a) {
            n = a.length;
            tree = new long[4 * n];
            build(1, 0, n - 1, a);
        }

        void build(int node, int l, int r, long[] a) {
            if (l == r) {
                tree[node] = a[l];
                return;
            }

            int mid = (l + r) / 2;
            build(node * 2, l, mid, a);
            build(node * 2 + 1, mid + 1, r, a);

            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        void update(int idx, long value) {
            update(1, 0, n - 1, idx, value);
        }

        void update(int node, int l, int r, int idx, long value) {
            if (l == r) {
                tree[node] = value;
                return;
            }

            int mid = (l + r) / 2;

            if (idx <= mid) {
                update(node * 2, l, mid, idx, value);
            } else {
                update(node * 2 + 1, mid + 1, r, idx, value);
            }

            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        // Returns the first index >= ql whose height is > x.
        int firstGreater(int ql, long x) {
            return firstGreater(1, 0, n - 1, ql, x);
        }

        int firstGreater(int node, int l, int r, int ql, long x) {
            if (r < ql || tree[node] <= x) {
                return -1;
            }

            if (l == r) {
                return l;
            }

            int mid = (l + r) / 2;

            int result = firstGreater(node * 2, l, mid, ql, x);

            if (result != -1) {
                return result;
            }

            return firstGreater(node * 2 + 1, mid + 1, r, ql, x);
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int N = fs.nextInt();
        int M = fs.nextInt();

        long[] height = new long[N];
        for (int i = 0; i < N; i++) {
            height[i] = fs.nextLong();
        }

        long[] candy = new long[M];
        for (int i = 0; i < M; i++) {
            candy[i] = fs.nextLong();
        }

        SegmentTree seg = new SegmentTree(height);

        for (long c : candy) {
            long base = 0;
            long remaining = c;
            int pos = 0;

            while (remaining > 0) {
                // Find the next cow that can reach the candy.
                int i = seg.firstGreater(pos, base);

                if (i == -1) {
                    break;
                }

                // Amount this cow can eat.
                long eat = Math.min(remaining, height[i] - base);

                height[i] += eat;
                remaining -= eat;
                base += eat;

                seg.update(i, height[i]);

                // This cow's turn is finished.
                pos = i + 1;
            }
        }

        StringBuilder out = new StringBuilder();

        for (long h : height) {
            out.append(h).append('\n');
        }

        System.out.print(out);
    }

    // Fast input for large N and M.
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) {
                    return -1;
                }
            }

            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ');

            boolean negative = false;

            if (c == '-') {
                negative = true;
                c = read();
            }

            long result = 0;

            while (c > ' ') {
                result = result * 10 + (c - '0');
                c = read();
            }

            return negative ? -result : result;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}