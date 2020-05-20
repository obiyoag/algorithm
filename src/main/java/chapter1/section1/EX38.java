package chapter1.section1;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class EX38 {

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }
  public static void main(String[] args) {
    int T = Integer.parseInt(args[0]);
    int N = 100;
    int[] result = new int[4];

    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 4; i++) {
      N *= 10;
      for (int j = 0; j < T; j++) {
        int[] a = new int[N];
        int[] b = new int[N];
        for (int k = 0; k < N; k++) {
          a[k] = StdRandom.uniform(100000, 1000000);
          b[k] = StdRandom.uniform(100000, 1000000);
        }
        Arrays.sort(a);
        for (int k = 0; k < N; k++) {
          if (rank(b[k], a) != -1) {
            result[i]++;
          }
        }
      }
    }
    long endTime = System.currentTimeMillis();
    System.out.printf("计算完成，耗时 %d ms.\n", +(endTime - startTime));
    System.out.println("计算结果:");

    N = 100;
    for (int i = 0; i < 4; i++) {
      N *= 10;
      System.out.printf("%7d %9.2f\n", N, (double) result[i] / T);
    }
  }
}