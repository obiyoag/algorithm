package chapter.chapter1.section1;

import edu.princeton.cs.algs4.*;

public class EX30 {

    public static int gcd(int p, int q) {
        if (q == 0)
            return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static boolean[][] gcdMatrix(int row, int col) {
        boolean[][] matrix = new boolean[row][col];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (gcd(i, j) == 1)
                    matrix[i][j] = true;
        return matrix;
    }

    public static void main(String[] args) {
        int row = 4;
        int col = 3;
        boolean[][] matrix = gcdMatrix(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                StdOut.print(matrix[i][j]+" ");
            StdOut.printf("\n");
        }

    }
}