package homeWork;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyLinkedList<T> implements MyList<T> {

    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head, tail;
    private int size;

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        MyNode node = getNode(index);
        node.data = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (index == size) {
            addLast(item);
            return;
        }
        MyNode nextNode = getNode(index);
        MyNode prevNode = nextNode.prev;
        MyNode newNode = new MyNode(item);
        newNode.next = nextNode;
        newNode.prev = prevNode;
        if (prevNode != null) {
            prevNode.next = newNode;
        } else {
            head = newNode;
        }
        nextNode.prev = newNode;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        if (size == 0) throw new NoSuchElementException("List is empty");
        return head.data;
    }

    @Override
    public T getLast() {
        if (size == 0) throw new NoSuchElementException("List is empty");
        return tail.data;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        MyNode node = getNode(index);
        removeNode(node);
    }

    @Override
    public void removeFirst() {
        if (size == 0) throw new NoSuchElementException("List is empty");
        removeNode(head);
    }

    @Override
    public void removeLast() {
        if (size == 0) throw new NoSuchElementException("List is empty");
        removeNode(tail);
    }

    @Override
    public void sort() {
        if (size <= 1) return;
        MyNode currentNode = head;
        T[] array = (T[]) new Object[size];
        int i = 0;
        while (currentNode != null) {
            array[i++] = currentNode.data;
            currentNode = currentNode.next;
        }
        if (array[0] instanceof Comparable) {
            Arrays.sort(array);
        } else {
            throw new UnsupportedOperationException("Items in the list must be Comparable for sorting.");
        }
        currentNode = head;
        for (i = 0; i < size; i++) {
            currentNode.data = array[i];
            currentNode = currentNode.next;
        }
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (MyNode node = head; node != null; node = node.next) {
            if (node.data.equals(object)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        for (MyNode node = tail; node != null; node = node.prev) {
            if (node.data.equals(object)) {
                return index;
            }
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (MyNode node = head; node != null; node = node.next) {
            array[index++] = node.data;
        }
        return array;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private MyNode node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (node == null) {
                    throw new NoSuchElementException("No more elements");
                }
                T data = node.data;
                node = node.next;
                return data;
            }
        };
    }

    private void removeNode(MyNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        size--;
    }

    private MyNode getNode(int index) {
        MyNode currentNode;
        if (index < size / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }
}
