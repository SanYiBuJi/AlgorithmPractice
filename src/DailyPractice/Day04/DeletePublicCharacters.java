package DailyPractice.Day04;
//https://www.nowcoder.com/questionTerminal/f0db4c36573d459cae44ac90b90c6212
import java.util.Scanner;

public class DeletePublicCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            String pattern = "[" + str2 + "]";
            System.out.println(str1.replaceAll(pattern,""));
        }
    }
}
