package dsa;

public class Queue {

    private int front;
    private int rear;

    private int[] queue;
    private int size;

    Queue(int length) {

        queue = new int[length];
        front = 0;
        rear = -1;
        size = 0;
    
    }

    public void enqueue(int data) {
        queue[++rear] = data;
        size++;
    }


    public int dequeue() {

        return queue[front++];


    }
    
    public void show() {
        for(int i = front; i < size; i++) {
            System.out.print(queue[i] + " ");

        }
        System.out.println();
    }
}
