package dsa;

public class QueueMain {

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(12);
        queue.enqueue(10);

        queue.dequeue();

        queue.show();
    }

}
