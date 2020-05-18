package chapter.chapter1.section3;

import java.util.Scanner;

public class ResizingArrayQueueOfStrings {
    private String[] a;
    private int cap;
    private int front; // front指向队头元素
    private int rear; // rear指向队尾元素的下一个位置

    public ResizingArrayQueueOfStrings(int cap) {
        a = new String[cap];
        this.cap = cap;
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    private void resize(int max) {
        String[] temp = new String[max];
        for (int i = front; i < rear - front; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void enqueue(String item) {
        if (rear >= cap)
            resize(2 * rear);
        a[rear] = item;
        rear++;
    }

    public String dequeue() {
        String item = a[front];
        front++;
        return item;
    }

    public static void printQueue(ResizingArrayQueueOfStrings q) {
        for (int i = q.front; i < q.rear; i++) {
            System.out.print(q.a[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ResizingArrayQueueOfStrings q = new ResizingArrayQueueOfStrings(3);
        while (sc.hasNext()) {
            q.enqueue(sc.next());
        }
        sc.close();
        q.dequeue();
        q.dequeue();

        printQueue(q);
        System.out.println("");

    }

}