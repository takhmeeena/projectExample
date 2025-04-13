package homeWork;

public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();


    public void enqueue(T t) {
        list.addLast(t);
    }



    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }


    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }


    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();

    }

    public void clear() {
        list.clear();
    }
}
