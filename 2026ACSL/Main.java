import java.util.LinkedList;
import java.util.Queue;

// Node class
class CharNode {
    char value;
    CharNode left, right;

    public CharNode(char value) {
        this.value = value;
        left = right = null;
    }
}

// Tree class (ASCII-based)
class AsciiTree {
    CharNode root;

    public void insert(char value) {
        root = insertRec(root, value);
    }

    private CharNode insertRec(CharNode node, char value) {
        if (node == null) {
            return new CharNode(value);
        }

        // ASCII comparison (your way)
        int newVal = (int) value;
        int currentVal = (int) node.value;

        if (newVal < currentVal) {
            node.left = insertRec(node.left, value);
        } else {
            node.right = insertRec(node.right, value);
        }

        return node;
    }
}

public class Main {
    public static void main(String[] args) {
        AsciiTree tree = new AsciiTree();

        String input = "guesswhat";

        // Insert each character
        for (char c : input.toCharArray()) {
            tree.insert(c);
        }

        // Print in level-order (your output style)
        printLevelOrder(tree.root);
    }

    // Level-order traversal (BFS)
    public static void printLevelOrder(CharNode root) {
        if (root == null) return;

        Queue<CharNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            CharNode current = queue.poll();

            System.out.print(current.value);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}