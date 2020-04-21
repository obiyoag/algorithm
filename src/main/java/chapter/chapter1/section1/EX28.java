package chapter.chapter1.section1;

import java.util.Arrays;

import edu.princeton.cs.algs4.*;

public class EX28 {
    public static void main(String[] args) {
        int[] whitelist = new In(args[0]).readAllInts();
        Arrays.sort(whitelist);
        int temp = 0;
        for(int entry:whitelist){
            if(entry != temp){
                StdOut.println(entry);
                temp = entry;
            }
        }
    }
}