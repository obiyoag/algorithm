package chapter.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class EX16 {
    public static String exR1(int n) {
        if (n <= 0)
            return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }
    public static void main(String[] args) {
        String s = exR1(6);
        StdOut.println(s);
    }
}