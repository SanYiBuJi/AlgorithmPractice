package DailyPractice.Day06;
//https://www.nowcoder.com/questionTerminal/02d8d42b197646a5bbd0a98785bb3a34

import java.util.Scanner;

public class CalculationOfCandy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int m = sc.nextInt();
        int a = (x + z) / 2;
        int b = z - a;
        int c = m - b;
        if ((a - b) == x && (b - c) == y && (a + b) == z && (b + c) == m) {
            System.out.println(a + " " + b + " " + c);
        } else System.out.println("N0");
    }
}
