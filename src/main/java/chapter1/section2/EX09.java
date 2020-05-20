package chapter1.section2;

public class EX09 {
    public static void main(String[] args) {
        Counter c = new Counter("Counter");
        int[] arr = { 0, 2, 3, 4, 2, 13, 4, 5 };
        BinarySearch.rank(0, arr, c);
        System.out.println(c);
    }

}

class Counter {
    private final String name;
    private int count;

    public Counter(String name) {
        this.name = name;
    }

    public void increment() {
        count++;
    }

    public int tally() {
        return count;
    }

    public String toString() {
        return count + " " + name;
    }
}

class BinarySearch {

    public static int rank(int key, int[] a, Counter c) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            c.increment();
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}