package DailyPractice.Day07;
// https://www.nowcoder.com/questionTerminal/1183548cd48446b38da501e58d5944eb

import java.util.Scanner;

public class DontTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        System.out.println(fun(M, N));
    }

    public static int fun(int M, int N) {
        // 拆分
        if (M >= 4 && N >= 4) {
            int m1 = M - M % 4;
            int n1 = N - N % 4;

            return funIf(m1, n1) + funIf(m1, N - n1) + funIf(M - m1, n1) + funIf(M - m1, N - n1);
        } else {
            return funIf(M, N);

        }
    }

    public static int funIf(int M, int N) {
        if (M == 0 || N == 0) {
            return 0;
        }
        if (M % 4 == 0 || N % 4 == 0) {
            if (M % 2 == 0 && N % 2 == 0) {
                return fun1(M, N);
            } else {
                return fun3(M, N);
            }
        } else if (M % 2 == 0 || N % 2 == 0) {
            if (M % 2 == 0 && N % 2 == 0) {
                return fun2(M, N);
            } else return fun4(M, N);
        } else return fun5(M, N);
    }


    public static int fun1(int M, int N) {
        // M,N都是偶数，且其中一个是4的倍数
        return N * M / 2;
    }

    public static int fun2(int M, int N) {
        // M,N都是偶数，都不是4的倍数
        return (M * N / 4 + 1) * 2;
    }

    public static int fun3(int M, int N) {
        // M是4的倍数，N是奇数
        return M * N / 2;
    }

    public static int fun4(int M, int N) {
        // M是偶数，N是奇数
        return M * N / 2 + 1;
    }

    public static int fun5(int M, int N) {
        // M,N都是奇数
        return (M * N + 1) / 2;
    }
}
