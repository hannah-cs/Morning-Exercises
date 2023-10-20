package org.example;
import java.util.Arrays;
public class QueueExercise {
    private int queueLength;
    private int[] items;
    private int front = -1;
    private int back = -1;

    public QueueExercise(int maxSize) {
        queueLength = maxSize;
        this.items = new int[queueLength];
    }

    public boolean isEmpty() {
        return front == -1;
    }
    public boolean isFull() {
        return back == queueLength-1;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("The queue is full. Could not add "+item);
        } else {
            if (isEmpty()) {
                front = back = 0;
                items[back] = item;
            }
            back ++;
            items[back] = item;
            System.out.println("Enqueued "+item+". Queue contents: "+Arrays.toString(items));
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            int dequeuedItem = items[front];
            for (int i = front; i < back; i++) {
                items[i] = items[i + 1];
            }
            items[back] = 0;
            back -= 1;
            if (front == back) {
                front = -1;
                back = -1;
            } else {
                front = (front + 1);
            }
            System.out.println("Dequeued " + dequeuedItem + ". Queue contents: " + Arrays.toString(items));
        }
    }

    public void display(){
        System.out.println("Queue contents: "+Arrays.toString(items));
    }

    public void peek(){
        if (isEmpty()){
            System.out.println("The queue is empty.");
        } else {
            System.out.println("The first item in the queue is " + items[front]);
        }
    }

    public static void main(String[] args) {
        QueueExercise queue = new QueueExercise(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.display();
        queue.peek();

        queue.dequeue();

        queue.enqueue(4);
        queue.display();

        queue.enqueue(5);
    }
}