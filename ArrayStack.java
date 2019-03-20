public class ArrayStack<T> implements Stack<T> {
    private int top; // The first index
    private T[] arr;  // Declare initial size

    // Constructor
    public ArrayStack() {
        arr = (T[]) new Object[10];
        top = -1;
    }

    // Adds the item onto the top of the stack and if full it grows the array
    @Override
    public void push(T item) {
        if (top == arr.length-1) {
            grow_array();
        }
        arr[++top] = item;
    }

    // Doubles the array size if the array is full
    private void grow_array() {
        T[] newarr = (T[]) new Object[arr.length*2];
        for (int i =0; i<arr.length; i++) {
            newarr[i] = arr[i];
        }
        arr = newarr;
    }

    // Returns the end of the array and de-increments the top of the array
    @Override
    public T pop() {
        if (!empty()) {
            return arr[top--];
        }
        throw new IllegalArgumentException("Array is Empty");
    }

    // Returns the top element of the array if not empty.
    @Override
    public T peek() {
        if (!empty()) {
            return arr[top];
        }
        throw new IllegalArgumentException("Array is Empty");
    }

    // If the top is equal to -1, then it is empty and return result
    @Override
    public boolean empty() {
        return (top == -1);
    }
}