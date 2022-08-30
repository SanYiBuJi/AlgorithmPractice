package DailyPractice.Day04;
//https://www.nowcoder.com/questionTerminal/61cfbb2e62104bc8aa3da5d44d38a6ef

import java.util.Scanner;

public class BuyApple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(buyApple(sc.nextInt()));
    }

    public static int buyApple(int n){
        if ((n % 2 == 1) || (n < 0) || (n < 6) || (n == 10)){
            return -1;
        }
        if (n % 8 == 0){
            return n/8;
        }else {
            return n/8 + 1;
        }
    }
}
