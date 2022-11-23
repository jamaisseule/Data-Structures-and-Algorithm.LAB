package implementations;

import interfaces.AbstractQueue;
import org.w3c.dom.Node;

import java.util.Iterator;

public class Queue2<E> implements AbstractQueue<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int rear;
    private E[] queue;
    public Queue2() {
        rear = -1;
        queue = (E[]) new Object[DEFAULT_CAPACITY];
    }
    @Override
    public void offer(E element) {
        if(rear == queue.length-1){
            throw new IllegalStateException("Stack Overflow!");
        }
        queue[++rear] = element;
    }

    @Override
    public E poll() {
        ensureNonEmpty();
        E element = queue[0];  //lấy dữ liệu đó ra
        for(int i = 0; i < rear; i++){ //đẩy ngược trở lại để xoá 1 phần tử nó k bị trống chỗ
            queue[i] = queue[i+1];
        }
        rear--;
        return element;
    }
    private void ensureNonEmpty() {
        if (rear == -1) throw new IllegalStateException("Empty!");
    }
    @Override
    public String toString() {
        int current = 0;
        StringBuilder result = new StringBuilder();
        while(current <= rear){
            result.append(queue[current]+ "\n");
            current++;
        }
        return result.toString();
    }

    @Override
    public E peek() {
        ensureNonEmpty();
        return queue[0];
    }

    @Override
    public int size() {
        return rear+1;
    }

    @Override
    public boolean isEmpty() {
        return rear==-1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index <= rear;
            }
            @Override
            public E next() {
                return queue[index++];
            }
        };
    }
}

