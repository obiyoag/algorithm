package chapter.chapter1.section3;

import java.util.Scanner;

public class EX04 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("0");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            stack.push(sc.next());
            String str1 = stack.pop();   //将括号放入栈并两两pop出来检查是否合法,若不合法再push入栈，最后若栈空则合法
            String str2 = stack.pop();
            if ((str2 + str1).equals("()") || (str2 + str1).equals("[]") || (str2 + str1).equals("{}")) {
                continue;
            }
            stack.push(str2);
            stack.push(str1);
        }
        if (stack.pop().equals("0")){
            System.out.println("balanced");
        }else{
            System.out.println("unbalanced");
        }
        sc.close();
    }
}