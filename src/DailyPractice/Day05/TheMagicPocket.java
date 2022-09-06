package DailyPractice.Day05;
//https://www.nowcoder.com/questionTerminal/9aaea0b82623466a8b29a9f1a00b5d35

import java.util.Scanner;

public class TheMagicPocket {
    static int count = 0;
    static int[] weight = null;

    //    static int len = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        weight = new int[len];
//        int i = 0;
        for (int i = 0; i < len; i++) {
            weight[i] = sc.nextInt();
        }
        count(40, len - 1);
        System.out.println(count);
    }

    public static void count(int s, int n) {
        if (s == 0) {
            count++;
            return;
        } else if (s < 0 || (s > 0 && n < 0)) {
            return;
        }
        count(s - weight[n], n - 1);
        count(s, n - 1);
    }
}
