package chapter1.section3;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek(){
        Item item = first.item;
        return item;
    }

    public static void printStack(Stack<String> st){
        for(String str: st){
            System.out.print(str + " ");
        }
    }

    public static Stack<String> copy(Stack<String> s){
        Stack<String> s_temp = new Stack<String>();
        Stack<String> s_copy = new Stack<String>();
        for(String str:s) s_temp.push(str);
        for(String str:s_temp) s_copy.push(str);
        return s_copy;
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        public boolean hasNext(){
            return current != null;
        }

        public void remove(){}

        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("(");
        stack.push(")");
        Stack<String> fake_copy = stack;
        Stack<String> stack_copy = copy(stack);
        System.out.println(stack.toString());
        System.out.println(fake_copy.toString());
        System.out.println(stack_copy.toString());
    }

}