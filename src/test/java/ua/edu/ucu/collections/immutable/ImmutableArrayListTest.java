package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    
    @Test
    public void testConstructor() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
    }

    @Test
    public void testAddObject() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        arrayList = (ImmutableArrayList) arrayList.add(0);
        String res = "12, 3.0, hello, 0";

        assertEquals(res, arrayList.toString());
    }

    @Test
    public void testInsertObject() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        arrayList = (ImmutableArrayList) arrayList.add(2, 0);
        String res = "12, 3.0, 0, hello";

        assertEquals(res, arrayList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertObjectException() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        arrayList = (ImmutableArrayList) arrayList.add(7, 0);
    }

    @Test
    public void testAddAll() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        Object[] add = {0, "end"};
        arrayList = (ImmutableArrayList) arrayList.addAll(add);
        String res = "12, 3.0, hello, 0, end";

        assertEquals(res, arrayList.toString());
    }

    @Test
    public void testInsertAll() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        Object[] add = {0, "end"};
        arrayList = (ImmutableArrayList) arrayList.addAll(2, add);
        String res = "12, 3.0, 0, end, hello";

        assertEquals(res, arrayList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertAllException() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        Object[] add = {0, "end"};
        arrayList = (ImmutableArrayList) arrayList.addAll(-2, add);
    }

    @Test
    public void testRemove() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        arrayList = (ImmutableArrayList) arrayList.remove(1);
        String res = "12, hello";

        assertEquals(res, arrayList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveException() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        arrayList = (ImmutableArrayList) arrayList.remove(3);
    }

    @Test
    public void testGet() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        String res = "hello";

        assertEquals(res, arrayList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        arrayList = (ImmutableArrayList) arrayList.get(100);
    }

    @Test
    public void testSet() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        arrayList = (ImmutableArrayList) arrayList.set(2, "new");
        String res = "12, 3.0, new";

        assertEquals(res, arrayList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetException() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        arrayList = (ImmutableArrayList) arrayList.set(-1, 0);
    }

    @Test
    public void testIndexOf() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        assertEquals(2, arrayList.indexOf("hello"));
    }

    @Test
    public void testIndexOfNotFound() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        assertEquals(-1, arrayList.indexOf(7));
    }

    @Test
    public void testSize() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        assertEquals(3, arrayList.size());
    }

    @Test
    public void testClear() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        arrayList = (ImmutableArrayList) arrayList.clear();
        assertEquals("", arrayList.toString());
    }

    @Test
    public void testIsEmpty() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        assertFalse(arrayList.isEmpty());
    }

    @Test
    public void testToArray() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        assertArrayEquals(arr, arrayList.toArray());
    }

    @Test
    public void testToString() {
        Object[] array = {12, 3.0, "hello"};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        String str = arrayList.toString();
        String res = "12, 3.0, hello";
        assertEquals(res, str);
    }

}