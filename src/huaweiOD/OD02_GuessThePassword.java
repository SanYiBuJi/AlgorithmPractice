package huaweiOD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// todo
public class OD02_GuessThePassword {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] dirs = in.nextLine().split(",");
        int minLength = in.nextInt();
        List<Integer> dire = new ArrayList<>();
        for (String dir : dirs) {
            dire.add(Integer.parseInt(dir));
        }
        Collections.sort(dire);
        List<String> passwordList = new ArrayList<>();
        for (int i = minLength; i < dirs.length; i++) {
            for (int direElement :
                    dire) {

            }
        }
    }
}
