package chapter.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class EX33 {

    public static double dot(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new RuntimeException("Lengths are supposed to be the same.");
        }
        double result = 0.0;
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y.length; j++)
                result += x[i] * y[j];
        return result;
    }

    public static double[][] mult(double[][] a, double[][] b) {
        int a_row = a.length;
        int a_col = a[0].length;
        int b_row = b.length;
        int b_col = b[0].length;
        if (a_col != b_row)
            throw new RuntimeException("Matrix size mismatch.");
        double[][] new_mat = new double[a_row][b_col];
        for (int i = 0; i < a_row; i++)
            for (int j = 0; j < b_col; j++)
                for (int k = 0; k < a_col; k++)
                    new_mat[i][j] += a[i][k] * b[k][j];
        return new_mat;
    }

    public static double[][] transpose(double[][] a) {

        int row = a[0].length;
        int col = a.length;
        double[][] new_mat = new double[row][col];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                new_mat[i][j] = a[j][i];
        return new_mat;
    }

    public static void printMatrix(double[][] a) {
        int row = a.length;
        int col = a[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                StdOut.printf("%.1f  ", a[i][j]);
            StdOut.printf("\n");
        }
    }

    public static double[][] getMatrix(int row, int col) {
        double flag = 0.;
        double a[][] = new double[row][col];

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                a[i][j] = flag;
                flag++;
            }
        return a;
    }
    public static void main(String[] args) {
        double[][] mat = getMatrix(3, 4);
        double[][] trans_mat = transpose(mat);
        double[][] mul_mat = mult(mat, trans_mat);
        printMatrix(mat);
        StdOut.println("");
        printMatrix(trans_mat);
        StdOut.println("");
        printMatrix(mul_mat);
    }
}