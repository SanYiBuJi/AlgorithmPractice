package DailyPractice.Day01;

import java.util.Scanner;

public class StatisticsPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        System.out.println(CountStatisticsPalindrome(A,B));
    }
    public static int CountStatisticsPalindrome(String A,String B){
        char[] charsA = A.toCharArray();
        int count = 0;
        for (int i = -1; i < charsA.length; i++) {
            String s;
            if (i == -1){
                s = B + A;
            }else {
                s = A.substring(0, i) + B + A.substring(i);
            }
            if (IsStatisticsPalindrome(s)){
                count++;
            }
        }
        return count;
    }

    public static boolean IsStatisticsPalindrome(String s){
        int temp = s.length()/2;
        char[] chars = s.toCharArray();
        for (int i = 0; i < temp; i++) {
            if (chars[i] != chars[s.length()-1 -i]){
                return false;
            }
        }
        return true;
    }
}
