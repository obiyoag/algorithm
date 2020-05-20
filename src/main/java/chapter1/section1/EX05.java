package chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EX05 {
    public static void main(String[] args) {
        double key1 = StdIn.readDouble();
        double key2 = StdIn.readDouble();

        if (key1 > 0 && key1 < 1 && key2 > 0 && key2 < 1)
            StdOut.println("true");
        else
            StdOut.println("false");
    }
}