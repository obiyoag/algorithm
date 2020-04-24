package chapter.chapter1.section2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EX02 {

    public static void getIntersect(Interval1D[] inList) {
        int numInterval = inList.length;
        for (int i = 0; i < numInterval - 1; i++) {
            Interval1D in = inList[i];
            for (int j = i + 1; j < numInterval; j++)
                if (in.intersects(inList[j]))
                    StdOut.println(in + " " + inList[j]);
        }
    }

    public static void main(String[] args) {
        int numInterval = Integer.parseInt(args[0]);
        Interval1D[] inList = new Interval1D[numInterval];
        double[] list = StdIn.readAllDoubles();
        int j = 0;
        for (int i = 0; i < numInterval; i++) {
            inList[i] = new Interval1D(list[j], list[j + 1]);
            j += 2;
        }
        getIntersect(inList);

    }
}