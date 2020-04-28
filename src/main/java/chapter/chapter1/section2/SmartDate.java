package chapter.chapter1.section2;

import java.util.Calendar;
import java.util.Scanner;

public class SmartDate {
    private final int month;
    private final int day;
    private final int year;

    public SmartDate(int month, int day, int year) {
        if(month>0 && month<=12){
            this.month = month;
        }else{
            throw new IllegalArgumentException("Invalid Month");
        }
        if(day>0 && day<=30){
            this.day = day;
        }else{
            throw new IllegalArgumentException("Invalid Day");
        }
        if(year>2000){
            this.year = year;
        }else{
            throw new IllegalArgumentException("Invalid Year");
        }
    }

    public SmartDate(String date){
        String[] fields = date.split("/");
        this.month = Integer.parseInt(fields[0]);
        this.day = Integer.parseInt(fields[1]);
        this.year = Integer.parseInt(fields[2]);
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }

    public String dayOfTheWeek() {
        Calendar c = Calendar.getInstance();
        // Month value is 0-based, so it has to -1 to set date correctly
        c.set(year, month - 1, day);
        int dow = c.get(Calendar.DAY_OF_WEEK);
        switch (dow) {
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Saturday";
            default:
                return null;
        }
    }

    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        SmartDate that = (SmartDate) x;
        if (this.day != that.day) return false;
        if (this.month != that.month) return false;
        if (this.year != that.year) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = 0;
        int month = 0;
        int year = 0;
        while (sc.hasNextInt()) {
            month = sc.nextInt();
            day = sc.nextInt();
            year = sc.nextInt();
        }
        try {
            SmartDate sd = new SmartDate(month, day, year);
            System.out.println(sd);
            sc.close();
        } catch (Exception e) {
            System.out.println("Illegal Formatted Date");
        }
    }

}