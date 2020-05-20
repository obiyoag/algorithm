package chapter1.section1;

public class EX14 {
    public static int lg(int N){
        int count = 0;
        while(N!=0)
        {
            N >>= 1;
            count++;
        }
        return count - 1;
    }
    public static void main(String[] args) {
        System.out.println(Integer.toString(lg(18)));

    }
}