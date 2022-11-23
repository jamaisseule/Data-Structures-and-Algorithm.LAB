package implementations;

import interfaces.AbstractStack;
import org.w3c.dom.Node;

import javax.annotation.Nonnull;
import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> { // thêm vào cuối cùng lấy ra đầu tiên
    private Node<E> top;
    private int size;
    private static class Node<E>{
        E element;
        Node<E> previous;
        public Node( E element){
            this(element,null);
        }
        public Node(E element, Node<E> previous){
            this.element = element;
            this.previous = previous;
        }
    }
    public Stack(){

    }
    @Override
    public void push(E element) { //nhập dô
        Node<E> newNode = new Node<>(element);
        newNode.previous = top;
        top = newNode;
        this.size++;
    }

    @Override
    public E pop() {  //lấy từng cái ra
        ensureNonEmpty();
        E element = this.top.element;
        Node<E> temp = this.top.previous;
        this.top.previous = null;
        this.top = temp;
        this.size--;
        return element;
//        return null;
    }

    @Override
    public E peek() {
        ensureNonEmpty();
        return this.top.element;  //lấy element trên cùng
//        return null;
    }
    private void ensureNonEmpty() {
        if (size == 0) throw new IllegalStateException("Stack is Empty!");
    }
    @Override
    public String toString() {
        Node<E> current = top;
        StringBuilder result = new StringBuilder();
        while(current != null){
            result.append(current.element+ "\n");
            current = current.previous;
        }
        return result.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Nonnull
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Stack.Node<E> current = top;

            @Override
            public boolean hasNext() {
                return current != null;
//                return false;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.previous;
                return element;
            }
        };
    }
}
