package chapter.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class EX24 {

    public static int gcd(int p, int q) {
        StdOut.printf("%d   %d\n", p, q);
        if (q == 0)
            return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int d = gcd(p, q);
        StdOut.println(d);
    }
}