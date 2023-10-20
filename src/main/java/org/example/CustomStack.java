package org.example;
import java.util.Arrays;

public class CustomStack {
    int maxSize;

    long[] stackArray;
    int top;

    public CustomStack(int s) {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(long j) throws StackFullException {
        if (isFull()) {
            throw new StackFullException("The stack is full. Could not add "+j);
        } else {
            top ++;
            stackArray[top] = j;
            System.out.println("Pushed "+j+". Stack contents: "+ Arrays.toString(stackArray));
        }
    }

    public void pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("The stack is empty.");
        } else {
            long poppedElement = stackArray[top];
            for (int i = 0; i < top; i++) {
                stackArray[i] = stackArray[i + 1];
            }
            stackArray[top] = 0 ;
            top -= 1;
            System.out.println("Popped " + poppedElement + ". Stack contents: " + Arrays.toString(stackArray));
        }
    }

    public void peek(){
        if (isEmpty()){
            System.out.println("The stack is empty.");
        } else {
            System.out.println("The top item in the stack is " + stackArray[top]);
        }
    }

    public class StackFullException extends Exception {
        public StackFullException(String message) {
            super(message);
        }
    }

    public class StackEmptyException extends Exception {
        public StackEmptyException(String message) {
            super(message);
        }
    }


    public static void main(String[] args) throws StackFullException, StackEmptyException {
        CustomStack newStack = new CustomStack(3);
        newStack.push(123);
        newStack.push(321);
        newStack.push(456);
        newStack.push(654);
        newStack.peek();
        newStack.pop();
    }
}