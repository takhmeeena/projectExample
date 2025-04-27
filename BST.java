package hw2;

import java.util.ArrayList;
import java.util.Iterator;



public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size;

    class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }


    public int size() {
        return size;
    }


    public void put(K key, V val) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        root = put(root, key, val);
    }

    private Node put(Node x, K key, V val) {
        if (x == null) {
            size++;
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        return x;
    }


    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        return get(root, key);
    }

    private V get(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }


    public void delete(K key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        root = delete(root, key);
    }

    private Node delete(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            size--;
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }


    public Iterable<Node> iterator() {
        return new InOrderIterable();
    }

    private class InOrderIterable implements Iterable<Node> {
        private ArrayList<Node> list = new ArrayList<>();

        public InOrderIterable() {
            inOrder(root);
        }

        private void inOrder(Node x) {
            if (x == null) return;
            inOrder(x.left);
            list.add(x);
            inOrder(x.right);
        }

        public Iterator<Node> iterator() {
            return list.iterator();
        }
    }


    public K getKey(Node node) {
        if (node == null) throw new IllegalArgumentException("Node cannot be null");
        return node.key;
    }


    public V getValue(Node node) {
        if (node == null) throw new IllegalArgumentException("Node cannot be null");
        return node.val;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node x, String indent, boolean last) {
        if (x == null) return;
        System.out.println(indent + "+- " + x.key + ": " + x.val);
        indent += (last ? "   " : "|  ");
        printTree(x.left, indent, false);
        printTree(x.right, indent, true);
    }


    public void clear() {
        root = null;
        size = 0;
    }
}
