package homeWork;

public class MyMinHeap {
    private MyArrayList<Integer> heap = new MyArrayList<>();


    public void add(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }



    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }


    public boolean isEmpty() {
        return heap.size() == 0;
    }


    public int poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int min = heap.get(0);
        int last = heap.get(heap.size() - 1);
        heap.set(0, last);
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return min;
    }


    private void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(parent) > heap.get(i)) {
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }


    private void heapifyDown(int i) {
        int left, right, smallest;
        while (true) {
            left = 2 * i + 1;
            right = 2 * i + 2;
            smallest = i;


            if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }


            if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }


            if (smallest != i) {
                swap(i, smallest);
                i = smallest;
            } else {
                break;
            }
        }
    }


    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
