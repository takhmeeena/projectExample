package hw2;

import java.util.Random;

public class MyTestingClass {
    private final int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyTestingClass)) return false;
        MyTestingClass that = (MyTestingClass) o;
        return this.id == that.id;
    }

    @Override
    public String toString() {
        return "ID: " + id;
    }

    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>(50);
        Random rand = new Random();

        for (int i = 0; i < 10000; i++) {
            int id = rand.nextInt(100000);
            table.put(new MyTestingClass(id), "Student" + i);
        }

        System.out.println("Total size: " + table.size());
        table.printBucketSizes();
    }
}