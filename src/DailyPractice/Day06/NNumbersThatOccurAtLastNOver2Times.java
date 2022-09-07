package DailyPractice.Day06;
//https://www.nowcoder.com/questionTerminal/eac8c671a0c345b38aa0c07aba40097b

import java.util.Scanner;

public class NNumbersThatOccurAtLastNOver2Times {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int[] count = new int[100];
        while (sc.hasNext()) {
            count[sc.nextInt()]++;
            n++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= n / 2) {
                System.out.println(i);
                return;
            }
        }
    }
}
