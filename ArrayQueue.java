import java.lang.reflect.Array;
import java.util.Objects;

public class ArrayQueue<T> implements Queue<T> {
    private T[] arr;
    private int head;
    private int tail;

    //Constructor
	public ArrayQueue() {
		arr = (T[]) new Object[10];
		head = 0;
		tail = 0;
    }

    // Doubles the array size
	public void grow_array() {
		T[] newarr = (T[]) new Object[arr.length*2];
        int count = 0;
        
		if (tail < head) {
            for (int i = head; i < arr.length; i++) {
                newarr[count] = arr[i];
                count++;
            }
        }
        for (int i = 0; i < tail; i++) {
            newarr[count] = arr[i];
            count++;
        }

        head = 0;
        tail = count;
        arr = newarr;
	}

    // Removes item the first/top item in the queue and returns it.
    @Override
	public T dequeue() {
		T curr = arr[head];
		head = head +1;
		if (head >= arr.length) {
			head = 0;
		}
		return curr;
	}

    // Adds item to the end of the queue
    @Override
	public void enqueue(T item) {
        if ((tail + 1) % arr.length == head) {
			grow_array();
		}
        arr[tail] = item;
        tail = tail +1;
		if (tail >= arr.length) {
			tail = 0;
		}
    }

    // Checks if array is empty
    @Override
	public boolean empty() {
	    if (head == tail) {
            return true;
        }
        return false;
    }
}