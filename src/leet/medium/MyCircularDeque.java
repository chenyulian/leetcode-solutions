package medium;

public class MyCircularDeque {
    private int data[];
    private int head;
    private int tail;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        data = new int[k + 1];
        head = 0;
        tail = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if(isFull()) {
            return false;
        }

        if(head > 0) {
            head--;
        }else{
            head = data.length - 1;

        }
        data[head] = value;

        return true;

    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }

        data[tail] = value;
        tail = (tail + 1) % data.length;

        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }
        data[head] = 0;
        head = (head + 1) % data.length;

        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }


        if(tail > 0) {
            tail = tail - 1;
        }else{
            tail = data.length - 1;
        }

        data[tail] = 0;

        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if(isEmpty()) {
            return -1;
        }
        return data[head];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if(isEmpty()) {
            return -1;
        }
        if(tail > 0) {
            return data[tail - 1];
        }else{
            return data[data.length - 1];
        }
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return head == (tail+1) % data.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("head [");
        for(int i = head; i != tail; i = (i + 1) % data.length) {
            if(i != tail-1){
                sb.append(data[i] + ", ");
            }else{
                sb.append(data[i]);
            }
        }
        sb.append("] tail");

        return sb.toString();
    }

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(5);
        for(int i = 0; i < 5; i ++) {
            deque.insertLast(i * 3 + 1);
        }
        System.out.println(deque);
        deque.deleteFront();
        System.out.println(deque);
        deque.deleteLast();
        System.out.println(deque);
        deque.insertFront(77);
        System.out.println(deque);
        deque.insertLast(88);
        System.out.println(deque);
        deque.insertLast(99);
        System.out.println(deque);
        System.out.println("head:"+deque.getFront());
        System.out.println("tail:"+deque.getRear());
    }

}
