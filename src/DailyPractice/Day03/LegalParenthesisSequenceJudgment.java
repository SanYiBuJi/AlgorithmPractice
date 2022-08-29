package DailyPractice.Day03;
// https://www.nowcoder.com/questionTerminal/d8acfa0619814b2d98f12c071aef20d4

import java.util.Scanner;
import java.util.Stack;

public class LegalParenthesisSequenceJudgment {
    public static void main(String[] args) {
        String str = "";
        System.out.println(legalParenthesisSequenceJudgment(str));
    }

    public static boolean legalParenthesisSequenceJudgment(String str){
        Stack<String> stack = new Stack<String>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '('){
                stack.add(String.valueOf(chars[i]));
            }else if (chars[i] == ')'){
                if (stack.size() == 0){
                    return false;
                }else stack.pop();
            }else return false;
        }
        if (stack.size() == 0){
            return true;
        }

        return false;
    }
}
