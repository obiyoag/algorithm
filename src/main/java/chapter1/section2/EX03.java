package chapter1.section2;

import edu.princeton.cs.algs4.*;

public class EX03 {

    public static void getIntersect(Interval2D[] list2D) {
        int intervalNum = list2D.length;
        for (int i = 0; i < intervalNum - 1; i++) {
            Interval2D in = list2D[i];
            for (int j = i + 1; j < intervalNum; j++)
                if (in.intersects(list2D[j]))
                    StdOut.println(in + " " + list2D[j]);
        }
    }

    public static double[] getBoundary(double min, double max) {
        while(true){
            double[] interval = new double[2];
            interval[0] = StdRandom.uniform();
            interval[1] = interval[0] + StdRandom.uniform(min, max);
            if(interval[1]<= 1.0) return interval;
        }
    }
    public static void main(String[] args) {
        int intervalNum = Integer.parseInt(args[0]);
        double max = Double.parseDouble(args[1]);
        double min = Double.parseDouble(args[2]);

        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLACK);

        Interval1D[] list1D = new Interval1D[2 * intervalNum];
        Interval2D[] list2D = new Interval2D[intervalNum];

        for (int i = 0; i < 2 * intervalNum; i++) {
            double[] boundaryList = getBoundary(min, max);
            list1D[i] = new Interval1D(boundaryList[0], boundaryList[1]);
        }

        int j = 0;
        for (int i = 0; i < intervalNum; i++) {
            list2D[i] = new Interval2D(list1D[j], list1D[j + 1]);
            list2D[i].draw();
            j += 2;
        }
        getIntersect(list2D);

    }
}