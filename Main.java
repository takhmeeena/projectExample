package hw2;

public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();

        System.out.println("=== Inserting nodes ===");
        bst.put(70, "A");
        bst.put(90, "B");
        bst.put(100, "C");
        bst.put(40, "D");
        bst.put(20, "E");
        bst.put(50, "F");
        bst.put(95, "G");

        bst.printTree();

        System.out.println("\n=== Size of tree ===");
        System.out.println("Size: " + bst.size());

        System.out.println("\n=== Getting values ===");
        System.out.println("Get 30: " + bst.get(30));
        System.out.println("Get 70: " + bst.get(70));
        System.out.println("Get 100 (non-existent): " + bst.get(100));

        System.out.println("\n=== Contains check ===");
        System.out.println("Contains 60? " + bst.contains(60));
        System.out.println("Contains 100? " + bst.contains(100));

        System.out.println("\n=== In-order traversal ===");
        for (BST<Integer, String>.Node node : bst.iterator()) {
            System.out.println("Key: " + bst.getKey(node) + ", Value: " + bst.getValue(node));
        }

        System.out.println("\n=== Deleting nodes ===");
        System.out.println("Delete 20 (leaf node)");
       bst.delete(20);
        bst.printTree();

        System.out.println("Delete 30 (node with one child)");
        bst.delete(30);
        bst.printTree();

        System.out.println("Delete 50 (node with two children - root)");
        bst.delete(50);
        bst.printTree();

        System.out.println("\nSize after deletions: " + bst.size());

        System.out.println("\n=== Clearing tree ===");
        bst.clear();
        bst.printTree();
        System.out.println("Size after clear: " + bst.size());

    }
}
