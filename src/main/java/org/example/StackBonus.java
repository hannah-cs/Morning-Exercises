package org.example;

import java.util.Arrays;

public class StackBonus<T>{
    int maxSize;
    int initialMaxSize;

    T[] stackArray;
    int top;


    public StackBonus(int s) {
        maxSize = s;
        this.stackArray = (T[]) new Object[maxSize];
        top = -1;
        initialMaxSize = s;
    }


    public boolean isFull(){
        return top == maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(T j) {
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
            T poppedElement = stackArray[top];
            for (int i = 0; i < top; i++) {
                stackArray[i] = stackArray[i + 1];
            }
            stackArray[top] = null ;
            top--;
            long populatedElements = Arrays.stream(stackArray)
                    .filter(element -> element != null)
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

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            str.append(stackArray[i]);
            if (i < top) {
                str.append(", ");
            }
        }
        return str.toString();
    }

    public void peek(){
        if (isEmpty()){
            System.out.println("The stack is empty.");
        } else {
            System.out.println("The top item in the stack is " + stackArray[top]);
        }
    }

    public static class StackEmptyException extends Exception {
        public StackEmptyException(String message) {
            super(message);
        }
    }


    public static void main(String[] args) throws StackEmptyException {
        StackBonus<String> newStack = new StackBonus<>(3);
        newStack.push("Hello");
        newStack.push("World");
        newStack.push("!");
        System.out.println(newStack.toString());
        System.out.println("Max size: "+newStack.maxSize+", current size: "+newStack.size());
        newStack.push(" :)");
        System.out.println("Max size: "+newStack.maxSize+", current size: "+newStack.size());
        newStack.pop();
        newStack.pop();
        newStack.pop();
        System.out.println("Max size: "+newStack.maxSize+", current size: "+newStack.size());
    }
}