package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/28
  TIME: 10:53

  1.4.5.2
  3-sum 问题的快速算法

 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ThreeSumFast {

    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (BinarySearch.rank(-a[i] - a[j], a) > j) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static int count_fast(int[] a){
        int l = a.length-1;
        int cnt = 0;
        for (int i = 0; i < a.length-2; i++) {
            int f = i+1;
            while (f!=l){
                if (a[i]+a[f]+a[l]>0) l--;
                else if (a[i]+a[f]+a[l]<0) f++;
                else{
                    cnt++;
                    f++;
                    l--;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int cnt = count(a);
        StdOut.println(cnt + " triples  " + timer.elapsedTime() + " seconds.");
    }
}
