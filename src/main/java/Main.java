import implementations.*;
import interfaces.List;

public class Main {
    public static void main(String[] args) {
//       testArrayList();
//       testStack();
//       testQueue();
//        testSinglyLinklist();
        testDoublyLinklist();
    }

    public static void testArrayList(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(7);
        list.add(0, 9);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.get(1));
    }
    public static void testStack() {
        Stack2<Integer> myStack = new Stack2<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(7);
        myStack.push(8);
        myStack.push(9);
        System.out.println(myStack);
        System.out.println("Pop:");
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println("After pop: ");
        System.out.println(myStack);
        System.out.print("Peek: ");
        System.out.println(myStack.peek());
    }
    public static void testQueue(){
        Queue<Integer> myQueue = new Queue<>();
        myQueue.offer(3);
        myQueue.offer(5);
        myQueue.offer(7);
        myQueue.offer(11);
        myQueue.offer(15);
        System.out.println(myQueue);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println("After poll:");
        System.out.println(myQueue);
        System.out.println("Peek: " + myQueue.peek());
    }
    public static void testSinglyLinklist() {
        SinglyLinkedList<Integer> mySinglyLinkedList = new SinglyLinkedList<>();
        mySinglyLinkedList.addFirst(1);
        mySinglyLinkedList.addLast(3);
        mySinglyLinkedList.addFirst(7);
        mySinglyLinkedList.addLast(5);
        mySinglyLinkedList.addLast(9);
        mySinglyLinkedList.addLast(12);
        mySinglyLinkedList.addLast(18);
        mySinglyLinkedList.addMid(20);
        System.out.println(mySinglyLinkedList);
        System.out.println("Remove First element: " + mySinglyLinkedList.removeFirst());
        System.out.println("Remove First element: " + mySinglyLinkedList.removeFirst());
        System.out.println("Remove last element: " + mySinglyLinkedList.removeLast());
        System.out.println("After remove:\n" + mySinglyLinkedList);
//        System.out.println("Remove mid element: " + mySinglyLinkedList.removeMid());
        System.out.println("After remove mid:\n" + mySinglyLinkedList);
        System.out.println("First: " + mySinglyLinkedList.getFirst());
        System.out.println("Last: " + mySinglyLinkedList.getLast());
        System.out.println("Size: " + mySinglyLinkedList.size());
    }
    public static void testDoublyLinklist() {
        DoublyLinkedList<Integer> myDoublyLinkedList = new DoublyLinkedList<>();
        myDoublyLinkedList.addFirst(5);
        myDoublyLinkedList.addFirst(8);
        myDoublyLinkedList.addLast(7);
        myDoublyLinkedList.addLast(9);
        myDoublyLinkedList.addLast(4);
        System.out.println("First To Last");
        System.out.println(myDoublyLinkedList.displayFirstToLast());
        System.out.println("Last To First");
        System.out.println(myDoublyLinkedList.displayLastToFirst());

        System.out.println("Remove First element: " + myDoublyLinkedList.removeFirst());
        System.out.println("First To Last");
        System.out.println(myDoublyLinkedList.displayFirstToLast());
        System.out.println("Last To First");
        System.out.println(myDoublyLinkedList.displayLastToFirst());

        System.out.println("Remove last element: " + myDoublyLinkedList.removeLast());
        System.out.println("First To Last");
        System.out.println(myDoublyLinkedList.displayFirstToLast());
        System.out.println("Last To First");
        System.out.println(myDoublyLinkedList.displayLastToFirst());

        System.out.println("First: " + myDoublyLinkedList.getFirst());
        System.out.println("Last: " + myDoublyLinkedList.getLast());
        System.out.println("Size: " + myDoublyLinkedList.size());
    }
}
