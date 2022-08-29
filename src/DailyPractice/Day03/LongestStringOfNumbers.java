package DailyPractice.Day03;
//https://www.nowcoder.com/questionTerminal/bd891093881d4ddf9e56e7cc8416562d

import java.util.Scanner;

public class LongestStringOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
        String str = "abcd12345ed125ss123456789";
        System.out.println(logestStringOfNumbers(str));
    }
    public static String logestStringOfNumbers(String str){
        char[] arrays = str.toCharArray();
        int index = -1;
        int max = -1;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] >= '0' && arrays[i] <= '9'){
                int tempIndex = i;
                while (i < arrays.length && arrays[i] >= '0' && arrays[i] <= '9'){
                    i++;
                }
                int tempLong = i - tempIndex;
                if (tempLong > max){
                    index = tempIndex;
                    max = tempLong;
                }
            }
        }
        return str.substring(index,index + max);
    }
}
