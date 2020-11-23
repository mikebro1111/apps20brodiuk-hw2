package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    
    @Test
    public void testEmptyConstructor() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        assertEquals(0, linkedList.size(), 0.0);
    }

    @Test
    public void testConstructor() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        String res = "12, 3.0, hello";
        assertEquals(res, linkedList.toString());
    }

    @Test
    public void testAddObject() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.add(0);
        String res = "12, 3.0, hello, 0";

        assertEquals(res, linkedList.toString());
    }

    @Test
    public void testInsertObject() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.add(2, 0);
        String res = "12, 3.0, 0, hello";

        assertEquals(res, linkedList.toString());
    }

    @Test
    public void testInsertFirstObject() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.add(0, 0);
        String res = "0, 12, 3.0, hello";

        assertEquals(res, linkedList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertObjectException() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.add(7, 0);
    }

    @Test
    public void testAddAll() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        Object[] add = {0, "end"};
        linkedList = (ImmutableLinkedList) linkedList.addAll(add);
        String res = "12, 3.0, hello, 0, end";

        assertEquals(res, linkedList.toString());
    }

    @Test
    public void testInsertAll() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        Object[] add = {0, "end"};
        linkedList = (ImmutableLinkedList) linkedList.addAll(2, add);
        String res = "12, 3.0, 0, end, hello";

        assertEquals(res, linkedList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertAllException() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        Object[] add = {0, "end"};
        linkedList = (ImmutableLinkedList) linkedList.addAll(-2, add);
    }


    @Test
    public void testRemove() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.remove(1);
        String res = "12, hello";

        assertEquals(res, linkedList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveException() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.remove(4);
    }

    @Test
    public void testGet() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        String res = "hello";

        assertEquals(res, linkedList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.get(100);
    }

    @Test
    public void testSet() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.set(2, "new");
        String res = "12, 3.0, new";

        assertEquals(res, linkedList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetException() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.set(-1, 0);
    }

    @Test
    public void testIndexOf() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        assertEquals(2, linkedList.indexOf("hello"));
    }

    @Test
    public void testIndexOfNotFound() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        assertEquals(-1, linkedList.indexOf(7));
    }

    @Test
    public void testSize() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        assertEquals(3, linkedList.size());
    }

    @Test
    public void testClear() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.clear();
        assertEquals("", linkedList.toString());
    }

    @Test
    public void testIsEmpty() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        assertFalse(linkedList.isEmpty());
    }

    @Test
    public void testToArray() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        assertArrayEquals(arr, linkedList.toArray());
    }

    @Test
    public void testToString() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        String str = linkedList.toString();
        String res = "12, 3.0, hello";
        assertEquals(res, str);
    }

    @Test
    public void testAddFirst() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.addFirst(0);
        String res = "0, 12, 3.0, hello";

        assertEquals(res, linkedList.toString());
    }

    @Test
    public void testAddLast() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.addLast(0);
        String res = "12, 3.0, hello, 0";

        assertEquals(res, linkedList.toString());
    }

    @Test
    public void testGetFirst() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        int res = 12;

        assertEquals(res, linkedList.getFirst());
    }

    @Test
    public void testGetLast() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        String res = "hello";

        assertEquals(res, linkedList.getLast());
    }

    @Test
    public void testRemoveFirst() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.removeFirst();
        String res = "3.0, hello";

        assertEquals(res, linkedList.toString());
    }

    @Test
    public void testRemoveLast() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.removeLast();
        String res = "12, 3.0";

        assertEquals(res, linkedList.toString());
    }
}
