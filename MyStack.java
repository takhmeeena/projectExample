package homeWork;

public class MyStack<T> {
    private MyArrayList<T> list = new MyArrayList<>();


    public void push(T t) {
        list.addLast(t);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = list.getLast();
        list.removeLast();
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getLast();
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
