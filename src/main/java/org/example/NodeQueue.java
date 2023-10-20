package org.example;

public class NodeQueue {
    private int length;
    private Node first;
    private Node last;

    public NodeQueue(int value) {
        this.length = 1;
        first = new Node(value);
        last = first;
    }

    public class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void enqueue(int value){
        Node newNode = new Node(value);
        if (this.length == 0){
            this.first = newNode;
            this.last = newNode;
        } else {
            last.next = newNode;
            this.last = newNode;
            length++;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("First: null");
            System.out.println("Last: null");
        } else {
            System.out.println("First: " + first.value);
            System.out.println("Last: " + last.value);
        }
        System.out.println("Length:" + length);
        System.out.println("Queue:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void printList() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        NodeQueue myQueue = new NodeQueue(4);
        myQueue.printAll();
        System.out.println("___");
        myQueue.enqueue(5);
        myQueue.printAll();
    }
}