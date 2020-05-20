package chapter1.section2;

public class EX07 {

    public static String mystery(String s) {//字符串翻转
        int N = s.length();
        if (N <= 1)
            return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(b) + mystery(a);
    }

    public static void main(String[] args) {
        String s = mystery("o00O00o");
        System.out.println(s);
    }
}