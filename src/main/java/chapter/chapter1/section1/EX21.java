package chapter.chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EX21 {
    public static void main(String[] args) {
        String[] lines = StdIn.readAllLines(); // Ctrl+D 结束循环
        for (String line : lines) {
            String[] split = line.split(" ");
            String Name = split[0];
            double num1 = Double.parseDouble(split[1]);
            double num2 = Double.parseDouble(split[2]);
            StdOut.printf(Name + " %.0f %.0f %.3f\n", num1, num2, num1 / num2);
        }
    }
}