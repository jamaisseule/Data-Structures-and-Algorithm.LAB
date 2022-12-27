package implementations;

import interfaces.LinkedList;
import org.w3c.dom.Node;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {
    private Node<E> head, tail;
    private int size;
    private static class Node<E> {
        E element;
        Node<E> next;
        public Node( E element){
            this(element,null);
        }
        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }
    }
    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
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
            tail = newNode;
        }
        size++;
    }


    public void addMid(E element) {
        Node<E> newNode = new Node(element);
        if (head == null){
            head = tail = newNode;
        } else {
            Node temp, current;
            //Store the mid position of the list
            int count = (size % 2 == 0) ? (size/2) : ((size+1)/2);
            //Node temp will point to head
            temp = head;
            current = null;
            //Traverse through the list till the middle of the list is reached
            for(int i = 0; i < count; i++) {
                //Node current will point to temp
                current = temp;
                //Node temp will point to node next to it.
                temp = temp.next;
            }
            //current will point to new node
            current.next = newNode;
            //new node will point to temp
            newNode.next = temp;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        ensureNonEmpty();
        E data = head.element;
        head = head.next;
        size--;
        return data;
    }
    @Override
    public E removeLast() {
        ensureNonEmpty();
        E data = tail.element;
        Node<E> current = head;
        while(current.next!=tail){
            current = current.next;
        }
        current.next = null;
        tail = current;
        size--;
        return data;
    }

//    public E removeMid(){
//        ensureNonEmpty();
//        Node temp, current;
//        //Store the mid position of the list
//        int count = (size % 2 == 0) ? (size/2) : ((size+1)/2);
//        //Checks whether the head is equal to the tail or not, if yes then the list has only one node.
//        if( head != tail ) {
//            //Initially, temp will point to head
//            temp = head;
//            current = null;
//            //Current will point to node previous to temp
//            //If temp is pointing to node 2 then current will point to node 1.
//            for(int i = 0; i < count-1; i++){
//                current = temp;
//                temp = temp.next;
//            }
//            if(current != null) {
//                //temp is the middle that needs to be removed.
//                //So, current node will point to node next to temp by skipping temp.
//                current.next = temp.next;
//                //Delete temp
//                temp = null;
//            }
//            //If current points to NULL then, head and tail will point to node next to temp.
//            else {
//                head = tail = temp.next;
//            //Delete temp
//                temp = null;
//            }
//        }
//        //If the list contains only one element
//        //then it will remove it and both head and tail will point to NULL
//        else {
//            head = tail = null;
//        }
//        size--;
//       return
//}
    public String toString(){
        Node<E> current = head;
        StringBuilder result = new StringBuilder();
        while(current!=null){
            result.append(current.element+ "\n");
            current = current.next;
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
            SinglyLinkedList.Node<E> current = head;
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
