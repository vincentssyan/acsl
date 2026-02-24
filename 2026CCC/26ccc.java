import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine(); 


        Set<String> visited = new HashSet<>();
        int x = 0, y = 0; 
        visited.add(x + "," + y); 

        int slimyCount = 0;

        for (int i = 0; i < M; i++) {
            String move = sc.nextLine();
            char dir = move.charAt(0);
            int steps = Integer.parseInt(move.substring(1));

            for (int j = 0; j < steps; j++) {
                // move snail
                switch (dir) {
                    case 'N': y++; break;
                    case 'S': y--; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }
                String pos = x + "," + y;
                if (visited.contains(pos)) {
                    slimyCount++; 
                } else {
                    visited.add(pos); 
                }
            }
        }

        System.out.println(slimyCount);
    }
}
