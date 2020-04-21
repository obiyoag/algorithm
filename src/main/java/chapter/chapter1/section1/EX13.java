package chapter.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class EX13 {

    public static int[][] transpose(int[][] a) {

        int row = a[0].length;
        int col = a.length;
        int[][] tran_a = new int[row][col];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                tran_a[i][j] = a[j][i];
        return tran_a;
    }

    public static void printMatrix(int[][] a) {
        int row = a.length;
        int col = a[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                StdOut.printf("%d  ", a[i][j]);
            StdOut.printf("\n");
        }
    }

    public static int[][] getMatrix(int row, int col) {
        int flag = 0;
        int a[][] = new int[row][col];

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                a[i][j] = flag;
                flag++;
            }
        return a;
    }
    public static void main(String[] args) {
        int[][] mat = getMatrix(3, 4);
        printMatrix(mat);
        int[][] tran_mat = transpose(mat);
        printMatrix(tran_mat);
    }

}