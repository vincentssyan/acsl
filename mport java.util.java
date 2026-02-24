import java.util.Scanner;

public class GridDiagonalInput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Grid size
        int rows = 10;
        int cols = 10;

        // Ask user for the two points
        System.out.print("Enter first point (x1 y1): ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();

        System.out.print("Enter second point (x2 y2): ");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        // Create empty grid filled with '.'
        char[][] grid = new char[rows][cols];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                grid[y][x] = '.';
            }
        }

        // Draw line between the points
        drawLine(grid, x1, y1, x2, y2);

        // Mark the two points as X
        grid[rows - 1 - y1][x1] = 'X';
        grid[rows - 1 - y2][x2] = 'X';

        // Print the grid
        System.out.println("\nGrid:");
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                System.out.print(grid[y][x] + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    // Draw a diagonal line between two points
    public static void drawLine(char[][] grid, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;

        int err = dx - dy;
        int x = x1;
        int y = y1;

        while (true) {
            // Only mark cells that are empty
            if (grid[grid.length - 1 - y][x] == '.') {
                grid[grid.length - 1 - y][x] = '*';
            }

            if (x == x2 && y == y2) break;

            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x += sx;
            }
            if (e2 < dx) {
                err += dx;
                y += sy;
            }
        }
    }
}