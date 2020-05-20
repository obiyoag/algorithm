package chapter1.section1;

import edu.princeton.cs.algs4.StdRandom;

public class EX37 {
    public static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // int r = i + StdRandom.uniform(N - i);
            int r = StdRandom.uniform(N);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);  //length of the array
        int N = Integer.parseInt(args[1]);  //num of shuffles
    
        int[] arr = new int[M];
        int[][] result = new int[M][M];
    
        for (int i = 0; i < N; i++) {
            //initialization
            for (int j = 0; j < M; j++) {
                arr[j] = j;
            }

            shuffle(arr);

            for (int j = 0; j < M; j++) {
                result[arr[j]][j]++;  //result[i][j]表示下标为i的的元素打乱后落到j处的次数
            }
        }
        //print the table
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}