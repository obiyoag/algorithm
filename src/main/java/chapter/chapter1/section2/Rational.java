package chapter.chapter1.section2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Rational {
    private final long numerator;
    private final long denominator;

    public Rational(long numerator, long denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("The demominator can't be 0.");
        } else {
            long gcd = gcd(numerator, denominator);
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        }
    }

    public static long gcd(long a, long b) {
        long res = a % b;
        if (res != 0) {
            return gcd(b, res);
        } else
            return b;
    }

    public Rational plus(Rational b) {
        return new Rational(this.numerator * b.denominator + this.denominator * b.numerator,
                this.denominator * b.denominator);
    }

    public Rational minus(Rational b) {
        return new Rational(this.numerator * b.denominator - this.denominator * b.numerator,
                this.denominator * b.denominator);
    }

    public Rational times(Rational b) {
        return new Rational(this.numerator * b.numerator, this.denominator * b.denominator);
    }

    public Rational divides(Rational b) {
        return this.times(new Rational(b.denominator, b.numerator));
    }

    public boolean equals(Rational that) {
        if (this == that)
            return true;
        if (that == null)
            return false;
        if (this.getClass() != that.getClass())
            return false;
        if (this.numerator != that.numerator)
            return false;
        if (this.denominator != that.denominator)
            return false;
        return true;
    }

    public String toString() {
        if (this.denominator < 0) {
            return -this.numerator + "/" + -this.denominator;
        } else {
            return this.numerator + "/" + this.denominator;
        }
    }

    public static void main(String[] args) {
        int anumerator = StdIn.readInt();
        int adenominator = StdIn.readInt();
        Rational a = new Rational(anumerator, adenominator);
        int bnumerator = StdIn.readInt();
        int bdenominator = StdIn.readInt();
        Rational b = new Rational(bnumerator, bdenominator);
        StdOut.printf("%s plus %s is %s\n", a, b, a.plus(b));
        StdOut.printf("%s minus %s is %s\n", a, b, a.minus(b));
        StdOut.printf("%s times %s is %s\n", a, b, a.times(b));
        StdOut.printf("%s divides %s is %s\n", a, b, a.divides(b));
    }
}