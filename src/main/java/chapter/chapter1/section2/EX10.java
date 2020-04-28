package chapter.chapter1.section2;

import java.util.ArrayList;

import edu.princeton.cs.algs4.StdDraw;

public class EX10 {
    public static void main(String[] args) {
        VisualCounter vc = new VisualCounter(10, 10);
        vc.increment();
        vc.increment();
        vc.increment();
        vc.increment();
        vc.decrement();
        vc.decrement();
        vc.plotTally();
    }
}

class VisualCounter {
    private final int N;
    private final int max;
    private int operation;
    private int count;
    private ArrayList<Integer> tallyArr = new ArrayList<>();

    public VisualCounter(int N, int max) {
        this.N = N;
        this.max = max;
    }

    public void increment() {
        if (isInBoundary()) {
            operation++;
            count++;
        } else {
            System.out.println("Boudary Exceeded");
        }
        tallyArr.add(count);
    }

    public void decrement() {
        if (isInBoundary()) {
            operation++;
            count--;
        } else {
            System.out.println("Boudary Exceeded");
        }
        tallyArr.add(count);
    }

    public int tally() {
        return count;
    }

    public String toString() {
        return "Current Count: " + count;
    }

    private boolean isInBoundary() {
        if (Math.abs(this.count) >= max || operation >= N) {
            return false;
        }
        return true;
    }

    public void plotTally() {
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLACK);
        System.out.println(tallyArr);
        for (int i = 0; i < tallyArr.size(); i++) {
            StdDraw.point(0.1 * i, 0.1 * tallyArr.get(i));
        }
    }
}