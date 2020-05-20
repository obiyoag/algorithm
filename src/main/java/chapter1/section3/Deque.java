package chapter1.section3;

public class Deque<Item> {
    Node head;
    int size;
    Node end;

    private class Node {
        Node last;
        Item item;
        Node next;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size(){
        return size;
    }

    public Deque(Item item) {
        Node head = new Node();
        head.last = null;
        head.next = null;
        head.item = item;
        this.head = head;
        this.end = head;
        this.size = 1;
    }

    void pushLeft(Item item) {
        Node newHead = new Node();
        newHead.last = null;
        newHead.item = item;
        newHead.next = head;
        head.last = newHead;
        if (head.next == null)
            end = head;
        head = newHead;
        size++;
    }

    Item popLeft() {
        Item item = head.item;
        if (head.next != null) {
            head.next.last = null;
            head = head.next;
        }
        size--;
        return item;
    }

    void pushRight(Item item) {
        Node newEnd = new Node();
        newEnd.item = item;
        newEnd.next = null;
        end.next = newEnd;
        newEnd.last = end;
        end = newEnd;
        size++;
    }

    Item popRight() {
        Item item = end.item;
        if (end.last != null) {
            end.last.next = null;
            end = end.last;
        }
        size--;
        return item;
    }
    public static void main(String[] args) {
        Deque<String> dq = new Deque<String>("1");
        dq.pushLeft("2");
        dq.pushRight("3");
        System.out.println(dq.popRight());
    }
}