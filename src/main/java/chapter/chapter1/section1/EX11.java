package chapter.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class EX11 {
    public static void main(String[] args) {
        int row = 3;
        int col = 4;
        int a[][] = new int[row][col];

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                a[i][j] = i * j;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                StdOut.print(a[i][j]);
            StdOut.printf("\n");
        }

    }
}