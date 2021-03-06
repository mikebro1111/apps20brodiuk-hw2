package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {

    private ImmutableLinkedList stack;

    public Stack() {
        stack = new ImmutableLinkedList();
    }

    public void push(Object object) {
        stack = stack.addFirst(object);
    }

    public Object peek() {
        return stack.getFirst();
    }

    public Object pop() {
        Object removedElement = stack.getFirst();
        stack = stack.removeFirst();
        return removedElement;
    }

}
