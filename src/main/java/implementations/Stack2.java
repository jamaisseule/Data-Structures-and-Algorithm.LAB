package implementations;

import interfaces.AbstractStack;

import javax.annotation.Nonnull;
import java.util.Iterator;

public class Stack2<E> implements AbstractStack<E> {
    private static final int MAX = 100;
    private int top;
    private int length;
    private final E[] elements;
    public Stack2(){
        elements =  (E[])new Object[MAX];
        top = -1;
        length = 0;
    }
    @Override
    public void push(E element) { // nhập dô
        ensureNonMax();
        elements[++top] = element;
        length++;
    }

    @Override
    public E pop() {  //lấy từng cái ra
        ensureNonMax();
        E element = elements[top--];
        length--;
        return element;
//        return null;
    }
    @Override
    public E peek() {
        ensureNonMax();
        return elements[top];
//        return null;
    }
    @Override
    public String toString() {
        int current = top;
        StringBuilder result = new StringBuilder();
        while(current >= 0){
            result.append(elements[current]+ "\n");
            current--;
        }
        return result.toString();
    }
    private void ensureNonMax() {
        if (length == MAX) throw new IllegalStateException("Stack Overflow!");
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }
    @Nonnull
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = top;
            @Override
            public boolean hasNext() {
                return index >= 0;
            }
            @Override
            public E next() {
                E element = elements[index];
                index--;
                return element;
            }
        };
    }
}
