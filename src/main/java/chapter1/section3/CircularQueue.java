package chapter1.section3;

public class CircularQueue<Item> {

    Node last;

    private class Node {
        Node next;
        Item item;
    }

    public CircularQueue(Item item) {
        Node n = new Node();
        last = n;
        last.item = item;
        last.next = last;
    }

    public void enqueue(Item item) {
        Node n = new Node();
        n.item = item;
        n.next = last.next;
        last.next = n;
        last = n;
    }

    public Item dequeue() {
        Item item = last.next.item;
        last.next = last.next.next;
        return item;
    }
    public static void main(String[] args) {
        CircularQueue<Integer> cq = new CircularQueue<Integer>(1);
        cq.enqueue(2);
        cq.enqueue(3);
        cq.enqueue(4);
        for (int i = 0; i < 4; i++)
            System.out.println(cq.dequeue());

    }

}