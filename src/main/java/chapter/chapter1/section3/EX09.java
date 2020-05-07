package chapter.chapter1.section3;

import java.util.Scanner;

public class EX09 {  //为表达式添加左括号
    public static void main(String[] args) {
        Queue<String> q0 = new Queue<String>();
        Queue<String> q1 = new Queue<String>();
        Stack<String> s1 = new Stack<String>();
        Stack<String> s2 = new Stack<String>();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {     //将输入装进q0中处理
            q0.enqueue(sc.next());
        }
        sc.close();

        while (!q0.isEmpty()) {
            String str = q0.dequeue();
            q1.enqueue(str);          //q0中的元素装入q1中
            if (str.equals(")")) {     //直到读取到"）",将"（"push进s1,将q1中所有元素push进s1
                s1.push("(");
                if (!q0.isEmpty() && q0.getHead().equals("*")) {  //若")"后是"*",则多push一个"("
                    s1.push("(");
                    q1.enqueue(q0.dequeue());
                }
                if (!q0.isEmpty() && q0.getHead().equals(")")) {  //若")"后还是")",则不push进"("
                    s1.pop();
                    continue;
                }
                while (!q1.isEmpty() && !q1.getHead().equals("("))  //将q1中的元素全部push进s1
                    s1.push(q1.dequeue());
            }
        }
        while (!s1.isEmpty()) {   //s1翻转成s2
            s2.push(s1.pop());
        }

        Stack.printStack(s2);
        System.out.println("");
    }
}