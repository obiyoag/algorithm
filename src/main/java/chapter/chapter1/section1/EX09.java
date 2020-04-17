package chapter.chapter1.section1;

public class EX09 {

    public static String toStringBinary(int n) {
        String bi_n = "";
        if (n == 0)
            return "0";
        if (n == 1)
            return "1";
        while (true) {
            if (n % 2 == 1) {
                n /= 2;
                bi_n = "1" + bi_n;
            }
            if (n % 2 == 0) {
                n = n / 2;
                bi_n = "0" + bi_n;
            }
            if (n == 0 || n == 1) {
                bi_n = Integer.toString(n) + bi_n;
                break;
            }
        }
        return bi_n;
    }

    public static String simpleSringBinary(int n) {
        String s = "";
        for (int i = n; i > 0; i /= 2)
            s = (i % 2) + s;
        return s;
    }
    public static void main(String[] args) {
        int a = 114;
        String bi_a = toStringBinary(a);
        String si_a = simpleSringBinary(a);
        System.out.println(bi_a);
        System.out.println(si_a);
    }
}
