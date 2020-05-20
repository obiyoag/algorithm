package chapter1.section2;

import edu.princeton.cs.algs4.*;

public class EX01 {

    public static double getMinDistance(Point2D[] pl) {
        double distance = 3.;
        int pointNum = pl.length;
        for (int i = 0; i < pointNum - 1; i++) {
            Point2D p = pl[i];
            for (int j = i + 1; j < pointNum; j++) {
                double new_distance = p.distanceTo(pl[j]);
                if (new_distance < distance)
                    distance = new_distance;
            }
        }
        return distance;
    }
    public static void main(String[] args) {

        int pointNum = Integer.parseInt(args[0]);

        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.square(0.5, 0.5, 0.5);

        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLACK);
        Point2D[] pointList = new Point2D[pointNum];
        for (int i = 0; i < pointNum; i++) {
            pointList[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
            pointList[i].draw();
        }

        double minDistance = getMinDistance(pointList);
        StdOut.printf("The minimal distance is %.3f\n", minDistance);
    }
}