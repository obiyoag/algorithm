package chapter1.section3;
import java.util.Scanner;

public class EX15 {
    public static void main(String[] args) {
        int k = 4;
        Queue<String> q = new Queue<String>();
        Stack<String> s = new Stack<String>();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { // 将输入装进q0中处理
            q.enqueue(sc.next());
        }
        sc.close();

        while(!q.isEmpty()){
            s.push(q.dequeue());
        }

        if(s.size()<k) System.out.println("k should be less than the size of the stack.");
        else{
            for(int i=0;i<k;i++){
                System.out.println(s.pop());
            }
        }
        
    }
}