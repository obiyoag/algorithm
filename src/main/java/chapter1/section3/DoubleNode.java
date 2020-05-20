package chapter1.section3;

public class DoubleNode<Item> {
    Node head;
    int size;
    Node end;

    private class Node {
        Node last;
        Item item;
        Node next;
    }

    public DoubleNode(Item item) {
        Node head = new Node();
        head.last = null;
        head.next = null;
        head.item = item;
        this.head = head;
        this.end = head;
        this.size = 1;
    }

    void insertHead(Item item) {
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

    Item removeHead() {
        Item item = head.item;
        if (head.next != null) {
            head.next.last = null;
            head = head.next;
        }
        size--;
        return item;
    }

    void insertEnd(Item item) {
        Node newEnd = new Node();
        newEnd.item = item;
        newEnd.next = null;
        end.next = newEnd;
        newEnd.last = end;
        end = newEnd;
        size++;
    }

    Item removeEnd() {
        Item item = end.item;
        if (end.last != null) {
            end.last.next = null;
            end = end.last;
        }
        size--;
        return item;
    }

    void insertBefore(Item item, int pos) {
        Node newNode = new Node();
        newNode.item = item;
        Node current;
        if (pos > size / 2) {
            current = end;
            for (int i = 0; i < size - pos; i++)
                current = current.last;
        } else {
            current = head;
            for (int i = 0; i < pos - 1; i++)
                current = current.next;
        }
        newNode.last = current;
        newNode.next = current.next;
        newNode.next.last = newNode;
        current.next = newNode;
        size++;
    }

    void insertAfter(Item item, int pos) {
        Node newNode = new Node();
        newNode.item = item;
        Node current;
        if (pos > size / 2) {
            current = end;
            for (int i = 0; i < size - pos - 1; i++)
                current = current.last;
        } else {
            current = head;
            for (int i = 0; i < pos; i++)
                current = current.next;
        }
        newNode.last = current;
        newNode.next = current.next;
        newNode.next.last = newNode;
        current.next = newNode;
        size++;
    }

    Item remove(int pos) {
        Node current;
        if (pos > size / 2) {
            current = end;
            for (int i = 0; i < size - pos; i++)
                current = current.last;
        } else {
            current = head;
            for (int i = 0; i < pos - 1; i++)
                current = current.next;
        }
        Item item = current.next.item;
        current.next = current.next.next;
        current.next.last = current;
        size--;
        return item;
    }

    public static void main(String[] args) {
        DoubleNode<String> dn = new DoubleNode<String>("1");
        dn.insertEnd("2");
        dn.insertEnd("3");
        dn.insertAfter("item", 1);
        System.out.println(dn.remove(2));


    }
}