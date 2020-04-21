package chapter.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class EX20 {


    public static double lnF(int N) {
        if (N == 0 || N == 1)
            return 1;
        return Math.log(N) + lnF(N - 1);
    }
    public static void main(String[] args) {
        StdOut.println(lnF(5));
    }

}