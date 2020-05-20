package chapter1.section3;

import edu.princeton.cs.algs4.In;

/*Format for Data
Data:         5/22/1939
*/

public class EX16 {
    public static String[] readDates(String date) {
        In in = new In(date);
        Queue<String> q = new Queue<String>();
        while (!in.isEmpty())
            q.enqueue(in.readString());

        int N = q.size();
        String[] a = new String[N];
        for (int i = 0; i < N; i++)
            a[i] = q.dequeue();
        return a;
    }

    public static void main(String[] args) {
        String[] dateList = readDates("Datas.txt");
        for (int i = 0; i < dateList.length; i++)
            System.out.println(dateList[i]);
    }

}
