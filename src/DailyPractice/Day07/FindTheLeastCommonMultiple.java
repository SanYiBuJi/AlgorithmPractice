package DailyPractice.Day07;
// https://www.nowcoder.com/questionTerminal/22948c2cad484e0291350abad86136c3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FindTheLeastCommonMultiple {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strs = str.split(" ");
        int A = Integer.parseInt(strs[0]);
        int B = Integer.parseInt(strs[1]);
        System.out.println(fun(A, B));
    }

    public static int fun(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a % b == 0) {
            if (a > b) {
                return a;
            } else return b;
        }
        int gbc = gbc(a, b);
        return (a / gbc) * (b / gbc) * gbc;
    }

    public static int gbc(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gbc(b, a % b);
        }
    }
}
