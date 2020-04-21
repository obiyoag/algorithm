package chapter.chapter1.section1;
import edu.princeton.cs.algs4.StdOut;

public class EX15 {

    public static int[] histogram(int[] a, int M) {
        int[] arr = new int[M];
        for (int i = 0; i < M; i++)
            for (int entry : a)
                if (entry == i)
                    arr[i]++;
        return arr;
    }
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,5,5};
        int[] histo = histogram(a, 8);
        for(int entry:histo) StdOut.println(entry);
    }
}