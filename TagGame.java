import java.util.Scanner;

public class TagGame {

    static final int SIZE = 10;
    static char[][] map = new char[SIZE][SIZE];
    static int taggerX = 0, taggerY = 0;
    static int runnerX = SIZE - 1, runnerY = SIZE - 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeMap();

        while (true) {
            printMap();

            if (taggerX == runnerX && taggerY == runnerY) {
                System.out.println("Tagger caught the runner! Game over.");
                break;
            }

            System.out.print("Move Tagger (WASD): ");
            char moveTagger = scanner.nextLine().toUpperCase().charAt(0);
            moveCharacter(moveTagger, true);

            if (taggerX == runnerX && taggerY == runnerY) {
                printMap();
                System.out.println("Tagger caught the runner! Game over.");
                break;
            }

            System.out.print("Move Runner (WASD): ");
            char moveRunner = scanner.nextLine().toUpperCase().charAt(0);
            moveCharacter(moveRunner, false);
        }

        scanner.close();
    }

    static void initializeMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = '.';
            }
        }
        map[taggerX][taggerY] = 'T'; // Tagger
        map[runnerX][runnerY] = 'R'; // Runner
    }

    static void moveCharacter(char direction, boolean isTagger) {
        int x = isTagger ? taggerX : runnerX;
        int y = isTagger ? taggerY : runnerY;
        if (x == runnerX && y == runnerY) return; // Don't erase runner

        map[x][y] = '.';

        switch (direction) {
            case 'W': x = Math.max(0, x - 1); break;
            case 'S': x = Math.min(SIZE - 1, x + 1); break;
            case 'A': y = Math.max(0, y - 1); break;
            case 'D': y = Math.min(SIZE - 1, y + 1); break;
            default: System.out.println("Invalid move."); break;
        }

        if (isTagger) {
            taggerX = x; taggerY = y;
            map[x][y] = 'T';
        } else {
            runnerX = x; runnerY = y;
            if (taggerX == runnerX && taggerY == runnerY) return;
            map[x][y] = 'R';
        }
    }

    static void printMap() {
        System.out.println();
        for (char[] row : map) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
