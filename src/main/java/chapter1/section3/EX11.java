package chapter1.section3;

import java.util.Scanner;

public class EX11 {
    /*
     * Evaluate postfix 1. 当遇到操作数，压入栈顶 2. 当遇到运算符，就从栈中两次取出栈顶，按照运算符对这两个操作数进行计算。 3.
     * 然后将将计算结果压入栈顶。如此往复直到结束，栈顶的值就是表达式的值。
     */

    public static boolean isNumeric(String str) { // 判断字符串是不是数字
        for (int i = str.length(); --i >= 0;) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String getValue(String str1, String str2, String op) {
        double num1 = Double.parseDouble(str1);
        double num2 = Double.parseDouble(str2);
        double result = 0.0;
        switch (op) {
            case "+":
                result = num2 + num1;
                break;
            case "-":
                result = num2 - num1;
                break;
            case "*":
                result = num2 * num1;
                break;
            case "/":
                result = num2 / num1;
                break;
            default:
                break;
        }
        return Double.toString((double)result);
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();
        Stack<String> s = new Stack<String>();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { // 将输入装进q0中处理
            q.enqueue(sc.next());
        }
        sc.close();

        while(!q.isEmpty()){
            String str = q.dequeue();
            if(isNumeric(str)){
                s.push(str);
            }else{ //先出来的在运算符后面
                String result = getValue(s.pop(), s.pop(), str);
                s.push(result);
            }
        }

        System.out.println(s.pop());
    }
}