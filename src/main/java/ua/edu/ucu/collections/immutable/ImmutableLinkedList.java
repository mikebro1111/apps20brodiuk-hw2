package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList{
    private Node main;
    private int length;

    public ImmutableLinkedList() {
        this.main = null;
        this.length = 0;
    }

    public ImmutableLinkedList(Object[] array) {
        if (array.length != 0) {
            this.main = new Node(array[0]);
            Node current = this.main;
            for (int i = 1; i < array.length; i++) {
                current.next = new Node(array[i]);
                current = current.next;
            }
        }
        length = array.length;
    }

    private ImmutableLinkedList copy() {
        if (length == 0)
            return new ImmutableLinkedList();
        ImmutableLinkedList newList = new ImmutableLinkedList();
        newList.main = new Node(main.data);
        Node current = main.next;
        Node currentCopy = newList.main;
        while (current != null) {
            currentCopy.next = new Node(current.data);
            current = current.next;
            currentCopy = currentCopy.next;
        }
        copyList.length = length;
        return newList;
    }

    private Node getNode(int index) {
        if (index > length || index < 0 || length == 0)
            throw new IndexOutOfBoundsException();
        Node current = main;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current;
    }

    private void checkIndex(int index) {
        if (index > length || index < 0)
            throw new IndexOutOfBoundsException();
    }

    @Override
    public ImmutableLinkedList add(Object element) {
        return add(length, element);
    }


    @Override
    public ImmutableLinkedList add(int index, Object element) {
        checkIndex(index);
        ImmutableLinkedList resultList = copy();
        if (index == 0)
            resultList.main = new Node(element, resultList.main);
        else {
            Node previous = resultList.getNode(index - 1);
            previous.next = new Node(element, previous.next);
        }
        resultList.length = length + 1;
        return resultList;
    }


    @Override
    public ImmutableLinkedList addAll(Object[] copy) {
        return addAll(length, copy);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] copy) {
        checkIndex(index);
        ImmutableLinkedList resultList = copy();
        resultList.main = new Node(null, resultList.main);
        if (copy.length > 0) {
            Node current = resultList.getNode(index);
            for (Object obj : copy) {
                current.next = new Node(obj, current.next);
                current = current.next;
            }
        }
        resultList.main = resultList.main.next;
        return resultList;
    }

    @Override
    public Object get(int index) {
        return getNode(index).data;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        checkIndex(index);
        ImmutableLinkedList resultList = copy();
        if (index == 0)
            resultList.main = resultList.main.next;
        else {
            Node previous = resultList.getNode(index - 1);
            previous.next = previous.next.next;
        }
        resultList.length = length - 1;
        return resultList;
    }

    @Override
    public ImmutableLinkedList set(int index, Object element) {
        ImmutableLinkedList resultList = copy();
        resultList.getNode(index).data = element;
        return resultList;
    }

    @Override
    public int indexOf(Object element) {
        Node current = main;
        for (int i = 0; i < length; i++) {
            if (current.data.equals(element))
                return i;
            current = current.next;
        }
        return -1;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        Node current = main;
        for (int i = 0; i < length; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    public String toString() {
        if (main == null)
            return "";
        StringBuilder result = new StringBuilder(main.data.toString());
        Node current = main.next;
        while (current != null) {
            result.append(", ").append(current.data.toString());
            current = current.next;
        }
        return result.toString();
    }

    public ImmutableLinkedList addFirst(Object element) {
        return (ImmutableLinkedList) add(0, element);
    }

    public ImmutableLinkedList addLast(Object element) {
        return (ImmutableLinkedList) add(element);
    }

    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return get(length - 1);
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(length - 1);
    }



    private static class Node {
        private Object data;
        private Node next;

        private Node(Object obj) {
            data = obj;
            next = null;
        }

        private Node(Object obj, Node nextNode) {
            data = obj;
            next = nextNode;
        }

    }




}
