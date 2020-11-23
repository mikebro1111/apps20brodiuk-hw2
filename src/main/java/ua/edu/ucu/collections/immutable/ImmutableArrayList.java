package ua.edu.ucu.collections.immutable;

public final class ImmutableArrayList implements ImmutableList {

    private final Object[] array;

    public ImmutableArrayList(Object[] array) {
        this.array = array;
    }

    private void checkIndex(int index, boolean forInserting) {
        if ((index > array.length || index < 0) && forInserting)
            throw new IndexOutOfBoundsException();
        if ((index >= array.length || index < 0) && !forInserting)
            throw new IndexOutOfBoundsException();
    }

    @Override
    public ImmutableArrayList add(Object element) {
        return add(array.length, element);
    }

    @Override
    public ImmutableArrayList add(int index, Object element) {
        checkIndex(index, true);
        Object[] result = new Object[array.length + 1];
        System.arraycopy(array, 0, result, 0, index);
        result[index] = element;
        System.arraycopy(array, index, result, index + 1, array.length - index);
        return new ImmutableArrayList(result);
    }

    @Override
    public ImmutableArrayList addAll(Object[] copy) {
        return addAll(array.length, copy);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] copy) {
        checkIndex(index, true);
        Object[] result = new Object[array.length + copy.length];
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(copy, 0, result, index, copy.length);
        System.arraycopy(array, index, result, index + copy.length, array.length - index);
        return new ImmutableArrayList(result);
    }

    @Override
    public Object get(int index) {
        checkIndex(index, false);
        return array[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        checkIndex(index, false);
        Object[] result = new Object[array.length - 1];
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(array, index + 1, result, index, array.length - index - 1);
        return new ImmutableArrayList(result);
    }

    @Override
    public ImmutableArrayList set(int index, Object element) {
        checkIndex(index, false);
        array[index] = element;
        return new ImmutableArrayList(array);
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < array.length; i++)
            if (array[i].equals(element))
                return i;
        return -1;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList(new Object[]{});
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[array.length];
        System.arraycopy(array, 0, result, 0, array.length);
        return result;
    }

    public String toString() {
        if (array.length == 0)
            return "";
        StringBuilder result = new StringBuilder(array[0].toString());
        for (int i = 1; i < array.length; i++)
            result.append(", ").append(array[i].toString());
        return result.toString();
    }
}