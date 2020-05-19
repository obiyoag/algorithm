package chapter.chapter1.section3;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class RandomBag<Item> implements Iterable<Item> {
    private Item[] arr;
    private int size;
    private int cap = 5;

    public RandomBag() {
        arr = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return size == 0;

    }

    public int size() {
        return size;

    }

    public void add(Item item) {
        arr[size] = item;
        size++;
    }

    public Iterator<Item> iterator() {
        return new BagIterator<Item>();
    }

    private class BagIterator<Item> implements Iterator<Item> {
        private int count = size;

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
        RandomBag<String> rb = new RandomBag<String>();
        rb.add("1");
        rb.add("2");
        rb.add("3");
        rb.add("4");
        for(String item:rb){
            System.out.println(item);
        }

    }

}