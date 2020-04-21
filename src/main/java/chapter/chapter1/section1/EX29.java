package chapter.chapter1.section1;

import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class EX29 {

    public static int rank(int key, int[] a) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == key) return i;
        return -1;
    }

    public static int count(int key, int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) count++;
            if (a[i] > key) break;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] whitelist = new In(args[0]).readAllInts();
        Arrays.sort(whitelist);
        int key = 1;
        StdOut.println(rank(key, whitelist));
        StdOut.println(count(key, whitelist));

    }
}