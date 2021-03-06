package ua.edu.ucu.collections.immutable;

// У результаті змін, що призводять на модифікації (зміну стану) колекції має повртатись нова колекція
public interface ImmutableList {

    ImmutableList add(Object element); //додає елемент у кінець колекції

    ImmutableList add(int index, Object element); //додає елемент до колекції за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    ImmutableList addAll(Object[] copy); //додає масив елементів у кінець колекції

    ImmutableList addAll(int index, Object[] copy); // додає масив елементів починаючи з зазначеного індекса, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    Object get(int index); //повертає елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    ImmutableList remove(int index); //видаляє елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    ImmutableList set(int index, Object element); //змінює значення елементу за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    int indexOf(Object element); //шукає індекс елемента (повертає індекс першого який знайшов, або -1 у випадку відсутності)

    int size(); //розмір колекції

    ImmutableList clear(); //очищує вміст колекції

    boolean isEmpty(); //якщо у колеції нема елементів то повертає true

    Object[] toArray(); //перетворює колекцію до масиву обєктів

    @Override
    String toString(); //повертає рядок, де через кому відображаютсься елементи колекції
}
