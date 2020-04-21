package chapter.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class EX22 {

    public static int rank(int key, int[] a, int lo, int hi, int depth) {
        StdOut.println(++depth);
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
            return rank(key, a, lo, mid - 1, depth);
        else if (key > a[mid])
            return rank(key, a, mid + 1, hi, depth);
        else
            return mid;
    }

    public static void main(String[] args) {
        int depth = 0;
        int[] arr = new int[12];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i;
        int index = rank(14, arr, 0, arr.length - 1, depth);
        StdOut.println(index);
    }

}