package huaweiOD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 最长方连续方波信号
// https://dream.blog.csdn.net/article/details/131446655
public class OD01_TheLongestContinuousSquareWaveSignal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        LongestContinuous(str);
    }

    public static void LongestContinuous(String s){
        String tempString = null;
        int maxLength = -1;
        String[] ss = s.split("00");
        for (String current :
                ss) {
            if (current.isEmpty()) {
                continue;
            }
            if (current.charAt(0) == '1'){
                current = "0" + current;
            }
            if (current.charAt(current.length() -1)=='1'){
                current = current + "0";
            }
            // 11 判断不是连续高位
            // 01010 判断是连续交替波
            // 0+(10){2,}0*
            if (current.length() > maxLength && !current.contains("11") && current.contains("01010") && current.matches("0+(10){2,}0*")){
                maxLength = current.length();
                tempString = current;
            }
        }
        if (maxLength == -1){
            System.out.println(maxLength);
        }else {
            System.out.println(tempString);
        }
    }
    public static String func1(String str){
        char[] strs = str.toCharArray();
        List<Character> maxStrs = new ArrayList<>();
        List<Character> tempStrs = new ArrayList<>();
        int maxLength = -1;
        int tempLength = 0;
        int tempIndex = -1;
        int index = 0;
        while (index < str.length() - 2){
            if (strs[index]=='0' && strs[index+1]=='1' && strs[index+2]=='0'){
                // 一个最小交替方波
                if (index == tempIndex){
                    // 连续
                    tempIndex = index + 2;
                    tempLength += 2;
                    tempStrs.add('1');
                    tempStrs.add('0');
                    index += 2;
                }else {
                    tempIndex = index + 2;
                    tempLength = 2;
                    tempStrs.clear();
                    tempStrs.add('0');
                    tempStrs.add('1');
                }
            }
        }
        return "";
    }
}


//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            String signal = br.readLine(); 读取一个字符串
//            String[] signalList = signal.split("00"); 通过00 拆分，这时候每个连续信号串格式应为101的形式
//            int maxSignalLength = -1;
//            String longestSignal = "";
//
//            for (String currentSignal : signalList) {
//                if (currentSignal.isEmpty()) {
//                    continue;
//                }
//                  修复
//                if (currentSignal.charAt(0) == '1') {
//                    currentSignal = "0" + currentSignal;
//                }
//                if (currentSignal.charAt(currentSignal.length() - 1) == '1') {
//                    currentSignal = currentSignal + "0";
//                }
//
//                if (currentSignal.length() > maxSignalLength && !currentSignal.contains("11") && currentSignal.contains("01010")
//                        && currentSignal.matches("0+(10){2,}0*")) {
//                    maxSignalLength = currentSignal.length();
//                    longestSignal = currentSignal;
//                }
//            }
//
//            if (maxSignalLength != -1) {
//                System.out.println(longestSignal);
//            } else {
//                System.out.println(maxSignalLength);
//            }
//        }
//    }
//}




