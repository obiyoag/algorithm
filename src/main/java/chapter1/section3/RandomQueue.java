package chapter1.section3;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class RandomQueue<Item> implements Iterable<Item> {
    private Item[] arr;
    private int arrLen = 5;
    private int rear;

    public RandomQueue() {
        arr = (Item[]) new Object[arrLen];
        rear = 0;
    }

    public boolean isEmpty() {
        return rear == 0;
    }

    private void resize() {
        Item[] temp = (Item[]) new Object[2 * arrLen];
        for (int i = 0; i < rear; i++)
            temp[i] = arr[i];
        arr = temp;
        arrLen *= 2;
    }

    public void enqueue(Item item) {
        if (rear >= arrLen)
            resize();
        arr[rear] = item;
        rear++;
    }

    public Item dequeue() {
        int random = StdRandom.uniform(rear);
        Item item = arr[random];
        arr[random] = arr[rear - 1];
        rear--;
        return item;

    }

    public Item sample() {
        int random = StdRandom.uniform(rear);
        Item item = arr[random];
        return item;
    }

    public Iterator<Item> iterator() {
        return new RandomQueueIterator<Item>();
    }

    private class RandomQueueIterator<Item> implements Iterator<Item> {

        private int count = rear;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Item next() {
            int random = StdRandom.uniform(count);
            Item item = (Item) arr[random];
            arr[random] = arr[count - 1];
            arr[count - 1] = null;
            count--;
            return item;
        }
    }

    public static void main(String[] args) {
        RandomQueue<String> rq = new RandomQueue<String>();
        rq.enqueue("1");
        rq.enqueue("2");
        rq.enqueue("3");
        rq.enqueue("4");
        System.out.println(rq.sample());
        for (String item : rq) {
            System.out.println(item);
        }

    }
}