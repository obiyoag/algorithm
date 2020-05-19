package chapter.chapter1.section3;

public class Steque<Item> {
    Node first;
    int size;
    Node last;
    private class Node{
        Node next;
        Item item;
    }

    public Steque(Item item){
        first = new Node();
        first.item = item;
        last = first;
    }
    void push(Item item){
        Node newFirst = new Node();
        newFirst.item = item;
        newFirst.next = first;
        first = newFirst;
        size++;
    }   
    
    Item pop(){
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    void enqueue(Item item){
        Node newLast = new Node();
        newLast.item = item;
        last.next = newLast;
        last = newLast;
        size++;
    }

    public static void main(String[] args) {
        Steque<String> stq = new Steque<String>("1");
        stq.push("2");
        stq.push("3");
        stq.enqueue("item");
        System.out.println(stq.pop());
        System.out.println(stq.pop());
        System.out.println(stq.pop());
        System.out.println(stq.pop());


    }
}