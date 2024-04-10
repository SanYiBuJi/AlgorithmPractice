package huaweiOD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
// https://dream.blog.csdn.net/article/details/129246222

public class OD5_Archaeologist {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        String s = in.nextLine();
        System.out.println(s);
        String[] array = in.nextLine().split(" ");
        List<String> resultList = new ArrayList<>();
        permute(array,0, array.length -1,resultList);
        resultList = resultList.stream().distinct().toList();
        System.out.println(resultList);
        for (String result :
                resultList) {
            System.out.println(result);
        }


//        List<String> resultList = new ArrayList<>();
//        List<String> initList = Arrays.asList(array);
//        for (String init:array ) {
//            List<String> list = new ArrayList<>(resultList);
//            resultList.add(init);
//            for (String pr :
//                    list) {
//                resultList.add(pr + init);
//            }
//        }
//        List<String> resList = resultList.stream().distinct().filter(res ->res.length() == m).toList();
//        System.out.println(resList);
    }
    public static void permute(String[] arr,int start,int end,List<String> resultList){
        if (start == end){
            resultList.add(StringArrayToString(arr));
        }else {
            String[] arrCopy = arr.clone();
            for (int i = start; i <= end ; i++) {// 深度优先 依次将当前位置与往后的位置元素进行交换位置后，记录到集合中
                swap(arrCopy,i,start);
                permute(arrCopy,start + 1,end,resultList);
                swap(arrCopy,i,start);
            }
        }
    }
    public static void swap(String[] arr,int n, int m){
        String temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }
    public static String StringArrayToString(String[] array){
        StringBuffer strBuff = new StringBuffer();
        for (String s :
                array) {
            strBuff.append(s);
        }
        return strBuff.toString();
    }
}



//import java.util.Scanner;
//        import java.util.TreeSet;
//
//public class Main {
//    public static final TreeSet<String> resTreeSet = new TreeSet<>();
//    public static void solve(int index, String[] parts) {
//        if (index == parts.length) {  遍历到最后一个元素
//            StringBuilder sb = new StringBuilder();
//            for (String str : parts) {
//                sb.append(str);
//            }
//            if (!sb.toString().isEmpty()) {
//                resTreeSet.add(sb.toString()); 将当前组合后的字符串添加到集合中
//            }
//            return;
//        }
//        for (int i = index; i < parts.length; ++i) {
//            dataSwap(i, index, parts);
//            solve(index + 1, parts);
//            dataSwap(i, index, parts);
//        }
//
//    }
//
//    public static void dataSwap(int i, int j, String[] values) {
//        String temp = values[j];
//        values[j] = values[i];
//        values[i] = temp;
//    }
//
//    public static void main(String[] args) {
//        try {
//            Scanner s = new Scanner(System.in);
//            int n = Integer.parseInt(s.nextLine());
//            String part = s.nextLine();
//            String[] parts = part.split(" ");
//            solve(0, parts);
//            for (String str : resTreeSet) {
//                System.out.println(str);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("input error");
//        }
//    }
//}

