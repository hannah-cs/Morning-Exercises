package org.example;

import java.util.Arrays;

public class StackBonus{
    int maxSize;
    int initialMaxSize;

    long[] stackArray;
    int top;


    public StackBonus(int s) {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
        initialMaxSize = s;
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(long j) {
        if (isFull()) {
            int newMaxSize = maxSize*2;
            stackArray = Arrays.copyOf(stackArray, newMaxSize);
            maxSize = newMaxSize;
        }
            top ++;
            stackArray[top] = j;
            System.out.println("Pushed "+j+". Stack contents: "+ Arrays.toString(stackArray));
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
            top--;
            long populatedElements = Arrays.stream(stackArray)
                    .filter(element -> element != 0)
                    .count();
            if (populatedElements <= maxSize / 4 && maxSize > initialMaxSize) {
                int newMaxSize = maxSize / 2;
                if (newMaxSize < initialMaxSize) {
                    newMaxSize = initialMaxSize;
                }
                maxSize = newMaxSize;
                stackArray = Arrays.copyOf(stackArray, maxSize);
            }
            System.out.println("Popped " + poppedElement + ". Stack contents: " + Arrays.toString(stackArray));
        }
    }

    public int size(){
        return top+1;
    }

    public void peek(){
        if (isEmpty()){
            System.out.println("The stack is empty.");
        } else {
            System.out.println("The top item in the stack is " + stackArray[top]);
        }
    }

    public class StackEmptyException extends Exception {
        public StackEmptyException(String message) {
            super(message);
        }
    }


    public static void main(String[] args) throws StackEmptyException {
        StackBonus newStack = new StackBonus(3);
        newStack.push(123);
        newStack.push(321);
        newStack.push(456);
        System.out.println("Max size: "+newStack.maxSize+", current size: "+newStack.size());
        newStack.push(456);
        System.out.println("Max size: "+newStack.maxSize+", current size: "+newStack.size());
        newStack.pop();
        newStack.pop();
        newStack.pop();
        System.out.println("Max size: "+newStack.maxSize+", current size: "+newStack.size());
    }
}
