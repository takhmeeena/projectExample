#Custom Java Data Structures

Welcome to a custom-built collection of Java data structures, created from scratch to demonstrate the fundamentals of how arrays, lists, heaps, stacks, and queues work behind the scenes.

All classes are part of the `homeWork` package and use Java Generics for flexibility across different data types.




#Package Structure

The structure below shows the organization of the project inside the `homeWork` package:

#Built With

- Java 8 or newer
- No external dependencies



#Interface: `MyList<T>`

Defines a set of common list operations used across both array and linked list implementations.

#Key Methods:

- `add(T item)`
- `add(int index, T item)`
- `addFirst(T item)`, `addLast(T item)`
- `get(int index)`, `getFirst()`, `getLast()`
- `remove(int index)`, `removeFirst()`, `removeLast()`
- `sort()`
- `indexOf(Object obj)`, `lastIndexOf(Object obj)`
- `exists(Object obj)`
- `toArray()`
- `clear()`
- `size()`
- `iterator()`



#Implementations

#`MyArrayList<T>`

- Backed by a dynamic array
- Resizes automatically
- Supports indexed access
- Custom `bubbleSort()` for sorting

#`MyLinkedList<T>`

- Doubly linked structure (nodes with `prev` and `next`)
- Efficient head/tail operations
- Converts to array before sorting
- Custom iterator



#Additional Data Structures

# `MyMinHeap`

- Stores integers in min-heap order
- Maintains heap property with `heapifyUp()` and `heapifyDown()`
- Key Methods: `add()`, `poll()`, `peek()`, `isEmpty()`

# `MyQueue<T>`

- Queue implementation using `MyLinkedList`
- FIFO behavior
- Methods: `enqueue()`, `dequeue()`, `peek()`, `isEmpty()`, `size()`, `clear()`

#`MyStack<T>`

- Stack built with `MyArrayList`
- LIFO behavior
- Methods: `push()`, `pop()`, `peek()`, `isEmpty()`, `size()`, `clear()`


#How to Use

Each structure can be tested by writing a quick `main()` function. Example:

MyStack<Integer> stack = new MyStack<>();
stack.push(10);
stack.push(20);
System.out.println(stack.pop()); // Output: 20