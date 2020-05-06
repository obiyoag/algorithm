package chapter.chapter1.section3;

import java.util.Scanner;

public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;
    private int cap;

    public FixedCapacityStack(int cap) {
        this.cap = cap;
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }

    public boolean isFull() {
        return cap == N;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FixedCapacityStack<String> s = new FixedCapacityStack<String>(5);
        while (sc.hasNext()) {
            s.push(sc.next());
        }
        System.out.println(s.isFull());

    }

}