package lintcode;

public class Topic936 {
}
// https://www.lintcode.com/problem/936/leaderboard
class Solution {
    /**
     * @param s: a string
     * @return: a string after capitalizes the first letter
     */
    public String capitalizesFirst(String s) {
        // Write your code here
        if (s.length() == 0){
            return s;
        }
        char[] ss = s.toCharArray();
        ss[0] = Character.toUpperCase(ss[0]);
        if (s.length() == 1){
            return String.valueOf(ss);
        }
        for (int i = 1; i < ss.length; i++) {
            if (ss[i - 1] == ' ') {
                ss[i] = Character.toUpperCase(ss[i]);
            }
        }
        return String.valueOf(ss);
    }
}
