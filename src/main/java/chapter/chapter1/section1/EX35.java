package chapter.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class EX35 {
    public static int SIDES = 6;
    public static int N = 10000;

    public static double[] getprobabilities() {
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i + j] += 1;
        for (int k = 0; k <= 2 * SIDES; k++)
            dist[k] /= 36.0;
        return dist;
    }

    public static double[] realexperiment(int N, double[] theories) {
        double[] actual = new double[2 * SIDES + 1];
        for (int i = 0; i < N; i++)
            actual[StdRandom.discrete(theories)]++;
        for (int i = 0; i < 2 * SIDES + 1; i++)
            actual[i] /= N;
        return actual;
    }
    public static void main(String[] args) {

        double[] theories = getprobabilities();
        for (double entry : theories)
            StdOut.printf("%.3f ", entry);
        StdOut.println("");

        double[] actual = realexperiment(N, theories);
        for (double entry : actual)
            StdOut.printf("%.3f ", entry);
        StdOut.println("");

    }
}