package chapter1.section3;

class JosephusQueue {
    Node last;

    private class Node {
        Node next;
        int item;
    }

    public JosephusQueue(int item) {
        Node n = new Node();
        last = n;
        last.item = item;
        last.next = last;
    }

    public void enqueue(int item) {
        Node n = new Node();
        n.item = item;
        n.next = last.next;
        last.next = n;
        last = n;
    }

    public int dequeueNextNode(Node before) {
        int item = before.next.item;
        last.next = before.next.next;
        return item;
    }

    public void josephusPrint(int seq) {
        while (last.next != last) {
            Node current = last;
            for (int i = 0; i < seq-1; i++) {
                current = current.next;
            }
            System.out.println(dequeueNextNode(current));
        }
    }
}

public class Josephus {

    static public void initiate(JosephusQueue jq, int num) {
        for (int i = 1; i < num; i++) {
            jq.enqueue(i);
        }
    }

    public static void main(String[] args) {
        JosephusQueue jq = new JosephusQueue(0);
        initiate(jq, 7);
        jq.josephusPrint(2);
    }

}