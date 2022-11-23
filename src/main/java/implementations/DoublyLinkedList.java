package implementations;

import interfaces.LinkedList;
import org.w3c.dom.Node;

import java.util.Iterator;

public class DoublyLinkedList<E> implements LinkedList<E> {
    private Node<E> head, tail;
    private int size;
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;
        public Node( E element){
            this(element,null,null);
        }
        public Node(E element, Node<E> next, Node<E> prev){
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        this.size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> newNode = new Node(element);
        if (head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        ensureNonEmpty();
        E data = head.element;
//        head = head.next;
        if(head.next == null){
            tail = null;
        } else {
            head.next.prev = null;
        }
        head = head.next;
        size--;
        return data;
    }

    @Override
    public E removeLast() {
        ensureNonEmpty();
        E data = tail.element;
        if(head.next == null){
            head = null;
        } else {
            tail.prev.next = null;
        }
        tail = tail.prev;
        size--;
        return data;
    }
    public String displayFirstToLast(){
        Node<E> current = head;
        StringBuilder result = new StringBuilder();
        while(current!=null){
            result.append(current.element+ "\n");
            current = current.next;
        }
        return result.toString();
    }
    public String displayLastToFirst(){
        Node<E> current = tail;
        StringBuilder result = new StringBuilder();
        while(current!=null){
            result.append(current.element+ "\n");
            current = current.prev;
        }
        return result.toString();
    }
    private void ensureNonEmpty() {
        if (size == 0) throw new IllegalStateException("Linklist is empty");
    }


    @Override
    public E getFirst() {
        return head.element;
    }

    @Override
    public E getLast() {
        return tail.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return  new Iterator<E>() {
            DoublyLinkedList.Node<E> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }
}
