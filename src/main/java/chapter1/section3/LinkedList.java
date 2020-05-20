package chapter1.section3;

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {
    Node head;
    int size;

    private class Node {
        Node next;
        Item item;
    }

    public LinkedList() {
        Node head = new Node();
        head.next = null;
        head.item = null;
        this.head = head;
    }

    public void append(Item item) {   //在链表尾添加元素
        Node current = this.head;
        while (!(current.next == null)) {
            current = current.next;
        }
        Node last = new Node();
        last.item = item;
        current.next = last;
        size++;
    }

    public Item getItem(int k) throws NullPointerException {  //返回链表中第k个元素
        Node current = this.head;
        for (int i = 0; i < k; i++) {
            if (current.next != null)
                current = current.next;
            else
                throw new NullPointerException();
        }
        return current.item;
    }

    public void delete(int k) {    //删除链表中第k个元素
        Node current = this.head;
        for (int i = 0; i < k - 1; i++)
            current = current.next;
        current.next = current.next.next;
        size--;
    }

    public void deleteItem(Item key) {  //删除链表中值为key的元素
        Node current = this.head;
        while (!current.next.item.equals(key)) {
            if (current.next == null)
                break;
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    public boolean find(Item key) {  //若链表中含有值为key的元素，返回true，否则返回false
        for (Item item : this)
            if (item.equals(key))
                return true;
        return false;
    }

    public void remove(Item key) {  //删除链表中所有值为key的元素
        while (find(key)) {
            deleteItem(key);
        }
    }

    public int max() {   //返回正整数链表中的最大值
        int max = 0;
        Node current = this.head.next;
        while (true) {
            int currentValue = (int) current.item;
            if (currentValue > max)
                max = currentValue;
            if(current.next == null)
                break;
            current = current.next;
        }
        return max;
    }

    public int recursive_max(Node head, int max) {  //递归实现max
        if (head.next == null)
            return max;
        if ((int) head.next.item > max) {
            max = (int) head.next.item;
            return recursive_max(head.next, max);
        }else
            return recursive_max(head.next, max);
    }

    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {

        private Node current = head.next;
        private int i = size;

        @Override
        public boolean hasNext() { // 只有当hasNext为true时，才会调用next
            return i > 0;
        }

        @Override
        public Item next() {
            Item currentItem = current.item;
            current = current.next;
            i--;
            return currentItem;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.append(1);
        l.append(1);
        l.append(4);
        l.append(3);
        l.append(2);
        for (int item : l) {
            System.out.println(item);
        }
        System.out.println(l.recursive_max(l.head, 0));

    }
}