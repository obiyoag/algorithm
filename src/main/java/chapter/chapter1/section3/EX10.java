package chapter.chapter1.section3;

import java.util.Scanner;

public class EX10 {  //中缀表达式转换为后缀表达式

    public static boolean isNumeric(String str) {  //判断字符串是不是数字
        for (int i = str.length(); --i >= 0;) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean getPriority(String str1, String str2) { //判断str1和str2的优先级
        boolean flag = false;
        if ((str1.equals("+") || str1.equals("-")) && (str2.equals("*") || str2.equals("/"))) {
            flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {

        Queue<String> q0 = new Queue<String>();
        Queue<String> q1 = new Queue<String>();
        Stack<String> s = new Stack<String>();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { // 将输入装进q0中处理
            q0.enqueue(sc.next());
        }
        sc.close();

        while (!q0.isEmpty()) {  //当q0中还有元素时
            String str = q0.dequeue();
            if (isNumeric(str)) q1.enqueue(str);  //若str是数字,则直接入队
            else {  //若str是运算符
                if ( !s.isEmpty() && str.equals(")")) {  //str是右括号时,pop入队至左括号
                    while (!s.isEmpty()) {
                        if (s.peek().equals("(")) {
                            s.pop();
                            break;
                        }
                        q1.enqueue(s.pop());
                    }
                } 
                else if (!s.isEmpty() && getPriority(str, s.peek()) ) {  //str优先级比栈顶元素低时,栈顶元素出站入队,str入队
                    q1.enqueue(s.pop());
                    q1.enqueue(str);
                } 
                else s.push(str);   //除以上两种情况,运算符直接入栈
            }
        }
        while(!s.isEmpty()) q1.enqueue(s.pop());  //当q0为空时,将栈内元素全部出站入队
        Queue.printQueue(q1);
        System.out.println("");
    }
}