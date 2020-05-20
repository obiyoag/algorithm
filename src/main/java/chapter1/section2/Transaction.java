package chapter1.section2;

import java.util.Scanner;

public class Transaction {
    private String who;
    private SmartDate when;
    private double amount;

    public Transaction(String who, SmartDate when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public Transaction(String transaction) {
        String[] fields = transaction.split(" ");
        this.who = fields[0];
        this.when = new SmartDate(fields[1]);
        this.amount = Double.parseDouble(fields[2]);
    }

    public String who() {
        return who;
    }

    public SmartDate when() {
        return when;
    }

    public double amount() {
        return amount;
    }

    public String toString() {
        return who + " made a deal of " + amount + " in " + when;
    }

    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Transaction that = (Transaction) x;
        if (this.who != that.who) return false;
        if (this.when != that.when) return false;
        if (this.amount != that.amount) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String who = sc.next();
            String when = sc.next();
            double amount = sc.nextDouble();
            SmartDate sd = new SmartDate(when);
            Transaction t1 = new Transaction(who, sd, amount);
            System.out.println(t1);

            String transaction = sc.nextLine();
            Transaction t2 = new Transaction(transaction);
            System.out.println(t2);

        }
        sc.close();
        

    }
}