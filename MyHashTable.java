package hw2;

public class MyHashTable<K, V> {
    private static class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M;
    private int size;


    public MyHashTable() {
        this.M = 11;
        this.chainArray = (HashNode<K, V>[]) new HashNode[M];
        this.size = 0;
    }

    public MyHashTable(int M) {
        if (M <= 0) throw new IllegalArgumentException("Number of chains must be positive");
        this.M = M;
        this.chainArray = (HashNode<K, V>[]) new HashNode[M];
        this.size = 0;
    }

    private int hash(K key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        return Math.abs(key.hashCode()) % M;
    }

    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];


        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }


        size++;
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;


        if (size > M * 0.75) {
            resize(2 * M);
        }
    }

    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public V remove(K key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];
        HashNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }

        if (head == null) return null;

        size--;
        if (prev != null) {
            prev.next = head.next;
        } else {
            chainArray[index] = head.next;
        }

        return head.value;
    }

    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> head = chainArray[i];
            while (head != null) {
                if (value == null) {
                    if (head.value == null) return true;
                } else if (value.equals(head.value)) {
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> head = chainArray[i];
            while (head != null) {
                if (value == null) {
                    if (head.value == null) return head.key;
                } else if (value.equals(head.value)) {
                    return head.key;
                }
                head = head.next;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    private void resize(int newSize) {
        MyHashTable<K, V> newTable = new MyHashTable<>(newSize);

        for (int i = 0; i < M; i++) {
            HashNode<K, V> head = chainArray[i];
            while (head != null) {
                newTable.put(head.key, head.value);
                head = head.next;
            }
        }

        this.chainArray = newTable.chainArray;
        this.M = newTable.M;
    }

    public void printBucketSizes() {
        for (int i = 0; i < M; i++) {
            int count = 0;
            HashNode<K, V> head = chainArray[i];
            while (head != null) {
                count++;
                head = head.next;
            }
            System.out.println("Bucket " + i + " has " + count + " elements.");
        }
    }

    public void printHashTable() {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> head = chainArray[i];
            System.out.print("Bucket " + i + ": ");
            while (head != null) {
                System.out.print(head + " -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }
}
